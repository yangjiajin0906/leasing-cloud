package com.leasing.common.base.entity;

import com.leasing.common.vo.foundation.DeptVO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @project:leasing-cloud
 * @date:2019-10-18
 * @author:lvcna@yonyou.com
 * @description:
 **/
@MappedSuperclass
public abstract class BaseBusinessVO extends BaseVO{

    /**
     * 部门主键
     */
    @ManyToOne
    @JoinColumn(name = "pkDept")
    private DeptVO pkDept;

    /**
     * 单据状态
     */
    private Short billstatus;

    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;

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
