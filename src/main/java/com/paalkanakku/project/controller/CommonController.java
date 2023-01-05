package com.paalkanakku.project.controller;

import com.paalkanakku.project.model.StockDetails;
import com.paalkanakku.project.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CommonController {

    @Autowired
    CommonService commonService;

    @PostMapping("/stockdetails/save")
    public String saveStockDetails(@RequestBody List<StockDetails> stockDetails) {
      List<StockDetails> stock = commonService.saveStockDetails(stockDetails);
      if(stock.size()>0) {
          return "updated Successfully";
      }
        return "failed";
    }

    @GetMapping("/stock/retrieve")
    public List<StockDetails> getStockDetails() {
        List<StockDetails> stockDetails = commonService.retrieveStockDetails();
        return stockDetails;
    }

    @GetMapping("/getInvoicenumber")
    public String getInvoiceNumber() {
        return commonService.geInvoiceNumber();
    }
}
