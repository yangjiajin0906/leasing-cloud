package com.leasing.communication;

import com.leasing.common.base.repository.support.BaseRepositoryImpl;
import com.leasing.common.utils.frame.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Import({SpringUtils.class})
@SpringBootApplication(scanBasePackages = {"com.leasing.communication","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,
		basePackages = {"com.leasing.communication","com.leasing.common"})
@EntityScan(basePackages = {"com.leasing.communication","com.leasing.common"})
@EnableScheduling
public class CommunicationServiceApplication {

	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(CommunicationServiceApplication.class, args);
	}

}
