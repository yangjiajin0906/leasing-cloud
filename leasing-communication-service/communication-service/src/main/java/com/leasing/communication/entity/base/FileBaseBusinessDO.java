package com.leasing.communication.entity.base;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019/11/11
 * @author:Yjj@yonyou.com
 * @description: 文件导入导出业务基类DO
 **/
@MappedSuperclass
public abstract class FileBaseBusinessDO extends BaseEntity implements Serializable {
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
     * 来源系统
     */
    public String pkSys;
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

    public String getPkSys() {
        return pkSys;
    }

    public void setPkSys(String pkSys) {
        this.pkSys = pkSys;
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