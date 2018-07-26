package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class OrderDetail {

    @Id
    @GeneratedValue
    private String detailId;
    private String orderId;
    private String productId;
    private String productName;
    private double productPrice;
    private long productQuantity;
    private String productIcon;

}
