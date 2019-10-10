package com.leasing.sys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(value = {"com.leasing.common","com.leasing.sys"})
public class SysServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SysServiceApplication.class, args);
	}

}
