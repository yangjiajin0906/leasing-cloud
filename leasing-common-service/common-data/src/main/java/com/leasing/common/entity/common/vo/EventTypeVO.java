package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:wangjc@yonyou.com
 * @description:事件类别VO
 **/
@Entity
@Table(name="yls_event_type")
@NamedQueries({
        @NamedQuery(name = "ListEventType", query = "SELECT e from EventTypeVO e left join fetch e.pkOrg "),
        @NamedQuery(name = "ListEventType.count", query = "SELECT count(e.pkEventType) FROM EventTypeVO e")
})
public class EventTypeVO extends BaseBusinessVO {
    public String getTableName(){return "yls_event_type";}

    public String getPk(){return pkEventType;}

    public void setPk(String pkEventType){this.pkEventType = pkEventType;}

    public EventTypeVO(){}
    @Id
    private String pkEventType;

    /**
     * 业务模块
     */
    private Short module;

    /**
     * 事件分类编码
     */
    private String eventClassCode;

    /**
     * 事件分类名称
     */
    private String eventClassName;

    /**
     * 事件类别编码
     */
    private String eventCode;

    /**
     * 事件类别名称
     */
    private String eventName;

    /**
     * 现金流方向
     */
    private Short cashDeriction;

    /**
     * 是否启用
     */
    private Short isEnable;

    /**
     * 发生额别名
     */
    private String cashAlias;

    /**
     * 备注
     */
    private String memo;

    /**
     * 排序号
     */
    private Integer orderNum;


    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;

    /**
     * 复核时间
     */
    private String checkTime;

    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;

    /**
     * 授权时间
     */
    private String grantTime;


    public String getPkEventType() {
        return pkEventType;
    }

    public void setPkEventType(String pkEventType) {
        this.pkEventType = pkEventType;
    }

    public Short getModule() {
        return module;
    }

    public void setModule(Short module) {
        this.module = module;
    }

    public String getEventClassCode() {
        return eventClassCode;
    }

    public void setEventClassCode(String eventClassCode) {
        this.eventClassCode = eventClassCode;
    }

    public String getEventClassName() {
        return eventClassName;
    }

    public void setEventClassName(String eventClassName) {
        this.eventClassName = eventClassName;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Short getCashDeriction() {
        return cashDeriction;
    }

    public void setCashDeriction(Short cashDeriction) {
        this.cashDeriction = cashDeriction;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public String getCashAlias() {
        return cashAlias;
    }

    public void setCashAlias(String cashAlias) {
        this.cashAlias = cashAlias;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }
}