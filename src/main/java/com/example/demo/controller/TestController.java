package com.example.demo.controller;

import com.example.demo.bean.ProductCategory;
import com.example.demo.dao.ProductCategoryRepository;
import com.example.demo.mapper.ProductCategoryMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author kaibo
 * @date 2018/7/26 10:40
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
public class TestController {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @GetMapping("test1/{id}/")
    public ProductCategory test1(@PathVariable(name = "id") Integer id) {
        System.out.println(id);
        ProductCategory ex = new ProductCategory();
        ex.setCategoryId(1);
        Optional<ProductCategory> optional = productCategoryRepository.findOne(Example.of(ex));
        return optional.orElse(ex);
    }


}
