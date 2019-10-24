package com.leasing.common.base.repository.support;

import java.io.Serializable;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/24
 * @author:jiaoshy@yonyou.com
 * @description: 条件查询 结果集封装
 **/
public class PageQueryData implements Serializable {

    /**
     * 查询结果集
     */
    private List pageData;

    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private long pageSize;



    public List getPageData() {
        return pageData;
    }

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}
