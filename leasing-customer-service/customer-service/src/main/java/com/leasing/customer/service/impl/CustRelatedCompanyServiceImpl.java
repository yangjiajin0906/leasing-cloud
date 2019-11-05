package com.leasing.customer.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.enums.constant.PubEnumsConstant;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.repository.CustRelatedCompanyRepo;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.dao.vo.CustomerVO;
import com.leasing.customer.service.CustRelatedCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustRelatedCompanyServiceImpl")
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
    public void deleteByCustomer(CustomerVO customerVO) {

    }

    @Override
    public void deleteForTypes(String pkCustomer, Short BillType, Short executiveType) {
        repo.deleteForType(pkCustomer, PubEnumsConstant.RELATION_EXECUTIVE, PubEnumsConstant.EXECUTIVE_LEGAL);
    }

    @Override
    public void deleteByCustomer(List<CustomerVO> customerVO) {

    }

    @Override
    public List<Map> getCustRelatedCompany(String pkCustomer, Short billTyp) {
        return repo.getCustRelatedCompany(pkCustomer, billTyp);
    }

    @Override
    public List<Map> getCustRelatedCompany(String pkCustomer, Short billTyp, Short executiveType) {
        return repo.getCustRelatedCompany(pkCustomer, billTyp, executiveType);
    }
}