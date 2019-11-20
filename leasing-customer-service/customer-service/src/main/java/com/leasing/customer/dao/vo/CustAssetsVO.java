package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustExternalFinanceDTO;
import com.leasing.common.dto.customer.CustPledgeDTO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_assets")
public class CustAssetsVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkCustAssets;
    /**
     * 合同主键
     */
    private String pkContract;
    /**
     * 唯一标示
     */
    private String onlyMark;

    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 对外抵质押主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustPledge")
    private CustPledgeDTO pkCustPledge;

    /**
     * 其他融资主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustExternalFinance")
    private CustExternalFinanceDTO pkCustExternalFinance;
    /**
     * 权利种类
     */
    @ManyToOne
    @JoinColumn(name = "warrantType")
    private ParameterDTO warrantType;

    /**
     * 使用权人
     */
    private String rightUser;

    /**
     * 发票编号
     */
    private String invoiceNo;

    /**
     * 资产类型
     */
    private Short assetsType;

    /**
     * 不动产分类
     */
    private Short realEstateClass;


    /**
     * 地址
     */
    private String assetsName;


    /**
     * 权证号/机身号
     */
    private String assetsNo;


    /**
     * 面积/数量
     */
    private BigDecimal assetsCount;


    /**
     * 所有权人
     */
    @Transient
    private String ownerPage;

    /**
     * 所有权人
     */
    @ManyToOne
    @JoinColumn(name = "owner")
    private CustomerDTO owner;


    /**
     * 有无抵押
     */
    private Short pledgeStatus;


    /**
     * 采购时间
     */
    private String purchaseDate;


    /**
     * 原值
     */
    private BigDecimal originalValue;


    /**
     * 净值
     */
    private BigDecimal netValue;


    /**
     * 估值
     */
    private BigDecimal estimateValue;

    /**
     * 设备类型
     */
    @ManyToOne
    @JoinColumn(name = "equipmentType")
    private ParameterDTO equipmentType;

    /**
     * 设备生产厂商
     */
    private String equipmentManufacturer;

    /**
     * 建造日期
     */
    private String buildDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 设备分类(银监-大)
     */
    @ManyToOne
    @JoinColumn(name = "equipmentClassBig")
    private ParameterDTO equipmentClassBig;

    /**
     * 设备分类(银监-中)
     */
    @ManyToOne
    @JoinColumn(name = "equipmentClassMid")
    private ParameterDTO equipmentClassMid;

    /**
     * 设备分类(银监-小)
     */
    @ManyToOne
    @JoinColumn(name = "equipmentClassSmall")
    private ParameterDTO equipmentClassSmall;

    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 记账人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 记账日期
     */
    private String operateDate;


    /**
     * 记账时间
     */
    private String operateTime;


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


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;


    /**
     * 抵押权人
     */
    private CustomerDTO mortgagor;

    /**
     * 抵押金额/已为其他债权设定抵押金额
     */
    private BigDecimal mortgageCash;

    /**
     * 抵押权证
     */
    private String mortgageWarrant;

    /**
     * 起始日期
     */
    private String startDate;

    /**
     * 截止日期
     */
    private String endDate;

    /**
     * 抵押(质押)物权属
     */
    private Short mortgageBelong;

    /**
     * 抵押(质押)物是否足值
     */
    private Short mortgageIfSuffice;

    /**
     * 预计损失率
     */
    private BigDecimal loseRatioPre;

    /**
     * 预计押品可回收金额
     */
    private BigDecimal callbackCashPre;

    /**
     * 抵押物名称/设备名称
     */
    private String guaranteeName;

    /**
     * 评估日期
     */
    private String assessDate;

    /**
     * 评估机构
     */
    private String assessOrg;

    /**抵押期限（月）
     *
     */
    private Integer pledgeDeadline;

    /**
     * 其他物件
     */
    private String otherObjects;


    /**
     * 登记机关
     */
    private String regAuthority;


    /**
     * 设备单价（元）
     */
    private BigDecimal equipmentUnitPrice;
    /**
     * 设备总价（元）
     */
    private BigDecimal equipmentSumPrice;

    /**
     * 使用寿命（年）
     */
    private Integer useLife;
    /**
     * 已使用年限（年）
     */
    private Integer usedTerm;

    /**
     * 担保合同编号
     */
    private String assetsConCode;

    public String getPkCustAssets() {
        return pkCustAssets;
    }

    public void setPkCustAssets(String pkCustAssets) {
        this.pkCustAssets = pkCustAssets;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getOnlyMark() {
        return onlyMark;
    }

    public void setOnlyMark(String onlyMark) {
        this.onlyMark = onlyMark;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public CustPledgeDTO getPkCustPledge() {
        return pkCustPledge;
    }

    public void setPkCustPledge(CustPledgeDTO pkCustPledge) {
        this.pkCustPledge = pkCustPledge;
    }

    public CustExternalFinanceDTO getPkCustExternalFinance() {
        return pkCustExternalFinance;
    }

    public void setPkCustExternalFinance(CustExternalFinanceDTO pkCustExternalFinance) {
        this.pkCustExternalFinance = pkCustExternalFinance;
    }

    public ParameterDTO getWarrantType() {
        return warrantType;
    }

    public void setWarrantType(ParameterDTO warrantType) {
        this.warrantType = warrantType;
    }

    public String getRightUser() {
        return rightUser;
    }

    public void setRightUser(String rightUser) {
        this.rightUser = rightUser;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Short getAssetsType() {
        return assetsType;
    }

    public void setAssetsType(Short assetsType) {
        this.assetsType = assetsType;
    }

    public Short getRealEstateClass() {
        return realEstateClass;
    }

    public void setRealEstateClass(Short realEstateClass) {
        this.realEstateClass = realEstateClass;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetsNo() {
        return assetsNo;
    }

    public void setAssetsNo(String assetsNo) {
        this.assetsNo = assetsNo;
    }

    public BigDecimal getAssetsCount() {
        return assetsCount;
    }

    public void setAssetsCount(BigDecimal assetsCount) {
        this.assetsCount = assetsCount;
    }

    public String getOwnerPage() {
        return ownerPage;
    }

    public void setOwnerPage(String ownerPage) {
        this.ownerPage = ownerPage;
    }

    public CustomerDTO getOwner() {
        return owner;
    }

    public void setOwner(CustomerDTO owner) {
        this.owner = owner;
    }

    public Short getPledgeStatus() {
        return pledgeStatus;
    }

    public void setPledgeStatus(Short pledgeStatus) {
        this.pledgeStatus = pledgeStatus;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public BigDecimal getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(BigDecimal originalValue) {
        this.originalValue = originalValue;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getEstimateValue() {
        return estimateValue;
    }

    public void setEstimateValue(BigDecimal estimateValue) {
        this.estimateValue = estimateValue;
    }

    public ParameterDTO getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(ParameterDTO equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentManufacturer() {
        return equipmentManufacturer;
    }

    public void setEquipmentManufacturer(String equipmentManufacturer) {
        this.equipmentManufacturer = equipmentManufacturer;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ParameterDTO getEquipmentClassBig() {
        return equipmentClassBig;
    }

    public void setEquipmentClassBig(ParameterDTO equipmentClassBig) {
        this.equipmentClassBig = equipmentClassBig;
    }

    public ParameterDTO getEquipmentClassMid() {
        return equipmentClassMid;
    }

    public void setEquipmentClassMid(ParameterDTO equipmentClassMid) {
        this.equipmentClassMid = equipmentClassMid;
    }

    public ParameterDTO getEquipmentClassSmall() {
        return equipmentClassSmall;
    }

    public void setEquipmentClassSmall(ParameterDTO equipmentClassSmall) {
        this.equipmentClassSmall = equipmentClassSmall;
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

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public CustomerDTO getMortgagor() {
        return mortgagor;
    }

    public void setMortgagor(CustomerDTO mortgagor) {
        this.mortgagor = mortgagor;
    }

    public BigDecimal getMortgageCash() {
        return mortgageCash;
    }

    public void setMortgageCash(BigDecimal mortgageCash) {
        this.mortgageCash = mortgageCash;
    }

    public String getMortgageWarrant() {
        return mortgageWarrant;
    }

    public void setMortgageWarrant(String mortgageWarrant) {
        this.mortgageWarrant = mortgageWarrant;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Short getMortgageBelong() {
        return mortgageBelong;
    }

    public void setMortgageBelong(Short mortgageBelong) {
        this.mortgageBelong = mortgageBelong;
    }

    public Short getMortgageIfSuffice() {
        return mortgageIfSuffice;
    }

    public void setMortgageIfSuffice(Short mortgageIfSuffice) {
        this.mortgageIfSuffice = mortgageIfSuffice;
    }

    public BigDecimal getLoseRatioPre() {
        return loseRatioPre;
    }

    public void setLoseRatioPre(BigDecimal loseRatioPre) {
        this.loseRatioPre = loseRatioPre;
    }

    public BigDecimal getCallbackCashPre() {
        return callbackCashPre;
    }

    public void setCallbackCashPre(BigDecimal callbackCashPre) {
        this.callbackCashPre = callbackCashPre;
    }

    public String getGuaranteeName() {
        return guaranteeName;
    }

    public void setGuaranteeName(String guaranteeName) {
        this.guaranteeName = guaranteeName;
    }

    public String getAssessDate() {
        return assessDate;
    }

    public void setAssessDate(String assessDate) {
        this.assessDate = assessDate;
    }

    public String getAssessOrg() {
        return assessOrg;
    }

    public void setAssessOrg(String assessOrg) {
        this.assessOrg = assessOrg;
    }

    public Integer getPledgeDeadline() {
        return pledgeDeadline;
    }

    public void setPledgeDeadline(Integer pledgeDeadline) {
        this.pledgeDeadline = pledgeDeadline;
    }

    public String getOtherObjects() {
        return otherObjects;
    }

    public void setOtherObjects(String otherObjects) {
        this.otherObjects = otherObjects;
    }

    public String getRegAuthority() {
        return regAuthority;
    }

    public void setRegAuthority(String regAuthority) {
        this.regAuthority = regAuthority;
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

    public Integer getUseLife() {
        return useLife;
    }

    public void setUseLife(Integer useLife) {
        this.useLife = useLife;
    }

    public Integer getUsedTerm() {
        return usedTerm;
    }

    public void setUsedTerm(Integer usedTerm) {
        this.usedTerm = usedTerm;
    }

    public String getAssetsConCode() {
        return assetsConCode;
    }

    public void setAssetsConCode(String assetsConCode) {
        this.assetsConCode = assetsConCode;
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