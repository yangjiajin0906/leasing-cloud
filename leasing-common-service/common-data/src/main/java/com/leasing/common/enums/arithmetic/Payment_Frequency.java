package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:支付频率
 **/
public class Payment_Frequency extends EnumType {

    public Payment_Frequency(int code, String label) {
        super(code, label);
    }
    /**月-0*/
    public final static Payment_Frequency MONTH = new Payment_Frequency(0, "月");
    /**双月-1*/
    public final static Payment_Frequency TWIN_MONTH = new Payment_Frequency(1, "双月");
    /**季-2*/
    public final static Payment_Frequency SEASON = new Payment_Frequency(2, "季");
    /**四月-3*/
    public final static Payment_Frequency FOUR_MONTH = new Payment_Frequency(3, "四月");
    /**半年-4*/
    public final static Payment_Frequency HALF_YEAR = new Payment_Frequency(4, "半年");
    /**年-5*/
    public final static Payment_Frequency YEAR = new Payment_Frequency(5, "年");
    /**日-6*/
    public final static Payment_Frequency DAY = new Payment_Frequency(6, "日");

}