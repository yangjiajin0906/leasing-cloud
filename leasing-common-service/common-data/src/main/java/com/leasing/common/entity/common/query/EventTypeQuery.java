package com.leasing.common.entity.common.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/10/31
 * @author:wangjc@yonyou.com
 * @description:事件类别查询参数类
 **/
public class EventTypeQuery extends BaseQuery {
    @QueryCondition(field = "e.module")
    private Short module;

    @QueryCondition(func = MatchType.like,field = "e.eventClassName")
    private String eventClassName;

    @QueryCondition(func = MatchType.like,field = "e.eventName")
    private String eventName;

    public EventTypeQuery(){}

    public Short getModule() {
        return module;
    }

    public void setModule(Short module) {
        this.module = module;
    }

    public String getEventClassName() {
        return eventClassName;
    }

    public void setEventClassName(String eventClassName) {
        this.eventClassName = eventClassName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}