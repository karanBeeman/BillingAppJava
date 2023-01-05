package com.paalkanakku.project.service;

import com.paalkanakku.project.model.CustomerDetails;
import com.paalkanakku.project.model.StockDetails;

import java.util.List;

public interface CommonService {

    public String geInvoiceNumber();
    void saveCusotmerDetails(CustomerDetails customerDetails);

    List<CustomerDetails> getCustomerDetaisl();

    List<StockDetails> saveStockDetails(List<StockDetails> stockDetails);

    List<StockDetails> retrieveStockDetails();

    void deleteCustomer(CustomerDetails customerDetails);
}
