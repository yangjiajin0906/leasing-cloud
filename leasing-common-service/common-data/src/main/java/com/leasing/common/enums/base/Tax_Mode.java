package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:税种
 **/
public class Tax_Mode extends EnumType{
    public Tax_Mode(int code, String label) {
        super(code, label);
    }
    /**
     * 增值税
     */
    public final static Tax_Mode VALUE_ADDED = new Tax_Mode(0, "增值税");
    /**
     * 营业税
     */
    public final static Tax_Mode SALES = new Tax_Mode(1, "营业税");
}