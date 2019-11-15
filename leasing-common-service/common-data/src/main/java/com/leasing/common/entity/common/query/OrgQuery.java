package com.leasing.common.entity.common.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:wangjc@yonyou.com
 * @description: 机构查询类
 **/
public class OrgQuery extends BaseQuery {
    @QueryCondition(func = MatchType.like,field = "p.orgCode")
    private String orgCode;

    public OrgQuery(){}

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}