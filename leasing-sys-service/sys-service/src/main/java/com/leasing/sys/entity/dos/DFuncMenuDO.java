package com.leasing.sys.entity.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.vo.foundation.OrgVO;
import org.dozer.Mapping;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/17
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Entity
@Table(name="sm_business_menu")
public class DFuncMenuDO extends BaseBusinessDO {
    public String getTableName() {
        return "sm_business_menu";
    }

    public String getPk() {
        return pkFuncmenu;
    }

    public void setPk(String pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
    }

    public DFuncMenuDO(){}

    @Id
    private String pkFuncmenu;

    private String pkSystem;

    private String pkParent;

    private String funcCode;

    private String funcName;

    private String menuPath;

    private String menuProperty;

    private Short ifPower;

    private Short ifEnabled;

    private Short ifFirstEnabled;

    private String icon;

    private Short collected;

    public String getPkFuncmenu() {
        return pkFuncmenu;
    }

    public void setPkFuncmenu(String pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
    }

    public String getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(String pkSystem) {
        this.pkSystem = pkSystem;
    }

    public String getPkParent() {
        return pkParent;
    }

    public void setPkParent(String pkParent) {
        this.pkParent = pkParent;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getMenuProperty() {
        return menuProperty;
    }

    public void setMenuProperty(String menuProperty) {
        this.menuProperty = menuProperty;
    }

    public Short getIfPower() {
        return ifPower;
    }

    public void setIfPower(Short ifPower) {
        this.ifPower = ifPower;
    }

    public Short getIfEnabled() {
        return ifEnabled;
    }

    public void setIfEnabled(Short ifEnabled) {
        this.ifEnabled = ifEnabled;
    }

    public Short getIfFirstEnabled() {
        return ifFirstEnabled;
    }

    public void setIfFirstEnabled(Short ifFirstEnabled) {
        this.ifFirstEnabled = ifFirstEnabled;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Short getCollected() {
        return collected;
    }

    public void setCollected(Short collected) {
        this.collected = collected;
    }
}
