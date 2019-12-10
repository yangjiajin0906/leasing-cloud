package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @description 逾期合同 和 不良合同 共用查询VO
 * @author Yangjiajin
 * @date 2019/12/9 11:40
 */
public class CbOverdueContractQuery extends BaseQuery {

    /**
     * 合同编号
     */
    @QueryCondition(func = MatchType.equal,field = "cont_code")
    public String contCode;

    /**
     * 合同名称
     */
    @QueryCondition(func = MatchType.like,field = "cont_name")
    public String contName;

    /**
     * 客户名称
     */
    @QueryCondition(func = MatchType.like,field = "customer_name")
    public String customerName;

    /**
     * 交易批次号
     */
    @QueryCondition(func = MatchType.equal,field = "payment_batch_no")
    public String paymentBatchNo;

    /**
     * 交易批次号(供不良合同用)
     * 不良合同和逾期合同 该字段名称不一致
     */
    @QueryCondition(func = MatchType.equal,field = "payment_transaction_batch")
    public String paymentTransactionBatch;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
    }

    public String getPaymentTransactionBatch() {
        return paymentTransactionBatch;
    }

    public void setPaymentTransactionBatch(String paymentTransactionBatch) {
        this.paymentTransactionBatch = paymentTransactionBatch;
    }
}
