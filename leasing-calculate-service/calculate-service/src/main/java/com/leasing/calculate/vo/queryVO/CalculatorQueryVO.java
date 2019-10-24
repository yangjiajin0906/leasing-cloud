package com.leasing.calculate.vo.queryVO;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class CalculatorQueryVO extends BaseQuery {

    /**
     * 测算方案编号
     */
    @QueryCondition(func = MatchType.equal)
    public String quotCode;

    /**
     * 测算方案名称
     */
    @QueryCondition(func = MatchType.like)
    public String quotName;

    /**
     * 设备总金额
     */
    @QueryCondition(func = MatchType.gt)
    public BigDecimal totalAmountEquipment;

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public BigDecimal getTotalAmountEquipment() {
        return totalAmountEquipment;
    }

    public void setTotalAmountEquipment(BigDecimal totalAmountEquipment) {
        this.totalAmountEquipment = totalAmountEquipment;
    }

    @Override
    public Specification<CalculatorQueryVO> toSpec() {
        Specification<CalculatorQueryVO> spec = super.toSpecWithAnd();
        return ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicatesList = new ArrayList<>();
            predicatesList.add(spec.toPredicate(root, criteriaQuery, criteriaBuilder));
//            if (projectCode != null) {
//                predicatesList.add(
//                        criteriaBuilder.like(
//                                root.get("projectCode"),"%"+projectCode+"%"));
//            }
//            if (projectName != null) {
//                predicatesList.add(
//                        criteriaBuilder.like(
//                                root.get("projectName"),"%"+projectName+"%") );
//            }
            return criteriaBuilder.and(predicatesList.toArray(new Predicate[predicatesList.size()]));
        });
    }
}