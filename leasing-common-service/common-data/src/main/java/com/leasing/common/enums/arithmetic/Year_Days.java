package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:年计算天数
 **/
public class Year_Days extends EnumType {

    public Year_Days(int code, String label) {
        super(code, label);
    }
    /**360-0*/
    public final static Year_Days YEAR_360 = new Year_Days(0, "360");
    /**365-1*/
    public final static Year_Days YEAR_365 = new Year_Days(1, "365");

}
