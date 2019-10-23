package com.leasing.common.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:wangjc@yonyou.com
 * @description:
 **/

public enum DozerBeanMapperConfigure {
    BEANMAPPER;

    private DozerBeanMapper mapper = null;
    private DozerBeanMapperConfigure(){
        mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("utils/sysdozer-mapping.xml"));
    }

    public DozerBeanMapper getMapper(){
        return mapper;
    }


}