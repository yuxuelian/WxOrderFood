package com.example.demo.controller;

import com.example.demo.bean.ProductCategory;
import com.example.demo.bean.ProductInfo;
import com.example.demo.result.BaseResult;
import com.example.demo.result.ProductInfoResult;
import com.example.demo.result.ProductResult;
import com.example.demo.service.ProductCategoryService;
import com.example.demo.service.ProductInfoService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author Administrator
 * @date 2018/7/28 20:54
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：买家商品相关
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    public BaseResult<List<ProductResult>> list() {
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2.查询类目(注意:一次性查询,不要一条一条去查)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装
        List<ProductResult> productResultList = new ArrayList<>();
        productCategoryList.forEach(productCategory -> {
            ProductResult productResult = new ProductResult();
            productResult.setCategoryName(productCategory.getCategoryName());
            productResult.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoResult> productInfoResultList = new ArrayList<>();
            productInfoList.forEach(productInfo -> {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoResult productInfoResult = new ProductInfoResult();
                    //将 productInfo  copy  到  productInfoResult(有前后顺序)
                    BeanUtils.copyProperties(productInfo, productInfoResult);
                    productInfoResultList.add(productInfoResult);
                }
            });
            productResult.setProductInfoList(productInfoResultList);
            productResultList.add(productResult);
        });
        return BaseResult.ofSuccess(productResultList);
    }

    @GetMapping("/error")
    public void error() {
        int i = 1 / 0;
    }

}
