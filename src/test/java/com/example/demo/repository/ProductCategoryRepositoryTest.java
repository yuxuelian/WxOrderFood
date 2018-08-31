package com.example.demo.repository;

import com.example.demo.repository.dao.ProductCategory;
import com.example.demo.mapper.ProductCategoryMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author kaibo
 * @date 2018/7/26 10:07
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void findOne() {
        ProductCategory ex = new ProductCategory();
        ex.setCategoryId(1);
        Optional<ProductCategory> optional = repository.findOne(Example.of(ex));
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    @Test
    public void findById() {
        Optional<ProductCategory> optional = repository.findById(1);
        ProductCategory productCategory = optional.orElse(null);
        System.out.println(productCategory);
    }

    @Test
    public void save() {
//        ProductCategory ex = new ProductCategory("新品", 4);
//        int id = productCategoryMapper.save(ex);
//        System.out.println("影响行数" + id);
//        System.out.println("自增主键id" + ex.getCategoryId());

//        ProductCategory save = repository.save(ex);
//        System.out.println(save);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategorys = productCategoryMapper.findAll();
        for (ProductCategory productCategory : productCategorys) {
            System.out.println(productCategory);
        }
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = new ArrayList<>();
        categoryTypeList.add(1);
        categoryTypeList.add(2);
        categoryTypeList.add(3);
        categoryTypeList.add(4);
        categoryTypeList.add(5);
        List<ProductCategory> byCategoryTypeIn = repository.findByCategoryTypeInOrderByCategoryTypeDesc(categoryTypeList);
        byCategoryTypeIn.forEach(System.out::println);
    }

}













