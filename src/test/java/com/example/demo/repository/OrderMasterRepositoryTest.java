package com.example.demo.repository;

import com.example.demo.repository.dao.OrderMaster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2018/7/29 16:03
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private static final String OPEN_ID = "110110";

    @Test
    public void save() {
//        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setOrderId("123457");
//        orderMaster.setBuyerName("师兄");
//        orderMaster.setBuyerPhone("17323200861");
//        orderMaster.setBuyerAddress("成都市武侯区");
//        orderMaster.setBuyerOpenid(OPEN_ID);
//        orderMaster.setOrderAmount(new BigDecimal(2.5));
//        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(OPEN_ID, pageRequest);
        System.out.println(orderMasterPage.getTotalElements());



    }

}