package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustExternalFinanceQuery;
import com.leasing.customer.dao.repository.CustExternalFinanceRepo;
import com.leasing.customer.dao.vo.CustExternalFinanceVO;
import com.leasing.customer.service.CustExternalFinanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 其他融资服务接口实现类
 **/
@Service("customer.CustExternalFinanceService")
public class CustExternalFinanceServiceImpl implements CustExternalFinanceService {
    @Resource
    private CustExternalFinanceRepo repo;

    @Override
    public PageQueryData<CustExternalFinanceVO> pageQuery(Pagination pagination, CustExternalFinanceQuery query) {
        return repo.pageQuery(pagination, query, "custExternalFinancePageQuery");
    }
}