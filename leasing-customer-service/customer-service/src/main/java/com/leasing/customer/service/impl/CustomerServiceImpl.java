package com.leasing.customer.service.impl;

import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.repository.CustomerRepo;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务服务接口实现类
 **/
@Service("customer.CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepo customerRepo;

    @Override

    public void deleteByPkCustomer(String pkCustomer) {
        customerRepo.deleteById(pkCustomer);
    }

    @Override
    public void batchDelete(List<String> pks) {

        customerRepo.batchDeleteByPks(pks);
    }

    /**
     * 根据客户主键修改客户状态
     *
     * @param newBillstatus 客户新状态
     * @param pkCustomer    客户主键
     */
    @Override
    public void updateBillStatus(Short newBillstatus, String pkCustomer) {
        CustomerDO customerDO = customerRepo.findOne(pkCustomer);
        customerDO.setBillstatus(newBillstatus);
        this.save(customerDO);
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    public void save(CustomerVO vo) {
        //todo vo转do
        save(new CustomerDO());
    }

    /**
     * 校验客户名称是否重复
     * @param customerName 客户名称
     * @return int
     */
    @Override
    public int countCustomerName(String customerName) {
        return customerRepo.countCustomerName(customerName);
    }

    /**
     * 校验客户证件号码是否重复
     * @param identityNo 客户证件号
     * @return int
     */
    @Override
    public int countIdentityNo(String identityNo) {
        return customerRepo.countIdentityNo(identityNo);
    }

    /**
     * 保存或修改客户信息
     *
     * @param customerDO 客户信息
     */
    @Transactional
    @Override
    public void save(CustomerDO customerDO) {
        customerRepo.save(customerDO);
    }
}