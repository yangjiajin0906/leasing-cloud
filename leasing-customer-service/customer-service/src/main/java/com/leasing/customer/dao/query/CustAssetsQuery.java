package com.leasing.customer.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public class CustAssetsQuery extends BaseQuery {

    @QueryCondition(field = "a.pkCustomer.pkCustomer")
    private String pkCustomer;

    /**
     * 资产类型
     */
    @QueryCondition
    private Short assetsType;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(Short assetsType) {
        this.assetsType = assetsType;
    }
}