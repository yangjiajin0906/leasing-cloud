package com.leasing.common.ref.base;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description: 参照基类
 **/
public abstract class BaseRefEntity implements Serializable{
    /**
     * 主键
     */
    private String pk;

    /**
     * 参照编码
     */
    private String code;

    /**
     * 参照名称
     */
    private String name;

    public abstract String getPk();

    public abstract void setPk(String pk);

    public abstract String getCode();

    public abstract void setCode(String code);

    public abstract String getName();

    public abstract void setName(String name);

    @Override
    public boolean equals(Object obj) {
        BaseRefEntity entity = (BaseRefEntity)obj;
        if(entity == null || StringUtils.isBlank(entity.getPk())){
            return false;
        }
        return this.pk.equalsIgnoreCase(entity.getPk());
    }
}
