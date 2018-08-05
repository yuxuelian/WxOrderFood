package com.example.demo.exception;

import com.example.demo.enums.ResultCodeEnum;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/29 22:54
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Getter
public class ResultException extends RuntimeException {

    private Integer code;

    public ResultException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public ResultException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
