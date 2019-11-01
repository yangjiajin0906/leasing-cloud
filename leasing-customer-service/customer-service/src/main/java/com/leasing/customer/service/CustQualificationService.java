package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustQualificationQuery;
import com.leasing.customer.dao.vo.CustQualificationVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 资质认证服务接口
 **/
public interface CustQualificationService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustQualificationVO> pageQuery(Pagination pagination, CustQualificationQuery query);
}