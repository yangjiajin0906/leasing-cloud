package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustUpdownQuery;
import com.leasing.customer.dao.repository.CustUpdownRepo;
import com.leasing.customer.dao.vo.CustUpdownVO;
import com.leasing.customer.service.CustUpdownService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 上下游客户服务接口实现类
 **/
@Service("customer.CustUpdownService")
public class CustUpdownServiceImpl implements CustUpdownService {
    @Resource
    private CustUpdownRepo repo;

    @Override
    public PageQueryData<CustUpdownVO> pageQuery(Pagination pagination, CustUpdownQuery query) {
        return repo.pageQuery(pagination, query, "custUpdownPageQuery");
    }
}