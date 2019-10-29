package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:服务费收取方式
 **/
public class Service_Charge_Method extends EnumType {

    public Service_Charge_Method(int code, String label) {
        super(code, label);
    }
    /**期初一次性收取-0*/
    public final static Service_Charge_Method ONE_TIME_CHARGE = new Service_Charge_Method(0, "期初一次性收取");
    /**每笔投放收取-1*/
    public final static Service_Charge_Method EVERY_DELIVERY_CHARGE = new Service_Charge_Method(1, "每笔投放收取");
    /**每满一年收取-2*/
    public final static Service_Charge_Method EVERY_YEAR_CHARGE = new Service_Charge_Method(2, "每年收取（每年年初的第一个收租日）");
    /**手工维护-3*/
    public final static Service_Charge_Method MANUAL_MAINTENANCE = new Service_Charge_Method(3,"手工维护");
    /**每年收取（每年年初的第一个收租日）-4*/
    public final static Service_Charge_Method EVERY_BEGIAN = new Service_Charge_Method(4,"每年年初收取");


}
