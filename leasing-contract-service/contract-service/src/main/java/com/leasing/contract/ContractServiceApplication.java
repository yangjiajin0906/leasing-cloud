package com.leasing.contract;

import com.leasing.contract.entity.AuditorAwareImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.leasing.contract","com.leasing.common"})
@EnableEurekaClient
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ContractServiceApplication {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(ContractServiceApplication.class, args);
    }

}
