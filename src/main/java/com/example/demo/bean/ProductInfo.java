package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductInfo {

    @Id
    @GeneratedValue
    private String productId;
    private String productName;
    private double productPrice;
    private long productStock;
    private String productDescription;
    private String productIcon;
    private long categoryType;

}
