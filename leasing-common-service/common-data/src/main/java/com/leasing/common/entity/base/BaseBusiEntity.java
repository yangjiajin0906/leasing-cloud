package com.leasing.common.entity.base;

import javax.persistence.Version;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 业务对象实体基类
 **/
public abstract class BaseBusiEntity extends BaseEntity{

    /**
     * 获取业务对象对应的数据库表名
     * @return
     */
    public abstract String getTableName();






}
