package com.leasing.sys.entity.dto;

import com.leasing.sys.entity.vo.SystemVO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @project:leasing-cloud
 * @date:2019/10/22
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class DFuncMenuDTO {
    private String pkFuncmenu;

    private String menuPath;

    private String menuProperty;

    private Short ifPower;

    private Short ifEnabled;


    private Short ifFirstEnabled;

    public String getPkFuncmenu() {
        return pkFuncmenu;
    }

    public void setPkFuncmenu(String pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
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

}