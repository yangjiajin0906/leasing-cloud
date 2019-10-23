package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;
import lombok.Value;

import java.beans.ConstructorProperties;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Value
public class ProjectInfoRefVO  extends BaseRefVO {
    private String pkProjectInfo;

    private String projectCode;

    private String projectName;

    private String pkProjectApproval;

    @ConstructorProperties({"pkProjectInfo","projectCode", "projectName", "pkProjectApproval"})
    public ProjectInfoRefVO(String pkProjectInfo,String projectCode, String projectName, String pkProjectApproval) {
        this.pkProjectInfo = pkProjectInfo;
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.pkProjectApproval = pkProjectApproval;
        this.setCode(projectCode);
        this.setName(projectName);
        this.setPk(pkProjectInfo);
    }
}
