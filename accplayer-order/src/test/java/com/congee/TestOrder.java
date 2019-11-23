package com.congee;

import com.congee.service.OrderService;
import com.congee.utils.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/20
 * @time: 9:28
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestOrder {
    @Autowired
    private OrderService orderService;

    @Test
    public void test1(){
        Result all = orderService.find(1,2);
        System.out.println(all);

    }

    @Test
    public void test2(){
        Result byOStatus = orderService.findByOStatus(0);
        System.out.println(byOStatus);
    }

    /*@Test
    public void test3(){
        Result byOStatus = orderService.findOrderByOCreatetimeAndOStatus(0);
        System.out.println(byOStatus);
    }*/
}
