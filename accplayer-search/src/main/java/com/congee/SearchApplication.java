package com.congee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: 小米粥
 * @description: com.congee
 * @date: 2019/11/18
 * @time: 13:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SearchApplication {
    private final static Logger log = LoggerFactory.getLogger(SearchApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class,args);
        log.info("搜索服务已启动====================");
    }
}
