package com.leasing.customer.service;

import com.leasing.common.api.feign.calculate.CalculatorTest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @project:leasing-cloud
 * @date:2019-09-23
 * @author:zhangzhhn@yonyou.com
 * @description: 调用报价服务
 **/
@FeignClient(value = "leasing-calculate-service")
public interface CustomerService extends CalculatorTest{

}