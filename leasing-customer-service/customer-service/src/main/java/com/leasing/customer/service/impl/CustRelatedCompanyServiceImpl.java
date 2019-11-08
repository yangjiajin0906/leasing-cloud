package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.repository.CustRelatedCompanyRepo;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustRelatedCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustRelatedCompanyServiceImpl")
@Transactional
public class CustRelatedCompanyServiceImpl implements CustRelatedCompanyService {

    @Resource
    private CustRelatedCompanyRepo repo;

    @Override
    public PageQueryData<CustRelatedCompanyVO> pageQuery(Pagination pagination, CustRelatedCompanyQuery query) {
        return repo.pageQuery(pagination, query, "custSourcePageQuery");
    }

    @Override
    public void save(CustRelatedCompanyVO vo) {
        save(DozerUtils.convert(vo, CustRelatedCompanyDO.class));
    }

    @Override
    public void save(CustRelatedCompanyDO custRelatedCompanyDO) {
        repo.save(custRelatedCompanyDO);
    }

    @Override
    public void deleteByCustomer(String pkCustomer) {
        repo.batchDelete(pkCustomer);
    }

    @Override
    public void batchDelete(String pkCustomer, Short biitype, Short executiveType) {
        repo.batchDelete(pkCustomer, biitype, executiveType);
    }

    @Override
    public void batchDelete(String pkCustomer, Short billtype) {
        repo.batchDelete(pkCustomer, billtype);
    }

    @Override
    public void deleteByCustomer(List<CustomerVO> customerVO) {

    }

    @Override
    public List<CustRelatedCompanyVO> getCustRelatedCompany(String pkCustomer, Short billTyp) {
        CustomerDTO dto = new CustomerDTO(pkCustomer);
        return repo.getCustRelatedCompany(dto, billTyp);
    }

    @Override
    public List<CustRelatedCompanyVO> getCustRelatedCompany(String pkCustomer, Short billTyp, Short executiveType) {
        CustomerDTO dto = new CustomerDTO(pkCustomer);
        return repo.getCustRelatedCompany(dto, billTyp, executiveType);
    }

    @Override
    public CustRelatedCompanyDO findById(String pk) {
        return repo.findOne(pk);
    }

    @Override
    public List<CustRelatedCompanyVO> findByPkCustomer(String pkCustomer) {
        CustomerDTO dto = new CustomerDTO(pkCustomer);
        return repo.getCustRelatedCompany(dto);
    }
}