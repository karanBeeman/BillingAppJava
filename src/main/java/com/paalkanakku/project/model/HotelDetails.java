package com.paalkanakku.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hotel_Details")
public class HotelDetails {

    @Id
    private String customerName;
    private String customerGstNumber;
    private String customerAddress;
    private String customerPhoneNumber;



}
