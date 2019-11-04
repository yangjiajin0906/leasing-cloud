package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.dao.repository.CustContactRepo;
import com.leasing.customer.dao.vo.CustContactVO;
import com.leasing.customer.service.CustContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人服务接口实现
 **/
@Service("customer.CustContactService")
public class CustContactServiceImpl implements CustContactService {
    @Resource
    private CustContactRepo repo;

    @Override
    public PageQueryData<CustContactVO> pageQuery(Pagination pagination, CustContactQuery query) {
        query = new CustContactQuery();
        query.setPkCustomer("0001MG00000000030104");
        return repo.pageQuery(pagination, query, "CustContactPageQuery");
    }
}