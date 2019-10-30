package com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class ProjectQueryVO extends BaseQuery {
    @QueryCondition(func = MatchType.like)
    private String projectCode;

    @QueryCondition(func = MatchType.like)
    private String projectName;

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


}
