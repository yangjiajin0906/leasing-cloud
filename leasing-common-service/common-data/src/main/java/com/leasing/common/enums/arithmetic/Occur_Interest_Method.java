package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:利息计算方式(针对等额租金，利息如何计算)
 **/
public class Occur_Interest_Method extends EnumType {

    public Occur_Interest_Method(int code, String label) {
        super(code, label);
    }
    /**期复息-0*/
    public final static Occur_Interest_Method INTEREST_TERM = new Occur_Interest_Method(0, "期复息");
    /**日复息-1*/
    public final static Occur_Interest_Method INTEREST_DAY = new Occur_Interest_Method(1, "日复息");

}
