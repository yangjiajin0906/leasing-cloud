package com.leasing.sys.entity.query;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
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
    @QueryCondition(func = MatchType.like)
    private String funcCode;

    @QueryCondition(func = MatchType.like)
    private String funcName;

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

    @Override
    public Specification<DFuncMenuQuery> toSpec() {
        Specification<DFuncMenuQuery> spec = super.toSpecWithAnd();
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            predicatesList.add(spec.toPredicate(root, criteriaQuery, criteriaBuilder));
//            if (projectCode != null) {
//                predicatesList.add(
//                        criteriaBuilder.like(
//                                root.get("projectCode"),"%"+projectCode+"%"));
//            }
            return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
        });
    }
}