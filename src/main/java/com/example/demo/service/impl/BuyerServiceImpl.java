package com.example.demo.service.impl;

import com.example.demo.dto.OrderDto;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.exception.ResultException;
import com.example.demo.service.BuyerService;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2018/8/3 22:36
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDto findOrderOne(String openid, String orderId) {
        return checkOrderByOpenid(openid, orderId);
    }

    @Override
    public OrderDto cancelOrder(String openid, String orderId) {
        //检查查询到的订单
        OrderDto orderDto = checkOrderByOpenid(openid, orderId);
        //取消订单
        return orderService.cancel(orderDto);
    }

    private OrderDto checkOrderByOpenid(String openid, String orderId) {
        //查询订单
        OrderDto orderDto = orderService.findOne(orderId);
        if (orderDto == null) {
            log.info("[取消订单] 订单不存在 orderId={}", orderId);
            throw new ResultException(ResultCodeEnum.OPENID_CHECK_ERROR);
        }
        //校验用户
        if (!orderDto.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.info("[取消订单] 该订单非该用户订单");
            throw new ResultException(ResultCodeEnum.OPENID_CHECK_ERROR);
        }
        return orderDto;
    }
}

