package com.leasing.common.vo.foundation;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:wangjc@yonyou.com
 * @description: 角色/机构关联中间表VO
 **/
@Entity
@Table(name = "sm_role_corp_alloc")
@NamedQueries({
        @NamedQuery(name = "ListRoleOrg", query = "SELECT e from RoleOrgVO e left join fetch e.pkRole pr " +
                " left join fetch pr.pkCorp prc left join fetch e.pkCorp pc  "),
        @NamedQuery(name = "ListRoleOrg.count", query = "SELECT count(e.pkRoleCorpAlloc) FROM RoleOrgVO e")
})
public class RoleOrgVO extends BaseEntity {
    public String getTableName() {
        return "sm_role_corp_alloc";
    }

    @Override
    public String getPk() {
        return pkRoleCorpAlloc;
    }

    @Override
    public void setPk(String pkRoleCorpAlloc) {
        this.pkRoleCorpAlloc = pkRoleCorpAlloc;
    }

    @Id
    private String pkRoleCorpAlloc;

    /**
     * 角色VO
     */
    @ManyToOne
    @JoinColumn(name = "pkRole")
    private RoleVO pkRole;

    /**
     * 机构VO
     */
    @ManyToOne
    @JoinColumn(name = "pkCorp")
    private OrgDTO pkCorp;


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

    public OrgDTO getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(OrgDTO pkCorp) {
        this.pkCorp = pkCorp;
    }
}