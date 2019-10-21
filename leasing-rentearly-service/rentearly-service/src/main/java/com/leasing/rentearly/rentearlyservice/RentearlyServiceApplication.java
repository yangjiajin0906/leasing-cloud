package com.leasing.rentearly.rentearlyservice;

import com.leasing.rentearly.rentearlyservice.projectInfo.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import(SpringUtils.class)
public class RentearlyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentearlyServiceApplication.class, args);
    }

}
