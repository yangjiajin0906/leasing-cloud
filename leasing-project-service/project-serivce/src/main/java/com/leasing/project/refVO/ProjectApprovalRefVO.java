package com.leasing.project.refVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/9/26
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_project_approval")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class ProjectApprovalRefVO {

    @Id
    public String pk_project_approval;
    /**
     * 项目报备批次
     */
    public Integer project_filing_batch;
    /**
     * 客户主键
     */
    public String pk_consumer;
    /**
     * 文档规则
     */
    public String project_approval_rule;
    /**
     * 项目类型
     */
    public Short project_type;

    /**
     * 项目金额
     */
    public BigDecimal release_amount;

    /**
     * 地区审批总额
     */
    public BigDecimal area_approve_total;
    /**
     * 地区实际投放总额
     */
    public BigDecimal area_loan_total;
    /**
     * 地区剩余投放总额
     */
    public BigDecimal area_surplus_total;
    /**
     * 地区可用授信额度
     */
    public BigDecimal area_usable_total;
    /**
     * 行业审批总额
     */
    public BigDecimal industry_approve_total;
    /**
     * 行业实际投放总额
     */
    public BigDecimal industry_loan_total;
    /**
     * 行业剩余投放总额
     */
    public BigDecimal industry_surplus_total;
    /**
     * 行业可用授信额度
     */
    public BigDecimal industry_usable_total;

    public String getPk_project_approval() {
        return pk_project_approval;
    }

    public void setPk_project_approval(String pk_project_approval) {
        this.pk_project_approval = pk_project_approval;
    }

    public Integer getProject_filing_batch() {
        return project_filing_batch;
    }

    public void setProject_filing_batch(Integer project_filing_batch) {
        this.project_filing_batch = project_filing_batch;
    }

    public String getPk_consumer() {
        return pk_consumer;
    }

    public void setPk_consumer(String pk_consumer) {
        this.pk_consumer = pk_consumer;
    }

    public String getProject_approval_rule() {
        return project_approval_rule;
    }

    public void setProject_approval_rule(String project_approval_rule) {
        this.project_approval_rule = project_approval_rule;
    }

    public Short getProject_type() {
        return project_type;
    }

    public void setProject_type(Short project_type) {
        this.project_type = project_type;
    }

    public BigDecimal getRelease_amount() {
        return release_amount;
    }

    public void setRelease_amount(BigDecimal release_amount) {
        this.release_amount = release_amount;
    }

    public BigDecimal getArea_approve_total() {
        return area_approve_total;
    }

    public void setArea_approve_total(BigDecimal area_approve_total) {
        this.area_approve_total = area_approve_total;
    }

    public BigDecimal getArea_loan_total() {
        return area_loan_total;
    }

    public void setArea_loan_total(BigDecimal area_loan_total) {
        this.area_loan_total = area_loan_total;
    }

    public BigDecimal getArea_surplus_total() {
        return area_surplus_total;
    }

    public void setArea_surplus_total(BigDecimal area_surplus_total) {
        this.area_surplus_total = area_surplus_total;
    }

    public BigDecimal getArea_usable_total() {
        return area_usable_total;
    }

    public void setArea_usable_total(BigDecimal area_usable_total) {
        this.area_usable_total = area_usable_total;
    }

    public BigDecimal getIndustry_approve_total() {
        return industry_approve_total;
    }

    public void setIndustry_approve_total(BigDecimal industry_approve_total) {
        this.industry_approve_total = industry_approve_total;
    }

    public BigDecimal getIndustry_loan_total() {
        return industry_loan_total;
    }

    public void setIndustry_loan_total(BigDecimal industry_loan_total) {
        this.industry_loan_total = industry_loan_total;
    }

    public BigDecimal getIndustry_surplus_total() {
        return industry_surplus_total;
    }

    public void setIndustry_surplus_total(BigDecimal industry_surplus_total) {
        this.industry_surplus_total = industry_surplus_total;
    }

    public BigDecimal getIndustry_usable_total() {
        return industry_usable_total;
    }

    public void setIndustry_usable_total(BigDecimal industry_usable_total) {
        this.industry_usable_total = industry_usable_total;
    }
}
