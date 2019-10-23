package com.leasing.rentearly.rentearlyservice.projectInfo.enity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.vo.foundation.UserVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_project_info")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class ProjectInfoVO extends BaseVO {

    @Id    //主键id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project-id")
    @GenericGenerator(name = "project-id", strategy = "com.leasing.rentearly.rentearlyservice.projectInfo.utils.IDGenerator")
//    @Column(name = "pk_project_info", unique = true, nullable = false, length = 20)
    public String pkProjectInfo;


    public String projectCode;

    public String projectName;

    private String pkProjectApproval;

    private Short billstatus;

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pkPrjManager")
    public UserVO pkPrjManager;

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

    public UserVO getPkPrjManager() {
        return pkPrjManager;
    }

    public void setPkPrjManager(UserVO pkPrjManager) {
        this.pkPrjManager = pkPrjManager;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
