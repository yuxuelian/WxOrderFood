package com.example.demo.service;

import com.example.demo.bean.ProductCategory;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author Administrator
 * @date 2018/7/26 23:51
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface ProductCategoryService {

    @Nullable
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryList);

    ProductCategory save(@NonNull ProductCategory productCategory);

}
