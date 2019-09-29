package com.leasing.customer_service.repository;

import com.leasing.customer_service.pojo.CustomerCorpVO;
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
public interface CustomerCorpRepository extends JpaRepository<CustomerCorpVO,String>, JpaSpecificationExecutor {


}