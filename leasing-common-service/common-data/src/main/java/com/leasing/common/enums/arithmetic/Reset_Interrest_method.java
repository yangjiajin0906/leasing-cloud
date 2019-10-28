package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:利息补差方式
 **/
public class Reset_Interrest_method extends EnumType {

    public Reset_Interrest_method(int code, String label) {
        super(code, label);
    }
    /**不补差-0*/
    public static final Reset_Interrest_method NO_RESET = new Reset_Interrest_method(0, "不补差");
    /**按实际补差-1*/
    public static final Reset_Interrest_method FACT_RESET = new Reset_Interrest_method(1, "按实际补差");
    /**多补少不退-2*/
    public static final Reset_Interrest_method MORE_RESET = new Reset_Interrest_method(2, "多补少不退");

}
