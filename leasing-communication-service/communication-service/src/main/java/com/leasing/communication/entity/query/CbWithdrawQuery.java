package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019-11-20
 * @author:zhangzhhn@yonyou.com
 * @description: 付款查询条件
 **/
public class CbWithdrawQuery extends BaseQuery {

    /**
     * 合同编号
     */
    @QueryCondition(func = MatchType.like,field = "contCode")
    private String contCode;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }
}