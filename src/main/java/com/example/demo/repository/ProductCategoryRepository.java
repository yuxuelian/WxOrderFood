package com.example.demo.repository;

import com.example.demo.bean.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author kaibo
 * @date 2018/7/26 10:07
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {


    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeDesc(List<Integer> categoryTypeList);

}
