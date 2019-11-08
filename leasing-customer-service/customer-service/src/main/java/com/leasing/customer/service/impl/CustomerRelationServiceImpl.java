package com.leasing.customer.service.impl;

import com.leasing.customer.dao.dos.CustomerRelationDO;
import com.leasing.customer.dao.repository.CustomerRelationRepo;
import com.leasing.customer.service.CustomerRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustomerRelationService")
public class CustomerRelationServiceImpl implements CustomerRelationService {
    @Resource
    private CustomerRelationRepo relationRepo;

    @Override
    public void deleteByPkCustSubTable(String pkCustSubTable) {
        relationRepo.deleteByPkCustChildTable(pkCustSubTable);
    }

    @Override
    public void save(CustomerRelationDO relationDO) {
        relationRepo.save(relationDO);
    }
}