package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 在手合同
 **/
@Entity
@Table(name = "yls_contract_hands")
public class ContractHandsVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkContractHands;


    /**
     * 主表主键
     */
    private String pkCustomer;

    /**
     * 客户名称
     */
    private String customerName;


    /**
     * 客户编号
     */
    private String customerCode;


    /**
     * 项目名称
     */
    private String projectName;


    /**
     * 合同金额（万元）
     */
    private BigDecimal contractCash;


    /**
     * 开始日期
     */
    private String startDate;


    /**
     * 截止日期
     */
    private String endDate;


    /**
     * 目前工程进度
     */
    private String projectSituation;


    /**
     * 回款情况
     */
    private String backcashSituation;


    /**
     * 备注
     */
    private String memo;


    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;


    /**
     * 操作时间
     */
    private String operateTime;


    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;


    /**
     * 复核时间
     */
    private String checkTime;


    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;


    /**
     * 授权时间
     */
    private String grantTime;


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;

    public String getPkContractHands() {
        return pkContractHands;
    }

    public void setPkContractHands(String pkContractHands) {
        this.pkContractHands = pkContractHands;
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

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getContractCash() {
        return contractCash;
    }

    public void setContractCash(BigDecimal contractCash) {
        this.contractCash = contractCash;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getProjectSituation() {
        return projectSituation;
    }

    public void setProjectSituation(String projectSituation) {
        this.projectSituation = projectSituation;
    }

    public String getBackcashSituation() {
        return backcashSituation;
    }

    public void setBackcashSituation(String backcashSituation) {
        this.backcashSituation = backcashSituation;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
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

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
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

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
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

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
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