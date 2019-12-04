package com.leasing.communication.entity.dos;

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
@Table(name="yc_invoice_apply")
public class InvoiceApply2DO extends FileBaseBusinessDO{
    /**
     * 票据信息主键
     */
    @Id
    @Excel(titleName = "主键", orderNum = 10)
    private String pkInvoiceApply;

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
     * 发票抬头
     */
    @Excel(titleName = "发票抬头", orderNum = 13)
    private String invoiceTitle;

    /**
     * 税号
     */
    @Excel(titleName = "税号", orderNum = 14)
    private String ein;

    /**
     * 单位地址
     */
    @Excel(titleName = "单位地址", orderNum = 15)
    private String employerAddress;

    /**
     * 电话号码
     */
    @Excel(titleName = "电话号码", orderNum = 16)
    private String telephoneNumber;

    /**
     * 开户银行
     */
    @Excel(titleName = "开户银行", orderNum = 17)
    private String openingBank;

    /**
     * 银行账号
     */
    @Excel(titleName = "银行账号", orderNum = 18)
    private String bankAccount;

    /**
     * 邮寄地址
     */
    @Excel(titleName = "邮寄地址", orderNum = 19)
    private String mailingAddress;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 20)
    private String customerName;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 21)
    private String employerName;

    /**
     * 租赁方式
     */
    @Excel(titleName = "租赁方式", orderNum = 22)
    private Integer leaseType;

    /**
     * 期次
     */
    @Excel(titleName = "期次", orderNum = 23)
    private Integer leaseTime;

    /**
     * 应收日期
     */
    @Excel(titleName = "应收日期", orderNum = 24)
    private String planDate;

    /**
     * 税率
     */
    @Excel(titleName = "税率", orderNum = 25)
    private BigDecimal taxRate;

    /**
     * 税额
     */
    @Excel(titleName = "税额", orderNum = 26)
    private BigDecimal leaseCashTax;

    /**
     * 不含税金额
     */
    @Excel(titleName = "不含税金额", orderNum = 27)
    private BigDecimal excludingTax;

    /**
     * 开票状态
     */
    @Excel(titleName = "开票状态", orderNum = 28)
    private Integer billingStatus;

    /**
     * 开票内容
     */
    @Excel(titleName = "开票内容", orderNum = 29)
    private Integer invoiceContents;

    /**
     * 公司主体
     */
    @Excel(titleName = "公司主体", orderNum = 26)
    private String companyMainBody;

    @Override
    public String getPk() {
        return pkInvoiceApply;
    }

    @Override
    public void setPk(String pk) {
        this.pkInvoiceApply = pk;
    }

    /**
     * 票据信息主键
     * @return PK_INVOICE_APPLY 票据信息主键
     */
    public String getPkInvoiceApply() {
        return pkInvoiceApply;
    }

    /**
     * 票据信息主键
     * @param pkInvoiceApply 票据信息主键
     */
    public void setPkInvoiceApply(String pkInvoiceApply) {
        this.pkInvoiceApply = pkInvoiceApply == null ? null : pkInvoiceApply.trim();
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
    public Integer getBillingStatus() {
        return billingStatus;
    }

    /**
     * 开票状态
     * @param billingStatus 开票状态
     */
    public void setBillingStatus(Integer billingStatus) {
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

    public InvoiceApply2DO() {
    }

    public InvoiceApply2DO(String pkInvoiceApply, String contCode, String contName, String invoiceTitle, String ein, String employerAddress, String telephoneNumber, String openingBank, String bankAccount, String mailingAddress, String customerName, String employerName, Integer leaseType, Integer leaseTime, String planDate, BigDecimal taxRate, BigDecimal leaseCashTax, BigDecimal excludingTax, Integer billingStatus, Integer invoiceContents, String companyMainBody) {
        this.pkInvoiceApply = pkInvoiceApply;
        this.contCode = contCode;
        this.contName = contName;
        this.invoiceTitle = invoiceTitle;
        this.ein = ein;
        this.employerAddress = employerAddress;
        this.telephoneNumber = telephoneNumber;
        this.openingBank = openingBank;
        this.bankAccount = bankAccount;
        this.mailingAddress = mailingAddress;
        this.customerName = customerName;
        this.employerName = employerName;
        this.leaseType = leaseType;
        this.leaseTime = leaseTime;
        this.planDate = planDate;
        this.taxRate = taxRate;
        this.leaseCashTax = leaseCashTax;
        this.excludingTax = excludingTax;
        this.billingStatus = billingStatus;
        this.invoiceContents = invoiceContents;
        this.companyMainBody = companyMainBody;
    }
}