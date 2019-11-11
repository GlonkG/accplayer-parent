package com.congee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: 小米粥
 * @description: com.itqf
 * @date: 2019/11/10
 * @time: 21:15
 */
@SpringBootApplication
@EnableConfigServer//开启springcloud config支持
@EnableDiscoveryClient
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class,args);
    }
}
