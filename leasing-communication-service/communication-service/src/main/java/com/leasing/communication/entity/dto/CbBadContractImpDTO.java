package com.leasing.communication.entity.dto;

import com.leasing.common.base.annotation.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 不良合同DTO 2C业务 导入文件实体类，只用于导入，不参与前后端业务处理
 * @author Yangjiajin
 * @date 2019/12/5 13:44
 */
public class CbBadContractImpDTO {

    /**
     * 付款交易批次号
     */
    @Excel(titleName = "付款交易批次号",orderNum = 0)
    private String paymentTransactionBatch;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称",orderNum = 1)
    private String contName;

    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号",orderNum = 2)
    private String contCode;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称",orderNum = 3)
    private String customerName;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户编号",orderNum = 4)
    private String customerCode;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称",orderNum = 5)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期",orderNum = 6)
    private String rentDate;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式",orderNum = 7)
    private Integer leaseType;

    /**
     * 应收租金
     */
    @Excel(titleName = "应收租金",orderNum = 8)
    private BigDecimal receivableRent;

    /**
     * 实收租金
     */
    @Excel(titleName = "实收租金",orderNum = 9)
    private BigDecimal paidinRent;

    /**
     * 应收本金
     */
    @Excel(titleName = "应收本金",orderNum = 10)
    private BigDecimal receivableCorpus;

    /**
     * 实收本金
     */
    @Excel(titleName = "实收本金",orderNum = 11)
    private BigDecimal paidinCorpus;

    /**
     * 剩余本金
     */
    @Excel(titleName = "剩余本金",orderNum = 12)
    private BigDecimal corpusBalance;

    /**
     * 币种
     */
    @Excel(titleName = "币种",orderNum = 13)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体",orderNum = 14)
    private String companyBody;

    /**
     * 来源系统
     */
    @Excel(titleName = "来源系统",orderNum = 15)
    private String pkSys;

    /**
     * 付款交易批次号
     * @return PAYMENT_TRANSACTION_BATCH 付款交易批次号
     */
    public String getPaymentTransactionBatch() {
        return paymentTransactionBatch;
    }

    /**
     * 付款交易批次号
     * @param paymentTransactionBatch 付款交易批次号
     */
    public void setPaymentTransactionBatch(String paymentTransactionBatch) {
        this.paymentTransactionBatch = paymentTransactionBatch == null ? null : paymentTransactionBatch.trim();
    }

    /**
     * 合同名称
     * @return CONT_NAME 合同名称
     */
    public String getContName() {
        return contName;
    }

    /**
     * 合同名称
     * @param contName 合同名称
     */
    public void setContName(String contName) {
        this.contName = contName == null ? null : contName.trim();
    }

    /**
     * 合同编号
     * @return CONT_CODE 合同编号
     */
    public String getContCode() {
        return contCode;
    }

    /**
     * 合同编号
     * @param contCode 合同编号
     */
    public void setContCode(String contCode) {
        this.contCode = contCode == null ? null : contCode.trim();
    }

    /**
     * 客户名称
     * @return CUSTOMER_NAME 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户名称
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 单位名称
     * @return EMPLOYER_NAME 单位名称
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * 单位名称
     * @param employerName 单位名称
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName == null ? null : employerName.trim();
    }

    /**
     * 起租日期
     * @return RENT_DATE 起租日期
     */
    public String getRentDate() {
        return rentDate;
    }

    /**
     * 起租日期
     * @param rentDate 起租日期
     */
    public void setRentDate(String rentDate) {
        this.rentDate = rentDate == null ? null : rentDate.trim();
    }

    /**
     * 租赁方式
     * @return LEASE_TYPE 租赁方式
     */
    public Integer getLeaseType() {
        return leaseType;
    }

    /**
     * 租赁方式
     * @param leaseType 租赁方式
     */
    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    /**
     * 应收租金
     * @return RECEIVABLE_RENT 应收租金
     */
    public BigDecimal getReceivableRent() {
        return receivableRent;
    }

    /**
     * 应收租金
     * @param receivableRent 应收租金
     */
    public void setReceivableRent(BigDecimal receivableRent) {
        this.receivableRent = receivableRent;
    }

    /**
     * 实收租金
     * @return PAIDIN_RENT 实收租金
     */
    public BigDecimal getPaidinRent() {
        return paidinRent;
    }

    /**
     * 实收租金
     * @param paidinRent 实收租金
     */
    public void setPaidinRent(BigDecimal paidinRent) {
        this.paidinRent = paidinRent;
    }

    /**
     * 应收本金
     * @return RECEIVABLE_CORPUS 应收本金
     */
    public BigDecimal getReceivableCorpus() {
        return receivableCorpus;
    }

    /**
     * 应收本金
     * @param receivableCorpus 应收本金
     */
    public void setReceivableCorpus(BigDecimal receivableCorpus) {
        this.receivableCorpus = receivableCorpus;
    }

    /**
     * 实收本金
     * @return PAIDIN_CORPUS 实收本金
     */
    public BigDecimal getPaidinCorpus() {
        return paidinCorpus;
    }

    /**
     * 实收本金
     * @param paidinCorpus 实收本金
     */
    public void setPaidinCorpus(BigDecimal paidinCorpus) {
        this.paidinCorpus = paidinCorpus;
    }

    /**
     * 剩余本金
     * @return CORPUS_BALANCE 剩余本金
     */
    public BigDecimal getCorpusBalance() {
        return corpusBalance;
    }

    /**
     * 剩余本金
     * @param corpusBalance 剩余本金
     */
    public void setCorpusBalance(BigDecimal corpusBalance) {
        this.corpusBalance = corpusBalance;
    }

    /**
     * 币种
     * @return PK_CURRENCY 币种
     */
    public String getPkCurrency() {
        return pkCurrency;
    }

    /**
     * 币种
     * @param pkCurrency 币种
     */
    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency == null ? null : pkCurrency.trim();
    }

    /**
     * 公司主体
     * @return COMPANY_BODY 公司主体
     */
    public String getCompanyBody() {
        return companyBody;
    }

    /**
     * 公司主体
     * @param companyBody 公司主体
     */
    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody == null ? null : companyBody.trim();
    }

    /**
     * 来源系统
     * @return PK_SYS 来源系统
     */
    public String getPkSys() {
        return pkSys;
    }

    /**
     * 来源系统
     * @param pkSys 来源系统
     */
    public void setPkSys(String pkSys) {
        this.pkSys = pkSys == null ? null : pkSys.trim();
    }

}