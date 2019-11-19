package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseRefVO;


/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:wangjc@yonyou.com
 * @description: 公共参照实体返回类
 **/
public class PageQueryRefData<T extends BaseRefVO> extends PageQueryData {
    //表头编码
    private String strFieldCode[];
    //表头名称
    private String strFieldName[];

    public PageQueryRefData(){}

    public PageQueryRefData(T t){
        this.strFieldCode = t.getFieldCode();
        this.strFieldName = t.getFieldName();
    }

    public String[] getStrFieldCode() {
        return strFieldCode;
    }

    public void setStrFieldCode(String[] strFieldCode) {
        this.strFieldCode = strFieldCode;
    }

    public String[] getStrFieldName() {
        return strFieldName;
    }

    public void setStrFieldName(String[] strFieldName) {
        this.strFieldName = strFieldName;
    }
}