package com.leasing.common.base.entity;

import org.dozer.Mapping;

import javax.persistence.MappedSuperclass;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:lvcna@yonyou.com
 * @description: 数据库持久层对象基类
 **/
@MappedSuperclass
public abstract class BaseBusinessDO extends BaseDO {

    /**
     * 单据状态
     */
    public Short billstatus;
    /**
     * 操作人
     */
    public String pkOperator;
    /**
     * 操作日期
     */
    public String operateDate;
    /**
     * 操作时间
     */
    public String operateTime;
    /**
     * 机构
     */
    public String pkOrg;
    /**
     * 部门主键
     */
    public String pkDept;


    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getPkDept() {
        return pkDept;
    }

    public void setPkDept(String pkDept) {
        this.pkDept = pkDept;
    }

    @Override
    public String[] getAttributeNames() {
        return super.getAttributeNames();
    }
}
