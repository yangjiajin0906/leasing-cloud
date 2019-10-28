package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:特殊算法设置
 **/
public class Special_Arithmetic_Settings extends EnumType {

    public Special_Arithmetic_Settings(int code, String label) {
        super(code, label);
    }
    /**无-0*/
    public final static Special_Arithmetic_Settings NOTHING = new Special_Arithmetic_Settings(0, "无");
    /**平息法-1*/
    public final static Special_Arithmetic_Settings FIXED_INTEREST_METHOD = new Special_Arithmetic_Settings(1, "平息法");
    /**表面利率法-2*/
    public final static Special_Arithmetic_Settings SURFACE_INTERESTR_METHOD = new Special_Arithmetic_Settings(2, "表面利率法");
    /**无利率-3*/
    public final static Special_Arithmetic_Settings NO_INTERESTR = new Special_Arithmetic_Settings(3,"无利率");

}