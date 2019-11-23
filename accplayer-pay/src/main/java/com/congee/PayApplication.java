package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: 小米粥
 * @description: com.itqf
 * @date: 2019/10/17
 * @time: 23:17
 */
@SpringBootApplication
@EnableEurekaClient//表示它是一个Eureka的客户端
@EnableCircuitBreaker//开启Hystrix
@EnableFeignClients//开启Feign
public class PayApplication {
    private final static Logger log = LoggerFactory.getLogger(PayApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class,args);
        log.info("支付服务已启动====================");
    }
}
