package com.leasing.communication.entity.dto;

import com.leasing.common.base.annotation.Excel;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-05
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CbWithdrawDetailDTO {

    @Excel(titleName = "合同编号",orderNum = 0)
    private String contCode;

    @Excel(titleName = "合同名称", orderNum = 1)
    private String contName;

    /**
     * 收款人
     */
    @Excel(titleName = "收款人", orderNum = 2)
    private String payeeName;

    /**
     * 收款账号
     */
    @Excel(titleName = "收款账号", orderNum = 3)
    private String receivingAccount;

    /**
     * 银行开户行
     */
    @Excel(titleName = "银行开户行", orderNum = 4)
    private String openingBank;

    /**
     * 行号
     */
    @Excel(titleName = "行号", orderNum = 5)
    private String accountNumber;

    /**
     * 合同签订日
     */
    @Excel(titleName = "行号", orderNum = 6)
    private String contSignedDate;

    /**
     * 运营商套餐金额（月）
     */
    @Excel(titleName = "行号", orderNum = 7)
    private BigDecimal operatorAmount;
    /**
     * 运营商套餐期限
     */
    @Excel(titleName = "行号", orderNum = 8)
    private String operatorDeadline;

    /**
     * 终端名称
     */
    @Excel(titleName = "行号", orderNum = 9)
    private String terminalName;

    /**
     * 终端型号
     */
    @Excel(titleName = "行号", orderNum = 10)
    private String terminalType;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 11)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 12)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期", orderNum = 13)
    private String dateFrom;


    /**
     * 合同金额
     */
    @Excel(titleName = "合同金额", orderNum = 14)
    private BigDecimal contAmount;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式", orderNum = 15)
    private Integer leaseType;

    /**
     * 实际放款金额
     */
    @Excel(titleName = "实际放款金额", orderNum = 16)
    private BigDecimal actualLoanAmount;

    /**
     * 付款账号
     */
    @Excel(titleName = "付款账号", orderNum = 17)
    private String paymentAccount;


    /**
     * 实付日期
     */
    @Excel(titleName = "实付日期", orderNum = 18)
    private String realPayDate;

    /**
     * 币种 (参照)
     */
    @Excel(titleName = "币种", orderNum = 19)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 20)
    private String companyMainBody;


    @Excel(titleName = "来源系统", orderNum = 21)
    private String sourceSys;

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

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(String receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getContSignedDate() {
        return contSignedDate;
    }

    public void setContSignedDate(String contSignedDate) {
        this.contSignedDate = contSignedDate;
    }

    public BigDecimal getOperatorAmount() {
        return operatorAmount;
    }

    public void setOperatorAmount(BigDecimal operatorAmount) {
        this.operatorAmount = operatorAmount;
    }

    public String getOperatorDeadline() {
        return operatorDeadline;
    }

    public void setOperatorDeadline(String operatorDeadline) {
        this.operatorDeadline = operatorDeadline;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
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

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public BigDecimal getContAmount() {
        return contAmount;
    }

    public void setContAmount(BigDecimal contAmount) {
        this.contAmount = contAmount;
    }

    public Integer getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(Integer leaseType) {
        this.leaseType = leaseType;
    }

    public BigDecimal getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(BigDecimal actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }

    public String getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public String getRealPayDate() {
        return realPayDate;
    }

    public void setRealPayDate(String realPayDate) {
        this.realPayDate = realPayDate;
    }

    public String getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(String pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }

    public String getSourceSys() {
        return sourceSys;
    }

    public void setSourceSys(String sourceSys) {
        this.sourceSys = sourceSys;
    }
}