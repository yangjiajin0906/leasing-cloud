package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_assets")
public class CustAssetsDO extends BaseDO {


    /**
     * 主键
     */
    @Id
    private String pkCustAssets;

    private Short pledgeStatus;

    private String mortgageWarrant;

    private String endDate;

    private String assessOrg;

    private String operateTime;

    private Short useLife;

    private Short usedTerm;

    private Short pledgeDeadline;

    private String mortgagor;

    private String invoiceNo;

    private String equipmentClassSmall;

    private String equipmentClassBig;

    private Short assetsType;

    private BigDecimal mortgageCash;

    private Short billstatus;

    private BigDecimal netValue;

    private String assetsConCode;

    private BigDecimal originalValue;

    private String grantDate;

    private String warrantType;

    private String pkCustPledge;

    private BigDecimal equipmentUnitPrice;

    private BigDecimal equipmentSumPrice;

    private BigDecimal loseRatioPre;

    private Short mortgageIfSuffice;

    private String onlyMark;

    private String checkTime;

    private String pkOrg;

    private BigDecimal callbackCashPre;

    private String pkCustExternalFinance;

    private String operateDate;

    private Short mortgageBelong;

    private String startDate;

    private String pkChecker;

    private String purchaseDate;

    private String grantTime;

    private String regAuthority;

    private String remark;

    private String buildDate;

    private String pkCustomer;

    private String equipmentType;

    private String equipmentClassMid;

    private String assetsName;

    private Short collateralState;

    private Short realEstateClass;

    private String owner;

    private BigDecimal assetsCount;

    private BigDecimal estimateValue;

    private String assetsNo;

    private String pkContract;

    private String guaranteeName;

    private String otherObjects;

    private String checkDate;

    private String equipmentManufacturer;

    private String assessDate;

    private String rightUser;

    private String pkOperator;

    private String pkGrantor;

    public String getPkCustAssets() {
        return pkCustAssets;
    }

    public void setPkCustAssets(String pkCustAssets) {
        this.pkCustAssets = pkCustAssets;
    }

    public Short getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(Short pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }

    public String getMortgageWarrant() {
        return mortgageWarrant;
    }

