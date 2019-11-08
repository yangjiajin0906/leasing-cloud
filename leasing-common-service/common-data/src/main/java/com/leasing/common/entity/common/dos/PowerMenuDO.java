package com.leasing.common.entity.common.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description:权限分配菜单DO
 **/
@Entity
@Table(name="yl_power_menu")
public class PowerMenuDO extends BaseDO {

    public String getPk(){return pkPower;}

    public void setPk(String pkCoderuleType){this.pkPower = pkPower;}

    public PowerMenuDO(){}

    @Id
    private String pkPower;

    private String pkRole;

    private String pkFuncmenu;

    private String pkCorp;

    private String pkOrg;


    public String getPkPower() {
        return pkPower;
    }

    public void setPkPower(String pkPower) {
        this.pkPower = pkPower;
    }

    public String getPkRole() {
        return pkRole;
    }

    public void setPkRole(String pkRole) {
        this.pkRole = pkRole;
    }

    public String getPkFuncmenu() {
        return pkFuncmenu;
    }

    public void setPkFuncmenu(String pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
    }

    public String getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(String pkCorp) {
        this.pkCorp = pkCorp;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

}