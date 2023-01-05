package com.paalkanakku.project.Repository;

import com.paalkanakku.project.model.HotelDetails;
import com.paalkanakku.project.model.InvoiceNumTable;
import com.paalkanakku.project.model.InvoiceProductDetails;
import com.paalkanakku.project.model.PendingBills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface InoviceNumDetailsRepository extends JpaRepository<InvoiceNumTable, String> {
    @Query(value = "SELECT n from InvoiceNumTable n ORDER BY  n.invoiceNumber DESC")
    List<InvoiceNumTable> getLastInvoice();

    @Transactional
    @Query(value = "SELECT n from InvoiceNumTable n where n.date= :date")
    List<InvoiceNumTable> getByDate(String date);

    @Query(value = "SELECT n from InvoiceNumTable n where n.invoiceNumber= :invoiceNumber")
    InvoiceNumTable getByInvoiceNumber(String invoiceNumber);

    @Query(value = "SELECT n from InvoiceNumTable n where n.date= :date1 and n.customerName= :customerName")
    List<InvoiceNumTable> getByDateAndCustomer(String date1, String customerName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE InvoiceNumTable n set n.productDetailList=:productDetailList where n.invoiceNumber =:invoiceNumber")
    int updateBill(String invoiceNumber, List<InvoiceProductDetails> productDetailList);
}
