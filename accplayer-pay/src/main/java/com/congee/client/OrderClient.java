package com.congee.client;

import com.congee.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author: 小米粥
 * @description: com.congee.client
 * @date: 2019/11/19
 * @time: 16:22
 */
@FeignClient(value = "accplayer-order",fallback = OrderMessage.class)
public interface OrderClient {

    @PostMapping("/updOrder")
    public String updOrder(@RequestBody Order order);
}
