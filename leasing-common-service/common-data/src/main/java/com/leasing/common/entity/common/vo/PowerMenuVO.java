package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.entity.foundation.vo.RoleVO;


import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description:功能权限中间表VO
 **/
@Entity
@Table(name="yl_power_menu")
@NamedQueries({
        @NamedQuery(name = "ListAllPowerMenuVO", query = "SELECT p from PowerMenuVO p " +
                " left join fetch p.pkRole pr left join fetch pr.pkCorp pro " +
                " left join fetch p.pkFuncmenu pf left join fetch pf.pkParent pfl left join fetch pf.pkSystem pfs " +
                " left join fetch pf.pkOrg pfo left join fetch pf.pkDept pfd left join fetch pf.pkOperator pfu " +
                " left join fetch p.pkCorp pc" +
                " left join fetch p.pkOrg po "),
        @NamedQuery(name = "ListAllPowerMenuVO.count", query = "SELECT count(p.pkPower) FROM PowerMenuVO p")
})
public class PowerMenuVO extends BaseEntity {
    public String getPk(){return pkPower;}

    public void setPk(String pkCoderuleType){this.pkPower = pkPower;}

    public PowerMenuVO(){}

    @Id
    private String pkPower;

    @ManyToOne
    @JoinColumn(name = "pkRole")
    private RoleVO pkRole;

    @ManyToOne
    @JoinColumn(name = "pkFuncmenu")
    private DFuncMenuVO pkFuncmenu;

    @ManyToOne
    @JoinColumn(name = "pkCorp")
    private OrgDTO pkCorp;

    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgDTO pkOrg;

    public String getPkPower() {
        return pkPower;
    }

    public void setPkPower(String pkPower) {
        this.pkPower = pkPower;
    }

    public RoleVO getPkRole() {
        return pkRole;
    }

    public void setPkRole(RoleVO pkRole) {
        this.pkRole = pkRole;
    }

    public DFuncMenuVO getPkFuncmenu() {
        return pkFuncmenu;
    }

    public void setPkFuncmenu(DFuncMenuVO pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
    }

    public OrgDTO getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(OrgDTO pkCorp) {
        this.pkCorp = pkCorp;
    }

    public OrgDTO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgDTO pkOrg) {
        this.pkOrg = pkOrg;
    }
}