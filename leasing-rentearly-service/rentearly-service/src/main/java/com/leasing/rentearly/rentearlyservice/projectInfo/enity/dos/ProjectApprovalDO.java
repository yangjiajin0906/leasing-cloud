package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos;

import com.leasing.common.base.entity.BaseDO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/22
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_project_approval")
public class ProjectApprovalDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project-id")
    @GenericGenerator(name = "project-id", strategy = "com.leasing.rentearly.rentearlyservice.projectInfo.utils.IDGenerator")
    private String pkProjectApproval;

    private String projectFilingCode;

    private String projectFilingName;

    private Integer projectFilingBatch;

    //暂时作为关联键试用 测试试用
    private String thingType;

    private String pkOrg;

    private Integer billstatus;


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

    public String getThingType() {
        return thingType;
    }

    public void setThingType(String thingType) {
        this.thingType = thingType;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public Integer getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Integer billstatus) {
        this.billstatus = billstatus;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
