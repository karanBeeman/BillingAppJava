package com.paalkanakku.project.serviceImpl;

import com.paalkanakku.project.Exception.CannotUpdateException;
import com.paalkanakku.project.Exception.CustomExceptionClass;
import com.paalkanakku.project.Repository.InoviceNumDetailsRepository;
import com.paalkanakku.project.model.*;
import com.paalkanakku.project.service.DetailProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DataServiceImpl implements DetailProviderService {

    @Autowired
    InoviceNumDetailsRepository inoviceNumDetailsRepository;

    @Autowired
    PdfService pdfService;

    public List<CustomerDetails> customerTable() {

        List<CustomerDetails> customerDetailedList = new ArrayList<>();


        return customerDetailedList;
    }


    @Override
    public InvoiceNumTable saveInvoiceDetails(InvoiceNumTable invoiceNumTable) throws Exception {
            SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
            Date result = sdt.parse(invoiceNumTable.getDate());
            String date1 = new SimpleDateFormat("dd-MM-yyyy").format(result);
            invoiceNumTable.setDate(date1);
            invoiceNumTable.setCustomerName(invoiceNumTable.getHotelDetails().getCustomerName());
            List<InvoiceNumTable> existingInvoice = inoviceNumDetailsRepository.getByDateAndCustomer(date1, invoiceNumTable.getHotelDetails().getCustomerName());
            if(existingInvoice.size() == 0) {
                InvoiceNumTable invoice = inoviceNumDetailsRepository.save(invoiceNumTable);
                if (invoice != null) {
                    pdfService.createPdf(invoiceNumTable);
                    return invoice;
                }
            } else {
                 throw new CustomExceptionClass();
            }
        return invoiceNumTable;
    }

    @Override
    public InvoiceNumTable updateInvoiceDetails(InvoiceNumTable invoiceNumTable) {
        InvoiceNumTable existingInvoice = inoviceNumDetailsRepository.getByInvoiceNumber(invoiceNumTable.getInvoiceNumber());
        if(existingInvoice!= null) {
              existingInvoice.setProductDetailList(invoiceNumTable.getProductDetailList());
              InvoiceNumTable invoiceNumTable1 = inoviceNumDetailsRepository.save(existingInvoice);
           return invoiceNumTable1;
        } else {
            throw new CannotUpdateException();
        }
    }


}
