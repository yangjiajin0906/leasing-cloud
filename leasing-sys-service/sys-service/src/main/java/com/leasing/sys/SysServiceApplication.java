package com.leasing.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.leasing.sys","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
//添加熔断降级注解
@EnableCircuitBreaker
public class SysServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysServiceApplication.class, args);
    }
}
