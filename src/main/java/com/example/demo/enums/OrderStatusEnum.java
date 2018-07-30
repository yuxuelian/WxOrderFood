package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/29 15:43
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：订单状态
 */

@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消")
    ;


    private final int code;
    private final String message;

    OrderStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
