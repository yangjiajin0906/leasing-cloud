package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_related_company")
public class CustExecutiveInformationDO extends BaseDO {

    @Id
    private String pkCustRelatedCompany;

    private String grantTime;

    private String pkCustomerRef;

    private String relationRole;

    private String operateTime;

    private String jobResume;

    private String memo;

    private Short sourceMethod;

    private String pkCustomer;

    private Short billtype;

    private Short familyRelation;

    private Short relationClass;

    private String memberContainsCorp;

    private Short billstatus;

    private String pkContract;

    private String grantDate;

    private Short executiveType;

    private String checkDate;

    private String checkTime;

    private String pkOrg;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    @Override
    public String getPk() {
        return this.pkCustRelatedCompany;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustRelatedCompany = pk;
    }

    public String getPkCustRelatedCompany() {
        return pkCustRelatedCompany;
    }

    public void setPkCustRelatedCompany(String pkCustRelatedCompany) {
        this.pkCustRelatedCompany = pkCustRelatedCompany;
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

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getJobResume() {
        return jobResume;
    }

    public void setJobResume(String jobResume) {
        this.jobResume = jobResume;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getSourceMethod() {
        return sourceMethod;
    }

    public void setSourceMethod(Short sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
    }

    public Short getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(Short familyRelation) {
        this.familyRelation = familyRelation;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public String getMemberContainsCorp() {
        return memberContainsCorp;
    }

    public void setMemberContainsCorp(String memberContainsCorp) {
        this.memberContainsCorp = memberContainsCorp;
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

    public Short getExecutiveType() {
        return executiveType;
    }

    public void setExecutiveType(Short executiveType) {
        this.executiveType = executiveType;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
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
}