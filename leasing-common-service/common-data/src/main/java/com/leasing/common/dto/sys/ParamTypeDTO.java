package com.leasing.common.dto.sys;

import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-20
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_param_type")
public class ParamTypeDTO extends BaseDTO{

    /**
     * 主键
     */
    @Id
    private String pkParamType;


    /**
     * 参数分类名称
     */
    private String paramName;

    /**
     * 参数分类英文名
     */
    private String paramVarname;

    /**
     * 参数编号
     */
    private String paramCode;
    /**
     * 参数类型
     */
    private Integer paramType;

    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;


    public String getPkParamType() {
        return pkParamType;
    }

    public void setPkParamType(String pkParamType) {
        this.pkParamType = pkParamType;
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

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamVarname() {
        return paramVarname;
    }

    public void setParamVarname(String paramVarname) {
        this.paramVarname = paramVarname;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPk() {
        return null;
    }

    public void setPk(String pk) {

    }
}
