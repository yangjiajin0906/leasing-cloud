package com.leasing.sys.dao.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.entity.BaseVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:lvcna@yonyou.com
 * @description: 枚举类型VO
 **/
@Entity
@Table(name = "yls_param_type")
public class ParamTypeDO extends BaseBusinessDO {

    /**
     * 主键
     */
    @Id
    private String pkParamType;


    /**
     * 参数分类编码
     */
    private String paramCode;


    /**
     * 参数分类名称
     */
    private String paramName;

    /**
     * 参数分类英文名
     */
    private String paramVarname;


    /**
     * 可否编辑
     */
    private String editable;


    /**
     * 参数类型
     */
    private Integer paramType;

    /**
     * 参数设置
     */

    @Transient
    private List<ParameterDO> parameter;


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

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public List<ParameterDO> getParameter() {
        return parameter;
    }

    public void setParameter(List<ParameterDO> parameter) {
        this.parameter = parameter;
    }

    @Override
    public String getPk() {
        return "pkParamType";
    }

    @Override
    public void setPk(String pk) {
        this.pkParamType = pk;
    }
}
