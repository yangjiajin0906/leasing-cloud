package com.leasing.common.entity.sys.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:lvcna@yonyou.com
 * @description:
 **/
public class ParameterQuery extends BaseQuery {

    @QueryCondition(func = MatchType.like,field = "b.paramName")
    private String paramName;
    @QueryCondition(field = "b.paramCode")
    private String paramCode;
    @QueryCondition(field = "b.paramType")
    private Integer paramType;
    @QueryCondition(column = "pe.param_code")
    private String paramTypeA;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getParamTypeA() {
        return paramTypeA;
    }

    public void setParamTypeA(String paramTypeA) {
        this.paramTypeA = paramTypeA;
    }
}
