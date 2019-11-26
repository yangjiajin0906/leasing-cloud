package com.leasing.common.utils.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @project:leasing-cloud
 * @date:2019/11/25
 * @author:wangjc@yonyou.com
 * @description:前台传递json数据解析工具类
 **/
@Component
public class DataParseUtils {
    private static DataParseUtils dataParseUtils;

    @PostConstruct
    public void init(){
        dataParseUtils = this;
    }


    public static <T> T jsonToBean(String data, String columnName, Class<T> clazz){
        JSONObject json = JSONObject.parseObject(data);
        if(json == null){
            if(columnName.equals("pagination")){
                return (T)new Pagination(1,5);
            }else{
                return null;
            }
        }
        if(json.get(columnName) != null && !StringUtils.isEmpty(json.get(columnName).toString())){
            return JSON.parseObject(json.get(columnName).toString(), clazz);
        }
        return null;
    }
}