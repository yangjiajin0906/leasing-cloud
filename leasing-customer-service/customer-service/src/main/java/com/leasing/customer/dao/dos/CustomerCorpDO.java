package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户
 **/
@Entity
@Table(name = "yls_customer_corp")
public class CustomerCorpDO extends BaseDO {

    /**
     * 企业客户主键
     */
    @Id
    private String pkCustomerCorp;

    private String pkCustomer;

    /**
     * 版本号
     */
    private Integer versionNumCorp;


    /**
     * 客户性质
     */

    private String customerProperty;
    /**
     * 客户性质(内部)
     */
    private String customerPropertyIn;


    /**
     * 经济性质
     */
    private String economicType;


    /**
     * 注册地址
     */
    private String regAddress;


    /**
     * 区域
     */
    private String region;


    /**
     * 行业类别
     */
    private String industryType;


    /**
     * 二级行业类别
     */
    private String industryType1;


    /**
     * 行业门类
     */
    private String industry;


    /**
     * 行业门类（大类）
     */
    private String industry1;


    /**
     * 行业门类（中类）
     */
    private String industry2;


    /**
     * 行业门类（小类）
     */
    private String industry3;


    /**
     * 从业人数
     */
    private Integer employeeNum;


    /**
     * 资产总额
     */
    private BigDecimal assetsTotal;


    /**
     * 营业收入
     */
    private BigDecimal operatingIncome;


    /**
     * 学校等级
     */
    private Short schoolGrade;


    /**
     * 医院等级
     */
    private Short hospitalGrade;


    /**
     * 企业规模（内部管理）
     */
    private Short enterScaleInner;


    /**
     * 企业规模（人行）
     */
    private Short enterScalePbc;


    /**
     * 企业规模（六部委）
     */
    @Column(name = "enter_scale_6m")
    private Short enterScale6m;


    /**
     * 有效期:自
     */
    private String startDateIdentity;


    /**
     * 至
     */
    private String endDateIdentity;


    /**
     * 最新年检日期
     */
    private String recentInspectDate;


    /**
     * 贷款卡号
     */
    private String loanCardNo;


    /**
     * 贷款卡是否有效
     */
    private Short ifValidLc;


    /**
     * 贷款卡最新年审时间
     */
    private String recentInspectDateLc;


    /**
     * 贷款卡最新年审结果
     */
    private Short recentInspectResultLc;


    /**
     * 营业执照号码
     */
    private String licenseNo;

    /**
     * 法定代表人编号
     */
    private String pkCustomerPerson;

    /**
     * 实际控制人
     */
    private String actualControl;

    /**
     * 法定代表人(文本类型)
     */
    private String legalRepresentative;

    /**
     * 实际控制人(文本类型)
     */
    private String actualController;


    /**
     * 注册资本币种
     */
    private String capitalCur;


    /**
     * 注册资本
     */
    private BigDecimal capital;


    /**
     * 实收资本币种
     */
    private String capitalCurPaidin;


    /**
     * 实收资本
     */
    private BigDecimal capitalPaidin;


    /**
     * 营业执照登记日
     */
    private String startDateLicense;


    /**
     * 营业执照到期日
     */
    private String endDateLicense;


    /**
     * 营业执照最新年审日
     */
    private String recentInspectDateLicense;


    /**
     * 成立日期
     */
    private String establishDate;


    /**
     * 经营范围（限200个汉字）
     */
    private String bussinessScope;


    /**
     * 主营业务（限200个汉字）
     */
    private String primaryBussiness;


    /**
     * 税务登记证号（国税）
     */
    private String nationalTax;


    /**
     * 税务登记证号（地税）
     */
    private String landTax;


    /**
     * 是否集团公司（母公司）
     */
    private Short ifGroupCompany;


    /**
     * 有无进出口经营
     */
    private Short ifImportExport;


    /**
     * 是否上市公司
     */
    private Short ifListedCompany;


    /**
     * 是否政府融资背景
     */
    private Short ifGovPlatform;


    /**
     * 是否人民银行认定平台
     */
    private Short ifPbcPlatform;


    /**
     * 是否银监会认定平台
     */
    private Short ifCbrcPlatform;

    /**
     * 是否江苏省银监局平台
     */
    private Short ifJscbrcPlatform;


    /**
     * 是否环保行业企业
     */
    private Short ifEnvironmentalCorp;


    /**
     * 是否重点监测客户
     */
    private Short ifImportantCorp;


    /**
     * 是否科技型企业
     */
    private Short ifTechnicalCorp;


    /**
     * 所在国家（地区）
     */
    private String country;


    /**
     * 注册地隶属
     */
    private Short regAddressMembership;


