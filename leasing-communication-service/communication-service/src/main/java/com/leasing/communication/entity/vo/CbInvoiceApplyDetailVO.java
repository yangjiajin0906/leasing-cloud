package com.leasing.communication.entity.vo;

import com.leasing.common.base.annotation.Excel;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.entity.BaseVO;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @description 2c票据信息VO
 * @author Yangjiajin
 * @date 2019/11/12 10:57
 */
@Entity
@Table(name="yc_invoice_apply_detail")
public class CbInvoiceApplyDetailVO {
    /**
     * 票据信息主键
     */
    @Id
    private String pkInvoiceApplyDetail;

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
    private Integer billingStatus;

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
     * 来源系统
     */
    @ManyToOne
    @JoinColumn(name = "pkSys")
    @NotFound(action= NotFoundAction.IGNORE)
    private SourceSystemVO pkSys;

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
     * 时间戳
     */
    private String ts;

    public String getPkInvoiceApplyDetail() {
        return pkInvoiceApplyDetail;
    }

    public void setPkInvoiceApplyDetail(String pkInvoiceApplyDetail) {
        this.pkInvoiceApplyDetail = pkInvoiceApplyDetail;
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

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
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

    public Integer getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Integer leaseTime) {
        this.leaseTime = leaseTime;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getLeaseCashTax() {
        return leaseCashTax;
    }

    public void setLeaseCashTax(BigDecimal leaseCashTax) {
        this.leaseCashTax = leaseCashTax;
    }

    public BigDecimal getExcludingTax() {
        return excludingTax;
    }

    public void setExcludingTax(BigDecimal excludingTax) {
        this.excludingTax = excludingTax;
    }

    public Integer getBillingStatus() {
        return billingStatus;
    }

    public void setBillingStatus(Integer billingStatus) {
        this.billingStatus = billingStatus;
    }

    public Integer getInvoiceContents() {
        return invoiceContents;
    }

    public void setInvoiceContents(Integer invoiceContents) {
        this.invoiceContents = invoiceContents;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getCompanyMainBody() {
        return companyMainBody;
    }

    public void setCompanyMainBody(String companyMainBody) {
        this.companyMainBody = companyMainBody;
    }

    public SourceSystemVO getPkSys() {
        return pkSys;
    }

    public void setPkSys(SourceSystemVO pkSys) {
        this.pkSys = pkSys;
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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}