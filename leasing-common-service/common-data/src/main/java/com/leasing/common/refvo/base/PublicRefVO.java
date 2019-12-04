package com.leasing.common.refvo.base;

import com.leasing.common.base.repository.support.Pagination;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:wangjc@yonyou.com
 * @description: 前端交互公共参照VO类
 **/
public class PublicRefVO {
    /**
     * 表头编码
     */
    private String[] strFieldCode;

    /**
     * 表头名称
     */
    private String[] strFieldName;

    /**
     *  结果集数据
     */
    private List data;

    /**
     *  分页对象封装
     */
    private Pagination page;

    public String[] getStrFieldCode() {
        return strFieldCode;
    }

    public void setStrFieldCode(String[] strFieldCode) {
        this.strFieldCode = strFieldCode;
    }

    public String[] getStrFieldName() {
        return strFieldName;
    }

    public void setStrFieldName(String[] strFieldName) {
        this.strFieldName = strFieldName;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Pagination getPage() {
        return page;
    }

    public void setPage(Pagination page) {
        this.page = page;
    }
}