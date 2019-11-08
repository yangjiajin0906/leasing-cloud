package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerPersonDO;
import com.leasing.customer.dao.query.CustomerPersonQuery;
import com.leasing.customer.dao.vo.CustomerPersonVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("customer.CustomerPersonRepo")
public interface CustomerPersonRepo extends BaseRepository<CustomerPersonDO, CustomerPersonQuery, CustomerPersonVO, String> {
}