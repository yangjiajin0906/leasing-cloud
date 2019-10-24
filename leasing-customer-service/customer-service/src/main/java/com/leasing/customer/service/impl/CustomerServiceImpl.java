package com.leasing.customer.service.impl;

import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.repository.CustomerRepository;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

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

    @Override
    @Transactional
    public void deleteByPkCustomer(String pkCustomer) {
        customerRepository.deleteById(pkCustomer);
    }

    /**
     * 根据客户主键修改客户状态
     *
     * @param newBillstatus 客户新状态
     * @param pkCustomer    客户主键
     */
    @Override
    @Transactional
    public void updateBillStatus(Short newBillstatus, String pkCustomer) {
        CustomerDO customerDO = customerRepository.findOne(pkCustomer);
        customerDO.setBillstatus(newBillstatus);
        this.save(customerDO);
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    @Transactional
    public void save(CustomerVO vo) {
        //todo vo转do
        save(new CustomerDO());
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    @Transactional
    public void save(CustomerCorpAllVO vo) {

        //todo 将单位客户信息拆分出来保存到yls_customer表中
        save(new CustomerDO());
    }

    /**
     * 校验客户名称是否重复
     * @param customerName 客户名称
     * @return int
     */
    @Override
    public int countCustomerName(String customerName) {
        return customerRepository.countCustomerName(customerName);
    }

    /**
     * 校验客户证件号码是否重复
     * @param identityNo 客户证件号
     * @return int
     */
    @Override
    public int countIdentityNo(String identityNo) {
        return customerRepository.countIdentityNo(identityNo);
    }

    /**
     * 保存或修改客户信息
     *
     * @param customerDO 客户信息
     */
    @Transactional
    @Override
    public void save(CustomerDO customerDO) {
        customerRepository.save(customerDO);
    }
}