package com.leasing.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @project:leasing-cloud
 * @date:2019-09-23
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务启动类
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}