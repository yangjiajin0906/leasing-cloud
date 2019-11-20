package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.IndexAnalysisQuery;
import com.leasing.customer.dao.vo.IndexAnalysisVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 指标分析服务接口
 **/
public interface IndexAnalysisService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<IndexAnalysisVO> pageQuery(Pagination pagination, IndexAnalysisQuery query);
}