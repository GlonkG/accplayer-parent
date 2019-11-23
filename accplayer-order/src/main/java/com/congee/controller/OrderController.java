package com.congee.controller;

import com.congee.domain.Order;
import com.congee.domain.OrderDetail;
import com.congee.service.OrderService;
import com.congee.utils.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class OrderController {
    //新增订单
    @Autowired
    private OrderService orderService;

    private static Order order = null;
    @RequestMapping("/saveOrder")
    @ResponseBody
    public Order saveOrder(@RequestBody Order order){
        this.order=createOrderNum(order);
        System.out.println(this.order);
        Order order1 = new Order();
        order1.setOrderNo(this.order.getOrderNo());
        order1.setUserNickname(order.getUserNickname());//昵称
        order1.setApid(order.getApid());//陪玩ID
        order1.setGid(order.getGid());//板块ID
        order1.setGName(order.getGName());//板块名称
        order1.setOAppointedtime(order.getOAppointedtime());//下单次数==即几个小时
        order1.setOMoney(order.getOMoney());//订单总金额
        order1.setOCreatetime(new Date());//订单创建时间
        order1.setOStatus(0);//支付状态：暂未支付
        Order save = orderService.save(order1);
        return save;
    }
    //生成订序号
    public Order createOrderNum(Order order1){
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for (int i=0;i<16;i++){
            int i1 = random.nextInt(9);
            str.append(i1);
        }
        order1.setOrderNo(str.toString());
        return order1;
    }

    //根据id查询订单详情
    @RequestMapping("/findOne/{oid}")
    @ResponseBody
    public Order findById(@PathVariable("oid")Integer oid){
            Order byId = orderService.findById(oid);
            return byId;
    }

    //测试查询订单详情
    @RequestMapping("/findByOrderNo/{orderNo}")
    @ResponseBody
    public Order findByOrderNo(@PathVariable("orderNo")String orderNo){
        Order byOrderNo = orderService.findByOrderNo(orderNo);
        return byOrderNo;
    }

    //测试更改订单状态
    @RequestMapping("/updOrder")
    @ResponseBody
    public String updOrder(@RequestBody Order order){
        Order order1 = orderService.saveAndFlush(order);
        if(order1!=null){
            return "updOrder success";
        }
        return "updOrder failure";
    }

    //测试订单分页降序
    @RequestMapping("/sortByoCreatetime/{page}/{size}")
    @ResponseBody
    public Result find(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Result result = orderService.find(page, size);
        return result;
    }

    //测试查询订单未支付 & 已支付
    @RequestMapping("/findByoStatus/{oStatus}")
    @ResponseBody
    public Result findByoStatus(@PathVariable("oStatus")Integer oStatus){
        Result byOStatus = orderService.findByOStatus(oStatus);
        return byOStatus;
    }


    //测试查询订单未支付 & 已支付
    /*@RequestMapping("/findOrderByOCreatetimeAndOStatus/{oStatus}")
    @ResponseBody
    public Result findOrderByOCreatetimeAndOStatus(@PathVariable("oStatus")Integer oStatus){
        Result byOStatus = orderService.findOrderByOCreatetimeAndOStatus(oStatus);
        return byOStatus;
    }*/

}
