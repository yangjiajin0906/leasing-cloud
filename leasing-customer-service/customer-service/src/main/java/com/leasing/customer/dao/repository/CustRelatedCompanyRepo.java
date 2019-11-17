package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源
 **/
@Repository
public interface CustRelatedCompanyRepo extends BaseRepository<CustRelatedCompanyDO,
        CustRelatedCompanyQuery, CustRelatedCompanyVO, String>, JpaRepository<CustRelatedCompanyDO, String> {

    // 通过客户主键、联系人类型、高管人员类别删除
    @Modifying
    @Transactional
    @Query(value = "delete from CustRelatedCompanyDO a where a.pkCustomer =:pkCustomer and a.billtype =:billtype " +
            " and a.executiveType = :executiveType")
    void batchDelete(@Param("pkCustomer") String pkCustomer, @Param("billtype") Short billtype,
                  @Param("executiveType") Short executiveType);

    // 通过客户主键、联系人类型删除
    @Modifying
    @Transactional
    @Query(value = "delete from CustRelatedCompanyDO a where a.pkCustomer =:pkCustomer and a.billtype =:billtype ")
    void batchDelete(@Param("pkCustomer") String pkCustomer, @Param("billtype") Short billtype);

    @Modifying
    @Transactional
    @Query(value = "delete from CustRelatedCompanyDO a where a.pkCustomer =:pkCustomer ")
    void batchDelete(@Param("pkCustomer") String pkCustomer);

//    void deleteByPkCustomerInAndAndBilltypeAndExecutiveType(List<CustRelatedCompanyDO>)
    @Modifying
    @Transactional
    @Query(value = "delete from CustRelatedCompanyDO a where a.pkCustomer in (:pkCustomers)")
    void batchDelete(@Param("pkCustomers") List<String> pkCustomers);


    @Query(value = "select b.pkCustRelatedCompany, b.pkCustomer from CustRelatedCompanyVO b" +
            " where b.pkCustomer=:pkCustomer and b.billtype =:billtype")
    List<CustRelatedCompanyVO> getCustRelatedCompany(@Param("pkCustomer") CustomerDTO pkCustomer, @Param("billtype") Short billtype);

    @Query(value = "select b.pkCustRelatedCompany, b.pkCustomer from CustRelatedCompanyVO b " +
            "where b.pkCustomer=:pkCustomer and b.billtype =:billtype and b.executiveType =:executiveType")
    List<CustRelatedCompanyVO> getCustRelatedCompany(@Param("pkCustomer") CustomerDTO pkCustomer, @Param("billtype") Short billtype,
                               @Param("executiveType") Short executiveType);

    @Query(value = " select  b from CustRelatedCompanyVO b where b.pkCustomer =: pkCustomer")
    List<CustRelatedCompanyVO> getCustRelatedCompany(@Param("pkCustomer") CustomerDTO pkCustomer);




}