package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerRelationDO;
import com.leasing.customer.dao.query.CustomerRelationQuery;
import com.leasing.customer.dao.vo.CustomerRelationVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("customer.CustomerRelationRepo")
public interface CustomerRelationRepo extends BaseRepository<CustomerRelationDO, CustomerRelationQuery, CustomerRelationVO, String> {


    /**
     * 根据关联子表主键删除
     * @param pkCustChildTable 关联子表主键
     */
    void deleteByPkCustChildTable(String pkCustChildTable);
}