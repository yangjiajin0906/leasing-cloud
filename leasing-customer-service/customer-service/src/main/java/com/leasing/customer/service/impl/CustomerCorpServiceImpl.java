package com.leasing.customer.service.impl;

import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.repository.CustomerCorpRepository;
import com.leasing.customer.service.CustomerCorpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务接口实现类
 **/
@Service("customer.CustomerCorpService")
public class CustomerCorpServiceImpl implements CustomerCorpService {

    @Resource
    private CustomerCorpRepository customerCorpRepository;


    @Override
    public CustomerCorpAllVO findOneAllByPkCustomer(String pkCustomer) {
        return customerCorpRepository.findOneAllByPkCustomer(pkCustomer);
    }

    @Override
    public List<CustomerCorpAllVO> findListByConditions(Map<String, Object> conditions) {
        return null;
    }

    @Override
    public void saveOrUpdate(CustomerCorpAllVO vo) {

    }

    @Override
    public void updateBillStatus(String billstatus, String pkCustomer) {

    }

    private void saveOrUpdate(CustomerCorpDO customerCorpDO){
        customerCorpRepository.save(customerCorpDO);
    }
}