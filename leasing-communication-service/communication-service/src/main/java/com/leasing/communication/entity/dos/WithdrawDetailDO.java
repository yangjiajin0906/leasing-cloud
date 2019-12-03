package com.leasing.communication.entity.dos;

import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.communication.utils.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_withdraw_detail")
public class WithdrawDetailDO extends FileBaseBusinessDO {


    /**
     * 付款信息主键
     */
    @Id
    @Excel(titleName = "主键", orderNum = 10)
    private String pkWithdrawDetail;

    /**
     * 合同编号
     */
    @Excel(titleName = "合同编号", orderNum = 11)
    private String contCode;

    /**
     * 合同名称
     */
    @Excel(titleName = "合同名称", orderNum = 12)
    private String contName;

    /**
     * 收款人
     */
    @Excel(titleName = "收款人", orderNum = 13)
    private String payeeName;

    /**
     * 收款账号
     */
    @Excel(titleName = "收款账号", orderNum = 14)
    private String receivingAccount;

    /**
     * 银行开户行
     */
    @Excel(titleName = "银行开户行", orderNum = 15)
    private String openingBank;

    /**
     * 行号
     */
    @Excel(titleName = "行号", orderNum = 16)
    private String accountNumber;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 17)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 18)
    private String employerName;

    /**
     * 起租日期
     */
    @Excel(titleName = "起租日期", orderNum = 19)
    private String dateFrom;

    /**
     * 合同金额
     */
    @Excel(titleName = "合同金额", orderNum = 20)
    private BigDecimal contAmount;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式", orderNum = 21)
    private Integer leaseType;

    /**
     * 实际放款金额
     */
    @Excel(titleName = "实际放款金额", orderNum = 22)
    private BigDecimal actualLoanAmount;

    /**
     * 付款账号
     */
    @Excel(titleName = "付款账号", orderNum = 23)
    private String paymentAccount;

    /**
     * 实付日期
     */
    @Excel(titleName = "实付日期", orderNum = 24)
    private String realPayDate;

    /**
     * 币种 (参照)
     */
    @Excel(titleName = "币种", orderNum = 25)
    private String pkCurrency;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 26)
    private String companyMainBody;

    /**
     * 付款批次号
     */
    private String paymentBatchNo;

    /**
     * 合同签订日
     */
    private String contSignedDate;

    /**
     * 运营商套餐金额（月）
     */
    private BigDecimal operatorAmount;
    /**
     * 运营商套餐期限
     */
    private String operatorDeadline;

    /**
     * 终端名称
     */
    private String terminalName;

    /**
     * 终端型号
     */
    private String terminalType;

    /**
     * 主表主键
     */
    private String pkWithdraw;


    @Override
    public String getPk() {
        return pkWithdrawDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkWithdrawDetail = pk;
    }

    /**
     * 付款信息主键
     * @return PK_WITHDRAW_REPAYMENT_C 付款信息主键
     */
    public String getPkWithdrawDetail() {
        return pkWithdrawDetail;
    }

    /**
     * 付款信息主键
     * @param pkWithdrawDetail 付款信息主键
     */
    public void setPkWithdrawDetail(String pkWithdrawDetail) {
        this.pkWithdrawDetail = pkWithdrawDetail == null ? null : pkWithdrawDetail.trim();
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
     * 收款人
     * @return PAYEE_NAME 收款人
     */
    public String getPayeeName() {
        return payeeName;
    }

    /**
     * 收款人
     * @param payeeName 收款人
     */
    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    /**
     * 收款账号
     * @return RECEIVING_ACCOUNT 收款账号
     */
    public String getReceivingAccount() {
        return receivingAccount;
    }

    /**
     * 收款账号
     * @param receivingAccount 收款账号
     */
    public void setReceivingAccount(String receivingAccount) {
        this.receivingAccount = receivingAccount == null ? null : receivingAccount.trim();
    }

    /**
     * 银行开户行
     * @return OPENING_BANK 银行开户行
     */
    public String getOpeningBank() {
        return openingBank;
    }

    /**
     * 银行开户行
     * @param openingBank 银行开户行
     */
    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
    }

    /**
     * 行号
     * @return ACCOUNT_NUMBER 行号
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * 行号
     * @param accountNumber 行号
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
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
     * @return DATE_FROM 起租日期
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * 起租日期
     * @param dateFrom 起租日期
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom == null ? null : dateFrom.trim();
    }

    /**
     * 合同金额
     * @return CONT_AMOUNT 合同金额
     */
    public BigDecimal getContAmount() {
        return contAmount;
    }

    /**
     * 合同金额
     * @param contAmount 合同金额
     */
    public void setContAmount(BigDecimal contAmount) {
        this.contAmount = contAmount;
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
     * 实际放款金额
     * @return ACTUAL_LOAN_AMOUNT 实际放款金额
     */
    public BigDecimal getActualLoanAmount() {
        return actualLoanAmount;
    }

    /**
     * 实际放款金额
     * @param actualLoanAmount 实际放款金额
     */
    public void setActualLoanAmount(BigDecimal actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }

    /**
     * 付款账号
     * @return PAYMENT_ACCOUNT 付款账号
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 付款账号
     * @param paymentAccount 付款账号
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount == null ? null : paymentAccount.trim();
    }

    /**
     * 实付日期
     * @return REAL_PAY_DATE 实付日期
     */
    public String getRealPayDate() {
        return realPayDate;
    }

    /**
     * 实付日期
     * @param realPayDate 实付日期
     */
    public void setRealPayDate(String realPayDate) {
        this.realPayDate = realPayDate == null ? null : realPayDate.trim();
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
        this.pkCurrency = pkCurrency;
    }

    /**
     * 公司主体
     * @return COMPANY_MAIN_BODY 公司主体
     */
    public String getCompanyMainBody() {
        return companyMainBody;
    }

    /**
     * 公司主体
     * @param companyMainBody 公司主体
     */
    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody == null ? null : companyMainBody.trim();
    }

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
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

    public WithdrawDetailDO() {

    }

    public String getPkWithdraw() {
        return pkWithdraw;
    }

    public void setPkWithdraw(String pkWithdraw) {
        this.pkWithdraw = pkWithdraw;
    }

    public WithdrawDetailDO(String pkWithdrawDetail, String contCode, String contName, String payeeName, String receivingAccount, String openingBank, String accountNumber, String customerName, String employerName, String dateFrom, BigDecimal contAmount, Integer leaseType, BigDecimal actualLoanAmount, String paymentAccount, String realPayDate, String pkCurrency, String companyMainBody) {
        this.pkWithdrawDetail = pkWithdrawDetail;
        this.contCode = contCode;
        this.contName = contName;
        this.payeeName = payeeName;
        this.receivingAccount = receivingAccount;
        this.openingBank = openingBank;
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.employerName = employerName;
        this.dateFrom = dateFrom;
        this.contAmount = contAmount;
        this.leaseType = leaseType;
        this.actualLoanAmount = actualLoanAmount;
        this.paymentAccount = paymentAccount;
        this.realPayDate = realPayDate;
        this.pkCurrency = pkCurrency;
        this.companyMainBody = companyMainBody;
    }

}