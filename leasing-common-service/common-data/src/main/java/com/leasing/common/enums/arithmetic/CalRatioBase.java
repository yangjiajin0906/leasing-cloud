package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:计算比例基数
 **/
public class CalRatioBase extends EnumType {

    public CalRatioBase(int code, String label){
        super(code, label);
    }


    /**
     * 合同金额
     */
    public final static CalRatioBase CONTRACT_CASH = new CalRatioBase(0, "合同金额");

    /**
     * 实际投放金额
     */
    public final static CalRatioBase FACT_LOAN_CASH = new CalRatioBase(1, "实际投放金额");
}