    public void setMortgageWarrant(String mortgageWarrant) {
        this.mortgageWarrant = mortgageWarrant;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAssessOrg() {
        return assessOrg;
    }

    public void setAssessOrg(String assessOrg) {
        this.assessOrg = assessOrg;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public Short getUseLife() {
        return useLife;
    }

    public void setUseLife(Short useLife) {
        this.useLife = useLife;
    }

    public Short getUsedTerm() {
        return usedTerm;
    }

    public void setUsedTerm(Short usedTerm) {
        this.usedTerm = usedTerm;
    }

    public Short getPledgeDeadline() {
        return pledgeDeadline;
    }

    public void setPledgeDeadline(Short pledgeDeadline) {
        this.pledgeDeadline = pledgeDeadline;
    }

    public String getMortgagor() {
        return mortgagor;
    }

    public void setMortgagor(String mortgagor) {
        this.mortgagor = mortgagor;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getEquipmentClassSmall() {
        return equipmentClassSmall;
    }

    public void setEquipmentClassSmall(String equipmentClassSmall) {
        this.equipmentClassSmall = equipmentClassSmall;
    }

    public String getEquipmentClassBig() {
        return equipmentClassBig;
    }

    public void setEquipmentClassBig(String equipmentClassBig) {
        this.equipmentClassBig = equipmentClassBig;
    }

    public Short getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(Short assetsType) {
        this.assetsType = assetsType;
    }

    public BigDecimal getMortgageCash() {
        return mortgageCash;
    }

    public void setMortgageCash(BigDecimal mortgageCash) {
        this.mortgageCash = mortgageCash;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public String getAssetsConCode() {
        return assetsConCode;
    }

    public void setAssetsConCode(String assetsConCode) {
        this.assetsConCode = assetsConCode;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getWarrantType() {
        return warrantType;
    }

    public void setWarrantType(String warrantType) {
        this.warrantType = warrantType;
    }

    public String getPkCustPledge() {
        return pkCustPledge;
    }

    public void setPkCustPledge(String pkCustPledge) {
        this.pkCustPledge = pkCustPledge;
    }

    public BigDecimal getEquipmentUnitPrice() {
        return equipmentUnitPrice;
    }

    public void setEquipmentUnitPrice(BigDecimal equipmentUnitPrice) {
        this.equipmentUnitPrice = equipmentUnitPrice;
    }

    public BigDecimal getEquipmentSumPrice() {
        return equipmentSumPrice;
    }

    public void setEquipmentSumPrice(BigDecimal equipmentSumPrice) {
        this.equipmentSumPrice = equipmentSumPrice;
    }

    public BigDecimal getLoseRatioPre() {
        return loseRatioPre;
    }

    public void setLoseRatioPre(BigDecimal loseRatioPre) {
        this.loseRatioPre = loseRatioPre;
    }

    public Short getMortgageIfSuffice() {
        return mortgageIfSuffice;
    }

    public void setMortgageIfSuffice(Short mortgageIfSuffice) {
        this.mortgageIfSuffice = mortgageIfSuffice;
    }

    public String getOnlyMark() {
        return onlyMark;
    }

    public void setOnlyMark(String onlyMark) {
        this.onlyMark = onlyMark;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public BigDecimal getCallbackCashPre() {
        return callbackCashPre;
    }

    public void setCallbackCashPre(BigDecimal callbackCashPre) {
        this.callbackCashPre = callbackCashPre;
    }

    public String getPkCustExternalFinance() {
        return pkCustExternalFinance;
    }

    public void setPkCustExternalFinance(String pkCustExternalFinance) {
        this.pkCustExternalFinance = pkCustExternalFinance;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public Short getMortgageBelong() {
        return mortgageBelong;
    }

    public void setMortgageBelong(Short mortgageBelong) {
        this.mortgageBelong = mortgageBelong;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(String pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getRegAuthority() {
        return regAuthority;
    }

    public void setRegAuthority(String regAuthority) {
        this.regAuthority = regAuthority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentClassMid() {
        return equipmentClassMid;
    }

    public void setEquipmentClassMid(String equipmentClassMid) {
        this.equipmentClassMid = equipmentClassMid;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public Short getCollateralState() {
        return collateralState;
    }

    public void setCollateralState(Short collateralState) {
        this.collateralState = collateralState;
    }

    public Short getRealEstateClass() {
        return realEstateClass;
    }

    public void setRealEstateClass(Short realEstateClass) {
        this.realEstateClass = realEstateClass;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getAssetsCount() {
        return assetsCount;
    }

    public void setAssetsCount(BigDecimal assetsCount) {
        this.assetsCount = assetsCount;
    }

    public BigDecimal getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(BigDecimal estimateValue) {
        this.estimateValue = estimateValue;
    }

    public String getAssetsNo() {
        return assetsNo;
    }

    public void setAssetsNo(String assetsNo) {
        this.assetsNo = assetsNo;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public String getOtherObjects() {
        return otherObjects;
    }

    public void setOtherObjects(String otherObjects) {
        this.otherObjects = otherObjects;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getEquipmentManufacturer() {
        return equipmentManufacturer;
    }

    public void setEquipmentManufacturer(String equipmentManufacturer) {
        this.equipmentManufacturer = equipmentManufacturer;
    }

    public String getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(String assessDate) {
        this.assessDate = assessDate;
    }

    public String getRightUser() {
        return rightUser;
    }

    public void setRightUser(String rightUser) {
        this.rightUser = rightUser;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(String pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    @Override
    public String getPk() {
        return pkCustAssets;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustAssets = pk;
    }
}