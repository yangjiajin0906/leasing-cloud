package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019-12-04
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CbCapitalDetailQuery extends BaseQuery {

    @QueryCondition(func = MatchType.like,field = "b.capitalBatchNo")
    private String capitalBatchNo;

    public String getCapitalBatchNo() {
        return capitalBatchNo;
    }

    public void setCapitalBatchNo(String capitalBatchNo) {
        this.capitalBatchNo = capitalBatchNo;
    }
}