package com.example.demo.simulate;

import com.example.demo.result.BaseResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author kaibo
 * @date 2018/8/31 10:08
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
@Slf4j
public class TestDataController {

    @GetMapping("/goods")
    public BaseResult<List<SimulateData.GoodsBean>> goods() {
        return BaseResult.ofSuccess(JsonUtils.simulateData.getGoods());
    }

    @GetMapping("/ratings")
    public BaseResult<List<SimulateData.RatingsBean>> ratings() {
        return BaseResult.ofSuccess(JsonUtils.simulateData.getRatings());
    }

    @GetMapping("/seller")
    public BaseResult<SimulateData.SellerBean> seller() {
        return BaseResult.ofSuccess(JsonUtils.simulateData.getSeller());
    }

}
