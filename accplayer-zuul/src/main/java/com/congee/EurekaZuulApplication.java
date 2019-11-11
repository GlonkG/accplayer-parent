package com.congee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/10
 * @time: 21:09
 */
@SpringBootApplication
@EnableZuulProxy//开启网关服务支持
public class EurekaZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulApplication.class,args);
    }
}
