package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;
import com.example.demo.repository.dao.OrderDetail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2018/7/29 23:45
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    private static final String BUYER_OPENID = "110110";
    private static final String ORDER_ID = "1532962616324983573";

    @Test
    public void create() {
        OrderDto orderDto = new OrderDto();
        orderDto.setBuyerName("王开波");
        orderDto.setBuyerAddress("四川省成都市");
        orderDto.setBuyerPhone("17323200861");
        orderDto.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123478");
        orderDetail.setProductQuantity(3);
        orderDetailList.add(orderDetail);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("123457");
        orderDetail2.setProductQuantity(3);
        orderDetailList.add(orderDetail2);

        orderDto.setOrderDetailList(orderDetailList);

        //创建订单
        OrderDto result = orderService.create(orderDto);
        log.info("[创建订单] result={}", result);
    }

    @Test
    public void findOne() {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        System.out.println(orderDto);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<OrderDto> orderDtoPage = orderService.findList(BUYER_OPENID, pageRequest);
        orderDtoPage.forEach(System.out::println);
    }

    @Test
    public void cancel() {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.cancel(orderDto);
        if (result.getOrderStatus().equals(OrderStatusEnum.FINISH.getCode())) {
            System.out.println("取消订单成功");
        }
    }

    @Test
    public void finish() {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.finish(orderDto);
        if (result.getOrderStatus().equals(OrderStatusEnum.FINISH.getCode())) {
            System.out.println("完结订单成功");
        }
    }

    @Test
    public void paid() {
        OrderDto orderDto = orderService.findOne(ORDER_ID);
        OrderDto result = orderService.paid(orderDto);
        if (result.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())) {
            System.out.println("订单支付成功");
        }
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://www.baidu.com", String.class);
    }

}