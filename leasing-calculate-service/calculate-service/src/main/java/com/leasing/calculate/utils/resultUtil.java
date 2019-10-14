package com.leasing.calculate.utils;

import org.springframework.util.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/10/14
 * @author:Yjj@yonyou.com
 * @description: 嘉易融提供的服务接口 返回数据工具类
 **/
public class resultUtil {

    private resultUtil(){}

    public static Map<String, Object> getMessageMap(String code, String msg,String applyNo,String riskCode,String riskMsg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("applyNo", applyNo);
        return map;
    }

    public static Map<String, Object> getMessageMap(String code, String msg,String applyNo) {
        return getMessageMap(code,msg,applyNo,null,null);
    }

}