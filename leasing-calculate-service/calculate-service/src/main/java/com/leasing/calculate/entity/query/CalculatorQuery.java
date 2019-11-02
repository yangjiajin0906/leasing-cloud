package com.leasing.calculate.entity.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class CalculatorQueryVO extends BaseQuery {

    /**
     * 测算方案编号
     */
    @QueryCondition(func = MatchType.equal)
    public String quotCode;

    /**
     * 测算方案名称
     */
    @QueryCondition(func = MatchType.like)
    public String quotName;

    /**
     * 设备总金额
     */
    @QueryCondition(func = MatchType.gt)
    public BigDecimal totalAmountEquipment;

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public BigDecimal getTotalAmountEquipment() {
        return totalAmountEquipment;
    }

    public void setTotalAmountEquipment(BigDecimal totalAmountEquipment) {
        this.totalAmountEquipment = totalAmountEquipment;
    }

}