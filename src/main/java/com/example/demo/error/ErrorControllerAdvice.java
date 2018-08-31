package com.example.demo.error;

import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.exception.ResultException;
import com.example.demo.result.BaseResult;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * @author Administrator
 * @date 2018/4/7 17:25
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：统一异常处理测试
 */

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handlerError(Exception ex, HandlerMethod handlerMethod) {
        ex.printStackTrace();
        if (ex instanceof ResultException) {
            //已知异常的情况下
            return BaseResult.ofError(((ResultException) ex).getCode(), ex.getMessage()).toString();
        }
        return BaseResult.ofError(ResultCodeEnum.SERVICE_ERROR).toString();
    }

    @ModelAttribute
    public void addAttributes(Model model) {
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
    }

}
