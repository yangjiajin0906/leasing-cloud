package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:租金表调整对象
 **/
public class Adjust extends EnumType {

    public Adjust(int code, String label) {
        super(code, label);
    }
    /**
     * 租金
     */
    public final static Adjust RENT = new Adjust(0, "租金");
    /**
     * 本金
     */
    public final static Adjust CURPUS = new Adjust(1, "本金");
    /**
     * 不限
     */
    public final static Adjust UNLIMITED = new Adjust(2, "不限");

}
