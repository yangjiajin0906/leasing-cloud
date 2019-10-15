package com.leasing.common.entity.sys.web;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:
 **/
public class ResResult {

    //成功与否标志
    private boolean success = true;
    //返回状态码，为空则默认200.前端需要拦截一些常见的状态码如403、404、500等
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;
    //返回数据
    public Object data;
    //返回消息
    public String msg;

    public ResResult() {

    }

    public ResResult(boolean success) {
        this.success = success;
    }

    public ResResult(boolean success, Integer status) {
        this.success = success;
        this.status = status;
    }

    public ResResult(boolean success, String msg){
        this(success);
        this.msg = msg;
    }

    public ResResult(boolean success, Integer status, String msg) {
        this.success = success;
        this.status = status;
        this.msg = msg;
    }

    public ResResult(boolean success, Integer status, String msg, Object data) {
        this.success = success;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
