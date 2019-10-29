package com.leasing.common.utils.base;

import com.leasing.common.base.web.ResResult;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:结果集工具类 业务调用结束后传入返回前端页面结果集
 **/
public class ResultUtils {

    protected ResultUtils() {}

    public static ResResult newResult() {
        return new ResResult();
    }
    /***************************************业务调用成功******************************************/
    public static ResResult success() {
        return new ResResult();
    }

    public static ResResult success(String msg) {
        return new ResResult(true, null, msg);
    }

    public static ResResult successWithData(Object data) {
        return new ResResult(true, null,null, data);
    }

    public static ResResult successWithData(Object data, String msg) {
        return new ResResult(true, null, msg, data);
    }

    /***************************************业务调用失败******************************************/
    public static ResResult failure() {
        return new ResResult(false);
    }

    public static ResResult failure(String msg) {
        return new ResResult(false, null, msg);
    }

    public static ResResult failureWithData(Object data) {
        return new ResResult(false, null,null, data);
    }

    public static ResResult failWithMsgData(Object data, String msg) {
        return new ResResult(false, null, msg, data);
    }

}
