package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustAssetsQuery;
import com.leasing.customer.dao.vo.CustAssetsVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 客户资产服务接口
 **/
public interface CustAssetsService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询
     * @return 分页列表
     */
    PageQueryData<CustAssetsVO> pageQuery(Pagination pagination, CustAssetsQuery query);
}