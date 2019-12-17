package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class CbInvoiceApplyQuery extends BaseQuery {

    /**
     * 开票批次号
     */
    @QueryCondition(func = MatchType.like,field = "invoice_batch_no")
    public String invoiceBatchNo;


    public String getInvoiceBatchNo() {
        return invoiceBatchNo;
    }

    public void setInvoiceBatchNo(String invoiceBatchNo) {
        this.invoiceBatchNo = invoiceBatchNo;
    }
}
