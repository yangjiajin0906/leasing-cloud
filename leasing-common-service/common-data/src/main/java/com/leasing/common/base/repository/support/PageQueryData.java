package com.leasing.common.base.repository.support;

import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/24
 * @author:jiaoshy@yonyou.com
 * @description: 条件查询 结果集封装
 **/
public class PageQueryData<T> implements Serializable {

    /**
     * 查询结果集
     */
    private List<T> pageData;

    /**
     * 总条数
     */
    private long total;

    /**
     * 总页数
     */
    private long pageCount;





    public PageQueryData(Page<T> page){
        this.pageData = page.getContent();
        this.pageCount = page.getTotalPages();
        this.total = page.getTotalElements();
    }

    public PageQueryData(long total,long pageSize,List<T> pageData){
        this.total = total;
        this.pageCount = pageSize;
        this.pageData = pageData;
    }

    public PageQueryData(){
    }

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


    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }
}
