package com.leasing.calculate.Enum;

/**
 * @project:leasing-cloud IRR天数转换参数
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Year_Days_Irr extends EnumType {
    public Year_Days_Irr(int code, String label) {
        super(code, label);
    }
    /**按照360转换天数-0*/
    public final static Year_Days_Irr IRR_360 = new Year_Days_Irr(0, "按照360转换天数");
    /**按照365转换天数-1*/
    public final static Year_Days_Irr IRR_365 = new Year_Days_Irr(1, "按照365转换天数");

}