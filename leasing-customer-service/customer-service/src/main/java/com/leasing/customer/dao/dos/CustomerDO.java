package com.leasing.customer.dao.dos;


import com.leasing.common.base.entity.BaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-09-24
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户与个人客户公共
 **/
@Entity
@Table(name = "yls_customer")
public class CustomerDO extends BaseBusinessDO {

    /**
     * 客户主键
     */
    @Id
    public String pkCustomer;

    /**
     * 版本号
     */
    public Integer versionNum;


    /**
     * 客户类别
     */

    public Short customerType;


    /**
     * 客户编号
     */
    public String customerCode;


    /**
     * 客户名称
     */
    public String customerName;

    /**
     * 客户英文名
     */
    public String customerEngName;

    /**
     * 证件类型
     */
    public Short identityType;

    /**
     * 证件号码
     */
    public String identityNo;

    /**
     * 客户经理
     */
    public String pkPrjManager;

    /**
     * 客户状态
     */
    public Short customerStatus;

    /**
     * 是否黑名单
     */
    public Short ifBlackList;

    /**
     * 冻结处理方式
     */
    public Short freezeTreatment;

    /**
     * 变更状态
     */
    public Short alteraStatus;

    /**
     * 最新变更人
     */
    public String pkOperatorLst;


    /**
     * 最新变更日期
     */
    public String operateDateLst;


    /**
     * 最新变更时间
     */
    public String operateTimeLst;

    /**
     * 记账日期
     */
    public String operateDate;


    /**
     * 记账时间
     */
    public String operateTime;


    /**
     * 复核人
     */
    public String pkChecker;

    /**
     * 复核日期
     */
    public String checkDate;


    /**
     * 复核时间
     */
    public String checkTime;


    /**
     * 授权人
     */
    public String pkGrantor;

    /**
     * 授权日期
     */
    public String grantDate;


    /**
     * 授权时间
     */
    public String grantTime;

    /**
     * 生效日期
     */
    public String effectiveDate;

    /**
     * 机构信用代码”   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    public String orgCreditCode;

    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    public Short ifWarrantCust;

    /**
     * 是否最新
     */
    public Short ifNew;


    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdbCode;


    /**
     * 20180911 是否CRM系统推送客户
     */
    public Short ifCrmPush;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEngName() {
        return customerEngName;
    }

    public void setCustomerEngName(String customerEngName) {
        this.customerEngName = customerEngName;
    }

    public Short getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Short identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getPkPrjManager() {
        return pkPrjManager;
    }

    public void setPkPrjManager(String pkPrjManager) {
        this.pkPrjManager = pkPrjManager;
    }

    public Short getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Short customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Short getIfBlackList() {
        return ifBlackList;
    }

    public void setIfBlackList(Short ifBlackList) {
        this.ifBlackList = ifBlackList;
    }

    public Short getFreezeTreatment() {
        return freezeTreatment;
    }

    public void setFreezeTreatment(Short freezeTreatment) {
        this.freezeTreatment = freezeTreatment;
    }

    public Short getAlteraStatus() {
        return alteraStatus;
    }

    public void setAlteraStatus(Short alteraStatus) {
        this.alteraStatus = alteraStatus;
    }

    public String getPkOperatorLst() {
        return pkOperatorLst;
    }

    public void setPkOperatorLst(String pkOperatorLst) {
        this.pkOperatorLst = pkOperatorLst;
    }

    public String getOperateDateLst() {
        return operateDateLst;
    }

    public void setOperateDateLst(String operateDateLst) {
        this.operateDateLst = operateDateLst;
    }

    public String getOperateTimeLst() {
        return operateTimeLst;
    }

    public void setOperateTimeLst(String operateTimeLst) {
        this.operateTimeLst = operateTimeLst;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
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

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
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

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getOrgCreditCode() {
        return orgCreditCode;
    }

    public void setOrgCreditCode(String orgCreditCode) {
        this.orgCreditCode = orgCreditCode;
    }

    public Short getIfWarrantCust() {
        return ifWarrantCust;
    }

    public void setIfWarrantCust(Short ifWarrantCust) {
        this.ifWarrantCust = ifWarrantCust;
    }

    public Short getIfNew() {
        return ifNew;
    }

    public void setIfNew(Short ifNew) {
        this.ifNew = ifNew;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    public Short getIfCrmPush() {
        return ifCrmPush;
    }

    public void setIfCrmPush(Short ifCrmPush) {
        this.ifCrmPush = ifCrmPush;
    }

    @Override
    public String getPk() {
        return this.pkCustomer;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomer = pk;
    }
}