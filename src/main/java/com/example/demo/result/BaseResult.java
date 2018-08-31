package com.example.demo.result;

import com.example.demo.enums.ResultCodeEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2018/7/28 20:58
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Getter
public class BaseResult<T> {

    private final Integer code;
    private final String message;
    private final T data;

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    private BaseResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> BaseResult<T> ofSuccess(T data) {
        return new BaseResult<>(ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.SUCCESS.getMessage(),
                data);
    }

    public static BaseResult<Object> ofSuccess() {
        return new BaseResult<>(ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.SUCCESS.getMessage(),
                new Object());
    }

    public static BaseResult<Object> ofError(ResultCodeEnum resultCodeEnum) {
        return new BaseResult<>(resultCodeEnum.getCode(),
                resultCodeEnum.getMessage(),
                new Object());
    }

    public static BaseResult<Object> ofError(Integer code, String message) {
        return new BaseResult<>(code,
                message,
                new Object());
    }

}
