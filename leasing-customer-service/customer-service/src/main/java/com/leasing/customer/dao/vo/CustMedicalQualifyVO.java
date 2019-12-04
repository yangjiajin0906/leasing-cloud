package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "YLS_MEDICAL_QUALIFY")
public class CustMedicalQualifyVO extends BaseBusinessVO {

    /**
     * 主键
     */
    @Id
    private String pkMedicalQualify;
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;
    private String sourceBill;
    /**
     * 成立时间
     */
    private String buildDate;
    /**
     * 医院类型
     */
    private Short medicalType;
    /**
     * 职工总人数
     */
    private Integer medicalNumber;
    /**
     * 统一社会信用代码
     */
    private String regNumber;
    /**
     * 注册资本
     */
    private BigDecimal regCapital;
    /**
     * 医疗执业许可证
     */
    private String medicalNo;
    /**
     * 医院简介
     */
    private String medicalProfile;
    /**
     * 区域排名
     */
    private String regRanking;
    /**
     * 当地概况
     */
    private String localProfile;
    /**
     * 法人/院长名称
     */
    private String regName;
    /**
     * 法人职务
     */
    private String regJob;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 出生年月
     */
    private String bornDate;
    /**
     * 学历
     */
    private Short regEducation;
    /**
     * 头衔
     */
    private String regTitle;
    /**
     * 所在区域名称
     */
    private String region;
    /**
     * 区域人口数量
     */
    private Integer regionNumber;
    /**
     * 区域GDP
     */
    private BigDecimal regionGdp;
    /**
     * 一般公共预算收入
     */
    @Transient
    private BigDecimal privateBudget;
    /**
     * 其中税收收入
     */
    private BigDecimal revenueTax;
    /**
     * 政府债务余额
     */
    private BigDecimal govBalance;
    /**
     * 上级补助收入
     */
    private BigDecimal superiorSubsidy;
    /**
     * 其中：一般转移支付收入
     */
    private BigDecimal generalTransfer;
    /**
     * 其中：专项转移支付收入
     */
    private BigDecimal specialTransfer;
    /**
     * 政府可支配财力
     */
    private BigDecimal govDisposableFinance;
    /**
     * 地域备注
     */
    private String regionMemo;
    /**
     * 负债余额与财报数据是否符合
     */
    private Short ifAccord;
    /**
     * 不符原因
     */
    private String noaccodrReason;
    /**
     * 是否有欠息、不良或者关注等负面信息
     */
    private Short ifNegative;
    /**
     * 非正常信贷信息内容及原因分析
     */
    private String improperReason;
    /**
     * 法律纠纷及负面信息
     */
    private String negativeReason;
    /**
     * 当地排名
     */
    private String localRanking;
    /**
     * 院长、法人信息表
     */
    @Transient
    private Set medicalPerson;
    /**
     * 医院业务信息表
     */
    @Transient
    private Set medicalBusinfo;
    /**
     * 融资租赁信息表
     */
    @Transient
    private Set medicalFinance;


    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;
    private String checkDate;
    private String checkTime;

    private String memo;

    @Override
    public String getPk() {
        return pkMedicalQualify;
    }

    @Override
    public void setPk(String pk) {
        this.pkMedicalQualify = pk;
    }

    public String getPkMedicalQualify() {
        return pkMedicalQualify;
    }

