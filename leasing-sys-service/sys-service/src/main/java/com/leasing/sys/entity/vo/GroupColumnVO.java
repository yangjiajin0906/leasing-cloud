//package com.leasing.common.entity.sys;
//
//import com.leasing.common.entity.base.BusinessEntity;
//
//import javax.persistence.*;
//import java.util.List;
//
///**
// * @project:leasing-cloud
// * @date:2019/10/15
// * @author:wangjc@yonyou.com
// * @description:保存用户组设置字段表
// **/
//@Entity
//@Table(name="sm_group_column")
//public class GroupColumnVO extends BusinessEntity {
//
//    public String getTableName() {
//        return "sm_group_column";
//    }
//
//    public String getPk(){return pkGroupcolumn;}
//
//    public void setPk(String pkGroupcolumn){
//        this.pkGroupcolumn=pkGroupcolumn;
//    }
//
//    public GroupColumnVO(){}
//
//    @Id
//    private String pkGroupcolumn;
//
//    @ManyToOne()
//    @JoinColumn(name = "pkFuncmenu")
//    private DFuncMenuVO pkFuncmenu;
//
//    @ManyToOne()
//    @JoinColumn(name = "pkUserGroup")
//    private UserGroupVO pkUserGroup;
//
//    private String listColumn;
//
//    private String formColumn;
//
//    private String btnColumn;
//
//    public String getPkGroupcolumn() {
//        return pkGroupcolumn;
//    }
//
//    public void setPkGroupcolumn(String pkGroupcolumn) {
//        this.pkGroupcolumn = pkGroupcolumn;
//    }
//
//    public DFuncMenuVO getPkFuncmenu() {
//        return pkFuncmenu;
//    }
//
//    public void setPkFuncmenu(DFuncMenuVO pkFuncmenu) {
//        this.pkFuncmenu = pkFuncmenu;
//    }
//
//    public UserGroupVO getPkUserGroup() {
//        return pkUserGroup;
//    }
//
//    public void setPkUserGroup(UserGroupVO pkUserGroup) {
//        this.pkUserGroup = pkUserGroup;
//    }
//
//    public String getListColumn() {
//        return listColumn;
//    }
//
//    public void setListColumn(String listColumn) {
//        this.listColumn = listColumn;
//    }
//
//    public String getFormColumn() {
//        return formColumn;
//    }
//
//    public void setFormColumn(String formColumn) {
//        this.formColumn = formColumn;
//    }
//
//    public String getBtnColumn() {
//        return btnColumn;
//    }
//
//    public void setBtnColumn(String btnColumn) {
//        this.btnColumn = btnColumn;
//    }
//}