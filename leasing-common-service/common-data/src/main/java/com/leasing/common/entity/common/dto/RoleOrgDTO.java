package com.leasing.common.entity.common.dto;

import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import com.leasing.common.entity.foundation.vo.RoleVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:wangjc@yonyou.com
 * @description: 角色机构关联中间表 (用作前台权限分配节点左侧数据展示)
 **/
public class RoleOrgDTO extends BaseDTO {

    public RoleOrgDTO (){}

    private String pkRoleCorpAlloc;    //主键

    private RoleVO pkRole;             //角色VO

    private List<OrgDTO> orgList;        //机构List

    public String getPkRoleCorpAlloc() {
        return pkRoleCorpAlloc;
    }

    public void setPkRoleCorpAlloc(String pkRoleCorpAlloc) {
        this.pkRoleCorpAlloc = pkRoleCorpAlloc;
    }

    public RoleVO getPkRole() {
        return pkRole;
    }

    public void setPkRole(RoleVO pkRole) {
        this.pkRole = pkRole;
    }

    public List<OrgDTO> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrgDTO> orgList) {
        this.orgList = orgList;
    }
}