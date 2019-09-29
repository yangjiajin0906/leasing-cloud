package com.leasing.customer_service.repository;

import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.pojo.CustomerVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository
public interface CustomerRepository extends JpaRepository<CustomerCorpVO,String>, JpaSpecificationExecutor {


    CustomerVO findByPkCustomer(String pk);
}