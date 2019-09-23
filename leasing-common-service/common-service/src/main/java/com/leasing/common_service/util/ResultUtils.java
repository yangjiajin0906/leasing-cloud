package com.leasing.common_service.util;

/**
 * Created by lvcn on 2019-7-17.
 * Result工具类
 */
public class ResultUtils {

    protected ResultUtils() {}

    public static Result newResult() {
         return new Result();
    }
    /***************************************业务调用成功******************************************/
    public static Result success() {
        return new Result();
    }

    public static Result success(String msg) {
        return new Result(true, null, msg);
    }

    public static Result successWithData(Object data) {
        return new Result(true, 200,null, data);
    }

    public static Result successWithData(Object data, String msg) {
        return new Result(true, null, msg, data);
    }

    /***************************************业务调用失败******************************************/
    public static Result failure() {
        return new Result(false);
    }

    public static Result failure(String msg) {
        return new Result(false, null, msg);
    }

    public static Result failureWithData(Object data) {
        return new Result(false, null,null, data);
    }

    public static Result failWithMsgData(Object data, String msg) {
        return new Result(false, null, msg, data);
    }
}
