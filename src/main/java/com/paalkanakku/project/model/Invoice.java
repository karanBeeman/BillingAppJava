package com.paalkanakku.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private SrDetails srDetails;
    private HotelDetails hotelDetails;
    private List<InvoiceProductDetails> productDetailsList;
}
