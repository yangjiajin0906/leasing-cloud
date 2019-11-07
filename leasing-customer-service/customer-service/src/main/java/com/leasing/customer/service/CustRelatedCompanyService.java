package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.dao.vo.CustomerVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源服务接口
 **/
public interface CustRelatedCompanyService {

    /**
     * 客户来源分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */
    PageQueryData<CustRelatedCompanyVO> pageQuery(Pagination pagination, CustRelatedCompanyQuery query);

    /**
     * 客户来源保存
     *
     * @param vo 客户来源 com.leasing.customer.dao.vo.CustRelatedCompanyVO
     */
    void save(CustRelatedCompanyVO vo);


    /**
     * 保存
     *
     * @param custRelatedCompanyDO com.leasing.customer.dao.dos.CustRelatedCompanyDO
     */
    void save(CustRelatedCompanyDO custRelatedCompanyDO);

    void deleteByCustomer(CustomerVO customerVO);


    void deleteByCustomer(List<CustomerVO> customerVO);


}