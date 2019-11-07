package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 资质认证
 **/
@Entity
@Table(name = "yls_cust_qualification")
public class CustQualificationDO extends BaseDO {

    private String authDate;

    private String grantTime;

    private Short billstatus;

    private String operateTime;

    private String memo;

    private String grantDate;

    private String authOrg;

    private String checkDate;

    private String certificateNo;

    private String pkCustomer;

    @Id
    private String pkCustQualification;

    private Short qualificationType;

    private String checkTime;

    private String pkOrg;

    private String qualificationClass;

    private String operateDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    public String getAuthDate() {
        return authDate;
    }

    public void setAuthDate(String authDate) {
        this.authDate = authDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
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

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getAuthOrg() {
        return authOrg;
    }

    public void setAuthOrg(String authOrg) {
        this.authOrg = authOrg;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkCustQualification() {
        return pkCustQualification;
    }

    public void setPkCustQualification(String pkCustQualification) {
        this.pkCustQualification = pkCustQualification;
    }

    public Short getQualificationType() {
        return qualificationType;
    }

    public void setQualificationType(Short qualificationType) {
        this.qualificationType = qualificationType;
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

    public String getQualificationClass() {
        return qualificationClass;
    }

    public void setQualificationClass(String qualificationClass) {
        this.qualificationClass = qualificationClass;
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
        return pkCustQualification;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustQualification = pk;
    }
}