package com.example.demo.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/28 20:35
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Getter
public enum ProductStatusEnum {

    UP(0, "上架"),
    DOWN(1, "下架");

    private final Integer code;
    private final String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
