package com.leasing.communication.entity.dto;

import com.leasing.common.base.annotation.Excel;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-10
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CbCapitalDetailImpDTO {


    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号", orderNum = 0)
    private String contCode;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称", orderNum = 1)
    private String contName;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 2)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 3)
    private String employerName;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式", orderNum = 4)
    private Integer leaseType;

    /**
     * 事件类别
     */
    @Excel(titleName = "事件类别", orderNum = 5)
    private String eventType;

    /**
     * 期次
     */
    @Excel(titleName = "期次", orderNum = 6)
    private Integer periodTime;

    /**
     * 应收日期
     */
    @Excel(titleName = "应收日期", orderNum = 7)
    private String receivableDate;

    /**
     * 应收金额
     */
    @Excel(titleName = "应收金额", orderNum = 8)
    private BigDecimal receivableAmount;

    /**
     * 应收本金
     */
    @Excel(titleName = "应收本金", orderNum = 9)
    private BigDecimal receivableCorpus;

    /**
     * 应收利息
     */
    @Excel(titleName = "应收利息", orderNum = 10)
    private BigDecimal receivableInterest;

    /**
     * 剩余本金
     */
    @Excel(titleName = "剩余本金", orderNum = 11)
    private BigDecimal surplusCorpus;

    /**
     * 到账金额
     */
    @Excel(titleName = "到账金额", orderNum = 12)
    private BigDecimal intoAccountAmount;

    /**
     * 到账日期
     */
    @Excel(titleName = "到账日期", orderNum = 13)
    private String intoAccountDate;
    /**
     * 核销状态
     */
    @Excel(titleName = "核销状态", orderNum = 14)
    private Integer verificationState;

    /**
     * 核销日期
     */
    @Excel(titleName = "核销日期", orderNum = 15)
    private String verificationDate;

    /**
     * 是否逾期
     */
    @Excel(titleName = "是否逾期", orderNum = 16)
    private Integer ifOverdue;

    /**
     * 抵扣状态
     */
    @Excel(titleName = "抵扣状态", orderNum = 17)
    private Integer deductionStatus;

    /**
     * 抵扣日期
     */
    @Excel(titleName = "抵扣日期", orderNum = 18)
    private String deductionDate;

    /**
     * 收款银行
     */
    @Excel(titleName = "收款银行", orderNum = 19)
    private String gatherBank;

    /**
     * 收款账号
     */
    @Excel(titleName = "收款账号", orderNum = 20)
    private String gatherAccount;

    /**
     * 核销金额
     */
    @Excel(titleName = "核销金额", orderNum = 21)
    private BigDecimal gatherBalance;

    /**
     * 实收本金
     */
    @Excel(titleName = "实收本金", orderNum = 22)
    private BigDecimal paidinCorpus;

    /**
     * 实收利息
     */
    @Excel(titleName = "实收利息", orderNum = 23)
    private BigDecimal paidinInterest;

    /**
     * 币种
     */
    @Excel(titleName = "币种", orderNum = 24)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 25)
    private String companyBody;

    /**
     * 来源系统
     */
    @Excel(titleName = "来源系统", orderNum = 26)
    private String pkSys;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public String getReceivableDate() {
        return receivableDate;
    }

    public void setReceivableDate(String receivableDate) {
        this.receivableDate = receivableDate;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public BigDecimal getReceivableCorpus() {
        return receivableCorpus;
    }

    public void setReceivableCorpus(BigDecimal receivableCorpus) {
        this.receivableCorpus = receivableCorpus;
    }

    public BigDecimal getReceivableInterest() {
        return receivableInterest;
    }

    public void setReceivableInterest(BigDecimal receivableInterest) {
        this.receivableInterest = receivableInterest;
    }

    public BigDecimal getSurplusCorpus() {
        return surplusCorpus;
    }

    public void setSurplusCorpus(BigDecimal surplusCorpus) {
        this.surplusCorpus = surplusCorpus;
    }

    public BigDecimal getIntoAccountAmount() {
        return intoAccountAmount;
    }

    public void setIntoAccountAmount(BigDecimal intoAccountAmount) {
        this.intoAccountAmount = intoAccountAmount;
    }

    public String getIntoAccountDate() {
        return intoAccountDate;
    }

    public void setIntoAccountDate(String intoAccountDate) {
        this.intoAccountDate = intoAccountDate;
    }

    public Integer getVerificationState() {
        return verificationState;
    }

    public void setVerificationState(Integer verificationState) {
        this.verificationState = verificationState;
    }

    public String getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(String verificationDate) {
        this.verificationDate = verificationDate;
    }

    public Integer getIfOverdue() {
        return ifOverdue;
    }

    public void setIfOverdue(Integer ifOverdue) {
        this.ifOverdue = ifOverdue;
    }

    public Integer getDeductionStatus() {
        return deductionStatus;
    }

    public void setDeductionStatus(Integer deductionStatus) {
        this.deductionStatus = deductionStatus;
    }

    public String getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(String deductionDate) {
        this.deductionDate = deductionDate;
    }

    public String getGatherBank() {
        return gatherBank;
    }

    public void setGatherBank(String gatherBank) {
        this.gatherBank = gatherBank;
    }

    public String getGatherAccount() {
        return gatherAccount;
    }

    public void setGatherAccount(String gatherAccount) {
        this.gatherAccount = gatherAccount;
    }

    public BigDecimal getGatherBalance() {
        return gatherBalance;
    }

    public void setGatherBalance(BigDecimal gatherBalance) {
        this.gatherBalance = gatherBalance;
    }

    public BigDecimal getPaidinCorpus() {
        return paidinCorpus;
    }

    public void setPaidinCorpus(BigDecimal paidinCorpus) {
        this.paidinCorpus = paidinCorpus;
    }

    public BigDecimal getPaidinInterest() {
        return paidinInterest;
    }

    public void setPaidinInterest(BigDecimal paidinInterest) {
        this.paidinInterest = paidinInterest;
    }

    public String getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public String getCompanyBody() {
        return companyBody;
    }

    public void setCompanyBody(String companyBody) {
        this.companyBody = companyBody;
    }

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
    }
}