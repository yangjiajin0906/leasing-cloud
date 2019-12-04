package com.leasing.customer.dao.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class AnalysisBalanceQuery extends BaseQuery {


    @QueryCondition(field = "a.pkIndexAnalysis.pkIndexAnalysis")
    private String pkIndexAnalysis;

    public String getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(String pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }
}