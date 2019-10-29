package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:不规则计算方法
 **/
public class Irregular_Cal_Method extends EnumType {

    public Irregular_Cal_Method(int code, String label) {
        super(code, label);
    }

    /** 租金法-0 */
    public final static Irregular_Cal_Method RENT_METHOD = new Irregular_Cal_Method(0, "租金法");
    /** 本金法-1 */
    public final static Irregular_Cal_Method PRINCIPAL_METHOD = new Irregular_Cal_Method(1, "本金法");
}
