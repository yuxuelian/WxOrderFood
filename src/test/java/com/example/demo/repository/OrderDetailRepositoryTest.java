package com.example.demo.repository;

import com.example.demo.repository.dao.OrderDetail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2018/7/29 16:31
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2354235");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("63452");
        orderDetail.setProductQuantity(800);
        orderDetail.setProductPrice(new BigDecimal(4.5));
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductIcon("http://xxxx.jpa");
        repository.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        repository.findByOrderId("123456").forEach(System.out::println);
    }
}