package com.leasing.customer.service.impl;

import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.dao.repository.CustomerRepository;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务服务接口实现类
 **/
@Service("customer.CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    /**
     * 根据客户主键修改客户状态
     *
     * @param newBillstatus 客户新状态
     * @param pkCustomer    客户主键
     */
    @Override
    public void updateBillStatus(Short newBillstatus, String pkCustomer) {
        CustomerDO customerDO = customerRepository.findOne(pkCustomer);
        customerDO.setBillstatus(newBillstatus);
        this.saveOrUpdate(customerDO);
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    public void saveOrUpdate(CustomerVO vo) {
        //todo vo转do
        saveOrUpdate(new CustomerDO());
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    public void saveOrUpdate(CustomerCorpAllVO vo) {

        //todo 将单位客户信息拆分出来保存到yls_customer表中
        saveOrUpdate(new CustomerDO());
    }

    /**
     * 保存或修改客户信息
     *
     * @param customerDO 客户信息
     */
    private void saveOrUpdate(CustomerDO customerDO) {
        customerRepository.save(customerDO);
    }
}