    public void setPkMedicalQualify(String pkMedicalQualify) {
        this.pkMedicalQualify = pkMedicalQualify;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public Short getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(Short medicalType) {
        this.medicalType = medicalType;
    }

    public Integer getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(Integer medicalNumber) {
        this.medicalNumber = medicalNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public BigDecimal getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(BigDecimal regCapital) {
        this.regCapital = regCapital;
    }

    public String getMedicalNo() {
        return medicalNo;
    }

    public void setMedicalNo(String medicalNo) {
        this.medicalNo = medicalNo;
    }

    public String getMedicalProfile() {
        return medicalProfile;
    }

    public void setMedicalProfile(String medicalProfile) {
        this.medicalProfile = medicalProfile;
    }

    public String getRegRanking() {
        return regRanking;
    }

    public void setRegRanking(String regRanking) {
        this.regRanking = regRanking;
    }

    public String getLocalProfile() {
        return localProfile;
    }

    public void setLocalProfile(String localProfile) {
        this.localProfile = localProfile;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
    }

    public String getRegJob() {
        return regJob;
    }

    public void setRegJob(String regJob) {
        this.regJob = regJob;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public Short getRegEducation() {
        return regEducation;
    }

    public void setRegEducation(Short regEducation) {
        this.regEducation = regEducation;
    }

    public String getRegTitle() {
        return regTitle;
    }

    public void setRegTitle(String regTitle) {
        this.regTitle = regTitle;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRegionNumber() {
        return regionNumber;
    }

    public void setRegionNumber(Integer regionNumber) {
        this.regionNumber = regionNumber;
    }

    public BigDecimal getRegionGdp() {
        return regionGdp;
    }

    public void setRegionGdp(BigDecimal regionGdp) {
        this.regionGdp = regionGdp;
    }

    public BigDecimal getPrivateBudget() {
        return privateBudget;
    }

    public void setPrivateBudget(BigDecimal privateBudget) {
        this.privateBudget = privateBudget;
    }

    public BigDecimal getRevenueTax() {
        return revenueTax;
    }

    public void setRevenueTax(BigDecimal revenueTax) {
        this.revenueTax = revenueTax;
    }

    public BigDecimal getGovBalance() {
        return govBalance;
    }

    public void setGovBalance(BigDecimal govBalance) {
        this.govBalance = govBalance;
    }

    public BigDecimal getSuperiorSubsidy() {
        return superiorSubsidy;
    }

    public void setSuperiorSubsidy(BigDecimal superiorSubsidy) {
        this.superiorSubsidy = superiorSubsidy;
    }

    public BigDecimal getGeneralTransfer() {
        return generalTransfer;
    }

    public void setGeneralTransfer(BigDecimal generalTransfer) {
        this.generalTransfer = generalTransfer;
    }

    public BigDecimal getSpecialTransfer() {
        return specialTransfer;
    }

    public void setSpecialTransfer(BigDecimal specialTransfer) {
        this.specialTransfer = specialTransfer;
    }

    public BigDecimal getGovDisposableFinance() {
        return govDisposableFinance;
    }

    public void setGovDisposableFinance(BigDecimal govDisposableFinance) {
        this.govDisposableFinance = govDisposableFinance;
    }

    public String getRegionMemo() {
        return regionMemo;
    }

    public void setRegionMemo(String regionMemo) {
        this.regionMemo = regionMemo;
    }

    public Short getIfAccord() {
        return ifAccord;
    }

    public void setIfAccord(Short ifAccord) {
        this.ifAccord = ifAccord;
    }

    public String getNoaccodrReason() {
        return noaccodrReason;
    }

    public void setNoaccodrReason(String noaccodrReason) {
        this.noaccodrReason = noaccodrReason;
    }

    public Short getIfNegative() {
        return ifNegative;
    }

    public void setIfNegative(Short ifNegative) {
        this.ifNegative = ifNegative;
    }

    public String getImproperReason() {
        return improperReason;
    }

    public void setImproperReason(String improperReason) {
        this.improperReason = improperReason;
    }

    public String getNegativeReason() {
        return negativeReason;
    }

    public void setNegativeReason(String negativeReason) {
        this.negativeReason = negativeReason;
    }

    public String getLocalRanking() {
        return localRanking;
    }

    public void setLocalRanking(String localRanking) {
        this.localRanking = localRanking;
    }

    public Set getMedicalPerson() {
        return medicalPerson;
    }

    public void setMedicalPerson(Set medicalPerson) {
        this.medicalPerson = medicalPerson;
    }

    public Set getMedicalBusinfo() {
        return medicalBusinfo;
    }

    public void setMedicalBusinfo(Set medicalBusinfo) {
        this.medicalBusinfo = medicalBusinfo;
    }

    public Set getMedicalFinance() {
        return medicalFinance;
    }

    public void setMedicalFinance(Set medicalFinance) {
        this.medicalFinance = medicalFinance;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}