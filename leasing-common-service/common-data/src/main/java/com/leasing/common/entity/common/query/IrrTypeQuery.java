package com.leasing.common.entity.common.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件类别对Irr影响查询参数类
 **/
public class IrrTypeQuery extends BaseQuery {

    @QueryCondition(field = "i.irrTypeName")
    private Short irrTypeName;

    public IrrTypeQuery(){}

    public Short getIrrTypeName() {
        return irrTypeName;
    }

    public void setIrrTypeName(Short irrTypeName) {
        this.irrTypeName = irrTypeName;
    }
}