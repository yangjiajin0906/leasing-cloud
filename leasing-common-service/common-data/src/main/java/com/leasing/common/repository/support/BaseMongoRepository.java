package com.leasing.common.repository.support;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

/**
 * @project:leasing-cloud
 * @date:2019-9-24
 * @author:lvcna@yonyou.com
 * @description: Mongo数据层基类
 **/
public class BaseMongoRepository<T, ID> extends SimpleMongoRepository<T, ID> {

    public BaseMongoRepository(MongoEntityInformation metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
    }
}
