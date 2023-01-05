package com.paalkanakku.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceProductDetails {

    private String productName;
    private double quantity;
    private double price;
    private double amount;
}
