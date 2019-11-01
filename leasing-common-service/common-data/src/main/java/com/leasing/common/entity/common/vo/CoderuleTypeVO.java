package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.sys.ParameterDTO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则配置子表VO类
 **/
@Entity
@Table(name="yls_coderule_type")
public class CoderuleTypeVO extends BaseVO {
    public String getTableName(){return "yls_coderule_type";}

    public String getPk(){return pkCoderuleType;}

    public void setPk(String pkCoderuleType){this.pkCoderuleType = pkCoderuleType;}

    public CoderuleTypeVO(){}

    @Id
    private String pkCoderuleType;

    @OneToOne
    @JoinColumn(name = "pkCoderule")
    private CoderuleVO pkCoderule;

    /**
     * 参照分类
     */
    private String referSort;
    /**
     * 编号规则类型
     */
    @ManyToOne
    @JoinColumn(name = "pkParameter")
    private ParameterDTO pkParameter;
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

    public CoderuleVO getPkCoderule() {
        return pkCoderule;
    }

    public void setPkCoderule(CoderuleVO pkCoderule) {
        this.pkCoderule = pkCoderule;
    }

    public String getReferSort() {
        return referSort;
    }

    public void setReferSort(String referSort) {
        this.referSort = referSort;
    }

    public ParameterDTO getPkParameter() {
        return pkParameter;
    }

    public void setPkParameter(ParameterDTO pkParameter) {
        this.pkParameter = pkParameter;
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