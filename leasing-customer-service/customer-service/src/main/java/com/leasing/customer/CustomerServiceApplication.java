package com.leasing.customer;

import com.leasing.common.base.repository.support.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @project:leasing-cloud
 * @date:2019-09-23
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务启动类
 **/
@SpringBootApplication(scanBasePackages = {"com.leasing.customer","com.leasing.common"})
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
        basePackages = {"com.leasing.customer","com.leasing.common"})
@EntityScan(basePackages = {"com.leasing.customer","com.leasing.common"})
@EnableEurekaClient
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
}