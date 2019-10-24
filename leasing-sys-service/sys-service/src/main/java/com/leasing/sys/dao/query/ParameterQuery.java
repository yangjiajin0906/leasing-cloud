package com.leasing.sys.dao.query;

import com.leasing.common.base.annotation.YlQuery;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.enums.QueryEnum;
import org.springframework.data.jpa.domain.Specification;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:lvcna@yonyou.com
 * @description: 枚举类型查询
 **/
public class ParameterQuery extends BaseQuery {


    @YlQuery
    public String paramCode;

    @YlQuery(logic = QueryEnum.LIKE)
    public String paramName;


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

    @Override
    public Specification toSpec() {
        return null;
    }
}
