package com.leasing.calculate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CalculateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateServiceApplication.class, args);
	}

}
