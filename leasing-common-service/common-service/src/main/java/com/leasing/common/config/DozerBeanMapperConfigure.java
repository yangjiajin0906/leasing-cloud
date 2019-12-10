package com.leasing.common.config;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        mapper=new DozerBeanMapper();
        List<String> mappingfiles=new ArrayList<>();
        mappingfiles.add(DozerConfig.path);
        mapper.setMappingFiles(mappingfiles);
    }

    public DozerBeanMapper getMapper(){
        return  mapper;
    }


}