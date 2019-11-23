package com.congee.service;

import com.congee.domain.Order;
import com.congee.utils.Result;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);

    Order findById(Integer oid);

    //测试订单详情页面
    public Order findByOrderNo(String orderNo);

    //测试订单新增暂未支付
    public Order save(Order order);

    //测试订单更改支付状态
    public Order saveAndFlush(Order order);

    //测试订单分页降序
    public Result find(Integer page, Integer size);

    //测试查询订单未支付 & 已支付
    public Result findByOStatus(Integer oStatus);

    //测试根据订单状态降序
   // public Result findOrderByOCreatetimeAndOStatus(Integer oStatus);
}
