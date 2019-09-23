package com.leasing.common.api.feign.calculate;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvcn on 2019-9-18.
 */
@RequestMapping(value = "/leasing/calculate")
public interface CalculatorTest {

    @RequestMapping(value = "/testFeign")
    String TestFeign();
}
