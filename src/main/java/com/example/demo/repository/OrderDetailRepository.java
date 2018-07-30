package com.example.demo.repository;

import com.example.demo.repository.dao.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/7/29 15:56
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 指定订单id  查询订单的详情
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}

