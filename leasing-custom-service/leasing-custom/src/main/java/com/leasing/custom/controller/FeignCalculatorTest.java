package com.leasing.custom.controller;

import com.leasing.common.api.feign.calculate.CalculatorTest;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by lvcn on 2019-9-20.
 */
@FeignClient(value = "leasing-calculate-service")
public interface FeignCalculatorTest extends CalculatorTest {
}
