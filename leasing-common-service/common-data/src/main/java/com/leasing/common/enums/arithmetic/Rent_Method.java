package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:租赁方式
 **/
public class Rent_Method extends EnumType {

    public Rent_Method(int code, String label) {
        super(code, label);
    }
    /**
     * 直租
     */
    public final static Rent_Method PLUMPLY = new Rent_Method(0, "直租");
    /**
     * 回租
     */
    public final static Rent_Method CALLBACK = new Rent_Method(1, "回租");

}
