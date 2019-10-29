package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:服务费基数
 **/
public class Service_Charge_Base extends EnumType {

    public Service_Charge_Base(int code, String label) {
        super(code, label);
    }
    /**投放本金-0*/
    public final static Service_Charge_Base PUTTING_BASE = new Service_Charge_Base(0, "投放本金");
    /**剩余本金-1*/
    public final static Service_Charge_Base BALANCE_BASE = new Service_Charge_Base(1, "剩余本金");


}
