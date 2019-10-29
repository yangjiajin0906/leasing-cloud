package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:服务费支出方式
 **/
public class Service_Pay_Method extends EnumType {

    public Service_Pay_Method(int code, String label) {
        super(code, label);
    }
    /**期初一次性支付-0*/
    public final static Service_Pay_Method ONE_TIME_PAY = new Service_Pay_Method(0, "期初一次性收取");
    /**每满一年支出-1*/
    public final static Service_Pay_Method EVERY_YEAR_PAY = new Service_Pay_Method(1, "每满一年支出");
    /**手工维护-2*/
    public final static Service_Pay_Method MANUAL_MAINTENANCE = new Service_Pay_Method(2,"手工维护");
    /**每年年初支付-3*/
    public final static Service_Pay_Method EVERY_BEGIAN = new Service_Pay_Method(3,"每年年初支付");


}
