package com.paalkanakku.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SrDetails {

    private String companyName;
    private String address;
    private String gstNumber;
    private String phoneNumber;
}
