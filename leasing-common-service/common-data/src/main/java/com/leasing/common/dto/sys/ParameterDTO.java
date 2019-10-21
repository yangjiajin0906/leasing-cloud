package com.leasing.common.dto.sys;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_parameter")
public class ParameterDTO extends BaseEntity{

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

    @Override
    public String getPk() {
        return this.pkParameter;
    }

    @Override
    public void setPk(String pk) {
        this.pkParameter = pk;
    }
}
