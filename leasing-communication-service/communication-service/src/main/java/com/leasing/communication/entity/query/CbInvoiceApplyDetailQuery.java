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

    @QueryCondition(field = "pk_invoice_apply")
    private String pkInvoiceApply;

    @QueryCondition(field = "billing_status")
    private String billingStatus;

    public String getPkInvoiceApply() {
        return pkInvoiceApply;
    }

    public void setPkInvoiceApply(String pkInvoiceApply) {
        this.pkInvoiceApply = pkInvoiceApply;
    }

    public String getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(String billingStatus) {
        this.billingStatus = billingStatus;
    }
}