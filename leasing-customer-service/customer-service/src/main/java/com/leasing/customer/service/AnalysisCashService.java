package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.AnalysisCashQuery;
import com.leasing.customer.dao.vo.AnalysisCashVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public interface AnalysisCashService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<AnalysisCashVO> pageQuery(Pagination pagination, AnalysisCashQuery query);
}