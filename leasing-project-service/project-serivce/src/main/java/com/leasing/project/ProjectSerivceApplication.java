package com.leasing.project;

import com.leasing.project.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Import(SpringUtils.class)
public class ProjectSerivceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectSerivceApplication.class, args);
    }

}
