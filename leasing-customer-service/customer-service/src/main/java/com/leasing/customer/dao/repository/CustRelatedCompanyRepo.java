package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.query.CustRelatedCompanyQuery;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源
 **/
@Repository
public interface CustRelatedCompanyRepo extends BaseRepository<CustRelatedCompanyDO, CustRelatedCompanyQuery, CustRelatedCompanyVO,String> {


    @Query(name = "CustomerCorpVO.querySourceByPkCustomer")
    List<CustRelatedCompanyVO> querySourceByPkCustomer(@Param("pkCustomer") CustomerDTO pkCustomer);

}