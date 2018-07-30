package com.example.demo.mapper;

import com.example.demo.repository.dao.ProductCategory;

import java.util.List;

/**
 * @author kaibo
 * @date 2018/7/26 14:43
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface ProductCategoryMapper {

    int save(ProductCategory productCategory);

    List<ProductCategory> findAll();
}

