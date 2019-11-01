package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "(" +
        "         SELECT A.PARAM_NAME,A.PARAM_VALUE,A.PARAM_CODE," +
        "            A.PK_PARAM_TYPE,A.MEMO,A.IS_ENABLE,A.PARENT_PARAMETER," +
        "            A.PARAM_TYPE,A.MDB_CODE,A.PK_PARAMETER" +
        "        FROM YLS_PARAMETER A" +
        "        INNER JOIN YLS_PARAM_TYPE B ON A.PK_PARAM_TYPE = B.PK_PARAM_TYPE" +
        "        WHERE B.PARAM_CODE = '1001630'" +
        "     )")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class BusinessDomainDTO extends BaseDTO {
    @Transient
    public String name;

    @Transient
    public String code;

    @Id
    public String pkParameter;
    public String paramCode;
    public String paramName;
    public String paramValue;
    public String pkParamType;
    public String memo;
    @Transient
    public Boolean isEnable;
    public Integer paramType;
    public String parentParameter;

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

    public String getPkParamType() {
        return pkParamType;
    }

    public void setPkParamType(String pkParamType) {
        this.pkParamType = pkParamType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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

    public String getPk() {
        return pkParameter;
    }

    public void setPk(String pk) {
        this.pkParameter = pk;
    }

    //    public BusinessDomainDTO(String pkParameter, String paramCode, String paramName, String paramValue, String pkParamType, String memo, Boolean isEnable, Integer paramType, String parentParameter) {
//        this.pkParameter = pkParameter;
//        this.paramCode = paramCode;
//        this.paramName = paramName;
//        this.paramValue = paramValue;
//        this.pkParamType = pkParamType;
//        this.memo = memo;
//        this.isEnable = isEnable;
//        this.paramType = paramType;
//        this.parentParameter = parentParameter;
//        this.setPk(pkParameter);
//        this.setCode(paramCode);
//        this.setName(paramName);
//    }
    public String getName() {
        return paramName;
    }

    public String getCode() {
        return paramCode;
    }

    public void setName(String name) {
        this.name = this.paramName;
    }

    public void setCode(String code) {
        this.code = this.paramCode;
    }
}
