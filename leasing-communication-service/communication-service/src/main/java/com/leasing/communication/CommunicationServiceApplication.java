package com.leasing.communication;

import com.leasing.common.base.repository.support.BaseRepositoryImpl;
import com.leasing.communication.utils.JpaNamingStrategy;
import com.leasing.communication.utils.SpringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Import({SpringUtils.class, JpaNamingStrategy.class})
@SpringBootApplication(scanBasePackages = {"com.leasing.communication","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
		basePackages = {"com.leasing.communication","com.leasing.common"})
@EntityScan(basePackages = {"com.leasing.communication","com.leasing.common"})
public class CommunicationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationServiceApplication.class, args);
	}

}
