package com.leasing.common.entity.common.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则VO
 **/
@Entity
@Table(name="yls_coderule")
public class CoderuleDO extends BaseBusinessDO {
    public String getTableName(){return "yls_coderule";}

    public String getPk(){return pkCoderule;}

    public void setPk(String pkCoderule){this.pkCoderule = pkCoderule;}

    public CoderuleDO(){}

    @Id
    private String pkCoderule;

    /**
     * 租赁类别
     */
    private Short rentalCategory;

    /**
     *业务节点
     */
    private String businessPoint;

    /**
     * 变量名称
     */
    private String variableName;

    /**
     * 编码规则名称
     */
    private String codeRuleName;

    /**
     * 复核人
     */
    private String pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;

    /**
     * 复核时间
     */
    private String checkTime;

    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="pkCoderule")
    private List<CoderuleTypeDO> coderuleType;

    public String getPkCoderule() {
        return pkCoderule;
    }

    public void setPkCoderule(String pkCoderule) {
        this.pkCoderule = pkCoderule;
    }

    public Short getRentalCategory() {
        return rentalCategory;
    }

    public void setRentalCategory(Short rentalCategory) {
        this.rentalCategory = rentalCategory;
    }

    public String getBusinessPoint() {
        return businessPoint;
    }

    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getCodeRuleName() {
        return codeRuleName;
    }

    public void setCodeRuleName(String codeRuleName) {
        this.codeRuleName = codeRuleName;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
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

    public List<CoderuleTypeDO> getCoderuleType() {
        return coderuleType;
    }

    public void setCoderuleType(List<CoderuleTypeDO> coderuleType) {
        this.coderuleType = coderuleType;
    }
}