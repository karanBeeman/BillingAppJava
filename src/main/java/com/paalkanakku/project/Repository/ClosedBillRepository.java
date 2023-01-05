package com.paalkanakku.project.Repository;

import com.paalkanakku.project.model.ClosedBills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClosedBillRepository extends JpaRepository<ClosedBills, Long> {
}
