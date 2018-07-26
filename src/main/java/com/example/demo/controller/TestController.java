package com.example.demo.controller;

import com.example.demo.bean.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.service.ProductCategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    private ProductCategoryService productCategoryService;

    @GetMapping("test1/{id}/")
    public ProductCategory test1(@PathVariable(name = "id") Integer id) {
        System.out.println(id);
        ProductCategory productCategory = productCategoryService.findOne(1);
        return productCategory;
    }

    @GetMapping("findProductCategoryAll/")
    public List<ProductCategory> findAll() {
        return productCategoryService.findAll();
    }

}
