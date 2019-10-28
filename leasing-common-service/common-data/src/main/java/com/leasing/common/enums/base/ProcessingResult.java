package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:批处理信息中的处理结果
 **/
public class ProcessingResult extends EnumType {

    public ProcessingResult(int code, String label) {
        super(code, label);
    }

    /**成功*/
    public static final ProcessingResult SUCCEED = new ProcessingResult(0,"成功");
    /**失败*/
    public static final ProcessingResult FAIL = new ProcessingResult(1,"失败");
    /**其他*/
    public static final ProcessingResult OTHERS = new ProcessingResult(-1,"其他");

}
