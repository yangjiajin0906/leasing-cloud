package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:是与否
 **/
public class Yes_Or_No extends EnumType {
    public Yes_Or_No(int code, String label) {
        super(code, label);
    }

    /** 是-0 */
    public final static Yes_Or_No YES = new Yes_Or_No(0, "是");
    /** 否-1 */
    public final static Yes_Or_No NO = new Yes_Or_No(1, "否");
}