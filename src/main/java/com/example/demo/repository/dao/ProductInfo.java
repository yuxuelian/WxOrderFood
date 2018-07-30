package com.example.demo.repository.dao;

import com.example.demo.enums.ProductStatusEnum;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    /**
     * 商品名字
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 商品库存
     */
    private Integer productStock;
    /**
     * 商品描述
     */
    private String productDescription;
    /**
     * 商品图片
     */
    private String productIcon;
    /**
     * 商品状态 0 上架  1下架
     */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**
     * 商品类目(类别)
     */
    private Integer categoryType;

}
