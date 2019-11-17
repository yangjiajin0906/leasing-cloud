package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:面向数据库层菜单VO
 **/

@Entity
@Table(name="yl_business_menu")
public class DFuncMenuVO extends BaseBusinessVO {

    public String getTableName(){return "yl_business_menu";}

    public String getPk(){return pkFuncmenu;}

    public void setPk(String pkFuncmenu){this.pkFuncmenu = pkFuncmenu;}

    @Id
    private String pkFuncmenu;

    @ManyToOne
    @JoinColumn(name = "pkSystem")
    private SystemVO pkSystem;

    @ManyToOne
    @JoinColumn(name = "pkParent")
    private DFuncMenuVO pkParent;

    private String funcCode;

    private String funcName;

    private String menuPath;

    private String menuProperty;

    private Short ifPower;

    private Short ifEnabled;

    private Short ifFirstEnabled;

    private String icon;

    private Short collected;

    @Transient
    private List<DFuncMenuVO> children;

    public String getPkFuncmenu() {
        return pkFuncmenu;
    }

    public void setPkFuncmenu(String pkFuncmenu) {
        this.pkFuncmenu = pkFuncmenu;
    }

    public SystemVO getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(SystemVO pkSystem) {
        this.pkSystem = pkSystem;
    }

    public DFuncMenuVO getPkParent() {
        return pkParent;
    }

    public void setPkParent(DFuncMenuVO pkParent) {
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

    public List<DFuncMenuVO> getChildren() {
        return children;
    }

    public void setChildren(List<DFuncMenuVO> children) {
        this.children = children;
    }

    public DFuncMenuVO(){

    }
}