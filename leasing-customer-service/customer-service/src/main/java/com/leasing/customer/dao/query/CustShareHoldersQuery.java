package com.leasing.customer.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import org.springframework.data.jpa.domain.Specification;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description: 股权情况查询条件
 **/
public class CustShareHoldersQuery extends BaseQuery {

    @QueryCondition(field = "a.pkCustomer.pkCustomer")
    private String pkCustomer;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }
}