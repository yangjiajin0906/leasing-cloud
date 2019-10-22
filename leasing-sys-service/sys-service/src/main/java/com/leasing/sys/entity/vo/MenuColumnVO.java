//package com.leasing.common.entity.sys;
//
//import com.leasing.common.entity.base.BusinessEntity;
//
//import javax.persistence.*;
//
///**
// * @project:leasing-cloud
// * @date:2019/10/15
// * @author:wangjc@yonyou.com
// * @description:菜单表对应全部字段
// **/
//@Entity
//@Table(name="sm_business_column")
//public class MenuColumnVO extends BusinessEntity {
//    public String getTableName() {
//        return "sm_business_column";
//    }
//
//    public String getPk(){return pkButnmenu;}
//
//    public void setPk(String pkButnmenu){
//        this.pkButnmenu=pkButnmenu;
//    }
//
//    @Id
//    private String pkButnmenu;
//
//    @ManyToOne()
//    @JoinColumn(name = "pkFuncmenu")
//    private DFuncMenuVO pkFuncmenu;
//
//    private String columnName;
//
//    private String columnType;
//
//    private String columnCode;
//
//    public MenuColumnVO(){}
//
//    public String getPkButnmenu() {
//        return pkButnmenu;
//    }
//
//    public void setPkButnmenu(String pkButnmenu) {
//        this.pkButnmenu = pkButnmenu;
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
//    public String getColumnName() {
//        return columnName;
//    }
//
//    public void setColumnName(String columnName) {
//        this.columnName = columnName;
//    }
//
//    public String getColumnType() {
//        return columnType;
//    }
//
//    public void setColumnType(String columnType) {
//        this.columnType = columnType;
//    }
//
//    public String getColumnCode() {
//        return columnCode;
//    }
//
//    public void setColumnCode(String columnCode) {
//        this.columnCode = columnCode;
//    }
//}