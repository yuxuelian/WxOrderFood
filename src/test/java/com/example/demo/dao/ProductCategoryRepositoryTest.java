package com.example.demo.dao;

import com.example.demo.DemoApplication;
import com.example.demo.bean.ProductCategory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;


/**
 * @author kaibo
 * @date 2018/7/26 10:07
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOne() {
        ProductCategory ex = new ProductCategory();
        ex.setCategoryId(1);
        Optional<ProductCategory> optional = repository.findOne(Example.of(ex));
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

}













