package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:调息种类（调息响应方式)
 **/
public class Interate_AdjResponse_Method extends EnumType {

    public Interate_AdjResponse_Method(int code, String label) {
        super(code, label);
    }
    /**不调息-0*/
    public final static Interate_AdjResponse_Method NO_ADJ = new Interate_AdjResponse_Method(0, "不调息");
    /**随基准调息-1*/
    public final static Interate_AdjResponse_Method BASE_ADJ = new Interate_AdjResponse_Method(1, "随基准调息");
    /**调息月次月1日-2*/
    public final static Interate_AdjResponse_Method BASE_NM_ONE = new Interate_AdjResponse_Method(2, "调息月次月1日");
    /**次年1月1日-3*/
    public final static Interate_AdjResponse_Method BASE_NY_ONE = new Interate_AdjResponse_Method(3, "次年1月1日");
    /**下一收租日-4*/
    public final static Interate_AdjResponse_Method CAL_N_RENT = new Interate_AdjResponse_Method(4, "下一收租日");
    /**投放满一月后收租日-5*/
    public final static Interate_AdjResponse_Method PUTTING_NM_RENT = new Interate_AdjResponse_Method(5, "投放满一月后收租日");
    /**投放满一季后收租日-6*/
    public final static Interate_AdjResponse_Method PUTTING_NS_RENT = new Interate_AdjResponse_Method(6, "投放满一季后收租日");
    /**投放满半年后收租日-7*/
    public final static Interate_AdjResponse_Method PUTTING_NHY_RENT = new Interate_AdjResponse_Method(7, "投放满半年后收租日");
    /**投放满一年后收租日-8*/
    public final static Interate_AdjResponse_Method PUTTING_NY_RENT = new Interate_AdjResponse_Method(8, "投放满一年后收租日");
    /**手工指定的调息日-9*/
    public final static Interate_AdjResponse_Method AUTO_DAY = new Interate_AdjResponse_Method(9, "手工指定的调息日");
}
