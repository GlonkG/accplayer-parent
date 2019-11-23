package com.congee.client;

import com.congee.domain.Order;
import org.springframework.stereotype.Component;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/19
 * @time: 16:35
 */
@Component
public class OrderMessage implements OrderClient {

    @Override
    public String updOrder(Order order) {
        return "对支付服务进行降级";
    }
}
