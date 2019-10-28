package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:平息法使用日利率，还是期利率
 **/
public class Fix_Method extends EnumType {

    public Fix_Method(int code, String label) {
        super(code, label);
    }
    /**日利率-0*/
    public static final Fix_Method DAYRATE = new Fix_Method(0, "日利率");
    /**期利率-1*/
    public static final Fix_Method TERMRATE = new Fix_Method(1, "期利率");

}
