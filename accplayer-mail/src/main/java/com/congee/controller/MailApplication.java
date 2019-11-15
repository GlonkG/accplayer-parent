package com.congee.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger log = LoggerFactory.getLogger(MailApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
        log.info("消息服务已启动====================");
    }
}
