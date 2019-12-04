package com.leasing.common.utils.tools;

import com.leasing.common.config.DozerBeanMapperConfigure;

import com.leasing.common.config.DozerBeanMapperConfigure;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:wangjc@yonyou.com
 * @description:dozer转换器工具类 使用xml配置格式化转换实体类型
 **/
public class DozerUtils {
    public static <T> T convert(Object source, Class<T> destinationClass){
        T t = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(source,destinationClass);
        return t;
    }
}