package com.leasing.communication.entity.vo;

import com.leasing.common.entity.customer.dto.OrgDTO;
import com.leasing.common.entity.foundation.vo.DeptVO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/12/4
 * @author:Yjj@yonyou.com
 * @description: 计提表类
 **/
@Entity
@Table(name="yls_accrual")
public class AccrualVO {
    /**
     * 主键
     */
    @Id
    public String pkAccrual;

    /**
     * 来源单据
     */
    public String sourceBill;

    /**
     * 来源单据类型
     */
    public String sourceBilltype;

    /**
     * 业务类型
     */
    public Short busiType;

    /**
     * 计提月份
     */
    public String month;

    /**
     * 计算日期
     */
    public String calDate;

    /**
     * 服务费日期
     */
    public String serviceDate;

    /**
     * 服务费按年归总金额
     */
    public BigDecimal serviceCash;

    /**
     * 计提金额
     */
    public BigDecimal cash;

    /**
     * 收支计划
     */
    //public InoutPlanRentRefVO pkInoutPlan;

    /**
     * 折分标识
     */
    public String caclTag;

    /**
     * 备注
     */
    public String memo;

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
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    public UserVO pkChecker;

    /**
     * 复核日期
     */
    public String checkDate;

    /**
     * 复核时间
     */
    public String checkTime;

    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    public UserVO pkGrantor;

    /**
     * 授权日期
     */
    public String grantDate;

    /**
     * 授权时间
     */
    public String grantTime;

    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    public OrgDTO pkOrg;


    //[合同变更-合同信息更正] wangjj@2016/06/17 ADD START

    /**
     * 当月实际计提金额
     */
    public BigDecimal accrualCashFact;
    /**
     * 当月计提补差金额
     */
    public BigDecimal accrualCashRepair;


    public BigDecimal getAccrualCashFact() {
        return accrualCashFact;
    }

    public void setAccrualCashFact(BigDecimal accrualCashFact) {
        this.accrualCashFact = accrualCashFact;
    }

    public BigDecimal getAccrualCashRepair() {
        return accrualCashRepair;
    }

    public void setAccrualCashRepair(BigDecimal accrualCashRepair) {
        this.accrualCashRepair = accrualCashRepair;
    }

    //[合同变更-合同信息更正] wangjj@2016/06/17 ADD END
    /**
     * 类AccrualVO的构造方法
     */
    public AccrualVO() {
    }

    /**
     * 主键的getter方法
     *
     * @return String
     */
    public String getPrimaryKey() {
        return pkAccrual;
    }

    /**
     * 主键的setter方法
     *
     * @param String
     *            key
     */
    public void setPrimaryKey(String key) {
        this.pkAccrual = key;
    }

    /**
     * 主键的getter方法
     *
     * @return String
     */
    public String getPkAccrual() {
        return pkAccrual;
    }

    /**
     * 主键的setter方法
     *
     * @param pkAccrual
     *            主键
     */
    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    /**
     * 业务类型的getter方法
     *
     * @return Short
     */
    public Short getBusiType() {
        return busiType;
    }

    /**
     * 业务类型的setter方法
     *
     * @param busiType
     *            业务类型
     */
    public void setBusiType(Short busiType) {
        this.busiType = busiType;
    }

    /**
     * 计提月份的getter方法
     *
     * @return String
     */
    public String getMonth() {
        return month;
    }

    /**
     * 计提月份的setter方法
     *
     * @param month
     *            计提月份
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 计提金额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * 计提金额的setter方法
     *
     * @param cash
     *            计提金额
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * 收支计划的getter方法
     *
     * @return String
     */
//    public InoutPlanRentRefVO getPkInoutPlan() {
//        return pkInoutPlan;
//    }
//
//    /**
//     * 收支计划的setter方法
//     *
//     * @param pkInoutPlan
//     *            收支计划
//     */
//    public void setPkInoutPlan(InoutPlanRentRefVO pkInoutPlan) {
//        this.pkInoutPlan = pkInoutPlan;
//    }

    /**
     * 备注的getter方法
     *
     * @return String
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注的setter方法
     *
     * @param memo
     *            备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 部门主键的getter方法
     *
     * @return DeptdocRefVO
     */
    public DeptVO getPkDept() {
        return pkDept;
    }

    public void setPkDept(DeptVO pkDept) {
        this.pkDept = pkDept;
    }

    /**
     * 单据状态的getter方法
     *
     * @return Short
     */
    public Short getBillstatus() {
        return billstatus;
    }

    /**
     * 单据状态的setter方法
     *
     * @param billstatus
     *            单据状态
     */
    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
        this.pkOperator = pkOperator;
    }

    /**
     * 操作日期的getter方法
     *
     * @return String
     */
    public String getOperateDate() {
        return operateDate;
    }

    /**
     * 操作日期的setter方法
     *
     * @param operateDate
     *            操作日期
     */
    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 操作时间的getter方法
     *
     * @return String
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 操作时间的setter方法
     *
     * @param operateTime
     *            操作时间
     */
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    /**
     * 复核日期的getter方法
     *
     * @return String
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * 复核日期的setter方法
     *
     * @param checkDate
     *            复核日期
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 复核时间的getter方法
     *
     * @return String
     */
    public String getCheckTime() {
        return checkTime;
    }

    /**
     * 复核时间的setter方法
     *
     * @param checkTime
     *            复核时间
     */
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    /**
     * 授权日期的getter方法
     *
     * @return String
     */
    public String getGrantDate() {
        return grantDate;
    }

    /**
     * 授权日期的setter方法
     *
     * @param grantDate
     *            授权日期
     */
    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    /**
     * 授权时间的getter方法
     *
     * @return String
     */
    public String getGrantTime() {
        return grantTime;
    }

    /**
     * 授权时间的setter方法
     *
     * @param grantTime
     *            授权时间
     */
    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public OrgDTO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgDTO pkOrg) {
        this.pkOrg = pkOrg;
    }

    /**
     * Description: 来源单据<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public String getSourceBill() {
        return sourceBill;
    }

    /**
     * Description: 来源单据<br>
     * @param sourceBill
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    /**
     * Description: 来源单据类型.<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public String getSourceBilltype() {
        return sourceBilltype;
    }

    /**
     * Description: 来源单据类型.<br>
     * @param sourceBilltype
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }

    /**
     * Description: 计算日期.<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public String getCalDate() {
        return calDate;
    }

    /**
     * Description: 计算日期.<br>
     * @param calDate
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setCalDate(String calDate) {
        this.calDate = calDate;
    }

    /**
     * Description: 服务费日期.<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public String getServiceDate() {
        return serviceDate;
    }

    /**
     * Description: 服务费日期.<br>
     * @param serviceDate
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    /**
     * Description: 按年归总金额.<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public BigDecimal getServiceCash() {
        return serviceCash;
    }

    /**
     * Description: 按年归总金额.<br>
     * @param serviceCash
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setServiceCash(BigDecimal serviceCash) {
        this.serviceCash = serviceCash;
    }

    /**
     * Description: 拆分标识.<br>
     * @return
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public String getCaclTag() {
        return caclTag;
    }

    /**
     * Description: 拆分标识.<br>
     * @param caclTag
     * @author: kehy<br>
     * @Date：2013-9-28
     */
    public void setCaclTag(String caclTag) {
        this.caclTag = caclTag;
    }
}