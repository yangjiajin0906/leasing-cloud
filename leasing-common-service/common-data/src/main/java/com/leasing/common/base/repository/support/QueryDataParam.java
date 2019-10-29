package com.leasing.common.base.repository.support;

import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:lvcna@yonyou.com
 * @description:
 **/
public class QueryDataParam {

    private String sql;
    private String where;
    private Map<String,Object> paramMap;
    private Boolean ifArrange;


    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Boolean getIfArrange() {
        return ifArrange;
    }

    public void setIfArrange(Boolean ifArrange) {
        this.ifArrange = ifArrange;
    }
}
