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
 * @description: 计提当前表VO
 **/
@Entity
@Table(name="yls_accrued_c")
public class AccrualCVO {
    /**
     * 主键
     */
    @Id
    private String pkAccrual;

    /**
     * 计提主表
     */
    private String pkAccrualMain;
    /**
     * 是否月初计提.
     */
    private Short ifBegin;
    /**
     * 月末处理计提确认金额.
     */
    private BigDecimal confirmCashEnd;
    /**
     * 月末处理补计提金额.
     */
    private BigDecimal supplementCashEnd;
    /**
     * 月末处理当期预提余额.
     */
    private BigDecimal currCashEnd;
    /**
     * 月末处理凭证预提金额.
     */
    private BigDecimal vouCashEnd;

    /**
     * 服务费(预提).
     */
    private BigDecimal serviceAccCash;
    /**
     * 服务费(预收).
     */
    private BigDecimal servicePreCash;

    /**
     * 计提合同主键
     */
    @ManyToOne
    @JoinColumn(name = "pkContract")
    private ContractDTO pkContract;

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

    public String getPkAccrual() {
        return pkAccrual;
    }

    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    /**
     * Description: 是否月初计提<br>
     *
     * @return 是否月初计提
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public Short getIfBegin() {
        return ifBegin;
    }

    /**
     * Description: 是否月初计提<br>
     *
     * @param ifBegin
     *            是否月初计提
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public void setIfBegin(Short ifBegin) {
        this.ifBegin = ifBegin;
    }

    /**
     * Description: 月末处理计提确认金额.<br>
     *
     * @return 月末处理计提确认金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public BigDecimal getConfirmCashEnd() {
        return confirmCashEnd;
    }

    /**
     * Description: 月末处理计提确认金额.<br>
     *
     * @param confirmCashEnd
     *            月末处理计提确认金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public void setConfirmCashEnd(BigDecimal confirmCashEnd) {
        this.confirmCashEnd = confirmCashEnd;
    }

    /**
     * Description: 月末处理补计提金额<br>
     *
     * @return 月末处理补计提金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public BigDecimal getSupplementCashEnd() {
        return supplementCashEnd;
    }

    /**
     * Description: 月末处理补计提金额<br>
     *
     * @param supplementCashEnd
     *            月末处理补计提金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public void setSupplementCashEnd(BigDecimal supplementCashEnd) {
        this.supplementCashEnd = supplementCashEnd;
    }

    /**
     * Description: 月末处理当期预提余额.<br>
     *
     * @return 月末处理当期预提余额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public BigDecimal getCurrCashEnd() {
        return currCashEnd;
    }

    /**
     * Description: 月末处理当期预提余额.<br>
     *
     * @param currCashEnd
     *            月末处理当期预提余额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public void setCurrCashEnd(BigDecimal currCashEnd) {
        this.currCashEnd = currCashEnd;
    }

    /**
     * Description: 月末处理凭证预提金额<br>
     *
     * @return 月末处理凭证预提金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public BigDecimal getVouCashEnd() {
        return vouCashEnd;
    }

    /**
     * Description: 月末处理凭证预提金额<br>
     *
     * @param vouCashEnd
     *            月末处理凭证预提金额
     * @author: kehy<br>
     * @Date：2013-10-29
     */
    public void setVouCashEnd(BigDecimal vouCashEnd) {
        this.vouCashEnd = vouCashEnd;
    }

    /**
     * Description: 计提合同主键<br>
     *
     * @return 计提合同主键
     * @author: kehy<br>
     * @Date：2013-11-6
     */
    public ContractDTO getPkContract() {
        return pkContract;
    }

    /**
     * Description: 计提合同主键<br>
     *
     * @param pkContract
     *            计提合同主键
     * @author: kehy<br>
     * @Date：2013-11-6
     */
    public void setPkContract(ContractDTO pkContract) {
        this.pkContract = pkContract;
    }

    /**
     * Description: 计提主表<br>
     *
     * @return 计提主表
     * @author: kehy<br>
     * @Date：2014-1-20
     */
    public String getPkAccrualMain() {
        return pkAccrualMain;
    }

    /**
     * Description: 计提主表<br>
     *
     * @param pkAccrualMain
     *            计提主表
     * @author: kehy<br>
     * @Date：2014-1-20
     */
    public void setPkAccrualMain(String pkAccrualMain) {
        this.pkAccrualMain = pkAccrualMain;
    }

    /**
     * Description: 服务费期初(预提)<br>
     *
     * @return 服务费期初(预提)
     * @author: kehy<br>
     * @Date：2014-1-23
     */
    public BigDecimal getServiceAccCash() {
        return serviceAccCash;
    }

    /**
     * Description: 服务费期初(预提)<br>
     *
     * @param serviceAccCash
     *            服务费期初(预提)
     * @author: kehy<br>
     * @Date：2014-1-23
     */
    public void setServiceAccCash(BigDecimal serviceAccCash) {
        this.serviceAccCash = serviceAccCash;
    }

    /**
     * Description: 服务费期初(预收)<br>
     *
     * @return 服务费期初(预收)
     * @author: kehy<br>
     * @Date：2014-1-23
     */
    public BigDecimal getServicePreCash() {
        return servicePreCash;
    }

    /**
     * Description: 服务费期初(预收)<br>
     *
     * @param servicePreCash
     *            服务费期初(预收)
     * @author: kehy<br>
     * @Date：2014-1-23
     */
    public void setServicePreCash(BigDecimal servicePreCash) {
        this.servicePreCash = servicePreCash;
    }

    /**
     * 获得子表表名
     *
     * @return String
     */
    public String getChildrenTableName() {
        return "ylsAccrualC";
    }

    /**
     * 获得子表主键定义
     *
     * @return String
     */
    public String getPKFieldName() {
        return "pkAccrual";
    }

    /**
     * 获得主表主键定义
     *
     * @return String
     */
    public String getParentPKFieldName() {
        return "pkAccrualMain";
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getSourceBilltype() {
        return sourceBilltype;
    }

    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }

    public Short getBusiType() {
        return busiType;
    }

    public void setBusiType(Short busiType) {
        this.busiType = busiType;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCalDate() {
        return calDate;
    }

    public void setCalDate(String calDate) {
        this.calDate = calDate;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public BigDecimal getServiceCash() {
        return serviceCash;
    }

    public void setServiceCash(BigDecimal serviceCash) {
        this.serviceCash = serviceCash;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public String getCaclTag() {
        return caclTag;
    }

    public void setCaclTag(String caclTag) {
        this.caclTag = caclTag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

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

    public OrgDTO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgDTO pkOrg) {
        this.pkOrg = pkOrg;
    }

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
}