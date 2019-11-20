package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.ContractHandsQuery;
import com.leasing.customer.dao.repository.ContractHandsRepo;
import com.leasing.customer.dao.vo.ContractHandsVO;
import com.leasing.customer.service.ContractHandsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 在手合同服务接口实现类
 **/
@Service("customer.ContractHandsService")
public class ContractHandsServiceImpl implements ContractHandsService {
    @Resource
    private ContractHandsRepo repo;

    @Override
    public PageQueryData<ContractHandsVO> queryPage(Pagination pagination, ContractHandsQuery query) {
        return repo.pageQuery(pagination, query, "contractHandsPageQuery");
    }
}