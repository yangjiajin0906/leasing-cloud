package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerAuthDO;
import com.leasing.customer.dao.query.CustomerAuthQuery;
import com.leasing.customer.dao.vo.CustomerAuthVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限
 **/
@Repository("customer.CustomerAuthRepo")
public interface CustomerAuthRepo extends BaseRepository<CustomerAuthDO, CustomerAuthQuery, CustomerAuthVO, String> {

}