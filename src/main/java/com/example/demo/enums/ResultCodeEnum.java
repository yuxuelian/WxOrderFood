package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/28 21:03
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(0, "成功"),
    SERVICE_ERROR(500, "内部服务器错误");

    private final String message;
    private final Integer code;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
