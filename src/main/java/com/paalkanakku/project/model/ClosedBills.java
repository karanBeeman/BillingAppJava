package com.paalkanakku.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "closed_bills")
public class ClosedBills {

    @Id
    private String invoiceNumber;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HotelDetails hotelDetails;
    private String date;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<InvoiceProductDetails> productDetailList;
}
