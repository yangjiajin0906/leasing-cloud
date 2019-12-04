package com.leasing.common.entity.common.dto;

/**
 * @project:leasing-cloud
 * @date:2019-11-25
 * @author:lvcna@yonyou.com
 * @description: 解析Excel Cell值返回解析结果
 **/
public class CellValueDTO {

    //是否成功
    private Boolean flag;
    //解析值
    private Object value;
    //错误日志
    private String errorMsg;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
