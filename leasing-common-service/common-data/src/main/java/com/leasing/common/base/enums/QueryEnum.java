package com.leasing.common.base.enums;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:lvcna@yonyou.com
 * @description:
 **/
public enum QueryEnum {

    /**
     * 模糊查询：解析为 like %%
     */
    LIKE,

    /**
     * 模糊查询：解析为 not like %%
     */
    NOTLIKE,

    /**
     * 存在：解析为：exists ("subsql")
     */
    EXITS,

    /**
     * 等于：解析为：=
     */
    EQUAL,

    /**
     * 不存在：解析为 not exists ("subsql")
     */
    NOTEXISTS,

}
