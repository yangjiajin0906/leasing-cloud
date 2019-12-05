package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/28
 * @author:Yjj@yonyou.com
 * @description: 合同
 **/
@Entity
@Table(name="yls_contract_c")
public class ContractDTO extends BaseVO{
    /**
     * 合同主键
     */
    @Id
    public String pkContract;

    /**
     * 合同名称
     */
    public String contName;

    /**
     * 起租流程
     */
    public Short leaseFlow;

    /**
     * 计税方式
     */
    @Transient
    public Short taxMode;

    /**
     * 合同编号
     */

    public String contCode;

    /**
     * 部门
     */
    public String psndeptname ;

    /**
     * 机构
     */
    public String pkOrg ;

    /**
     * 签约主体
     */
    public String pkAcctOrg;

    /**
     * 投放主键
     * @return
     */
    public String pkLeaseCalculator;

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getPsndeptname() {
        return psndeptname;
    }

    public void setPsndeptname(String psndeptname) {
        this.psndeptname = psndeptname;
    }

    /**
     * 合同状态
     * @return
     */
    public Short contStatus;


    @Override
    public String getPk() {
        return pkContract;
    }

    @Override
    public void setPk(String pk) {
        this.pkContract = pk;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public Short getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Short leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    public Short getTaxMode() {
        return taxMode;
    }

    public void setTaxMode(Short taxMode) {
        this.taxMode = taxMode;
    }

    public Short getContStatus() {
        return contStatus;
    }

    public void setContStatus(Short contStatus) {
        this.contStatus = contStatus;
    }

    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

    /**
     * 资产类型
     */
    public Short assetType;
    /**
     * 税率方案
     */
    public Short taxPlan;

    public Short getAssetType() {
        return assetType;
    }

    public void setAssetType(Short assetType) {
        this.assetType = assetType;
    }

    public Short getTaxPlan() {
        return taxPlan;
    }

    public void setTaxPlan(Short taxPlan) {
        this.taxPlan = taxPlan;
    }

    /**
     * 租赁方式
     */
    @Transient
    public Short leaseMethod;

    public Short getLeaseMethod() {
        return leaseMethod;
    }

    public void setLeaseMethod(Short leaseMethod) {
        this.leaseMethod = leaseMethod;
    }

    public String getPkAcctOrg() {
        return pkAcctOrg;
    }

    public void setPkAcctOrg(String pkAcctOrg) {
        this.pkAcctOrg = pkAcctOrg;
    }

}