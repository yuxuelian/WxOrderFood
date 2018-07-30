package com.example.demo.exception;

import com.example.demo.enums.ResultCodeEnum;

/**
 * @author Administrator
 * @date 2018/7/29 22:54
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public class ResultException extends RuntimeException {

    private ResultCodeEnum resultCodeEnum;

    public ResultException(ResultCodeEnum resultCodeEnum) {
        this.resultCodeEnum = resultCodeEnum;
    }

    public ResultCodeEnum getResultCodeEnum() {
        return resultCodeEnum;
    }
}
