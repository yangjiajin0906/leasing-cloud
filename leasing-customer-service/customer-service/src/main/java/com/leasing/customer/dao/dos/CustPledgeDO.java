package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_pledge")
public class CustPledgeDO extends BaseBusinessDO {

    /**
     * 主键
     */
    @Id
    private String pkCustPledge;

    private String reason;

    private String endDate;

    private String pkCustomerRef;

    private BigDecimal pledgeAmount;

    private String memo;

    private BigDecimal backLimit;

    private Short ifManualEntry;

    private Short ifNewRelation;

    private Short contStatus;

    private String contCode;

    private BigDecimal prendaAmount;

    private BigDecimal planCash;

    private String pkAccount;

    private Short contValidStatus;

    private String grantDate;

    private Short contType;

    private String contSigned;

    private Short taxRate;

    private Short invoiceProperty;

    private String sourceBilltype;

    private String checkTime;

    private Short guaranteeType;

    private String appointContDate;

    private String startDate;

    private String pkAssureProject;

    private String pkChecker;

    private String bondBank;

    private Short ifAntiGuarantee;

    private String grantTime;

    private BigDecimal pkExchgRate;

    private Short pledgePotency;

    private BigDecimal dischargeRatioPre;

    private String relationRole;

    private String pkCustomer;

    private Short relationClass;

    private String pkContract;

    private String checkDate;

    private BigDecimal contAmount;

    private String pkCurrtype;

    private Short ifVersionNew;

    private Short taxMode;

    private String relateCode;

    private String contName;

    private String sourceBill;

    private String pkLesseeProtocol;

    private Short creditInvestigation;

    private Short guaranteeMethod;

    private String pkGlorgbook;

    private String pkOperator;

    private String pkGrantor;

    public String getPkCustPledge() {
        return pkCustPledge;
    }

    public void setPkCustPledge(String pkCustPledge) {
        this.pkCustPledge = pkCustPledge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(String pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    public BigDecimal getPledgeAmount() {
        return pledgeAmount;
    }

    public void setPledgeAmount(BigDecimal pledgeAmount) {
        this.pledgeAmount = pledgeAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getBackLimit() {
        return backLimit;
    }

    public void setBackLimit(BigDecimal backLimit) {
        this.backLimit = backLimit;
    }

    public Short getIfManualEntry() {
        return ifManualEntry;
    }

    public void setIfManualEntry(Short ifManualEntry) {
        this.ifManualEntry = ifManualEntry;
    }

    public Short getIfNewRelation() {
        return ifNewRelation;
    }

    public void setIfNewRelation(Short ifNewRelation) {
        this.ifNewRelation = ifNewRelation;
    }

    public Short getContStatus() {
        return contStatus;
    }

    public void setContStatus(Short contStatus) {
        this.contStatus = contStatus;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public BigDecimal getPrendaAmount() {
        return prendaAmount;
    }

    public void setPrendaAmount(BigDecimal prendaAmount) {
        this.prendaAmount = prendaAmount;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public String getPkAccount() {
        return pkAccount;
    }

    public void setPkAccount(String pkAccount) {
        this.pkAccount = pkAccount;
    }

    public Short getContValidStatus() {
        return contValidStatus;
    }

    public void setContValidStatus(Short contValidStatus) {
        this.contValidStatus = contValidStatus;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public Short getContType() {
        return contType;
    }

    public void setContType(Short contType) {
        this.contType = contType;
    }

    public String getContSigned() {
        return contSigned;
    }

    public void setContSigned(String contSigned) {
        this.contSigned = contSigned;
    }

    public Short getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Short taxRate) {
        this.taxRate = taxRate;
    }

    public Short getInvoiceProperty() {
        return invoiceProperty;
    }

    public void setInvoiceProperty(Short invoiceProperty) {
        this.invoiceProperty = invoiceProperty;
    }

    public String getSourceBilltype() {
        return sourceBilltype;
    }

    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public Short getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(Short guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getAppointContDate() {
        return appointContDate;
    }

    public void setAppointContDate(String appointContDate) {
        this.appointContDate = appointContDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPkAssureProject() {
        return pkAssureProject;
    }

    public void setPkAssureProject(String pkAssureProject) {
        this.pkAssureProject = pkAssureProject;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getBondBank() {
        return bondBank;
    }

    public void setBondBank(String bondBank) {
        this.bondBank = bondBank;
    }

    public Short getIfAntiGuarantee() {
        return ifAntiGuarantee;
    }

    public void setIfAntiGuarantee(Short ifAntiGuarantee) {
        this.ifAntiGuarantee = ifAntiGuarantee;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public BigDecimal getPkExchgRate() {
        return pkExchgRate;
    }

    public void setPkExchgRate(BigDecimal pkExchgRate) {
        this.pkExchgRate = pkExchgRate;
    }

    public Short getPledgePotency() {
        return pledgePotency;
    }

    public void setPledgePotency(Short pledgePotency) {
        this.pledgePotency = pledgePotency;
    }

    public BigDecimal getDischargeRatioPre() {
        return dischargeRatioPre;
    }

    public void setDischargeRatioPre(BigDecimal dischargeRatioPre) {
        this.dischargeRatioPre = dischargeRatioPre;
    }

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public BigDecimal getContAmount() {
        return contAmount;
    }

    public void setContAmount(BigDecimal contAmount) {
        this.contAmount = contAmount;
    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public Short getIfVersionNew() {
        return ifVersionNew;
    }

    public void setIfVersionNew(Short ifVersionNew) {
        this.ifVersionNew = ifVersionNew;
    }

    public Short getTaxMode() {
        return taxMode;
    }

    public void setTaxMode(Short taxMode) {
        this.taxMode = taxMode;
    }

    public String getRelateCode() {
        return relateCode;
    }

    public void setRelateCode(String relateCode) {
        this.relateCode = relateCode;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getPkLesseeProtocol() {
        return pkLesseeProtocol;
    }

    public void setPkLesseeProtocol(String pkLesseeProtocol) {
        this.pkLesseeProtocol = pkLesseeProtocol;
    }

    public Short getCreditInvestigation() {
        return creditInvestigation;
    }

    public void setCreditInvestigation(Short creditInvestigation) {
        this.creditInvestigation = creditInvestigation;
    }

    public Short getGuaranteeMethod() {
        return guaranteeMethod;
    }

    public void setGuaranteeMethod(Short guaranteeMethod) {
        this.guaranteeMethod = guaranteeMethod;
    }

    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook;
    }

    @Override
    public String getPkOperator() {
        return pkOperator;
    }

    @Override
    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    @Override
    public String getPk() {
        return pkCustPledge;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustPledge = pk;
    }
}