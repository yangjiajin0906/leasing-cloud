package com.leasing.communication.entity.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.communication.entity.dto.CustomerDTO;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * <b>中投计提节点，计提按钮弹出款多选参照model</b>
 *
 * @author zoucr
 *
 */
@Entity
@Table(name = "V_ACCRUAL")
public class AccrualViewVO {
    private static final long serialVersionUID = 334579052232820078L;

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
     * 计提月份
     */
    public String month;

    /**
     * 上次计提月份
     */
    @Transient
    public String mon;

    /**
     * 利息计提
     */
    public BigDecimal inter;
    /**
     * 手续费计提
     */
    public BigDecimal srv;
    /**
     * 其他收入计提
     */
    public BigDecimal pri;
    /**
     * 其他支出计提
     */
    public BigDecimal bus;

    /**
     * 客户code
     */
    public String customerCode;

//    @ManyToOne()
//    @JoinColumn(name="pkCustomer")
//    public String pkCustomer;

    public String customerName;
    /**
     * 合同
     */
    @ManyToOne
    @JoinColumn(name="pkContract")
    public ContractDTO pkContract;

    /**
     * 资产五级分类
     */
    public Short assetsClassify;

    /**
     * 币种
     */
    @ManyToOne()
    @JoinColumn(name="pkCurrtype")
    public CurrtypeVO pkCurrtype;
    /**
     * 汇率
     */
    public BigDecimal exchgRate;
    /**
     * 核算主体
     */
    @Transient
    public String pkGlorgbook;
//    @ManyToOne()
//    @JoinColumn(name="pkGlorgbook")
//    public GlorgbookRefVO pkGlorgbook;

    /**
     * 实际付款日期
     */
    @Transient
    public String realPayDate;

    /**
     * 起租流程
     */
    public Short leaseFlow;

    /**
     * 子合同主键
     */
    @Transient
    public String pkLesseeProtocol;

    /**
     * 计提标识
     */
    public Short ifBegin;

    /**
     * 约定起租日
     */
    @Transient
    public String appointRentDate;

    /**
     * 实际本月计提利息(用来解决月末计提)
     */
    @Transient
    public BigDecimal interActual;

    /**
     * 机构
     */
    public String pkOrg;
    /**
     * 类型
     */
    public String busiType;
    /**
     * 合同类型
     */
    @Transient
    public String contType;
    /**
     * 合同状态
     */
    public String contStatus;

    @Transient
    public String pk;

    @Transient
    public String name;

    @Transient
    public String code;

    public String getName(){
        return null;
    }

    public String getCode(){
        return null;
    }

    public void setName(String name) {
        this.name = null;
    }

    public void setCode(String code) {
        this.code = null;
    }

    public String getPk() {
        return pkAccrual;
    }

    public void setPk(String pk) {
        this.pkAccrual = pk;
    }

    /**
     * 实际本月计提利息(用来解决月末计提)get方法
     */
    public BigDecimal getInterActual() {
        return interActual;
    }
    /**
     * 实际本月计提利息(用来解决月末计提) set方法
     */
    public void setInterActual(BigDecimal interActual) {
        this.interActual = interActual;
    }

    /**
     * 约定起租日get方法
     */
    public String getAppointRentDate() {
        return appointRentDate;
    }

    /**
     * 约定起租日set方法
     */
    public void setAppointRentDate(String appointRentDate) {
        this.appointRentDate = appointRentDate;
    }

    public String getPkAccrual() {
        return pkAccrual;
    }

    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getInter() {
        return inter;
    }

    public void setInter(BigDecimal inter) {
        this.inter = inter;
    }

    public BigDecimal getSrv() {
        return srv;
    }

    public void setSrv(BigDecimal srv) {
        this.srv = srv;
    }

    public BigDecimal getPri() {
        return pri;
    }

    public void setPri(BigDecimal pri) {
        this.pri = pri;
    }

    public BigDecimal getBus() {
        return bus;
    }

    public void setBus(BigDecimal bus) {
        this.bus = bus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public ContractDTO getPkContract() {
        return pkContract;
    }

    public void setPkContract(ContractDTO pkContract) {
        this.pkContract = pkContract;
    }

    public Short getAssetsClassify() {
        return assetsClassify;
    }

    public void setAssetsClassify(Short assetsClassify) {
        this.assetsClassify = assetsClassify;
    }

    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getExchgRate() {
        return exchgRate;
    }

    public void setExchgRate(BigDecimal exchgRate) {
        this.exchgRate = exchgRate;
    }

    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook;
    }

    public String getRealPayDate() {
        return realPayDate;
    }

    public void setRealPayDate(String realPayDate) {
        this.realPayDate = realPayDate;
    }

    public Short getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Short leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    public String getPkLesseeProtocol() {
        return pkLesseeProtocol;
    }

    public void setPkLesseeProtocol(String pkLesseeProtocol) {
        this.pkLesseeProtocol = pkLesseeProtocol;
    }

    public Short getIfBegin() {
        return ifBegin;
    }

    public void setIfBegin(Short ifBegin) {
        this.ifBegin = ifBegin;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getCustomerName() {
        return customerName;
    }

//    public String getPkCustomer() {
//        return pkCustomer;
//    }
//
//    public void setPkCustomer(String pkCustomer) {
//        this.pkCustomer = pkCustomer;
//    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getContType() {
        return contType;
    }

    public void setContType(String contType) {
        this.contType = contType;
    }

    public String getContStatus() {
        return contStatus;
    }

    public void setContStatus(String contStatus) {
        this.contStatus = contStatus;
    }

}
