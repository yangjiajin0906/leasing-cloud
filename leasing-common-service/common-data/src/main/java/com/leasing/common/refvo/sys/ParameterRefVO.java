package com.leasing.common.refvo.sys;

import com.leasing.common.base.entity.BaseRefVO;
import lombok.Value;

import java.beans.ConstructorProperties;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:lvcna@yonyou.com
 * @description:
 **/

@Value
public class ParameterRefVO extends BaseRefVO{

    /**
     * 参数名称
     */
    private String pkParameter;
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


    @ConstructorProperties({"pkParameter","paramName", "paramCode", "paramValue"})
    public ParameterRefVO(String pkParameter,String paramName, String paramCode, String paramValue) {
        this.pkParameter = pkParameter;
        this.paramName = paramName;
        this.paramCode = paramCode;
        this.paramValue = paramValue;
        this.setCode(paramCode);
        this.setName(paramName);
        this.setPk(pkParameter);
    }
}
