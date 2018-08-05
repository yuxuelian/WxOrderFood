package com.example.demo.dto;

import com.example.demo.repository.dao.OrderDetail;
import com.example.demo.serializer.DateToLongSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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

//@JsonInclude(JsonInclude.Include.NON_NULL)
// 当有值为空的时候不返回到前端  这里不配置  使用全局的配置

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

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = DateToLongSerializer.class)
    private Date updateTime;

    /**
     * 这笔订单的商品详情
     */
    private List<OrderDetail> orderDetailList;
}
