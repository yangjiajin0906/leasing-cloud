package com.leasing.menu_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@SpringBootApplication
@EnableEurekaClient
public class MenuServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuServiceApplication.class, args);
    }
}