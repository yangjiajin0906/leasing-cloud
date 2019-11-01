package com.leasing.common.entity.common.dto;

import com.leasing.common.base.entity.BaseDTO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description: 事件类别的DTO
 **/
@Entity
@Table(name = "yls_event_type")
public class EventTypeDTO extends BaseDTO {
    @Id
    private String pkEventType;

    private Short module;

    private String eventClassCode;

    private String eventClassName;

    private String eventCode;

    private String eventName;

    private Short cashDeriction;

    private Short isEnable;

    private String memo;

    public EventTypeDTO(){}

    public String getPkEventType() {
        return pkEventType;
    }

    public void setPkEventType(String pkEventType) {
        this.pkEventType = pkEventType;
    }

    public Short getModule() {
        return module;
    }

    public void setModule(Short module) {
        this.module = module;
    }

    public String getEventClassCode() {
        return eventClassCode;
    }

    public void setEventClassCode(String eventClassCode) {
        this.eventClassCode = eventClassCode;
    }

    public String getEventClassName() {
        return eventClassName;
    }

    public void setEventClassName(String eventClassName) {
        this.eventClassName = eventClassName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Short getCashDeriction() {
        return cashDeriction;
    }

    public void setCashDeriction(Short cashDeriction) {
        this.cashDeriction = cashDeriction;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}