package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer_relation")
public class CustomerRelationDO extends BaseBusinessDO {

    @Id
    private String pkCustomerRelation;

    private String grantTime;

    private String endDate;

    private String pkCustomerRef;

    private String overdueEndDate;

    private String relationRole;

    private String pkCustomerRef2;

    private Short relationClass;

    private String pkProjectRef;

    private BigDecimal overdueAmount;

    private Short relationStatus;

    private String grantDate;

    private String checkDate;

    private Short relationDirection;

    private String balanceDate;

    private String checkTime;

    private String pkCustChildTable;

    private BigDecimal totalExposureBalance;

    private String startDate;

    private String pkChecker;

    private String pkGrantor;

    public String getPkCustomerRelation() {
        return pkCustomerRelation;
    }

    public void setPkCustomerRelation(String pkCustomerRelation) {
        this.pkCustomerRelation = pkCustomerRelation;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
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

    public String getOverdueEndDate() {
        return overdueEndDate;
    }

    public void setOverdueEndDate(String overdueEndDate) {
        this.overdueEndDate = overdueEndDate;
    }

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public String getPkCustomerRef2() {
        return pkCustomerRef2;
    }

    public void setPkCustomerRef2(String pkCustomerRef2) {
        this.pkCustomerRef2 = pkCustomerRef2;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public String getPkProjectRef() {
        return pkProjectRef;
    }

    public void setPkProjectRef(String pkProjectRef) {
        this.pkProjectRef = pkProjectRef;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Short getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(Short relationStatus) {
        this.relationStatus = relationStatus;
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

    public Short getRelationDirection() {
        return relationDirection;
    }

    public void setRelationDirection(Short relationDirection) {
        this.relationDirection = relationDirection;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkCustChildTable() {
        return pkCustChildTable;
    }

    public void setPkCustChildTable(String pkCustChildTable) {
        this.pkCustChildTable = pkCustChildTable;
    }

    public BigDecimal getTotalExposureBalance() {
        return totalExposureBalance;
    }

    public void setTotalExposureBalance(BigDecimal totalExposureBalance) {
        this.totalExposureBalance = totalExposureBalance;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        return pkCustomerRelation;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerRelation = pk;
    }


}