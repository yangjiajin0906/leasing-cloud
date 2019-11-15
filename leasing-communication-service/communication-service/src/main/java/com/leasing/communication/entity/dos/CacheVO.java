package com.leasing.communication.entity.dos;

import java.io.Serializable;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:Yjj@yonyou.com
 * @description: 把数据保存到 缓存数据库
 **/
public class CacheVO<T> implements Serializable {

    /**
     * 唯一标示
     */
    private String id;

    /**
     * 标记
     */
    private Integer tag;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 数据
     */
    private List<T> data;

    public CacheVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}