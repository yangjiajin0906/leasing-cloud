package com.leasing.rentearly.rentearlyservice;

import com.leasing.common.base.repository.support.BaseRepositoryImpl;
import com.leasing.rentearly.rentearlyservice.projectInfo.utils.JpaNamingStrategy;
import com.leasing.rentearly.rentearlyservice.projectInfo.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Import({SpringUtils.class, JpaNamingStrategy.class})
@SpringBootApplication(scanBasePackages = {"com.leasing.rentearly.rentearlyservice","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
        basePackages = {"com.leasing.rentearly.rentearlyservice","com.leasing.common"})
@EntityScan(basePackages = {"com.leasing.rentearly.rentearlyservice","com.leasing.common"})
public class RentearlyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentearlyServiceApplication.class, args);
    }

}
