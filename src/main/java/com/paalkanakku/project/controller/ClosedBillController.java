package com.paalkanakku.project.controller;

import com.paalkanakku.project.model.ClosedBills;
import com.paalkanakku.project.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClosedBillController {
    @Autowired
    BillsService billsService;

    @PostMapping("/save/closedbill")
    public ClosedBills saveToClosedBills(@RequestBody ClosedBills closedBills) {
        ClosedBills closedBills1 = billsService.closedbills(closedBills);
        return closedBills1;
    }

    @GetMapping("get/closedbills")
    public List<ClosedBills> getClosedBills() {
        return billsService.getAllClosedBills();
    }
}
