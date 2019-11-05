package com.leasing.customer.service.impl;

import com.leasing.common.enums.base.Billstatus;
import com.leasing.common.utils.base.DateUtils;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.repository.CustomerRepo;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
    public CustomerDO findOneByPkCustomer(String pkCustomer) {
        return customerRepo.findOne(pkCustomer);
    }

    @Override
    public void batchDelete(List<String> pks) {

        customerRepo.batchDeleteByPks(pks);
    }

    @Override
    public List<CustomerVO> queryCustomerStatusByName(String customerName, Short customerStatus, Short customerType) {
        return customerRepo.queryCustomerStatusByName(customerName, customerStatus, customerType);
    }

    @Override
    public void effect(CustomerVO vo) {
        vo.setBillstatus(Billstatus.APPROVE.getShort());
        vo.setEffectiveDate(DateUtils.getCurDate());
        this.save(vo);
    }

    /**
     * 保存或修改客户信息
     *
     * @param vo 客户信息
     */
    @Override
    public void save(CustomerVO vo) {
        this.save(DozerUtils.convert(vo, CustomerDO.class));
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