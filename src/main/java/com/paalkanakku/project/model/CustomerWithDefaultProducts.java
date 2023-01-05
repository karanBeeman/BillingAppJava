package com.paalkanakku.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWithDefaultProducts {


    private Integer id;
    private HotelDetails HotelDetails;
    private List<DefaultProductWithPrice> defaultProductWithPriceList;

}
