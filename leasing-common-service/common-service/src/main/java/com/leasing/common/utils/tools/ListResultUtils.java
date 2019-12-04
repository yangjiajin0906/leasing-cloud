package com.leasing.common.utils.tools;

import com.leasing.common.exception.BaseException;
import org.apache.commons.lang.ArrayUtils;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-2
 * @author:lvcna@yonyou.com
 * @description: 集合结果集操作工具类
 **/
public class ListResultUtils {

    /**
     * 从结果集中获取单个对象
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T singleResult(List<T> list){
        if(list == null){
            throw new BaseException("参数为空,请检查!");
        }
        if(list.size() > 1){
            throw new BaseException("参数集合对象数量大于1,请检查!");
        }
        if(list.size() < 1){
            throw new BaseException("参数集合为空,请检查!");
        }
        return list.get(0);
    }
}
