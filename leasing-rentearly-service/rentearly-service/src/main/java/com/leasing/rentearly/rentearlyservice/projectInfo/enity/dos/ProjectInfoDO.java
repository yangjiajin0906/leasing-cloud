package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos;

import com.leasing.common.annotation.QueryCondition;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.enums.MatchType;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_project_info")
public class ProjectInfoDO extends BaseDO {

    @Id
    private String pkProjectInfo;

    @QueryCondition(func= MatchType.like)
    private String projectCode;

    @QueryCondition(func= MatchType.like)
    private String projectName;

    private String pkProjectApproval;

    @Transient
    @OneToMany(mappedBy = "thingType",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ProjectApprovalDO> itemList;

    public List<ProjectApprovalDO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ProjectApprovalDO> itemList) {
        this.itemList = itemList;
    }

    public String getPkProjectInfo() {
        return pkProjectInfo;
    }

    public void setPkProjectInfo(String pkProjectInfo) {
        this.pkProjectInfo = pkProjectInfo;
    }

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

    public String getPkProjectApproval() {
        return pkProjectApproval;
    }

    public void setPkProjectApproval(String pkProjectApproval) {
        this.pkProjectApproval = pkProjectApproval;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }

    public Specification<ProjectInfoDO> toSpec() {

        Specification<ProjectInfoDO> spec = super.toSpecWithAnd();
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
