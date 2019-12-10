package com.leasing.common.utils.frame;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: Spring 工具类
 **/
@Component
public class SpringUtils implements ApplicationContextAware {

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
    public static Object getBean(String id) {
        Object object = applicationContext.getBean(id);
        return object;
    }
}

