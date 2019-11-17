package com.leasing.customer.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019-11-07
 * @author:zhangzhhn@yonyou.com
 * @description: 客户权限表
 **/
public class CustomerAuthQuery extends BaseQuery {

    @QueryCondition(field = "a.pkCustomer.pkCustomer")
    private String pkCustomer;


}