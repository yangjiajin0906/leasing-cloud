package com.leasing.common.base.entity;

/**
 * @project:leasing-cloud
 * @date:2019-10-18
 * @author:lvcna@yonyou.com
 * @description:
 **/
public abstract class BaseRefVO extends AbstractBaseEntity {

    public abstract String[] getFieldCode();

    public abstract String[] getFieldName();

    //编码
    private String code;
    //名称
    private String name;
    //主键
    private String pk;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }
}
