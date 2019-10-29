package com.leasing.common.base.repository.support;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:lvcna@yonyou.com
 * @description: 分页实体类
 **/
public class Pagination implements Serializable {

    /**
     * 分页构造方法
     * JPA分页从0开始，默认当前页 - 1;
     * @param curPage
     * @param pageSize
     */
    public Pagination(int curPage,int pageSize){
        this.curPage = curPage;
        this.pageSize = pageSize;
    }
    public Pagination(){

    }

    /**
     * Pagination对象转换为Pageable对象
     * @return Pageable
     */
    public Pageable toPageable(){
        return PageRequest.of(this.curPage > 0 ?
                this.curPage - 1 : 0, this.pageSize);
    }

    private int curPage;

    private int pageSize;

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 获取分页开始记录数
     * @return
     */
    public int getFirstResult(){
        int curPage = this.getCurPage()> 0 ? this.getCurPage() - 1 : 0;
        int pageSize = this.getPageSize();
        return curPage * pageSize;
    }
}
