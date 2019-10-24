package com.leasing.sys.dao.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.annotation.YlQuery;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.enums.QueryEnum;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:lvcna@yonyou.com
 * @description: 枚举类型查询
 **/
public class ParamTypeQuery extends BaseQuery {


    @QueryCondition
    public String paramCode;
    @QueryCondition(func = MatchType.like)
    public String paramName;
    @QueryCondition(func = MatchType.like)
    public String paramVarname;

    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamVarname() {
        return paramVarname;
    }

    public void setParamVarname(String paramVarname) {
        this.paramVarname = paramVarname;
    }

    @Override
    public Specification toSpec() {
        return null;
    }
}
