package com.paalkanakku.project.controller;

import com.paalkanakku.project.model.*;
import com.paalkanakku.project.service.CommonService;
import com.paalkanakku.project.service.DetailProviderService;
import com.paalkanakku.project.serviceImpl.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CustomerDetailsController {

    @Autowired
    DetailProviderService dataProvider;

    @Autowired
    PdfService pdfService;
    @Autowired
    CommonService commonService;

    @GetMapping("/login")
    public String stomerDetails(@RequestParam String username, @RequestParam String password) {
        return "authenticated" + username;
    }

//    @GetMapping("/createPdf")
//    public void generatePdf() {
//        pdfService.createPdf();
//    }

    @GetMapping("/html")
    public String getHtml() {
        return "thymeleafTemplate";
    }

    @PostMapping("/invoice")
    public InvoiceNumTable printInvoiceData(@RequestBody InvoiceNumTable invoiceNumTable) throws Exception {
        return dataProvider.saveInvoiceDetails(invoiceNumTable);
    }

    @PutMapping("/update/invoice")
    public InvoiceNumTable UpdateInvoiceData(@RequestBody InvoiceNumTable invoiceNumTable) throws Exception {
        return dataProvider.updateInvoiceDetails(invoiceNumTable);
    }


    @PostMapping("/save/cusotmerdetails")
    public void saveCustomer(@RequestBody CustomerDetails customerDetails) {
        commonService.saveCusotmerDetails(customerDetails);
   }

    @PostMapping("/delete/customer")
    public void deleteCustomerDetails(@RequestBody CustomerDetails customerDetails) {
       commonService.deleteCustomer(customerDetails);
    }

    @GetMapping("/get/existingcustomer")
    public List<CustomerDetails> getExistingCusotmer() {
        return commonService.getCustomerDetaisl();
   }
}
