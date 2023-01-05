package com.paalkanakku.project.controller;

import com.paalkanakku.project.Exception.CustomExceptionClass;
import com.paalkanakku.project.model.ClosedBills;
import com.paalkanakku.project.model.InvoiceNumTable;
import com.paalkanakku.project.model.PendingBills;
import com.paalkanakku.project.service.BillsService;
import com.paalkanakku.project.service.DetailProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class BillsController {

    @Autowired
    BillsService billsService;

    @Autowired
    DetailProviderService dataProvider;

    @GetMapping("/currentDateBills")
    public List<InvoiceNumTable> currentDateBills() {
        return billsService.getCurrentDateBills();
    }

    @GetMapping("/getAllBills")
    public List<InvoiceNumTable> getAllBills() {
        return billsService.getAllBills();
    }

    @PostMapping("/save/pendingBills")
    public PendingBills savePendingBills(@RequestBody String pendingBills) {
        return billsService.savePendingBills(pendingBills);
    }

    @GetMapping("/getpendingbills")
    public List<PendingBills> getPendingBills(@RequestParam(value = "invoiceNumber") String invoiceNumber) {
        List<PendingBills> pendingBills = billsService.getPendingBills(invoiceNumber);
        return pendingBills;
    }

    @PostMapping("/update/pendingbills")
    public PendingBills savePendingBills(@RequestBody PendingBills pendingBills) throws ParseException {
        PendingBills updateBills = billsService.updatePendingBills(pendingBills);
        return updateBills;
    }

    @PutMapping("/modify/pendingbills")
    public PendingBills modifyPendingBills(@RequestBody String pendingBills) throws ParseException {
        PendingBills updateBills = billsService.ModifyPendingBill(pendingBills);
        return updateBills;
    }

    @GetMapping("/getpendingBills/date")
    public List<InvoiceNumTable> getBillsByDate(@RequestParam(value = "date") String date) throws ParseException {
       List<InvoiceNumTable> bills = billsService.getBillsByDate(date);
       return bills;
    }

    @GetMapping("/error")
    public String error() {
      throw new CustomExceptionClass();
    }


}
