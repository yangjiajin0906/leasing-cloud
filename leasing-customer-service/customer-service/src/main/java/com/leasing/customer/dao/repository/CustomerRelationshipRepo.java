package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerRelationshipDO;
import com.leasing.customer.dao.query.CustomerRelationshipQuery;
import com.leasing.customer.dao.vo.CustomerRelationshipVO;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public interface CustomerRelationshipRepo extends BaseRepository<CustomerRelationshipDO, CustomerRelationshipQuery,
        CustomerRelationshipVO, String> {


}