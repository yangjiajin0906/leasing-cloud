package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:保证金收取方式
 **/
public class Deposit_Charge_Method extends EnumType {

    public Deposit_Charge_Method(int code, String label) {
        super(code, label);
    }
    /**期初一次性收取-0*/
    public final static Deposit_Charge_Method ONE_TIME_CHARGE = new Deposit_Charge_Method(0, "期初一次性收取");
    /**每笔投放收取-1*/
    public final static Deposit_Charge_Method EVERY_DELIVERY_CHARGE = new Deposit_Charge_Method(1, "每笔投放收取");
    /**手工维护-2*/
    public final static Deposit_Charge_Method MANUAL_MAINTENANCE = new Deposit_Charge_Method(2,"手工维护");


}
