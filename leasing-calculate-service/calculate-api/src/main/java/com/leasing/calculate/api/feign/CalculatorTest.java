package com.leasing.calculate.api.feign;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lvcn on 2019-9-18.
 */
@RequestMapping(value = "/leasing/calculate")
public interface CalculatorTest {

    @RequestMapping(value = "/testFeign")
    String TestFeign(@RequestParam(value = "str", required = false) String str);
}
