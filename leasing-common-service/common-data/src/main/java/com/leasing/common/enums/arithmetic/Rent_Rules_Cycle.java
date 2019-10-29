package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:收租规则周期
 **/
public class Rent_Rules_Cycle extends EnumType {

    public Rent_Rules_Cycle(int code, String label) {
        super(code, label);
    }
    /**按租赁期-0*/
    public static final Rent_Rules_Cycle LEASE_TERM = new Rent_Rules_Cycle(0, "按租赁期");
    /**按年循环-1*/
    public static final Rent_Rules_Cycle YEAR_CYCLE = new Rent_Rules_Cycle(1, "按年循环");

}
