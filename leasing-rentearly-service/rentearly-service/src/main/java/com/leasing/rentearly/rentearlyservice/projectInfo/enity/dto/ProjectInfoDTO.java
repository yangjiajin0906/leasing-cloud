package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.entity.foundation.vo.UserVO;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_project_info")
public class ProjectInfoDTO {

    @Id    //主键id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "project-id")
    @GenericGenerator(name = "project-id", strategy = "com.leasing.rentearly.rentearlyservice.projectInfo.utils.IDGenerator")
//    @Column(name = "pk_project_info", unique = true, nullable = false, length = 20)
    public String pkProjectInfo;


    public String projectCode;

    public String projectName;

    private String pkProjectApproval;

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
}
