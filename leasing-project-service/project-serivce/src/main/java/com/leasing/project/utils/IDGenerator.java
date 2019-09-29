package com.leasing.project.utils;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019/9/26
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class IDGenerator extends IdentityGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws MappingException{

        String query = "select  SEQ_PROJECT_INFO.nextval from dual";
        Object id = SpringUtils.getJdbcTemplate().queryForObject(query,String.class);
        if(id != null){
            return (Serializable) id;
        }
        return super.generate(session, object);
    }
}
