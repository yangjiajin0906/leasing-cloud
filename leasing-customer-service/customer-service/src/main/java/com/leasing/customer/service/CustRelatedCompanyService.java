package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
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

    void deleteByCustomer(String pkCustomer);

    /**
     * 根据客户主键/关系类型/高管人员类别 删除
     *
     * @param pkCustomer    客户主键
     * @param billtype      关系类型
     * @param executiveType 高管人员类别
     */
    void batchDelete(String pkCustomer, Short billtype, Short executiveType);

    /**
     * 根据客户主键/关系类型/高管人员类别 删除
     *
     * @param pkCustomer 客户主键
     * @param billtype   关系类型
     */
    void batchDelete(String pkCustomer, Short billtype);


    void deleteByCustomer(List<CustomerVO> customerVO);

    List<CustRelatedCompanyVO> getCustRelatedCompany(String pkCustomer, Short billtype);

    /**
     * @param pkCustomer    客户主键
     * @param billtype      人员类别
     * @param executiveType 高管类别
     * @return
     */
    List<CustRelatedCompanyVO> getCustRelatedCompany(String pkCustomer, Short billtype, Short executiveType);

    /**
     * 根据主键查询
     *
     * @param pk 主键
     * @return CustRelatedCompanyDO
     */
    CustRelatedCompanyDO findById(String pk);


    /**
     * 根据客户主键查询高管信息
     *
     * @param pkCustomer 客户主键
     * @return 高管列表
     */
    List<CustRelatedCompanyVO> findByPkCustomer(String pkCustomer);
}