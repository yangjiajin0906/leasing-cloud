package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_updown")
public class CustUpdownDO extends BaseDO {

    @Id
    private String pkCustUpdown;

    private String grantTime;

    private String pkCustomerRef;

    private Short updownType;

    private String relationRole;

    private BigDecimal supplyScale;

    private String operateTime;

    private String memo;

    private String pkCustomer;

    private String supplyProduct;

    private Short relationClass;

    private BigDecimal planCash;

    private Short billstatus;

    private String pkContract;

    private String grantDate;

    private String checkDate;

    private BigDecimal supplyAmount;

    private String settleMemo;

    private String checkTime;

    private String pkOrg;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    public String getPkCustUpdown() {
        return pkCustUpdown;
    }

    public void setPkCustUpdown(String pkCustUpdown) {
        this.pkCustUpdown = pkCustUpdown;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(String pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    public Short getUpdownType() {
        return updownType;
    }

    public void setUpdownType(Short updownType) {
        this.updownType = updownType;
    }

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public BigDecimal getSupplyScale() {
        return supplyScale;
    }

    public void setSupplyScale(BigDecimal supplyScale) {
        this.supplyScale = supplyScale;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getSupplyProduct() {
        return supplyProduct;
    }

    public void setSupplyProduct(String supplyProduct) {
        this.supplyProduct = supplyProduct;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public BigDecimal getSupplyAmount() {
        return supplyAmount;
    }

    public void setSupplyAmount(BigDecimal supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    public String getSettleMemo() {
        return settleMemo;
    }

    public void setSettleMemo(String settleMemo) {
        this.settleMemo = settleMemo;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    @Override
    public String getPk() {
        return pkCustUpdown;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustUpdown = pk;
    }
}