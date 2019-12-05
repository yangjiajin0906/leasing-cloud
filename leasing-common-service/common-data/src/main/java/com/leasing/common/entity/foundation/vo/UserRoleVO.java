package com.leasing.common.entity.foundation.vo;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.entity.customer.dto.OrgDTO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:wangjc@yonyou.com
 * @description: 角色用户关联中间表VO
 **/
@Entity
@Table(name = "sm_user_rela")
public class UserRoleVO extends BaseEntity {
    public String getTableName() {
        return "sm_user_rela";
    }

    @Override
    public String getPk() {
        return pkUserRela;
    }

    @Override
    public void setPk(String pkRole) {
        this.pkUserRela = pkUserRela;
    }

    @Id
    private String pkUserRela;

    /**
     * 关联用户的pk_userde_user
     */
    private String pkUser;

    /**
     * 机构主键
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgDTO pkOrg;

    /**
     * 角色主键
     */
    private String pkGroup;

    public String getPkUserRela() {
        return pkUserRela;
    }

    public void setPkUserRela(String pkUserRela) {
        this.pkUserRela = pkUserRela;
    }


    public OrgDTO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgDTO pkOrg) {
        this.pkOrg = pkOrg;
    }


    public String getPkUser() {
        return pkUser;
    }

    public void setPkUser(String pkUser) {
        this.pkUser = pkUser;
    }

    public String getPkGroup() {
        return pkGroup;
    }

    public void setPkGroup(String pkGroup) {
        this.pkGroup = pkGroup;
    }
}