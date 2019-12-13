package com.leasing.communication.entity.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:2c 月末计提查询VO
 **/
public class AccruedQuery extends BaseQuery {
    /**
     * 机构
     */
    @QueryCondition(func = MatchType.equal,field = "pk_org")
    public String pkOrg;

    /**
     * 计提月份
     */
    @QueryCondition(func = MatchType.equal,field = "accrual_month")
    public String accrualMonth;

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getAccrualMonth() {
        return accrualMonth;
    }

    public void setAccrualMonth(String accrualMonth) {
        this.accrualMonth = accrualMonth;
    }
}