package com.leasing.customer_service.service.impl;

import com.leasing.customer_service.pojo.CustomerVO;
import com.leasing.customer_service.repository.CustomerRepository;
import com.leasing.customer_service.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @project:leasing-cloud
 * @date:2019-09-24
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerVO> getList(CustomerVO customerVO) {

        return  customerRepository.findAll(customerVO.toSpec(),customerVO.toPageable()).getContent();
    }

    @Override
    public CustomerVO queryByPK(String pk) {
        return customerRepository.findByPkCustomer(pk);
//        return null;
    }

}