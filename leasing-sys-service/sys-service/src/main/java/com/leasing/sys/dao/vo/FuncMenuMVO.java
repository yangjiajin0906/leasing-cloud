package com.leasing.sys.dao.vo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Document(collection = "func-menu")
public class FuncMenuMVO {

    //主键
    private String pk_func_menu;
    //路由地址
    private String location;
    //中文简体 菜单名称
    private String name;
    //繁体 菜单名称
    private String name2;
    //英文 菜单名称
    private String name3;
    //预留 菜单名称
    private String name4;
    //预留 菜单名称
    private String name5;
    //预留 菜单名称
    private String name6;
    //菜单状态
    private String menustatus;
    //子菜单
    private List<FuncMenuMVO> children;
    //图标
    private String icon;
    //来源系统
    private String target;
    //打开方式
    private String openview;
    //菜单id
    private String menuId;
    //所属区域
    private String areaId;
    //是否收藏
    private String collected;
    //打开链接方式
    private String urltype;
    //菜单路由id
    private String id;
    //是否默认菜单
    private String isDefault;

    public String getPk_func_menu() {
        return pk_func_menu;
    }

    public void setPk_func_menu(String pk_func_menu) {
        this.pk_func_menu = pk_func_menu;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getMenustatus() {
        return menustatus;
    }

    public void setMenustatus(String menustatus) {
        this.menustatus = menustatus;
    }

    public List<FuncMenuMVO> getChildren() {
        return children;
    }

    public void setChildren(List<FuncMenuMVO> children) {
        this.children = children;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOpenview() {
        return openview;
    }

    public void setOpenview(String openview) {
        this.openview = openview;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCollected() {
        return collected;
    }

    public void setCollected(String collected) {
        this.collected = collected;
    }

    public String getUrltype() {
        return urltype;
    }

    public void setUrltype(String urltype) {
        this.urltype = urltype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
