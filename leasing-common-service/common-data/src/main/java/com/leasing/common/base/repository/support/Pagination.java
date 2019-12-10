package com.leasing.common.base.repository.support;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:lvcna@yonyou.com
 * @description: 分页实体类
 **/
public class Pagination<T> implements Serializable {

    /**
     * 分页构造方法
     * JPA分页从0开始，默认当前页 - 1;
     * @param pageIndex
     * @param pageSize
     */
    public Pagination(int pageIndex,int pageSize){
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
    public Pagination(){

    }

    /**
     * Pagination对象转换为Pageable对象
     * @return Pageable
     */
    public Pageable toPageable(){
        return PageRequest.of(this.pageIndex > 0 ?
                this.pageIndex - 1 : 0, this.pageSize);
    }

    private int pageIndex;

    private int pageSize;

    private int pageCount;

    private int total;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 获取分页开始记录数
     * @return
     */
    public int getFirstResult(){
        int pageIndex = this.getPageIndex()> 0 ? this.getPageIndex() - 1 : 0;
        int pageSize = this.getPageSize();
        return pageIndex * pageSize;
    }
}
