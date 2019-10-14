package com.leasing.calculate.Enum;

/**
 * @project:leasing-cloud 租金计算方法
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Lease_Cal_Method extends EnumType {
    public Lease_Cal_Method(int code, String label){
        super(code, label);
    }

    /**等额租金-0*/
    public final static Lease_Cal_Method RENT_EQ = new Lease_Cal_Method(0, "等额租金");
    /**等额本金-1*/
    public final static Lease_Cal_Method PRINCIPAL_EQ = new Lease_Cal_Method(1, "等额本金");
    /**等差租金-2*/
    public final static Lease_Cal_Method RENT_DIF = new Lease_Cal_Method(2, "等差租金");
    /**指定租金-3*/
    public final static Lease_Cal_Method RENT_SPE = new Lease_Cal_Method(3, "指定租金");
    /**指定本金-4*/
    public final static Lease_Cal_Method PRINCIPAL_SPE = new Lease_Cal_Method(4, "指定本金");
    /**根据租金计算利率-5*/
    public final static Lease_Cal_Method CALRATE_SPE = new Lease_Cal_Method(5, "根据租金计算利率");
    /**表面利率法-6*/
    public final static Lease_Cal_Method SURFACE = new Lease_Cal_Method(6, "表面利率法率");
    /**不规则测算租金法-7*/
    public final static Lease_Cal_Method IRREGULAR_RENT = new Lease_Cal_Method(7, "不规则测算租金法");
    /**不规则测算本金法-8*/
    public final static Lease_Cal_Method IRREGULAR_CORPUS = new Lease_Cal_Method(8, "不规则测算本金法");
}