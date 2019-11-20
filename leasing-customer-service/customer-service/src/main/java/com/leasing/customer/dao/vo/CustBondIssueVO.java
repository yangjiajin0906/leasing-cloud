package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.CurrtypeVO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 债券发行
 **/
@Entity
@Table(name = "yls_cust_bond_issue")
public class CustBondIssueVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkCustBondIssue;


    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 发行日期
     */
    private String issueDate;


    /**
     * 债券类型
     */
    @ManyToOne
    @JoinColumn(name = "bondType")
    private ParameterDTO bondType;


    /**
     * 币种
     */
    @ManyToOne
    @JoinColumn(name = "pkCurrtype")
    private CurrtypeVO pkCurrtype;


    /**
     * 发行金额
     */
    private BigDecimal planCash;


    /**
     * 兑现日期
     */
    private String cashDate;


    /**
     * 利息
     */
    private BigDecimal interest;


    /**
     * 备注
     */
    private String memo;


    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 记账人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 记账日期
     */
    private String operateDate;


    /**
     * 记账时间
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

    public String getPkCustBondIssue() {
        return pkCustBondIssue;
    }

    public void setPkCustBondIssue(String pkCustBondIssue) {
        this.pkCustBondIssue = pkCustBondIssue;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public ParameterDTO getBondType() {
        return bondType;
    }

    public void setBondType(ParameterDTO bondType) {
        this.bondType = bondType;
    }

    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public String getCashDate() {
        return cashDate;
    }

    public void setCashDate(String cashDate) {
        this.cashDate = cashDate;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
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
        return pkCustBondIssue;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustBondIssue = pk;
    }
}