package com.congee.service.impl;

import com.congee.domain.Order;
import com.congee.mapper.OrderMapper;
import com.congee.mapper.OrderRepository;
import com.congee.service.OrderService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Order saveOrder(Order order) {
        Order order1 = orderMapper.saveOrder(order);
        if(order1!=null){
            return order1;
        }
        return null;
    }

    @Override
    public Order findById(Integer oid) {
        Order byId = orderMapper.findById(oid);
        if (byId!=null){
            return byId;
        }
        return null;
    }

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order findByOrderNo(String orderNo) {
        Order byOrderNo = orderRepository.findByOrderNo(orderNo);
        return byOrderNo;
    }

    @Override
    public Order save(Order order) {
        Order save = orderRepository.save(order);
        return save;
    }

    @Override
    public Order saveAndFlush(Order order) {
        Order order1 = orderRepository.saveAndFlush(order);
        return order1;
    }

    @Override
    public Result find(Integer page, Integer size) {
        if(null==page){
            page = 1;
        }
        if(null==size){
            size = 5;
        }
        PageRequest pageable = PageRequest.of(page-1,size,Sort.Direction.DESC,"oCreatetime");
        Page<Order> all = orderRepository.findAll(pageable);
        Result result = new Result();
        result.setTotal(all.getTotalElements());
        result.setList(all.getContent());
        result.setCode(200);
        result.setMessage("订单降序分页查询成功");
        return result;
    }

    @Override
    public Result findByOStatus(Integer oStatus) {
        List<Order> byOStatus = orderRepository.findByOStatus(oStatus);
        Result result = new Result();
        result.setTotal(byOStatus.size());
        result.setList(byOStatus);
        result.setCode(200);
        result.setMessage("根据订单支付状态查询成功");
        return result;
    }

   /* @Override
    public Result findOrderByOCreatetimeAndOStatus(Integer oStatus) {
        Sort sort = new Sort(Sort.Direction.DESC, "oCreatetime");
        List<Order> order = orderRepository.findOrderByOCreatetimeAndOStatus(sort, oStatus);
        Result result = new Result();
        result.setTotal(order.size());
        result.setList(order);
        result.setCode(200);
        result.setMessage("根据订单支付状态降序查询成功");
        return result;
    }*/

}