    /**
     * 地区（省）
     */
    private String province;


    /**
     * 地区（市）
     */
    private String city;

    /**
     * 地区（县/区）
     */
    private String district;


    /**
     * 实际告知地址
     */
    private String informAddress;


    /**
     * 实际告知地址邮编
     */
    private String informAddressZip;


    /**
     * 通讯地址
     */
    private String commAddress;


    /**
     * 通讯地址邮编
     */
    private String commAddressZip;


    /**
     * 实际办公地址
     */
    private String officeAddress;


    /**
     * 实际办公地址邮编
     */
    private String officeAddressZip;


    /**
     * 实际办公地所有权
     */
    private Short officeOwnership;


    /**
     * 备注
     */
    private String remarks;


    /**
     * 客户洗钱风险评级
     */
    private Short enterRating;


    /**
     * 公司网址
     */
    private String companyWebsite;


    /**
     * 传真
     */
    private String fax;


    /**
     * 公司邮箱
     */
    private String companyMailbox;


    /**
     * 科技型企业类型
     */
    private Short technicalType;

    /**
     * 电话
     */
    private String phone;


    /**
     * 客户号
     */
    private String customerNo;


    /**
     * 客户简称
     */
    private String customerShort;


    /**
     * 客户类型
     */
    private String cusotmerClass;


    /**
     * 隶属
     */
    private Short subjection;


    /**
     * 称号
     */
    private Short title;


    /**
     * 财务相关
     */
    private String financeRelated;


    /**
     * 设备相关
     */
    private String equipmentRelated;


    /**
     * 其他部门
     */
    private String otherDept;


    /**
     * 政府相关
     */
    private String governmentRelated;


    /**
     * 政府财政相关
     */
    private String governFinanceRelated;


    /**
     * 政府其他部门
     */
    private String governOtherSectors;

    /**
     * 是否财政
     */
    private Short ifFinance;

    /**
     * 快递公司
     */
    private String expressCompany;

    /**
     * 开票说明
     */
    private String invoiceExplain;


    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    private Short regNumberType;


