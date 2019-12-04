package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.entity.foundation.vo.AreaclVO;
import com.leasing.common.entity.foundation.vo.OrgVO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 银行账户
 **/
@Entity
@Table(name = "YLS_CUST_BANK_ACCOUNT")
public class CustBankAccountVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkCustBankAccount;


    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 银行账号
     */
    private String accountNo;


    /**
     * 账户名称
     */
    private String accountName;


    /**
     * 开户银行
     */
    private String accountBank;


    /**
     * 银行行号
     */
    private String bankNo;

    /**
     * 开户行地址(省)
     */
    @ManyToOne
    @JoinColumn(name = "bankProvince")
    private AreaclVO bankProvince;

    /**
     * 开户行地址(市)
     */
    @ManyToOne
    @JoinColumn(name = "bankCity")
    private AreaclVO bankCity;

    /**
     * 开户行地址
     */
    private String bankAddress;

    /**
     * 账户类型
     */
    private Short accountUse;

    /**
     * 账户性质
     */
    private Short accountType;



    /**
     * 账户使用状态
     */
    private Short accountStatus;


    /**
     * 是否协定存款户
     */
    private Short ifAgreementAccount;


    /**
     * 协定截止日期
     */
    private String agreeEndDate;

    /**
     * 初始主键
     */
    private String initialPk;


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


    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    private String mdbCode;

    public String getPkCustBankAccount() {
        return pkCustBankAccount;
    }

    public void setPkCustBankAccount(String pkCustBankAccount) {
        this.pkCustBankAccount = pkCustBankAccount;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public AreaclVO getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(AreaclVO bankProvince) {
        this.bankProvince = bankProvince;
    }

    public AreaclVO getBankCity() {
        return bankCity;
    }

    public void setBankCity(AreaclVO bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public Short getAccountUse() {
        return accountUse;
    }

    public void setAccountUse(Short accountUse) {
        this.accountUse = accountUse;
    }

    public Short getAccountType() {
        return accountType;
    }

    public void setAccountType(Short accountType) {
        this.accountType = accountType;
    }

    public Short getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Short accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Short getIfAgreementAccount() {
        return ifAgreementAccount;
    }

    public void setIfAgreementAccount(Short ifAgreementAccount) {
        this.ifAgreementAccount = ifAgreementAccount;
    }

    public String getAgreeEndDate() {
        return agreeEndDate;
    }

    public void setAgreeEndDate(String agreeEndDate) {
        this.agreeEndDate = agreeEndDate;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
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

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    @Override
    public String getPk() {
        return pkCustBankAccount;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustBankAccount = pk;
    }
}