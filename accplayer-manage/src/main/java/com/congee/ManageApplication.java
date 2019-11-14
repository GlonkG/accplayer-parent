package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/13
 * @time: 22:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ManageApplication {
    private final static Logger log = LoggerFactory.getLogger(ManageApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class,args);
        log.info("管理服务已启动====================");
    }
}
