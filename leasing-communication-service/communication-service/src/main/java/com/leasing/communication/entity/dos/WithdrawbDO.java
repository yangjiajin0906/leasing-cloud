package com.leasing.communication.entity.dos;

import com.leasing.communication.entity.base.FileBaseBusinessDO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-21
 * @author:zhangzhhn@yonyou.com
 * @description: 付款子表
 **/
@Entity
@Table(name = "yc_withdraw_b")
public class WithdrawbDO extends FileBaseBusinessDO {

    @Id
    @Column(name = "pk_withdraw_b")
    private String pkWithdrawB;

    private String pkWithdrawRepayment;

    private String paymentBatchNo;

    private String contCode;

    private String contName;

    private String customerName;

    private String employerName;

    private BigDecimal contAmount;

    private String leaseType;

    private String actualLoanAmount;


    public String getPkWithdrawB() {
        return pkWithdrawB;
    }

    public void setPkWithdrawB(String pkWithdrawB) {
        this.pkWithdrawB = pkWithdrawB;
    }

    public String getPkWithdrawRepayment() {
        return pkWithdrawRepayment;
    }

    public void setPkWithdrawRepayment(String pkWithdrawRepayment) {
        this.pkWithdrawRepayment = pkWithdrawRepayment;
    }

    public String getPaymentBatchNo() {
        return paymentBatchNo;
    }

    public void setPaymentBatchNo(String paymentBatchNo) {
        this.paymentBatchNo = paymentBatchNo;
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

    public BigDecimal getContAmount() {
        return contAmount;
    }

    public void setContAmount(BigDecimal contAmount) {
        this.contAmount = contAmount;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }


    @Override
    public String getPk() {
        return pkWithdrawB;
    }

    @Override
    public void setPk(String pk) {
        this.pkWithdrawB = pk;
    }
}