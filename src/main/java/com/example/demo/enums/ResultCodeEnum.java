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

    /*------------请求出现错误-----------*/
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "商品库存不足"),
    ORDER_NOT_EXIST(3, "商品库存不足"),
    ORDER_DETAIL_EMPTY(4, "商品库存不足"),
    ORDER_NOT_PAY(5, "订单未支付,无法完结"),
    ORDER_STATUS_ERROR(6, "订单状态不正确,无法完结"),
    SERVICE_ERROR(-1, "内部服务器错误");

    private final String message;
    private final Integer code;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
