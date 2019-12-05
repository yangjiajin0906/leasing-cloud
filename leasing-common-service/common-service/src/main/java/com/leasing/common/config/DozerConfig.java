package com.leasing.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @project:leasing-cloud
 * @date:2019-12-4
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Configuration
public class DozerConfig {

    @Value("${dozer.path:dozer not found}")
    public static String path;

}
