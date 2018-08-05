package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/28 21:03
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description： restful接口返回Code码
 */
@Getter
public enum ResultCodeEnum {

    /**
     * 请求执行成功
     */
    SUCCESS(0, "成功"),

    /**
     * 表单验证错误parameter
     */
    PARAMETER_CHECK_ERROR(900, "表单验证错误"),
    PARAMETER_CART_EMPTY(901, "购物车为空"),

    /*------------请求出现错误-----------*/
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "商品库存不足"),
    ORDER_NOT_EXIST(3, "订单不存在"),
    ORDER_DETAIL_EMPTY(4, "订单详情为空"),
    ORDER_NOT_PAY(5, "订单未支付"),
    ORDER_STATUS_ERROR(6, "订单状态不正确"),
    ORDER_UPDATE_FAIL(7, "订单更新失败"),
    ORDER_PAYED(8, "订单已经支付，无需重新支付"),

    /*--------------身份校验失败------------*/
    OPENID_CHECK_ERROR(9, "身份校验失败"),

    /**
     * 服务器未知错误
     */
    SERVICE_ERROR(-1, "服务器未知错误");

    private final String message;
    private final Integer code;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
