package com.leasing.common.enums.excel;

/**
 * @project:leasing-cloud
 * @date:2019/11/18
 * @author:Yjj@yonyou.com
 * @description:
 **/
public enum ExcelType {
    XLS("xls"),
    XLS_X("xlsx")
    ;
    String type;

    ExcelType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}