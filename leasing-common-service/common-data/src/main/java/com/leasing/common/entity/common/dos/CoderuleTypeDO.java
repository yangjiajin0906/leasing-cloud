package com.leasing.common.entity.common.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description: 编码规则配置子表DO类
 **/
@Entity
@Table(name="yls_coderule_type")
public class CoderuleTypeDO extends BaseDO {
    public String getTableName(){return "yls_coderule_type";}

    public String getPk(){return pkCoderuleType;}

    public void setPk(String pkCoderuleType){this.pkCoderuleType = pkCoderuleType;}

    public CoderuleTypeDO(){}

    @Id
    private String pkCoderuleType;

    /**
     * 主表主键
     */
    private String pkCoderule;

    /**
     * 参照分类
     */
    private String referSort;
    /**
     * 编号规则类型
     */
    private String coderuleType;
    /**
     * 规则CODE
     */
    private String ruleCode;
    /**
     * 位数
     */
    private Integer bitNumber;
    /**
     * 补位符
     */
    private String fillSign;
    /**
     * 初始值
     */
    private Integer initialValue;

    public String getPkCoderuleType() {
        return pkCoderuleType;
    }

    public void setPkCoderuleType(String pkCoderuleType) {
        this.pkCoderuleType = pkCoderuleType;
    }

    public String getPkCoderule() {
        return pkCoderule;
    }

    public void setPkCoderule(String pkCoderule) {
        this.pkCoderule = pkCoderule;
    }

    public String getReferSort() {
        return referSort;
    }

    public void setReferSort(String referSort) {
        this.referSort = referSort;
    }

    public String getCoderuleType() {
        return coderuleType;
    }

    public void setCoderuleType(String coderuleType) {
        this.coderuleType = coderuleType;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public Integer getBitNumber() {
        return bitNumber;
    }

    public void setBitNumber(Integer bitNumber) {
        this.bitNumber = bitNumber;
    }

    public String getFillSign() {
        return fillSign;
    }

    public void setFillSign(String fillSign) {
        this.fillSign = fillSign;
    }

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }
}