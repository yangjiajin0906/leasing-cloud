package com.leasing.communication.entity.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 收款查询条件
 **/
public class CapitalQueryVO extends BaseQuery {

    @QueryCondition(func = MatchType.like,field = "contCode")
    private String contCode;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }
}