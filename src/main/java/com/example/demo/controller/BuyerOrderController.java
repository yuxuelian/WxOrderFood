package com.example.demo.controller;

import com.example.demo.dto.OrderDto;
import com.example.demo.enums.ResultCodeEnum;
import com.example.demo.exception.ResultException;
import com.example.demo.form.OrderForm;
import com.example.demo.result.BaseResult;
import com.example.demo.service.BuyerService;
import com.example.demo.service.OrderService;
import com.example.demo.util.ConnectionUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Administrator
 * @date 2018/7/31 23:22
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单接口
     *
     * @param orderForm
     * @return
     */
    @PostMapping("/create")
    public BaseResult<Map<String, String>> create(@RequestBody OrderForm orderForm,
                                                  BindingResult bindingResult) {
        //判断一下表单校验之后是否有错
        if (bindingResult.hasErrors()) {
            log.error("[创建订单] 参数不正确 orderForm={}", orderForm);
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        if (ConnectionUtils.isEmpty(orderForm.getOrderDetailList())) {
            log.error("[创建订单] 购物车为空 orderForm={}", orderForm);
            throw new ResultException(ResultCodeEnum.PARAMETER_CART_EMPTY.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderForm, orderDto);
        System.out.println(orderDto);
        //创建订单
        OrderDto result = orderService.create(orderDto);
        //返回创建完成的订单的id
        return BaseResult.ofSuccess(new HashMap<String, String>() {{
            put("orderId", result.getOrderId());
        }});
    }

    /**
     * 查询订单列表
     *
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list")
    public BaseResult<List<OrderDto>> list(@RequestParam("openid") String openid,
                                           @RequestParam("page") Integer page,
                                           @RequestParam("size") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.info("[查询订单列表] openid为空");
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(), "openid不能为空");
        }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDto> orderDtoPage = orderService.findList(openid, pageRequest);
        return BaseResult.ofSuccess(orderDtoPage.getContent());
    }

    /**
     * 订单详情
     *
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/detail")
    public BaseResult<OrderDto> detail(@RequestParam("openid") String openid,
                                       @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            log.info("[查询订单详情] openid为空");
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(), "openid不能为空");
        }
        if (StringUtils.isEmpty(orderId)) {
            log.info("[查询订单详情] orderId为空");
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(), "orderId不能为空");
        }
        OrderDto orderDto = buyerService.findOrderOne(openid, orderId);
        return BaseResult.ofSuccess(orderDto);
    }

    /**
     * 取消订单
     *
     * @param openid
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public BaseResult<Object> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        if (StringUtils.isEmpty(openid)) {
            log.info("[取消订单] openid为空");
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(), "openid不能为空");
        }
        if (StringUtils.isEmpty(orderId)) {
            log.info("[取消订单] orderId为空");
            throw new ResultException(ResultCodeEnum.PARAMETER_CHECK_ERROR.getCode(), "orderId不能为空");
        }
        //取消订单
        buyerService.cancelOrder(openid, orderId);
        return BaseResult.ofSuccess(null);
    }
}
