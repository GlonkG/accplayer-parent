package com.congee.controller;

import com.alipay.api.AlipayApiException;
import com.congee.client.OrderClient;
import com.congee.domain.Order;
import com.congee.utils.AlipayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

/*
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/11/19
 * @time: 13:50
*/

@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private AlipayUtils alipayUtils;
    @Autowired
    private OrderClient orderClient;
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String pay(@RequestBody Order order) {
        //更改订单信息
        Order order1 = new Order();
        order1.setUserTel(order.getUserTel());//手机号
        order1.setUserQq(order.getUserQq());//Qq号码
        order1.setOrderNo(order.getOrderNo());//订单流水号====订单编号
        order1.setOMoney(order.getOMoney());//订单金额
        order1.setGName(order.getGName());//订单主题
        order1.setOContent(order.getOContent());//订单描述
        Calendar calendar = Calendar.getInstance();
        order1.setOCreatetime(calendar.getTime());//修改时间
        if(order.getOStatus()==0){
            order.setOStatus(1);//将未支付改为已支付
            order1.setOStatus(order.getOStatus());
        }
        String pay = "";
        try {
            pay = alipayUtils.pay(order1);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        String s = orderClient.updOrder(order);
        if(s=="updOrder success"){
            System.out.println("您有一条新的订单信息入库啦!!!");
        }
        return pay;
    }

}
