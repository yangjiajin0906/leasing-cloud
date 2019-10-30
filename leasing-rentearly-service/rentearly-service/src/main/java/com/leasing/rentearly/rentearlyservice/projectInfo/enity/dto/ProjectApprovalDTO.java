package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;
import com.leasing.common.vo.foundation.OrgVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 立项参照
 **/
@Entity
@Table(name = "yls_project_approval")
public class ProjectApprovalDTO extends BaseEntity {

    @Id
    public String pkProjectApproval;

    public String projectFilingCode;

    public String projectFilingName;
    /**
     * 项目报备批次
     */
    public Integer projectFilingBatch;
    /**
     * 客户主键
     */
    public String pkConsumer;
    /**
     * 文档规则
     */
    public String projectApprovalRule;
    /**
     * 项目类型
     */
    public Short projectType;

    /**
     * 项目金额
     */
    public BigDecimal releaseAmount;

    /**
     * 地区审批总额
     */
    public BigDecimal areaApproveTotal;
    /**
     * 地区实际投放总额
     */
    public BigDecimal areaLoanTotal;
    /**
     * 地区剩余投放总额
     */
    public BigDecimal areaSurplusTotal;
    /**
     * 地区可用授信额度
     */
    public BigDecimal areaUsableTotal;
    /**
     * 行业审批总额
     */
    public BigDecimal industryApproveTotal;
    /**
     * 行业实际投放总额
     */
    public BigDecimal industryLoanTotal;
    /**
     * 行业剩余投放总额
     */
    public BigDecimal industrySurplusTotal;
    /**
     * 行业可用授信额度
     */
    public BigDecimal industryUsableTotal;

    /**
     * 所属公司
     */
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkProOrg")
    public OrgVO pkProOrg;

//    public ProjectApprovalDTO(String pkProjectApproval,String projectFilingCode,String projectFilingName, Integer projectFilingBatch, String pkConsumer, String projectApprovalRule, Short projectType, BigDecimal releaseAmount, BigDecimal areaApproveTotal, BigDecimal areaLoanTotal, BigDecimal areaSurplusTotal, BigDecimal areaUsableTotal, BigDecimal industryApproveTotal, BigDecimal industryLoanTotal, BigDecimal industrySurplusTotal, BigDecimal industryUsableTotal, OrgVO pkProOrg) {
//        this.pkProjectApproval = pkProjectApproval;
//        this.projectFilingCode = projectFilingCode;
//        this.projectFilingName = projectFilingName;
//        this.projectFilingBatch = projectFilingBatch;
//        this.pkConsumer = pkConsumer;
//        this.projectApprovalRule = projectApprovalRule;
//        this.projectType = projectType;
//        this.releaseAmount = releaseAmount;
//        this.areaApproveTotal = areaApproveTotal;
//        this.areaLoanTotal = areaLoanTotal;
//        this.areaSurplusTotal = areaSurplusTotal;
//        this.areaUsableTotal = areaUsableTotal;
//        this.industryApproveTotal = industryApproveTotal;
//        this.industryLoanTotal = industryLoanTotal;
//        this.industrySurplusTotal = industrySurplusTotal;
//        this.industryUsableTotal = industryUsableTotal;
//        this.pkProOrg = pkProOrg;
//        this.setCode(projectFilingCode);
//        this.setName(projectFilingName);
//        this.setPk(pkProjectApproval);
//    }

    public String getPkProjectApproval() {
        return pkProjectApproval;
    }

    public void setPkProjectApproval(String pkProjectApproval) {
        this.pkProjectApproval = pkProjectApproval;
    }

    public String getProjectFilingCode() {
        return projectFilingCode;
    }

    public void setProjectFilingCode(String projectFilingCode) {
        this.projectFilingCode = projectFilingCode;
    }

    public String getProjectFilingName() {
        return projectFilingName;
    }

    public void setProjectFilingName(String projectFilingName) {
        this.projectFilingName = projectFilingName;
    }

    public Integer getProjectFilingBatch() {
        return projectFilingBatch;
    }

    public void setProjectFilingBatch(Integer projectFilingBatch) {
        this.projectFilingBatch = projectFilingBatch;
    }

    public String getPkConsumer() {
        return pkConsumer;
    }

    public void setPkConsumer(String pkConsumer) {
        this.pkConsumer = pkConsumer;
    }

    public String getProjectApprovalRule() {
        return projectApprovalRule;
    }

    public void setProjectApprovalRule(String projectApprovalRule) {
        this.projectApprovalRule = projectApprovalRule;
    }

    public Short getProjectType() {
        return projectType;
    }

    public void setProjectType(Short projectType) {
        this.projectType = projectType;
    }

    public BigDecimal getReleaseAmount() {
        return releaseAmount;
    }

    public void setReleaseAmount(BigDecimal releaseAmount) {
        this.releaseAmount = releaseAmount;
    }

    public BigDecimal getAreaApproveTotal() {
        return areaApproveTotal;
    }

    public void setAreaApproveTotal(BigDecimal areaApproveTotal) {
        this.areaApproveTotal = areaApproveTotal;
    }

    public BigDecimal getAreaLoanTotal() {
        return areaLoanTotal;
    }

    public void setAreaLoanTotal(BigDecimal areaLoanTotal) {
        this.areaLoanTotal = areaLoanTotal;
    }

    public BigDecimal getAreaSurplusTotal() {
        return areaSurplusTotal;
    }

    public void setAreaSurplusTotal(BigDecimal areaSurplusTotal) {
        this.areaSurplusTotal = areaSurplusTotal;
    }

    public BigDecimal getAreaUsableTotal() {
        return areaUsableTotal;
    }

    public void setAreaUsableTotal(BigDecimal areaUsableTotal) {
        this.areaUsableTotal = areaUsableTotal;
    }

    public BigDecimal getIndustryApproveTotal() {
        return industryApproveTotal;
    }

    public void setIndustryApproveTotal(BigDecimal industryApproveTotal) {
        this.industryApproveTotal = industryApproveTotal;
    }

    public BigDecimal getIndustryLoanTotal() {
        return industryLoanTotal;
    }

    public void setIndustryLoanTotal(BigDecimal industryLoanTotal) {
        this.industryLoanTotal = industryLoanTotal;
    }

    public BigDecimal getIndustrySurplusTotal() {
        return industrySurplusTotal;
    }

    public void setIndustrySurplusTotal(BigDecimal industrySurplusTotal) {
        this.industrySurplusTotal = industrySurplusTotal;
    }

    public BigDecimal getIndustryUsableTotal() {
        return industryUsableTotal;
    }

    public void setIndustryUsableTotal(BigDecimal industryUsableTotal) {
        this.industryUsableTotal = industryUsableTotal;
    }

    public OrgVO getPkProOrg() {
        return pkProOrg;
    }

    public void setPkProOrg(OrgVO pkProOrg) {
        this.pkProOrg = pkProOrg;
    }

    @Override
    public String getPk() {
        return pkProjectApproval;
    }

    @Override
    public void setPk(String pk) {
        this.pkProjectApproval = pk;
    }
}
