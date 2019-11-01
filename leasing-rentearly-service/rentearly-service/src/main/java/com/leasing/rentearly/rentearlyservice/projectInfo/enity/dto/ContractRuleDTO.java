package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 文档生成规则参照
 **/
@Entity
@Table(name = "(SELECT CR.PK_CONTRACT_RULE," +
        "       CR.RULE_CODE," +
        "       CR.RULE_NAME," +
        "       CR.MEMO," +
        "       FR.FUN_CODE," +
        "       FR.FUN_NAME" +
        "  FROM YLS_CONTRACT_RULE CR" +
        "  LEFT JOIN SM_FUNCREGISTER FR" +
        "    ON CR.PK_FUN_NODE = FR.CFUNID)")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class ContractRuleDTO extends BaseDTO {

    @Id
    public String pkContractRule;

    public String ruleCode;

    public String ruleName;

    public String memo;

    public String funCode;

//    public ContractRuleDTO(String pkContractRule, String ruleCode, String ruleName, String memo, String funCode) {
//        this.pkContractRule = pkContractRule;
//        this.ruleCode = ruleCode;
//        this.ruleName = ruleName;
//        this.memo = memo;
//        this.funCode = funCode;
//        this.setCode(ruleCode);
//        this.setName(ruleName);
//        this.setPk(pkContractRule);
//    }

    public String getPkContractRule() {
        return pkContractRule;
    }

    public void setPkContractRule(String pkContractRule) {
        this.pkContractRule = pkContractRule;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    public String getPk() {
        return pkContractRule;
    }

    public void setPk(String pk) {
        this.pkContractRule = pk;
    }
    @Transient
    public String name;

    @Transient
    public String code;

    public String getName(){
        return ruleCode;
    }

    public String getCode(){
        return ruleName;
    }

    public void setName(String name) {
        this.name = this.ruleName;
    }

    public void setCode(String code) {
        this.code = this.ruleCode;
    }
}
