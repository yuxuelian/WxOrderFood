package com.example.demo.service;

import com.example.demo.dto.CartDto;
import com.example.demo.repository.dao.ProductInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/7/28 20:30
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */
public interface ProductInfoService {

    @Nullable
    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     *
     * @param cartDtoList
     */
    void increaseStock(List<CartDto> cartDtoList);

    /**
     * 减库存
     *
     * @param cartDtoList
     */
    void decreaseStock(List<CartDto> cartDtoList);
}
