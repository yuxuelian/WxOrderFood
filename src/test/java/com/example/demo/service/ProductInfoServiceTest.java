package com.example.demo.service;

import com.example.demo.repository.dao.ProductInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @date 2018/7/28 20:39
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceTest {

    @Autowired
    private ProductInfoService service;

    @Test
    public void findOne() {
        System.out.println(service.findOne("123456"));
    }

    @Test
    public void findUpAll() {
        service.findUpAll().forEach(System.out::println);
    }

    @Test
    public void findAll() {
        Page<ProductInfo> productInfoPage = service.findAll(PageRequest.of(0, 2));
        long totalElements = productInfoPage.getTotalElements();
        int totalPages = productInfoPage.getTotalPages();

    }

    @Test
    public void save() {

    }
}