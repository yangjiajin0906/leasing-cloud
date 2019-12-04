package com.leasing.common.enums.excel;

/**
 * @project:leasing-cloud
 * @date:2019-11-21
 * @author:lvcna@yonyou.com
 * @description: Excel导入匹配类型
 **/
public enum ExcelMatchType {
    //按列名匹配
    MatchTypeName(0),
    //按顺序匹配
    MatchTypeOrder(1),
    ;

    //匹配类型
    private Integer matchType;

    ExcelMatchType(int matchType){
        this.matchType = matchType;
    }

    public Integer getMatchType() {
        return matchType;
    }
}
