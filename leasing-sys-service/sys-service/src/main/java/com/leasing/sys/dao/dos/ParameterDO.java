package com.leasing.sys.dao.dos;

import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.dto.sys.ParamTypeDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:lvcna@yonyou.com
 * @description: 枚举字典实体类
 **/
@Entity
@Table(name="yls_parameter")
public class ParameterDO extends BaseDO {
    /**
     * 主键
     */
    @Id
    private String pkParameter;

    /**
     * 主表主键
     */
    private String pkParamType; // 主表主键
    /**
     * 参数名称
     */
    private String paramName;
    /**
     * 参数编号
     */
    private String paramCode;
    /**
     * 参数值
     */
    private String paramValue;
    /**
     * 参数类型
     */
    private Integer paramType;
    /**
     * 参数说明
     */
    private String memo;
    /**
     * 是否启用
     */
    private String isEnable;
    /**
     * 上级参数
     */
    private String parentParameter;
    /**
     * 是否唯一
     * 此字段目前只是针对 分类编码“000252”
     * 2016年6月24日
     */
    private String isOnly;

    @Transient
    private String paramVarname;

    public String getParamVarname() {
        return paramVarname;
    }

    public void setParamVarname(String paramVarname) {
        this.paramVarname = paramVarname;
    }

    public String getPkParameter() {
        return pkParameter;
    }

    public void setPkParameter(String pkParameter) {
        this.pkParameter = pkParameter;
    }

    public String getPkParamType() {
        return pkParamType;
    }

    public void setPkParamType(String pkParamType) {
        this.pkParamType = pkParamType;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getEnable() {
        return isEnable;
    }

    public void setEnable(String enable) {
        isEnable = enable;
    }

    public String getParentParameter() {
        return parentParameter;
    }

    public void setParentParameter(String parentParameter) {
        this.parentParameter = parentParameter;
    }

    public String getIsOnly() {
        return isOnly;
    }

    public void setIsOnly(String isOnly) {
        this.isOnly = isOnly;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
