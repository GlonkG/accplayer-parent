package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 小米粥
 * @description: com
 * @date: 2019/11/12
 * @time: 18:46
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AccApplication {
    private final static Logger log = LoggerFactory.getLogger(AccApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccApplication.class,args);
        log.info("陪玩服务已启动====================");
    }
}
