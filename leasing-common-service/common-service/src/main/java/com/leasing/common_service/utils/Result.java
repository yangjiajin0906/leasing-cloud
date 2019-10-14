package com.leasing.common_service.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by lvcn on 2019-7-11.
 * web请求返回对象
 */
public class Result implements Serializable{

    //成功与否标志
    private boolean success = true;
    //返回状态码，为空则默认200.前端需要拦截一些常见的状态码如403、404、500等
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status = 200;
    //返回数据
    public Object data;
    //返回消息
    public String msg;

    public Result() {

    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, Integer status) {
        this.success = success;
        this.status = status;
    }

    public Result(boolean success, String msg){
        this(success);
        this.msg = msg;
    }

    public Result(boolean success, Integer status, String msg) {
        this.success = success;
        this.status = status;
        this.msg = msg;
    }

    public Result(boolean success, Integer status, String msg, Object data) {
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
