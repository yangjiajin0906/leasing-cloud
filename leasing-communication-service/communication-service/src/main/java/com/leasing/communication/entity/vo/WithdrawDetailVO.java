package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.vo.foundation.CurrtypeVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_withdraw_detail")
public class WithdrawDetailVO extends BaseBusinessVO {

    /**
     * 付款信息主键
     */
    @Id
    private String pkWithdrawDetail;

    /**
     * 主表主键
     */
    private String pkWithdraw;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 合同名称
     */
    private String contName;

    /**
     * 收款人
     */
    private String payeeName;

    /**
     * 收款账号
     */
    private String receivingAccount;

    /**
     * 银行开户行
     */
    private String openingBank;

    /**
     * 行号
     */
    private String accountNumber;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 单位名称
     */
    private String employerName;

    /**
     * 起租日期
     */
    private String dateFrom;

    /**
     * 合同金额
     */
    private BigDecimal contAmount;

    /**
     * 租赁方式
     */
    private Integer leaseType;

    /**
     * 实际放款金额
     */
    private BigDecimal actualLoanAmount;

    /**
     * 付款账号
     */
    private String paymentAccount;

    /**
     * 实付日期
     */
    private String realPayDate;

    /**
     * 币种 (参照)
     */
    @ManyToOne
    @JoinColumn(name = "pkCurrency")
    private CurrtypeVO pkCurrency;

    /**
     * 公司主体
     */

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

    private String pkSys;


    @Override
    public String getPk() {
        return pkWithdrawDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkWithdrawDetail = pk;
    }

    public String getPkWithdrawDetail() {
        return pkWithdrawDetail;
    }

    public void setPkWithdrawDetail(String pkWithdrawDetail) {
        this.pkWithdrawDetail = pkWithdrawDetail;
    }

    public String getPkWithdraw() {
        return pkWithdraw;
    }

    public void setPkWithdraw(String pkWithdraw) {
        this.pkWithdraw = pkWithdraw;
    }

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

    public CurrtypeVO getPkCurrency() {
        return pkCurrency;
    }

    public void setPkCurrency(CurrtypeVO pkCurrency) {
        this.pkCurrency = pkCurrency;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
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

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
    }
}