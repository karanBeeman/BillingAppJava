package com.paalkanakku.project.model;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_details")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class CustomerDetails {

    @Id
    private String customerName;
    private String customerGstNumber;
    private String customerAddress;
    private String customerPhoneNumber;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<DefaultProductWithPrice> defaultProductWithPriceList;
//    @OneToMany(targetEntity = DefaultProductWithPrice.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "hp_fk", referencedColumnName = "customerName")
 //   private List<DefaultProductWithPrice> defaultProductWithPriceList;



}
