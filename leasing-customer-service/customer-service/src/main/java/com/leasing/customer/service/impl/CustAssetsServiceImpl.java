package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustAssetsQuery;
import com.leasing.customer.dao.repository.CustAssetsRepo;
import com.leasing.customer.dao.vo.CustAssetsVO;
import com.leasing.customer.service.CustAssetsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 客户资产服务接口实现类
 **/
@Service("customer.CustAssetsService")
public class CustAssetsServiceImpl implements CustAssetsService {
    @Resource
    private CustAssetsRepo repo;

    @Override
    public PageQueryData<CustAssetsVO> pageQuery(Pagination pagination, CustAssetsQuery query) {
        return repo.pageQuery(pagination, query, "custAssetsPageQuery");
    }
}