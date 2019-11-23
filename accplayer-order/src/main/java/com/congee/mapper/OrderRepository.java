package com.congee.mapper;

import com.congee.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.mapper
 * @date: 2019/11/19
 * @time: 12:56
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
    //测试订单详情页面
    public Order findByOrderNo(String orderNo);

    //测试查询订单未支付 & 已支付
    public List<Order> findByOStatus(Integer oStatus);

    //测试根据订单状态降序
    //public List<Order> findOrderByOCreatetimeAndOStatus(Sort sort,Integer oStatus);

}
