package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:保证金退回方式
 **/
public class Deposit_Back_Method extends EnumType {

    public Deposit_Back_Method(int code, String label) {
        super(code, label);
    }
    /**期末退回-0*/
    public final static Deposit_Back_Method LAST_BACK = new Deposit_Back_Method(0, "期末退回");
    /**冲抵租金-1*/
    public final static Deposit_Back_Method DEPOSITING_RENT = new Deposit_Back_Method(1,"冲抵租金");
    /**冲抵两期租金*/
    public final static Deposit_Back_Method DEPOSITING_TWO_RENT = new Deposit_Back_Method(2,"冲抵两期租金");


}
