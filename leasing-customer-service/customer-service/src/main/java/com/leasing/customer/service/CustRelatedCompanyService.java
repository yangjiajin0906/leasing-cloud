package com.leasing.customer.service;

import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
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

    /**
     * 根据客户查询 客户来源
     *
     * @param customerVO 客户对象
     * @return 客户来源列表
     */
    List<CustRelatedCompanyVO> findByCustomer(CustomerVO customerVO);

    /**
     * 查询客户的客户来源
     *
     * @param pkCustomer 客户主键
     * @return 客户来源列表
     */
    List<CustRelatedCompanyVO> findByCustomer(String pkCustomer);

    List<CustRelatedCompanyVO> findByCustomer(CustomerDTO customerDTO);


    void deleteByCustomer(CustomerVO customerVO);


    void deleteByCustomer(List<CustomerVO> customerVO);




}