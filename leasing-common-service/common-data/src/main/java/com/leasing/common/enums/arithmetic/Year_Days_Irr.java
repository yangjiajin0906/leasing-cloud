package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:IRR天数转换参数
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