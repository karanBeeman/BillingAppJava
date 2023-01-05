package com.paalkanakku.project.serviceImpl;

import com.paalkanakku.project.Repository.CustomerDetailsRepository;
import com.paalkanakku.project.Repository.InoviceNumDetailsRepository;
import com.paalkanakku.project.Repository.StockRepository;
import com.paalkanakku.project.model.CustomerDetails;
import com.paalkanakku.project.model.InvoiceNumTable;
import com.paalkanakku.project.model.StockDetails;
import com.paalkanakku.project.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    InoviceNumDetailsRepository inoviceNumDetailsRepository;

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public String geInvoiceNumber() {
        InvoiceNumTable in = new InvoiceNumTable();
       List<InvoiceNumTable> inp =  inoviceNumDetailsRepository.getLastInvoice();

        String filename = new SimpleDateFormat("yyyyMMdd").format(new Date());
       if(inp.size()<1){

           String num = "SRF" + "-" + filename + "-" + "00001";
           return num;
         //  inoviceNumDetailsRepository.save(in);
       } else {
           char ind = 0;
             String ss1 = inp.get(0).getInvoiceNumber();
             String splitStr[] = ss1.split("-");
             String concatString = "SRF" + "-" + filename + "-";
             String ss = splitStr[2];
           for(int s=0; s<ss.length(); s++) {
               if(ss.charAt(s)!= '0') {
                   //builder.append(ss.charAt(s));
                   ind = ss.charAt(s);
                   break;
               }
           }
           int x = ss.indexOf(ind);
           int xy = Integer.parseInt(ss.substring(x)) + 1;
           String finalf = String.valueOf(xy);
           StringBuilder bu = new StringBuilder();
           if(finalf.length() == 1) {
               bu.append("0000");
               bu.append(finalf);
           } else if(finalf.length() == 2) {
               bu.append("000");
               bu.append(finalf);
           }else if(finalf.length() == 3) {
               bu.append("00");
               bu.append(finalf);
           }else if(finalf.length() == 4) {
               bu.append("0");
               bu.append(finalf);
           } else {
               bu.append(finalf);
           }
         //  int num = Integer.parseInt(inp.get(0).getInvoiceNumber() ) + 1;
           String s = concatString + bu;
           return s;
         //  in.setInvoiceNumber(s);
         //  inoviceNumDetailsRepository.save(in);
//           inoviceNumDetailsRepository.save(in.getInvoiceNumber());
       }

    }

    @Override
    public List<CustomerDetails> getCustomerDetaisl() {
        List<CustomerDetails> customerDetailsList =  customerDetailsRepository.findAll();
        return customerDetailsList;
    }

    @Override
    @Transactional
    public List<StockDetails> saveStockDetails(List<StockDetails> stockDetails) {
        List<StockDetails> stockList = new ArrayList<>();
        StockDetails stock;
        List<StockDetails> stockDetails1 = stockRepository.findAll();
            if(!stockDetails1.isEmpty()) {
            stockRepository.deleteAll();
            for(StockDetails stockDetails2 : stockDetails) {
              stock = stockRepository.save(stockDetails2);
              stockList.add(stock);
            }
            return stockList;
        } else {
                stockList = stockRepository.saveAll(stockDetails);
            return stockList;
        }
    }

    @Override
    public List<StockDetails> retrieveStockDetails() {
       List<StockDetails> stockDetails = stockRepository.findAll();
       return stockDetails;
    }

    @Override
    public void saveCusotmerDetails(CustomerDetails customerDetails) {
        try {
          Optional<CustomerDetails> details = customerDetailsRepository.findById(customerDetails.getCustomerName());
           if(details.isPresent()) {
               customerDetailsRepository.deleteById(customerDetails.getCustomerName());
               customerDetailsRepository.save(customerDetails);
           } else {
               customerDetailsRepository.save(customerDetails);
           }
        } catch (Exception e) {
            System.out.println("cannot save in db");
        }
    }

    @Override
    public void deleteCustomer(CustomerDetails customerDetails) {
        try {
            Optional<CustomerDetails> cus = customerDetailsRepository.findById(customerDetails.getCustomerName());
            if(cus.isPresent()) {
                customerDetailsRepository.deleteById(customerDetails.getCustomerName());
            }
        } catch (Exception e) {
            System.out.println("cannot delete in db");
        }
    }


}
