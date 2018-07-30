package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/29 15:47
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：支付状态
 */


@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private final Integer code;
    private final String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
