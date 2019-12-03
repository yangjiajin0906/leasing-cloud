package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.vo.foundation.CurrtypeVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_withdraw")
public class WithdrawVO extends BaseBusinessVO {


    /**
     * 付款信息主键
     */
    @Id
    private String pkWithdraw;

    /**
     * 付款批次号
     */
    private String paymentBatchNo;

    /**
     * 收款人
     */
    private String payeeName;

    /**
     * 收款账号
     */
    private String receivingAccount;

    /**
     * 行号
     */
    private String accountNumber;

    /**
     * 银行开户行
     */
    private String openingBank;

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

    private String pkSys;



    /**
     * 付款子表
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pkWithdraw")
    private List<WithdrawDetailVO> pkWithdrawDetail;


    @Override
    public String getPk() {
        return pkWithdraw;
    }

    @Override
    public void setPk(String pk) {
        this.pkWithdraw = pk;
    }

    public String getPkWithdraw() {
        return pkWithdraw;
    }

    public void setPkWithdraw(String pkWithdraw) {
        this.pkWithdraw = pkWithdraw;
    }

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
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

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
    }

    public List<WithdrawDetailVO> getPkWithdrawDetail() {
        return pkWithdrawDetail;
    }

    public void setPkWithdrawDetail(List<WithdrawDetailVO> pkWithdrawDetail) {
        this.pkWithdrawDetail = pkWithdrawDetail;
    }
}