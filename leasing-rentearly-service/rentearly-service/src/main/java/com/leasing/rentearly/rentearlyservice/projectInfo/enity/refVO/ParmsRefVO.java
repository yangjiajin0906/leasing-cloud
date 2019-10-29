package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_parameter")
public class ParmsRefVO extends BaseRefVO {

    @Id
    public String pkParameter;

    public String paramCode;

    public String paramName;

    public String paramValue;

    public Integer paramType;

    public String parentParameter;

//    public ParmsRefVO(String pkParameter, String paramCode, String paramName, String paramValue, Integer paramType, String parentParameter) {
//        this.pkParameter = pkParameter;
//        this.paramCode = paramCode;
//        this.paramName = paramName;
//        this.paramValue = paramValue;
//        this.paramType = paramType;
//        this.parentParameter = parentParameter;
//        this.setParamCode(paramCode);
//        this.setParamName(paramName);
//        this.setPk(pkParameter);
//    }

    public String getPkParameter() {
        return pkParameter;
    }

    public void setPkParameter(String pkParameter) {
        this.pkParameter = pkParameter;
    }

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getParentParameter() {
        return parentParameter;
    }

    public void setParentParameter(String parentParameter) {
        this.parentParameter = parentParameter;
    }
}
