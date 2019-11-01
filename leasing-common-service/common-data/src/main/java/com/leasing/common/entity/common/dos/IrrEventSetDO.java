package com.leasing.common.entity.common.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseDO;
import com.leasing.common.base.repository.support.StringModalType;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_irr_event_set")
public class IrrEventSetDO extends BaseDO {

    public String getPk(){return pkIrrEventSet;}

    public void setPk(String pkIrrEventSet){this.pkIrrEventSet = pkIrrEventSet;}
    public IrrEventSetDO(){}

    @Id
    private String pkIrrEventSet;

    /**
     * Irr类别
     */
    private String pkIrrType;

    /**
     * 事件类别
     */
    private String pkEventType;

    /**
     * 设置值
     */
    private Short val;


    public String getPkIrrEventSet() {
        return pkIrrEventSet;
    }

    public void setPkIrrEventSet(String pkIrrEventSet) {
        this.pkIrrEventSet = pkIrrEventSet;
    }

    public String getPkIrrType() {
        return pkIrrType;
    }

    public void setPkIrrType(String pkIrrType) {
        this.pkIrrType = pkIrrType;
    }

    public String getPkEventType() {
        return pkEventType;
    }

    public void setPkEventType(String pkEventType) {
        this.pkEventType = pkEventType;
    }

    public Short getVal() {
        return val;
    }

    public void setVal(Short val) {
        this.val = val;
    }

}