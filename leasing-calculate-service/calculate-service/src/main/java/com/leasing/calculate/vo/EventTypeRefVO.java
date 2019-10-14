package com.leasing.calculate.vo;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 事件类别类
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 **/

public class EventTypeRefVO {
    /**
     * 业务模块
     */
    public Short module;
    /**
     * 事件分类编码
     */
    public String event_class_code;
    /**
     * 事件分类名称
     */
    public String event_class_name;
    /**
     * 事件类别编码
     */
    public String event_code;
    /**
     * 事件类别名称
     */
    public String event_name;
    /**
     * 现金流方向
     */
    public Short cash_deriction;
    /**
     * 是否启用
     */
    public Short is_enable;
    /**
     * 备注
     */
    public String memo;

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


    /**
     * 业务模块的getter方法
     *
     * @return String
     */
    public Short getModule() {
        return module;
    }

    /**
     * 业务模块的setter方法
     *
     * @param module 业务模块
     */
    public void setModule(Short module) {
        this.module = module;
    }


    /**
     * 事件分类编码的getter方法
     *
     * @return String
     */
    public String getEvent_class_code() {
        return event_class_code;
    }

    /**
     * 事件分类编码的setter方法
     *
     * @param event_class_code 事件分类编码
     */
    public void setEvent_class_code(String event_class_code) {
        this.event_class_code = event_class_code;
    }


    /**
     * 事件分类名称的getter方法
     *
     * @return String
     */
    public String getEvent_class_name() {
        return event_class_name;
    }

    /**
     * 事件分类名称的setter方法
     *
     * @param event_class_name 事件分类名称
     */
    public void setEvent_class_name(String event_class_name) {
        this.event_class_name = event_class_name;
    }

    /**
     * 事件类别编码的getter方法
     *
     * @return String
     */
    public String getEvent_code() {
        return event_code;
    }

    /**
     * 事件类别编码的setter方法
     *
     * @param event_code 事件类别编码
     */
    public void setEvent_code(String event_code) {
        this.event_code = event_code;
    }

    /**
     * 现金流方向的getter方法
     *
     * @return String
     */
    public Short getCash_deriction() {
        return cash_deriction;
    }

    /**
     * 现金流方向的setter方法
     *
     * @param cash_deriction 现金流方向
     */
    public void setCash_deriction(Short cash_deriction) {
        this.cash_deriction = cash_deriction;
    }


    /**
     * 是否启用的getter方法
     *
     * @return String
     */
    public Short getIs_enable() {
        return is_enable;
    }

    /**
     * 是否启用的setter方法
     *
     * @param is_enable 是否启用
     */
    public void setIs_enable(Short is_enable) {
        this.is_enable = is_enable;
    }


    /**
     * 备注的getter方法
     *
     * @return String
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注的setter方法
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
}