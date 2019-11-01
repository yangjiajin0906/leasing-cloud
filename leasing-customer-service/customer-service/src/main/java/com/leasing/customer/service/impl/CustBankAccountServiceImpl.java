package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustBankAccountQuery;
import com.leasing.customer.dao.repository.CustBankAccountRepo;
import com.leasing.customer.dao.vo.CustBankAccountVO;
import com.leasing.customer.service.CustBankAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 客户银行账户服务接口实现类
 **/
@Service("customer.CustBankAccountService")
public class CustBankAccountServiceImpl implements CustBankAccountService {
    @Resource
    private CustBankAccountRepo repo;

    @Override
    public PageQueryData<CustBankAccountVO> pageQuery(Pagination pagination, CustBankAccountQuery query) {

        return repo.pageQuery(pagination, query, "custBankAccountPageQuery");
    }
}