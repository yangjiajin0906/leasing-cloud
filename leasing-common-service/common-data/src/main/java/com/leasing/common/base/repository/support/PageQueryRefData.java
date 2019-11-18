package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseRefVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:wangjc@yonyou.com
 * @description: 公共参照实体返回类
 **/
public class PageQueryRefData<T> extends PageQueryData {
    //表头编码
    private String strFieldCode[];
    //表头名称
    private String strFieldName[];

    public PageQueryRefData(){}


}