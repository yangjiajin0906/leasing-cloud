package com.leasing.calculate.Exception;

/**
 * @project:leasing-cloud 统一异常处理
 * @date:2019/10/12
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class BusinessException extends RuntimeException {
    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(String msg, Throwable e) {
        super(msg, e);
    }

    public BusinessException(String msg, Object... objects) {
        super(getExceptionMessage(msg, objects));
    }

    private static String getExceptionMessage(String msg, Object[] objects) {
        String message = null;
        if (objects == null) {
            message = objects.toString();
                    //ExceptionConstant.getExceptionMess(msg);
        } else {
            message = objects.toString();
                    //ExceptionConstant.getExceptionMess(msg, objects);
        }

        return message != null ? message : msg;
    }
}