package com.leasing.common.entity.common.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则查询参数类
 **/
public class CoderuleQuery extends BaseQuery {
    @QueryCondition(field = "b.businessPoint")
    private String businessPoint;

    public CoderuleQuery(){}

    public String getBusinessPoint() {
        return businessPoint;
    }

    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint;
    }
}