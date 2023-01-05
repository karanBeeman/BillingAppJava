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
@Table(name="Invoice_Number_Details")
public class InvoiceNumTable {

    @Id
    private String invoiceNumber;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private HotelDetails hotelDetails;
    private String date;
    private String customerName;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<InvoiceProductDetails> productDetailList;
}
