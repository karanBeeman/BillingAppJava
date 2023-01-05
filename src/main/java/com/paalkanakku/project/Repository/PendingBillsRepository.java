package com.paalkanakku.project.Repository;

import com.paalkanakku.project.model.PendingBills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PendingBillsRepository extends JpaRepository<PendingBills, String> {
    @Query(value = "SELECT p from PendingBills p where p.invoiceNumber = :invoiceNumber")
    List<PendingBills> getByInvoiceNumber(String invoiceNumber);
}