    /**
     * 注册登记号码   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    private String regNumber;


    public String getPkCustomerCorp() {
        return pkCustomerCorp;
    }

    public void setPkCustomerCorp(String pkCustomerCorp) {
        this.pkCustomerCorp = pkCustomerCorp;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Integer getVersionNumCorp() {
        return versionNumCorp;
    }

    public void setVersionNumCorp(Integer versionNumCorp) {
        this.versionNumCorp = versionNumCorp;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    public String getCustomerPropertyIn() {
        return customerPropertyIn;
    }

    public void setCustomerPropertyIn(String customerPropertyIn) {
        this.customerPropertyIn = customerPropertyIn;
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getIndustryType1() {
        return industryType1;
    }

    public void setIndustryType1(String industryType1) {
        this.industryType1 = industryType1;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getIndustry1() {
        return industry1;
    }

    public void setIndustry1(String industry1) {
        this.industry1 = industry1;
    }

    public String getIndustry2() {
        return industry2;
    }

    public void setIndustry2(String industry2) {
        this.industry2 = industry2;
    }

    public String getIndustry3() {
        return industry3;
    }

    public void setIndustry3(String industry3) {
        this.industry3 = industry3;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public BigDecimal getAssetsTotal() {
        return assetsTotal;
    }

    public void setAssetsTotal(BigDecimal assetsTotal) {
        this.assetsTotal = assetsTotal;
    }

    public BigDecimal getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(BigDecimal operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    public Short getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(Short schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    public Short getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(Short hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    public Short getEnterScaleInner() {
        return enterScaleInner;
    }

    public void setEnterScaleInner(Short enterScaleInner) {
        this.enterScaleInner = enterScaleInner;
    }

    public Short getEnterScalePbc() {
        return enterScalePbc;
    }

    public void setEnterScalePbc(Short enterScalePbc) {
        this.enterScalePbc = enterScalePbc;
    }

    public Short getEnterScale6m() {
        return enterScale6m;
    }

    public void setEnterScale6m(Short enterScale6m) {
        this.enterScale6m = enterScale6m;
    }

    public String getStartDateIdentity() {
        return startDateIdentity;
    }

    public void setStartDateIdentity(String startDateIdentity) {
        this.startDateIdentity = startDateIdentity;
    }

    public String getEndDateIdentity() {
        return endDateIdentity;
    }

    public void setEndDateIdentity(String endDateIdentity) {
        this.endDateIdentity = endDateIdentity;
    }

    public String getRecentInspectDate() {
        return recentInspectDate;
    }

    public void setRecentInspectDate(String recentInspectDate) {
        this.recentInspectDate = recentInspectDate;
    }

    public String getLoanCardNo() {
        return loanCardNo;
    }

    public void setLoanCardNo(String loanCardNo) {
        this.loanCardNo = loanCardNo;
    }

    public Short getIfValidLc() {
        return ifValidLc;
    }

    public void setIfValidLc(Short ifValidLc) {
        this.ifValidLc = ifValidLc;
    }

    public String getRecentInspectDateLc() {
        return recentInspectDateLc;
    }

    public void setRecentInspectDateLc(String recentInspectDateLc) {
        this.recentInspectDateLc = recentInspectDateLc;
    }

    public Short getRecentInspectResultLc() {
        return recentInspectResultLc;
    }

    public void setRecentInspectResultLc(Short recentInspectResultLc) {
        this.recentInspectResultLc = recentInspectResultLc;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getPkCustomerPerson() {
        return pkCustomerPerson;
    }

    public void setPkCustomerPerson(String pkCustomerPerson) {
        this.pkCustomerPerson = pkCustomerPerson;
    }

    public String getActualControl() {
        return actualControl;
    }

    public void setActualControl(String actualControl) {
        this.actualControl = actualControl;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getActualController() {
        return actualController;
    }

    public void setActualController(String actualController) {
        this.actualController = actualController;
    }

    public String getCapitalCur() {
        return capitalCur;
    }

    public void setCapitalCur(String capitalCur) {
        this.capitalCur = capitalCur;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public String getCapitalCurPaidin() {
        return capitalCurPaidin;
    }

    public void setCapitalCurPaidin(String capitalCurPaidin) {
        this.capitalCurPaidin = capitalCurPaidin;
    }

    public BigDecimal getCapitalPaidin() {
        return capitalPaidin;
    }

    public void setCapitalPaidin(BigDecimal capitalPaidin) {
        this.capitalPaidin = capitalPaidin;
    }

    public String getStartDateLicense() {
        return startDateLicense;
    }

    public void setStartDateLicense(String startDateLicense) {
        this.startDateLicense = startDateLicense;
    }

    public String getEndDateLicense() {
        return endDateLicense;
    }

    public void setEndDateLicense(String endDateLicense) {
        this.endDateLicense = endDateLicense;
    }

    public String getRecentInspectDateLicense() {
        return recentInspectDateLicense;
    }

    public void setRecentInspectDateLicense(String recentInspectDateLicense) {
        this.recentInspectDateLicense = recentInspectDateLicense;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public String getBussinessScope() {
        return bussinessScope;
    }

    public void setBussinessScope(String bussinessScope) {
        this.bussinessScope = bussinessScope;
    }

    public String getPrimaryBussiness() {
        return primaryBussiness;
    }

    public void setPrimaryBussiness(String primaryBussiness) {
        this.primaryBussiness = primaryBussiness;
    }

    public String getNationalTax() {
        return nationalTax;
    }

    public void setNationalTax(String nationalTax) {
        this.nationalTax = nationalTax;
    }

    public String getLandTax() {
        return landTax;
    }

    public void setLandTax(String landTax) {
        this.landTax = landTax;
    }

    public Short getIfGroupCompany() {
        return ifGroupCompany;
    }

    public void setIfGroupCompany(Short ifGroupCompany) {
        this.ifGroupCompany = ifGroupCompany;
    }

    public Short getIfImportExport() {
        return ifImportExport;
    }

    public void setIfImportExport(Short ifImportExport) {
        this.ifImportExport = ifImportExport;
    }

    public Short getIfListedCompany() {
        return ifListedCompany;
    }

    public void setIfListedCompany(Short ifListedCompany) {
        this.ifListedCompany = ifListedCompany;
    }

    public Short getIfGovPlatform() {
        return ifGovPlatform;
    }

    public void setIfGovPlatform(Short ifGovPlatform) {
        this.ifGovPlatform = ifGovPlatform;
    }

    public Short getIfPbcPlatform() {
        return ifPbcPlatform;
    }

    public void setIfPbcPlatform(Short ifPbcPlatform) {
        this.ifPbcPlatform = ifPbcPlatform;
    }

    public Short getIfCbrcPlatform() {
        return ifCbrcPlatform;
    }

    public void setIfCbrcPlatform(Short ifCbrcPlatform) {
        this.ifCbrcPlatform = ifCbrcPlatform;
    }

    public Short getIfJscbrcPlatform() {
        return ifJscbrcPlatform;
    }

    public void setIfJscbrcPlatform(Short ifJscbrcPlatform) {
        this.ifJscbrcPlatform = ifJscbrcPlatform;
    }

    public Short getIfEnvironmentalCorp() {
        return ifEnvironmentalCorp;
    }

    public void setIfEnvironmentalCorp(Short ifEnvironmentalCorp) {
        this.ifEnvironmentalCorp = ifEnvironmentalCorp;
    }

    public Short getIfImportantCorp() {
        return ifImportantCorp;
    }

    public void setIfImportantCorp(Short ifImportantCorp) {
        this.ifImportantCorp = ifImportantCorp;
    }

    public Short getIfTechnicalCorp() {
        return ifTechnicalCorp;
    }

    public void setIfTechnicalCorp(Short ifTechnicalCorp) {
        this.ifTechnicalCorp = ifTechnicalCorp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Short getRegAddressMembership() {
        return regAddressMembership;
    }

    public void setRegAddressMembership(Short regAddressMembership) {
        this.regAddressMembership = regAddressMembership;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getInformAddress() {
        return informAddress;
    }

    public void setInformAddress(String informAddress) {
        this.informAddress = informAddress;
    }

    public String getInformAddressZip() {
        return informAddressZip;
    }

    public void setInformAddressZip(String informAddressZip) {
        this.informAddressZip = informAddressZip;
    }

    public String getCommAddress() {
        return commAddress;
    }

    public void setCommAddress(String commAddress) {
        this.commAddress = commAddress;
    }

    public String getCommAddressZip() {
        return commAddressZip;
    }

    public void setCommAddressZip(String commAddressZip) {
        this.commAddressZip = commAddressZip;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getOfficeAddressZip() {
        return officeAddressZip;
    }

    public void setOfficeAddressZip(String officeAddressZip) {
        this.officeAddressZip = officeAddressZip;
    }

    public Short getOfficeOwnership() {
        return officeOwnership;
    }

    public void setOfficeOwnership(Short officeOwnership) {
        this.officeOwnership = officeOwnership;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Short getEnterRating() {
        return enterRating;
    }

    public void setEnterRating(Short enterRating) {
        this.enterRating = enterRating;
    }

    public String getCompanyWebsite() {
        return companyWebsite;
    }

    public void setCompanyWebsite(String companyWebsite) {
        this.companyWebsite = companyWebsite;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyMailbox() {
        return companyMailbox;
    }

    public void setCompanyMailbox(String companyMailbox) {
        this.companyMailbox = companyMailbox;
    }

    public Short getTechnicalType() {
        return technicalType;
    }

    public void setTechnicalType(Short technicalType) {
        this.technicalType = technicalType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerShort() {
        return customerShort;
    }

    public void setCustomerShort(String customerShort) {
        this.customerShort = customerShort;
    }

    public String getCusotmerClass() {
        return cusotmerClass;
    }

    public void setCusotmerClass(String cusotmerClass) {
        this.cusotmerClass = cusotmerClass;
    }

    public Short getSubjection() {
        return subjection;
    }

    public void setSubjection(Short subjection) {
        this.subjection = subjection;
    }

    public Short getTitle() {
        return title;
    }

    public void setTitle(Short title) {
        this.title = title;
    }

    public String getFinanceRelated() {
        return financeRelated;
    }

    public void setFinanceRelated(String financeRelated) {
        this.financeRelated = financeRelated;
    }

    public String getEquipmentRelated() {
        return equipmentRelated;
    }

    public void setEquipmentRelated(String equipmentRelated) {
        this.equipmentRelated = equipmentRelated;
    }

    public String getOtherDept() {
        return otherDept;
    }

    public void setOtherDept(String otherDept) {
        this.otherDept = otherDept;
    }

    public String getGovernmentRelated() {
        return governmentRelated;
    }

    public void setGovernmentRelated(String governmentRelated) {
        this.governmentRelated = governmentRelated;
    }

    public String getGovernFinanceRelated() {
        return governFinanceRelated;
    }

    public void setGovernFinanceRelated(String governFinanceRelated) {
        this.governFinanceRelated = governFinanceRelated;
    }

    public String getGovernOtherSectors() {
        return governOtherSectors;
    }

    public void setGovernOtherSectors(String governOtherSectors) {
        this.governOtherSectors = governOtherSectors;
    }

    public Short getIfFinance() {
        return ifFinance;
    }

    public void setIfFinance(Short ifFinance) {
        this.ifFinance = ifFinance;
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany;
    }

    public String getInvoiceExplain() {
        return invoiceExplain;
    }

    public void setInvoiceExplain(String invoiceExplain) {
        this.invoiceExplain = invoiceExplain;
    }

    public Short getRegNumberType() {
        return regNumberType;
    }

    public void setRegNumberType(Short regNumberType) {
        this.regNumberType = regNumberType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}