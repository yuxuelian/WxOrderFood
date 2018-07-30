package com.example.demo.repository;

import com.example.demo.repository.dao.ProductCategory;

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


    /**
     * 查询指定商品类目的商品类目列表
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeInOrderByCategoryTypeDesc(List<Integer> categoryTypeList);

}
