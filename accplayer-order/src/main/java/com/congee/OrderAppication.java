package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
public class OrderAppication {
    private final static Logger log = LoggerFactory.getLogger(OrderAppication.class);
    public static void main(String[] args) {
        SpringApplication.run(OrderAppication.class);
        log.info("订单服务已启动====================");
    }
}
