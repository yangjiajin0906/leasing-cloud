package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
/**
 * @project:leasing-cloud
 * @date:2019-12-08
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CbInvoiceApplyDetailQuery  extends BaseQuery {

    @QueryCondition(field = "a.pkInvoiceApply")
    private String pkInvoiceApply;

    @QueryCondition(field = "a.billingStatus")
    private Integer billingStatus;

    public String getPkInvoiceApply() {
        return pkInvoiceApply;
    }

    public void setPkInvoiceApply(String pkInvoiceApply) {
        this.pkInvoiceApply = pkInvoiceApply;
    }

    public Integer getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(Integer billingStatus) {
        this.billingStatus = billingStatus;
    }
}