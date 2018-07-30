package com.example.demo.repository.dao;

import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;

}
