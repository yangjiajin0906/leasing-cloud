package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class WithdrawDetailQuery extends BaseQuery {

    /**
     * 付款批次号
     */
    @QueryCondition
    private String paymentBatchNo;

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
    }
}