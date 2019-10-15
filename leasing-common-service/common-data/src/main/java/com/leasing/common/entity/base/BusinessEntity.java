package com.leasing.common.entity.base;

import com.leasing.common.entity.foundation.DeptVO;
import com.leasing.common.entity.foundation.OrgVO;
import com.leasing.common.entity.foundation.UserVO;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 业务对象实体基类
 **/
@MappedSuperclass
public abstract class BusinessEntity extends BaseEntity{


    /**
     * 获取业务对象对应的数据库表名
     * @return
     */
    public abstract String getTableName();

    /**
     * 部门主键
     */
    @ManyToOne
    @JoinColumn(name = "pkDept")
    public DeptVO pkDept;

    /**
     * 单据状态
     */
    public Short billstatus;

    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    public UserVO pkOperator;

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
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    public OrgVO pkOrg;

    public DeptVO getPkDept() {
        return pkDept;
    }

    public void setPkDept(DeptVO pkDept) {
        this.pkDept = pkDept;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
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

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

}
