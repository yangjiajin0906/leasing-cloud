package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:年利率计算天数
 **/
public class Year_Days_Value extends EnumType {
    public Year_Days_Value(int code, String label) {
        super(code, label);
    }
    /**按照360计算-0*/
    public final static Year_Days_Value VALUE_360 = new Year_Days_Value(0, "按照360计算");
    /**按照360计算-1*/
    public final static Year_Days_Value VALUE_365 = new Year_Days_Value(1, "按照365计算");
}