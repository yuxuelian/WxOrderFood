package com.example.demo.repository;

import com.example.demo.repository.dao.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/7/28 18:10
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询指定商品状态的商品列表
     * @param productStatus
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);

}
