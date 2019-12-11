package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseDO;
import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.common.base.annotation.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @description 2c票据信息DO
 * @author Yangjiajin
 * @date 2019/11/12 10:57
 */
@Entity
@Table(name="yc_invoice_apply_detail")
public class CbInvoiceApplyDetailDO extends BaseDO{
    /**
     * 票据信息主键
     */
    @Id
    private String pkInvoiceApplyDetail;

    /**
     * 主表主键
     */
    private String pkInvoiceApply;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 合同名称
     */
    private String contName;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 税号
     */
    private String ein;

    /**
     * 单位地址
     */
    private String employerAddress;

    /**
     * 电话号码
     */
    private String telephoneNumber;

    /**
     * 开户银行
     */
    private String openingBank;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 邮寄地址
     */
    private String mailingAddress;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 单位名称
     */
    private String employerName;

    /**
     * 租赁方式
     */
    private Integer leaseType;

    /**
     * 期次
     */
    private Integer leaseTime;

    /**
     * 应收日期
     */
    private String planDate;

    /**
     * 税率
     */
    private BigDecimal taxRate;

    /**
     * 税额
     */
    private BigDecimal leaseCashTax;

    /**
     * 不含税金额
     */
    private BigDecimal excludingTax;

    /**
     * 开票状态
     */
    private Short billingStatus;

    /**
     * 开票内容
     */
    private Integer invoiceContents;

    /**
     * 核销状态
     */
    private Integer verificationStatus;

    /**
     * 公司主体
     */
    private String companyMainBody;

    /**
     * 开票金额
     */
    private BigDecimal invoiceAmount;

    /**
     * 开票日期
     */
    private String billingData;

    /**
     * 单据状态
     */
    private BigDecimal billstatus;

    /**
     * 操作人
     */
    private String pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 机构
     */
    private String pkOrg;

    /**
     * 部门主键
     */
    private String pkDept;

    /**
     * 来源系统
     */
    private String pkSys;

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
    }

    @Override
    public String getPk() {
        return pkInvoiceApplyDetail;
    }

    @Override
    public void setPk(String pk) {
        this.pkInvoiceApplyDetail = pk;
    }

    public String getPkInvoiceApplyDetail() {
        return pkInvoiceApplyDetail;
    }

    public void setPkInvoiceApplyDetail(String pkInvoiceApplyDetail) {
        this.pkInvoiceApplyDetail = pkInvoiceApplyDetail;
    }

    public String getPkInvoiceApply() {
        return pkInvoiceApply;
    }

    public void setPkInvoiceApply(String pkInvoiceApply) {
        this.pkInvoiceApply = pkInvoiceApply;
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
     * 发票抬头
     * @return INVOICE_TITLE 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 税号
     * @return EIN 税号
     */
    public String getEin() {
        return ein;
    }

    /**
     * 税号
     * @param ein 税号
     */
    public void setEin(String ein) {
        this.ein = ein == null ? null : ein.trim();
    }

    /**
     * 单位地址
     * @return EMPLOYER_ADDRESS 单位地址
     */
    public String getEmployerAddress() {
        return employerAddress;
    }

    /**
     * 单位地址
     * @param employerAddress 单位地址
     */
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress == null ? null : employerAddress.trim();
    }

    /**
     * 电话号码
     * @return TELEPHONE_NUMBER 电话号码
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * 电话号码
     * @param telephoneNumber 电话号码
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber == null ? null : telephoneNumber.trim();
    }

    /**
     * 开户银行
     * @return OPENING_BANK 开户银行
     */
    public String getOpeningBank() {
        return openingBank;
    }

    /**
     * 开户银行
     * @param openingBank 开户银行
     */
    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
    }

    /**
     * 银行账号
     * @return BANK_ACCOUNT 银行账号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 银行账号
     * @param bankAccount 银行账号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * 邮寄地址
     * @return MAILING_ADDRESS 邮寄地址
     */
    public String getMailingAddress() {
        return mailingAddress;
    }

    /**
     * 邮寄地址
     * @param mailingAddress 邮寄地址
     */
    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
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
     * 期次
     * @return LEASE_TIME 期次
     */
    public Integer getLeaseTime() {
        return leaseTime;
    }

    /**
     * 期次
     * @param leaseTime 期次
     */
    public void setLeaseTime(Integer leaseTime) {
        this.leaseTime = leaseTime;
    }

    /**
     * 应收日期
     * @return PLAN_DATE 应收日期
     */
    public String getPlanDate() {
        return planDate;
    }

    /**
     * 应收日期
     * @param planDate 应收日期
     */
    public void setPlanDate(String planDate) {
        this.planDate = planDate == null ? null : planDate.trim();
    }

    public String getBillingData() {
        return billingData;
    }

    public void setBillingData(String billingData) {
        this.billingData = billingData;
    }

    /**
     * 税率
     * @return TAX_RATE 税率
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }

    /**
     * 税率
     * @param taxRate 税率
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * 税额
     * @return LEASE_CASH_TAX 税额
     */
    public BigDecimal getLeaseCashTax() {
        return leaseCashTax;
    }

    /**
     * 税额
     * @param leaseCashTax 税额
     */
    public void setLeaseCashTax(BigDecimal leaseCashTax) {
        this.leaseCashTax = leaseCashTax;
    }

    /**
     * 不含税金额
     * @return EXCLUDING_TAX 不含税金额
     */
    public BigDecimal getExcludingTax() {
        return excludingTax;
    }

    /**
     * 不含税金额
     * @param excludingTax 不含税金额
     */
    public void setExcludingTax(BigDecimal excludingTax) {
        this.excludingTax = excludingTax;
    }

    /**
     * 开票状态
     * @return BILLING_STATUS 开票状态
     */
    public Short getBillingStatus() {
        return billingStatus;
    }

    /**
     * 开票状态
     * @param billingStatus 开票状态
     */
    public void setBillingStatus(Short billingStatus) {
        this.billingStatus = billingStatus;
    }

    /**
     * 开票内容
     * @return INVOICE_CONTENTS 开票内容
     */
    public Integer getInvoiceContents() {
        return invoiceContents;
    }

    /**
     * 开票内容
     * @param invoiceContents 开票内容
     */
    public void setInvoiceContents(Integer invoiceContents) {
        this.invoiceContents = invoiceContents;
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

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public CbInvoiceApplyDetailDO() {
    }

    public BigDecimal getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(BigDecimal billstatus) {
        this.billstatus = billstatus;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}