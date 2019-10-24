package com.leasing.common.exception;

/**
 * @project:leasing-cloud
 * @date:2019-10-18
 * @author:lvcna@yonyou.com
 * @description: 异常处理基类
 **/
public class BaseException extends RuntimeException {

    protected String code;

    public BaseException(String msg){
        super(msg);
    }

    public BaseException(String code,String msg){
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
