package com.example.demo.util;

import com.example.demo.dto.OrderDto;
import com.example.demo.repository.dao.OrderMaster;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2018/7/30 23:19
 * @GitHub：https://github.com/yuxuelian
 * @email：kaibo1hao@gmail.com
 * @description：
 */

public class ObjectConverter {

    public static OrderDto orderMaster2OrderDto(OrderMaster orderMaster) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(orderMaster, orderDto);
        return orderDto;
    }

    public static List<OrderDto> orderMasterList2OrderDtoList(List<OrderMaster> orderMasterList) {
        return orderMasterList.stream().map(orderMaster -> orderMaster2OrderDto(orderMaster)).collect(Collectors.toList());
    }

}
