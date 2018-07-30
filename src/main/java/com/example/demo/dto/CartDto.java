package com.example.demo.dto;

import lombok.Data;

/**
 * @author Administrator
 * @date 2018/7/29 23:26
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description： 购物车
 */

@Data
public class CartDto {

    /**
     * 购买商品的Id
     */
    private String productId;

    /**
     * 购买商品的数量
     */
    private Integer productQuantity;

    public CartDto(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDto() {
    }
}
