package com.leasing.project.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @project:leasing-cloud
 * @date:2019/9/26
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Component
public class SpringUtils implements ApplicationContextAware {

    private static String JDBCTEMPLATE = "jdbcTemplate";

    /**
     * 当前IOC
     */
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }


    /**
     * 获取bean
     */
    public static Object getBean(String id){
        Object object = applicationContext.getBean(id);
        return object;
    }

    /**
     * 获取JDBC
     */
    public static JdbcTemplate getJdbcTemplate(){
        return (JdbcTemplate) SpringUtils.getBean(JDBCTEMPLATE);
    }
}
