package com.example.demo.repository;

import com.example.demo.repository.dao.OrderMaster;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 * @date 2018/7/29 15:55
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 查询指定买家的订单
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
