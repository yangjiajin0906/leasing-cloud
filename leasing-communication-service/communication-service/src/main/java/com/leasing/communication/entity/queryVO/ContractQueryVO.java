package com.leasing.communication.entity.queryVO;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class ContractQueryVO extends BaseQuery {

    /**
     * 合同编号
     */
    @QueryCondition(func = MatchType.like,field = "contCode")
    public String contCode;

    /**
     * 客户名称
     */
    @QueryCondition(func = MatchType.like,field = "customerName")
    public String customerName;

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
