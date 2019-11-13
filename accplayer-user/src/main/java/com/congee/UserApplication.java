package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/11
 * @time: 13:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {
    private final static Logger log = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
        log.info("用户服务已启动====================");
    }
}
