package com.leasing.communication.entity.queryVO;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class InvoiceQueryVO extends BaseQuery {

    /**
     * 合同编号
     */
    @QueryCondition(func = MatchType.like,field = "contCode")
    public String contCode;


    /**
     * 合同名称
     */
    @QueryCondition(func = MatchType.like,field = "contName")
    public String contName;


    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }
}
