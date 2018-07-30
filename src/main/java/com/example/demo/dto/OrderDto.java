package com.example.demo.dto;

import com.example.demo.repository.dao.OrderDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author Administrator
 * @date 2018/7/29 22:39
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Data
public class OrderDto {

    private String orderId;
    /**
     * 买家姓名
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家openid
     */
    private String buyerOpenid;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 支付状态
     */
    private Integer payStatus;

    private Date createTime;
    private Date updateTime;

    /**
     * 这笔订单的商品详情
     */
    private List<OrderDetail> orderDetailList;
}
