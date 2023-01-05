package com.paalkanakku.project.Repository;

import com.paalkanakku.project.model.StockDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StockRepository extends JpaRepository<StockDetails, String> {

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM StockDetails s WHERE s.productName = :productName")
    void deleteByProductName(String productName);

//    @Transactional
//    @Modifying(flushAutomatically = true)
//    @Query(value = "UPDATE StockDetails s set stock = :stock WHERE s.productName = :productName")
//    void updateProductQuantity(String productName, String stock);
}
