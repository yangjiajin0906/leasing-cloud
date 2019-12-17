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
     * 批次号
     */
    @QueryCondition(func = MatchType.like,field = "payment_batch_no")
    private String paymentBatchNo;

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
    }
}