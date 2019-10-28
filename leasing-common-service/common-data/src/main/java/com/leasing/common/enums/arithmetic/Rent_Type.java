package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:租金计划表类型
 **/
public class Rent_Type extends EnumType {

    public Rent_Type(int code, String label) {
        super(code, label);
    }
    /**
     * 市场表
     */
    public final static Rent_Type MARKET = new Rent_Type(0, "市场表");
    /**
     * 会计表
     */
    public final static Rent_Type ACCOUNT = new Rent_Type(1, "会计表");

}
