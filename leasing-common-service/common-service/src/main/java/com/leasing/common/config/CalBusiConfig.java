package com.leasing.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @project:leasing-cloud
 * @date:2019/12/12
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Configuration
public class CalBusiConfig {
    public static String url;

    @Value("${calBusiness.path:http://127.0.0.1:8763}")
    public void setUrl(String url) {
        CalBusiConfig.url = url;
    }
}