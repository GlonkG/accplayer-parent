package com.congee.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: 小米粥
 * @description: com.congee.controller
 * @date: 2019/10/29
 * @time: 14:03
 */
@SpringBootApplication
@EnableEurekaClient
public class MailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }
}
