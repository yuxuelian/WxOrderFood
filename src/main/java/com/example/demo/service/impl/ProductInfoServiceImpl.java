package com.example.demo.service.impl;

import com.example.demo.dto.CartDto;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.exception.ResultException;
import com.example.demo.repository.dao.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.repository.ProductInfoRepository;
import com.example.demo.service.ProductInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Administrator
 * @date 2018/7/28 20:33
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void increaseStock(List<CartDto> cartDtoList) {
        cartDtoList.forEach(cartDto -> {
            ProductInfo productInfo = repository.findById(cartDto.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new ResultException(ResultCodeEnum.PRODUCT_NOT_EXIST);
            }
            //直接加这个库存
            int resultStock = productInfo.getProductStock() + cartDto.getProductQuantity();
            //设置新的库存
            productInfo.setProductStock(resultStock);
            //更新一下
            repository.save(productInfo);
        });
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void decreaseStock(List<CartDto> cartDtoList) {
        cartDtoList.forEach(cartDto -> {
            ProductInfo productInfo = repository.findById(cartDto.getProductId()).orElse(null);
            if (productInfo == null) {
                throw new ResultException(ResultCodeEnum.PRODUCT_NOT_EXIST);
            }
            int resultStock = productInfo.getProductStock() - cartDto.getProductQuantity();
            if (resultStock < 0) {
                throw new ResultException(ResultCodeEnum.PRODUCT_STOCK_ERROR);
            }
            //设置新的库存
            productInfo.setProductStock(resultStock);
            //更新一下
            repository.save(productInfo);
        });
    }
}
