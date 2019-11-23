package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/16
 * @time: 9:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UploadApplication {
    private final static Logger log = LoggerFactory.getLogger(UploadApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UploadApplication.class, args);
        log.info("OSS服务已启动====================");

    }
}
