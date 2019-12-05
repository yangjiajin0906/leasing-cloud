package com.leasing.common.entity.common.query;

import com.leasing.common.base.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.base.MatchType;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/24
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class DFuncMenuQuery extends BaseQuery {
    @QueryCondition(func = MatchType.like,field = "s.funcCode")
    private String funcCode;

    @QueryCondition(func = MatchType.like,field = "s.funcName")
    private String funcName;

    @QueryCondition(field = "s.pkSystem")
    private SystemVO pkSystem;

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public SystemVO getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(SystemVO pkSystem) {
        this.pkSystem = pkSystem;
    }
}