package com.leasing.customer.service;

import com.leasing.customer.dao.dos.CustRelatedCompanyDO;
import com.leasing.customer.dao.dos.CustomerRelationDO;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public interface CustomerRelationService {

    /**
     * 根据关联子表主键删除
     *
     * @param pkCustSubTable 关联子表主键
     */
    void deleteByPkCustSubTable(String pkCustSubTable);

    /**
     * 保存
     *
     * @param relationDO 对象
     */
    void save(CustomerRelationDO relationDO);
}