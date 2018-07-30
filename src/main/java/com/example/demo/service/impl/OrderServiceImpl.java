package com.example.demo.service.impl;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.OrderDto;
import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.exception.ResultException;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderMasterRepository;
import com.example.demo.repository.dao.OrderDetail;
import com.example.demo.repository.dao.OrderMaster;
import com.example.demo.repository.dao.ProductInfo;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductInfoService;
import com.example.demo.util.ConnectionUtils;
import com.example.demo.util.KeyUtil;
import com.example.demo.util.ObjectConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2018/7/29 22:27
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public OrderDto create(OrderDto orderDto) {
        //获取一个订单id
        String orderId = KeyUtil.getUniqueKey();

        //总价存放变量
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        //统计该订单中的商品以及数量
        List<CartDto> cartDtoList = new ArrayList<>();

        //1.查询商品 数量价格
        for (OrderDetail orderDetail : orderDto.getOrderDetailList()) {
            ProductInfo productInfo = productInfoService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new ResultException(ResultCodeEnum.PRODUCT_NOT_EXIST);
            }
            //计算订单总价
            orderAmount = productInfo.getProductPrice()
                    //一件商品的总价
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    //所有商品的总价
                    .add(orderAmount);
            //这个拷贝会覆盖一些变量
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setDetailId(KeyUtil.getUniqueKey());
            orderDetail.setOrderId(orderId);
            //订单详情入库
            orderDetailRepository.save(orderDetail);
            //统计购买的商品及其数量
            CartDto cartDto = new CartDto(orderDetail.getProductId(), orderDetail.getProductQuantity());
            cartDtoList.add(cartDto);
        }

        //写入订单数据库
        OrderMaster orderMaster = new OrderMaster();
        //这个拷贝会覆盖一些变量
        BeanUtils.copyProperties(orderDto, orderMaster);
        //设置订单id
        orderMaster.setOrderId(orderId);
        //设置订单总价
        orderMaster.setOrderAmount(orderAmount);

        //重新写回状态
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        //写入数据库
        orderMasterRepository.save(orderMaster);
        //下单成功,扣库存
        productInfoService.decreaseStock(cartDtoList);
        return orderDto;
    }

    @Override
    public OrderDto findOne(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).orElse(null);
        if (orderMaster == null) {
            log.info("[查询订单] 订单不存在 orderId={}!", orderId);
            throw new ResultException(ResultCodeEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (ConnectionUtils.isEmpty(orderDetailList)) {
            log.info("[查询订单] 订单中无详情 orderId={}!", orderId);
            throw new ResultException(ResultCodeEnum.ORDER_DETAIL_EMPTY);
        }
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);
        orderDto.setOrderDetailList(orderDetailList);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);
        List<OrderMaster> orderMasterList = orderMasterPage.getContent();
        return new PageImpl<>(ObjectConverter.orderMasterList2OrderDtoList(orderMasterList), pageable, orderMasterPage.getTotalElements());
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public OrderDto cancel(OrderDto orderDto) {
        //查询订单
        OrderMaster orderMaster = orderMasterRepository.findById(orderDto.getOrderId()).orElse(null);
        if (orderMaster == null) {
            log.info("[取消订单] 订单不存在! orderDto={}", orderDto);
            throw new ResultException(ResultCodeEnum.ORDER_NOT_EXIST);
        }

        //判断订单详情
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderDto.getOrderId());
        if (ConnectionUtils.isEmpty(orderDetailList)) {
            log.info("[取消订单] 订单中无详情! orderDto={}", orderDto);
            throw new ResultException(ResultCodeEnum.ORDER_DETAIL_EMPTY);
        }

        //修改订单状态
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        orderMasterRepository.save(orderMaster);

        //增加库存
        List<CartDto> cartDtoList = orderDto.getOrderDetailList().stream().map(orderDetail -> {
            CartDto cartDto = new CartDto();
            BeanUtils.copyProperties(orderDetail, cartDto);
            return cartDto;
        }).collect(Collectors.toList());
        productInfoService.increaseStock(cartDtoList);
        //已付款的订单需要退款
        if (orderMaster.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            //TODO 退款逻辑

        }
        return orderDto;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        //查询订单
        OrderMaster orderMaster = orderMasterRepository.findById(orderDto.getOrderId()).orElse(null);
        if (orderMaster == null) {
            log.info("[完结订单] 订单不存在! orderDto={}", orderDto);
            throw new ResultException(ResultCodeEnum.ORDER_NOT_EXIST);
        }

        //判断订单是否是新订单
        if (!orderMaster.getPayStatus().equals(OrderStatusEnum.NEW.getCode())) {
            log.info("[完结订单] 订单状态不正确! orderDto={}", orderDto);
            throw new ResultException(ResultCodeEnum.ORDER_STATUS_ERROR);
        }

        //判断订单是否已经支付
        if (!orderMaster.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            log.info("[完结订单] 订单未支付! orderDto={}", orderDto);
            throw new ResultException(ResultCodeEnum.ORDER_NOT_PAY);
        }
        //完结订单
        orderMaster.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDto;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
}
