package com.leasing.common.vo.foundation;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description: 角色基础VO
 **/
@Entity
@Table(name = "sm_role")
public class RoleVO extends BaseEntity {
    public String getTableName() {
        return "sm_role";
    }

    @Override
    public String getPk() {
        return pkRole;
    }

    @Override
    public void setPk(String pkRole) {
        this.pkRole = pkRole;
    }

    @Id
    private String pkRole;

    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkCorp")
    private OrgDTO pkCorp;

    private String roleCode;

    private String roleName;

    private String roleMemo;

    public String getPkRole() {
        return pkRole;
    }

    public void setPkRole(String pkRole) {
        this.pkRole = pkRole;
    }

    public OrgDTO getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(OrgDTO pkCorp) {
        this.pkCorp = pkCorp;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleMemo() {
        return roleMemo;
    }

    public void setRoleMemo(String roleMemo) {
        this.roleMemo = roleMemo;
    }
}