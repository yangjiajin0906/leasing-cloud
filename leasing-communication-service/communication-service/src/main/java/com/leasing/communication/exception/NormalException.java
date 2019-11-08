package com.leasing.communication.exception;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description: 导入导出异常处理
 **/
public class NormalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NormalException(String message) {
        super(message);
    }
}