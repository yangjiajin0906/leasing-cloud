package com.leasing.common.utils;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class DozerUtils {
    public static <T> T convert(Object source, Class<T> destinationClass){
        T t = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(source,destinationClass);
        return t;
    }

    public static <T> T convertByid(Object source, Class<T> destinationClass,String mapid){
        T t = DozerBeanMapperConfigure.BEANMAPPER.getMapper().map(source,destinationClass,mapid);
        return t;
    }
}