package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.common.ref.EventTypeRefVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:wangjc@yonyou.com
 * @description:irr影响子表
 **/
@Entity
@Table(name = "yls_irr_event_set")
public class IrrEventSetVO extends BaseVO {
    public String getPk(){return pkIrrEventSet;}

    public void setPk(String pkIrrEventSet){this.pkIrrEventSet = pkIrrEventSet;}

    public IrrEventSetVO(){}

    @Id
    private String pkIrrEventSet;

    /**
     * Irr类别
     */
    private IrrTypeVO pkIrrType;

    /**
     * 事件类别
     */
    @OneToOne
    @JoinColumn(name = "pkEventType")
    private EventTypeRefVO pkEventType;

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

    public IrrTypeVO getPkIrrType() {
        return pkIrrType;
    }

    public void setPkIrrType(IrrTypeVO pkIrrType) {
        this.pkIrrType = pkIrrType;
    }

    public EventTypeRefVO getPkEventType() {
        return pkEventType;
    }

    public void setPkEventType(EventTypeRefVO pkEventType) {
        this.pkEventType = pkEventType;
    }

    public Short getVal() {
        return val;
    }

    public void setVal(Short val) {
        this.val = val;
    }

}