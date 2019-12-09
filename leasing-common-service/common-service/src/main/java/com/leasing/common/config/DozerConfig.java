package com.leasing.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * @project:leasing-cloud
 * @date:2019-12-4
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Component
@Lazy(value = false)
public class DozerConfig {


    public static String path;

    @Value("${dozer.path:dozer not found}")
    public void setPath( String path) {
        DozerConfig.path = path;
    }


}
