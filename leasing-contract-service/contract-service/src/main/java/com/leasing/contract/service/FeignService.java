package com.leasing.contract.service;

        import com.leasing.common.api.feign.calculate.CalculatorTest;
        import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "leasing-calculate-service")
public interface FeignService extends CalculatorTest {
}
