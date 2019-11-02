package com.leasing.customer.service;

import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务接口
 **/
public interface CustomerService {


    void deleteByPkCustomer(String pkCustomer);

    void batchDelete(List<String> pks);

    List<CustomerVO> queryCustomerStatusByName(String customerName, Short CustomerStatus, Short CustomerType);


    /**
     * 修改客户信息
     *
     * @param vo 客户修改成vo
     */
    void save(CustomerVO vo);

    void save(CustomerDO customerDO);


    /**
     * 客户名称数量
     *
     * @param customerName 客户名称
     * @return int
     */
    int countCustomerName(String customerName);

    /**
     * 证件号码数量
     *
     * @param identityNo 客户证件号
     * @return int
     */
    int countIdentityNo(String identityNo);

}