package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:简单标准接口枚举类
 **/
public class EnumType {
    private Short code;//编码

    private String lable;//描述

    public EnumType (int code,String lable) {
        this.lable = lable;
        this.code = Short.valueOf(code + "");
    }

    public  Short getShort() {
        return code;
    }

    public String getLable () {
        return lable;
    }
}