package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:租赁业务类别
 **/
public class Leasing_Category extends EnumType {

    public Leasing_Category(int code, String label) {
        super(code, label);
    }
    /**普通融资租赁-0*/
    public static Leasing_Category RENT_COMMON=new Leasing_Category(0,"普通融资租赁");
    /**在建期租赁-1*/
    public static Leasing_Category RENT_CONSTRUCTION=new Leasing_Category(1,"在建期租赁");
    /**模拟普通融资租赁-2*/
    public static Leasing_Category RENT_VIRTUAL = new Leasing_Category(2,"模拟普通融资租赁");
    /**厂商租赁-3*/
    public static Leasing_Category RENT_FACTORY = new Leasing_Category(3,"厂商租赁");
    /**经营期租赁-4*/
    public static Leasing_Category RENT_OPERATE = new Leasing_Category(4,"经营期租赁");


}
