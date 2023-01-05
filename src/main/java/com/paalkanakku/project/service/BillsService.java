package com.paalkanakku.project.service;

import com.paalkanakku.project.model.ClosedBills;
import com.paalkanakku.project.model.InvoiceNumTable;
import com.paalkanakku.project.model.PendingBills;

import java.text.ParseException;
import java.util.List;

public interface BillsService {
    List<InvoiceNumTable> getCurrentDateBills();

    List<InvoiceNumTable> getAllBills();

    PendingBills savePendingBills(String pendingBills);

    List<PendingBills> getPendingBills(String invoiceNumber);

    PendingBills updatePendingBills(PendingBills pendingBills) throws ParseException;

    List<InvoiceNumTable> getBillsByDate(String date) throws ParseException;

    ClosedBills closedbills(ClosedBills closedBills);

    List<ClosedBills> getAllClosedBills();

    PendingBills ModifyPendingBill(String pendingBills);
}
