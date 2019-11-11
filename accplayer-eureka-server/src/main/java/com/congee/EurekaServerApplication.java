package com.congee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/10
 * @time: 21:04
 */
@SpringBootApplication
@EnableEurekaServer//开启注册中心支持
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
