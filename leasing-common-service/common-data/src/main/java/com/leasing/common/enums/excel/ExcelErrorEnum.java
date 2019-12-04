package com.leasing.common.enums.excel;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:Yjj@yonyou.com
 * @description:
 **/
public enum ExcelErrorEnum {

    SYS_EXCEPTION(9000, "系统异常,操作失败"),
    ILLEGAL_ARGUMENT(9001, "参数非法"),
    ARGUMENT_NOT_VALID(9002, "参数校验不通过"),
    FILE_NOT_EXISTS(9003, "文件不存在"),
    FILE_INVALID_TYPE(9004, "文件类型错误,只支持.xlx和.xlsx类型的文件导入"),
    FILE_STREAM_FAIL(9005, "解析文件流出现异常,请检查"),
    FILE_MATCH_FAIL(9006, "不支持的Excel匹配类型"),



    ;

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ExcelErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据错误编码查询详细错误信息
     * @param code
     * @return
     */
    public static String getMsgByCode(String code) {
        for (ExcelErrorEnum errorCode : ExcelErrorEnum.values()) {
            if (code.equals(errorCode.getCode())) {
                return errorCode.getMsg();
            }
        }
        return SYS_EXCEPTION.getMsg();
    }
}