package com.leasing.calculate.entity;

/**
 * @project:leasing-cloud 币种REF类
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class CurrtypeRefVO {
    /**
     * 符号
     */
    public String currtype_sign;

    public String getCurrtype_sign() {
        return currtype_sign;
    }

    public void setCurrtype_sign(String currtypeSign) {
        currtype_sign = currtypeSign;
    }

    public String pk;
    public String code;
    public String name;


    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getPk() {
        return this.pk;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrimaryKey() {
        return this.pk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

}