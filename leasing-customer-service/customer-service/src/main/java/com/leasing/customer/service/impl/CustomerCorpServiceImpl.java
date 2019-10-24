package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.DozerUtils;
import com.leasing.common.utils.ResultUtils;
import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.repository.CustomerCorpRepository;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.service.CustomerCorpService;
import com.leasing.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
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
    @Resource
    private CustomerService customerService;


    @Override
    @Transactional
    public ResResult delete(String pkCustomer) {
        //逻辑删除
        // 1.根据客户名称查询客户信息（List）
        // 2.删除关联表

        // 3.删除表中数据


//        customerCorpRepository.deleteB(pkCustomer);
//        customerService.deleteByPkCustomer(pkCustomer);
        return ResultUtils.successWithData(pkCustomer);
    }

    @Override
    public CustomerCorpAllVO findOneAllByPkCustomer(String pkCustomer) {
        return customerCorpRepository.findOneAllByPkCustomer(pkCustomer);
    }

    @Override
    public CustomerCorpAllVO findOneAllByCustomerName(String customerName) {
        return customerCorpRepository.findOneAllByCustomerName(customerName);
    }

    @Override
    public List<CustomerCorpAllVO> findListByConditions(Map<String, Object> conditions) {

        return null;
    }

    @Override
    public List<CustomerCorpAllVO> pageQuery(Pagination pagination, CustomerCorpQuery query) {
        String JPQL = "select b from CustomerCorpAllVO b where b.ifNew = 0 ";
        return customerCorpRepository.pageQuery(pagination,query, JPQL);
    }

    @Override
    @Transactional
    public void save(CustomerCorpAllVO vo) {

        CustomerCorpDO corpDO = DozerUtils.convert(vo,CustomerCorpDO.class);
        CustomerDO customerDO = DozerUtils.convert(vo, CustomerDO.class);
        customerDO.setPkCustomer("customerDO");
        customerDO.setBillstatus(Short.valueOf("204")
        );
        customerService.save(customerDO);
        corpDO.setPkCustomer(customerDO.getPkCustomer());
        this.saveOrUpdate(corpDO);
    }

    @Override
    @Transactional
    public void updateBillStatus(String billstatus, String pkCustomer) {

    }

    @Override
    public ResResult validateCustomerName(String customerName) {
        return ResultUtils.successWithData(customerService.countCustomerName(customerName));
    }


    @Override
    public ResResult validateIdentityNo(String identityNo) {
        return ResultUtils.successWithData(customerService.countIdentityNo(identityNo));
    }

    @Transactional
    void saveOrUpdate(CustomerCorpDO customerCorpDO){
        customerCorpRepository.save(customerCorpDO);
    }
}