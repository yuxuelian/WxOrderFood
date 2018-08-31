package com.example.demo.form;


import com.example.demo.repository.dao.OrderDetail;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * @author Administrator
 * @date 2018/7/31 23:25
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    @JsonProperty("name")
    private String buyerName;

    /**
     * 买家电话
     */
    @NotEmpty(message = "手机号必填")
    @JsonProperty("phone")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    @JsonProperty("address")
    private String buyerAddress;

    /**
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    @JsonProperty("openid")
    private String buyerOpenid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    @JsonProperty("items")
    private List<OrderDetail> orderDetailList;
}
