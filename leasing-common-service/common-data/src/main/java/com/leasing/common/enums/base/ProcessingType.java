package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:批处理信息中的处理类型
 **/
public class ProcessingType extends EnumType {
    public ProcessingType(int code, String label) {
        super(code, label);
    }
    /**调息*/
    public static final ProcessingType RATE_ADJUST = new ProcessingType(0,"调息");
    /**其他*/
    public static final ProcessingType OTHERS = new ProcessingType(-1,"其他");

}
