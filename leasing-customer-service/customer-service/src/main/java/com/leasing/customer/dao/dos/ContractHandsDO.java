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
 * @description: 在手合同
 **/
@Entity
@Table(name = "yls_contract_hands")
public class ContractHandsDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    private String pkContractHands;

    private String grantTime;

    private String endDate;

    private Short billstatus;

    private BigDecimal contractCash;

    private String operateTime;

    private String customerCode;

    private String memo;

    private String grantDate;

    private String checkDate;

    private String pkCustomer;

    private String customerName;

    private String checkTime;

    private String pkOrg;

    private String projectSituation;

    private String projectName;

    private String backcashSituation;

    private String operateDate;

    private String startDate;

    private String pkOperator;

    private String pkChecker;

    private String pkGrantor;

    public String getPkContractHands() {
        return pkContractHands;
    }

    public void setPkContractHands(String pkContractHands) {
        this.pkContractHands = pkContractHands;
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

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public BigDecimal getContractCash() {
        return contractCash;
    }

    public void setContractCash(BigDecimal contractCash) {
        this.contractCash = contractCash;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getProjectSituation() {
        return projectSituation;
    }

    public void setProjectSituation(String projectSituation) {
        this.projectSituation = projectSituation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getBackcashSituation() {
        return backcashSituation;
    }

    public void setBackcashSituation(String backcashSituation) {
        this.backcashSituation = backcashSituation;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
        return pkContractHands;
    }

    @Override
    public void setPk(String pk) {
        this.pkContractHands = pk;
    }
}