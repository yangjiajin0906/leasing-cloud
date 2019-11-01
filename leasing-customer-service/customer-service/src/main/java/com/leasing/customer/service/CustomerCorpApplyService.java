package com.leasing.customer.service;

import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-01
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public interface CustomerCorpApplyService {


    String checkUnique(CustomerCorpAllVO vo);

    /**
     * 通过客户名查询冻结单位客户
     * @param customerName 客户名称
     * @return CustomerVO
     */
    CustomerVO queryCustomerStatusByName(String customerName);
}