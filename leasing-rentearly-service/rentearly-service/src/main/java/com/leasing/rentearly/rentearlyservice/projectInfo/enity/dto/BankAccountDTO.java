package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;
import com.leasing.common.base.repository.support.StringModalType;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.beans.ConstructorProperties;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "v_bank_account")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class BankAccountDTO extends BaseDTO {

    @Transient
    public String name;

    @Transient
    public String code;

    /**
     * 客户主键
     */

    public String pkCustomer;

    @Id
    public String pkCustBankAccount;
    /**
     * 银行账号
     */
    public String accountNo;
    /**
     * 账户名称
     */
    public String accountName;
    /**
     * 开户银行
     */
    public String accountBank;
    /**
     * 银行行号
     */
    public String bankNo;
    /**
     * 开户行地址（省）
     */
    public String bankProvince;
    /**
     * 开户行地址（市）
     */
    public String bankCity;
    /**
     * 开户行地址
     */
    public String bankAddress;
    /**
     * 账户类型
     */
    public Short accountUse;

    /**
     * 账户性质
     */
    public Short accountType;

    /**
     * 账户使用状态
     */
    public Short accountStatus;

    /**
     *
     * 来源类型
     */
    public Short sourceType;

    /**
     * 初始主键
     */
    public String initialPk;


//    public BankAccountDTO(String pkCustomer, String accountNo, String accountName, String accountBank, String bankNo, String bankProvince, String bankCity, String bankAddress, Short accountUse, Short accountType, Short accountStatus, Short sourceType, String initialPk) {
//        this.pkCustomer = pkCustomer;
//        this.accountNo = accountNo;
//        this.accountName = accountName;
//        this.accountBank = accountBank;
//        this.bankNo = bankNo;
//        this.bankProvince = bankProvince;
//        this.bankCity = bankCity;
//        this.bankAddress = bankAddress;
//        this.accountUse = accountUse;
//        this.accountType = accountType;
//        this.accountStatus = accountStatus;
//        this.sourceType = sourceType;
//        this.initialPk = initialPk;
//        this.setCode(accountNo);
//        this.setName(accountName);
//        this.setPk(pkCustBankAccount);
//    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getPkCustBankAccount() {
        return pkCustBankAccount;
    }

    public void setPkCustBankAccount(String pkCustBankAccount) {
        this.pkCustBankAccount = pkCustBankAccount;
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

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
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

    public Short getSourceType() {
        return sourceType;
    }

    public void setSourceType(Short sourceType) {
        this.sourceType = sourceType;
    }

    public String getInitialPk() {
        return initialPk;
    }

    public void setInitialPk(String initialPk) {
        this.initialPk = initialPk;
    }

    public String getPk() {
        return pkCustBankAccount;
    }

    public void setPk(String pk) {
        this.pkCustBankAccount = pk;
    }

    public String getName(){
        return accountName;
    }

    public String getCode(){
        return accountNo;
    }

    public void setName(String name) {
        this.name = this.accountName;
    }

    public void setCode(String code) {
        this.code = this.accountNo;
    }
}
