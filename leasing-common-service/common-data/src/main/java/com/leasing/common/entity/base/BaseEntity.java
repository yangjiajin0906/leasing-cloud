package com.leasing.common.entity.base;

import com.leasing.common.repository.support.StringModalType;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description: 实体对象基类
 **/
@MappedSuperclass
public abstract class BaseEntity implements Serializable {


    public BaseEntity(String pk){
        this.setPk(pk);
    }

    public BaseEntity(){

    }

    //时间戳
    @Version
    private StringModalType ts;
    //主键
    @Transient
    private String pk;


    public abstract String getPk();
    public abstract void setPk(String pk);

    public StringModalType getTs() {
        return ts;
    }

    public void setTs(StringModalType ts) {
        this.ts = ts;
    }
}
