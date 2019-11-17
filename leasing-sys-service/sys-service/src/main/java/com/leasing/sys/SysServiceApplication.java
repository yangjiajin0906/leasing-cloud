package com.leasing.sys;

import com.leasing.common.base.repository.support.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.leasing.sys","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
        basePackages = {"com.leasing.sys","com.leasing.common"})
@EntityScan(basePackages = {"com.leasing.sys","com.leasing.common"})
public class SysServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SysServiceApplication.class, args);
    }

}
