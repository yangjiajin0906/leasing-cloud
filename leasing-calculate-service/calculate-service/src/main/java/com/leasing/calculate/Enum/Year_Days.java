package com.leasing.calculate.Enum;

/**
 * @project:leasing-cloud 年计算天数
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
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