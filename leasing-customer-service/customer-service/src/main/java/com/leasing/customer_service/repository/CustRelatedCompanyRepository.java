package com.leasing.customer_service.repository;

import com.leasing.customer_service.pojo.CustRelatedCompanyVO;
import com.leasing.customer_service.pojo.CustomerCorpVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源
 **/
@Repository
public interface CustRelatedCompanyRepository extends JpaRepository<CustRelatedCompanyVO,String>, JpaSpecificationExecutor {
}