package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
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
        CustRelatedCompanyQuery, CustRelatedCompanyVO, String> {

    // 通过客户主键、联系人类型、高管人员类别删除
    @Modifying
    @Transactional
    @Query(name = "deleteForType")
    void deleteForType(@Param("pkCustomer") String pkCustomer, @Param("billType") Short billType,
                  @Param("executiveType") Short executiveType);

    @Query(name = "getCustRelatedCompany1")
    List<Map> getCustRelatedCompany(@Param("pkCustomer") String pkCustomer, @Param("billType") Short billType);

    @Query(name = "getCustRelatedCompany2")
    List<Map> getCustRelatedCompany(@Param("pkCustomer") String pkCustomer, @Param("billType") Short billType,
                               @Param("executiveType") Short executiveType);





}