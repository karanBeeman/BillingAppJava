package com.paalkanakku.project.serviceImpl;

import com.paalkanakku.project.Exception.CannotUpdateException;
import com.paalkanakku.project.Repository.ClosedBillRepository;
import com.paalkanakku.project.Repository.InoviceNumDetailsRepository;
import com.paalkanakku.project.Repository.PendingBillsRepository;
import com.paalkanakku.project.model.ClosedBills;
import com.paalkanakku.project.model.InvoiceNumTable;
import com.paalkanakku.project.model.PendingBills;
import com.paalkanakku.project.service.BillsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class BillServiceImplementation implements BillsService {
    @Autowired
    InoviceNumDetailsRepository inoviceNumDetailsRepository;
    @Autowired
    PendingBillsRepository pendingBillsRepository;
    @Autowired
    ClosedBillRepository closedBillsRepository;

    @Override
    public List<InvoiceNumTable> getCurrentDateBills() {
        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        List<InvoiceNumTable> invoiceNumTables = inoviceNumDetailsRepository.getByDate(date);
        return invoiceNumTables;
    }
    @Override
    public List<InvoiceNumTable> getAllBills() {
        List<InvoiceNumTable> invoiceNumTables = inoviceNumDetailsRepository.findAll();
        return invoiceNumTables;
    }
    @Override
    public PendingBills savePendingBills(String pendingBills) {
        PendingBills pendingBills1 = new PendingBills();
        JSONObject jsonObject = new JSONObject(pendingBills);
        JSONObject hotelDetails = jsonObject.getJSONObject("hotelDetails");
        JSONArray productDetailsList = jsonObject.getJSONArray("productDetailList");
        double d = 0;
        for(int i=0; i< productDetailsList.length(); i++) {
            JSONObject js = (JSONObject) productDetailsList.get(i);
            d += js.getDouble("amount");
        }
        pendingBills1.setCustomerName(hotelDetails.getString("customerName"));
        pendingBills1.setDate(jsonObject.getString("date"));
        pendingBills1.setTotalAmount(d);
        pendingBills1.setInvoiceNumber(jsonObject.getString("invoiceNumber"));
        pendingBillsRepository.save(pendingBills1);
        return new PendingBills();
    }

    @Override
    public List<PendingBills> getPendingBills(String invoiceNumber) {
        List<PendingBills> pendingBills = pendingBillsRepository.getByInvoiceNumber(invoiceNumber);
        if(pendingBills!= null) {
            return pendingBills;
        }
        return Collections.EMPTY_LIST;
    }
    @Override
    public List<InvoiceNumTable> getBillsByDate(String date) throws ParseException {
        SimpleDateFormat sdt = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
        Date result = sdt.parse(date);
        String date1 = new SimpleDateFormat("dd-MM-yyyy").format(result);
        return inoviceNumDetailsRepository.getByDate(date1);
    }
    @Override
    public ClosedBills closedbills(ClosedBills closedBills) {
        InvoiceNumTable invoiceNumTable = inoviceNumDetailsRepository.getByInvoiceNumber(closedBills.getInvoiceNumber());
        if(invoiceNumTable!= null) {
            inoviceNumDetailsRepository.delete(invoiceNumTable);
        }
        ClosedBills closedBills1 = closedBillsRepository.save(closedBills);
        return closedBills1;
    }
    @Override
    public List<ClosedBills> getAllClosedBills() {
           return closedBillsRepository.findAll();
    }

    @Override
    public PendingBills ModifyPendingBill(String pendingBills) {
        PendingBills pendingBills1 = new PendingBills();
        JSONObject jsonObject = new JSONObject(pendingBills);
        JSONObject hotelDetails = jsonObject.getJSONObject("hotelDetails");
        JSONArray productDetailsList = jsonObject.getJSONArray("productDetailList");
        double d = 0;
        for(int i=0; i< productDetailsList.length(); i++) {
            JSONObject js = (JSONObject) productDetailsList.get(i);
            d += js.getDouble("amount");
        }
        pendingBills1.setCustomerName(hotelDetails.getString("customerName"));
        pendingBills1.setDate(jsonObject.getString("date"));
        pendingBills1.setTotalAmount(d);
        pendingBills1.setInvoiceNumber(jsonObject.getString("invoiceNumber"));

        List<PendingBills> pendingBillsList = pendingBillsRepository.getByInvoiceNumber(jsonObject.getString("invoiceNumber"));
         if(pendingBillsList.size() == 1) {
             pendingBillsRepository.delete(pendingBillsList.get(0));
            return pendingBillsRepository.save(pendingBills1);
         } else {
             throw new CannotUpdateException();
         }
    }
    @Override
    public PendingBills updatePendingBills(PendingBills pendingBills) throws ParseException {
        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
        Date result = sdt.parse(pendingBills.getDate());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(result);
        System.out.println(date);
        pendingBills.setDate(date);
        PendingBills pendingBills1 = pendingBillsRepository.save(pendingBills);
        return pendingBills1;
    }

}
