package com.leasing.customer_service.pojo;

import com.leasing.customer_service.pojo.ref.*;
import com.leasing.customer_service.utils.BaseQuery;
import com.leasing.customer_service.utils.MatchType;
import com.leasing.customer_service.utils.QueryCondition;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer")
@SecondaryTable(name = "yls_customer_corp", pkJoinColumns =
        {@PrimaryKeyJoinColumn(name = "pkCustomer", referencedColumnName = "pkCustomer")})
@Where(clause = "customer_type = 0 and if_new = 0")
public class CustomerCorpVO extends BaseQuery<CustomerCorpVO> implements Serializable {

    /**
     * 企业客户主键
     */

//    @Column(name = "yls_customer_corp", table = "yls_customer_corp")
//    public String pk_customer_corp;

    @Id
    public String pkCustomer;

    /**
     * 版本号
     */
    @Column(table = "yls_customer_corp")
    public Integer versionNumCorp;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customerProperty",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO customerProperty;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customerPropertyIn",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO customerPropertyIn;

    /**
     * 经济性质
     */
    @ManyToOne
    @JoinColumn(name="economicType",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO economicType;


    /**
     * 注册地址
     */
    @Column(table = "yls_customer_corp")
    public String regAddress;


    /**
     * 区域
     */
    @ManyToOne
    @JoinColumn(name="region",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO region;


    /**
     * 行业类别
     */
    @ManyToOne
    @JoinColumn(name="industryType",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industryType;


    /**
     * 二级行业类别
     */
    @ManyToOne
    @JoinColumn(name="industryType1",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industryType1;


    /**
     * 行业门类
     */
    @ManyToOne
    @JoinColumn(name="industry",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industry;


    /**
     * 行业门类（大类）
     */
    @ManyToOne
    @JoinColumn(name="industry1",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industry1;


    /**
     * 行业门类（中类）
     */
    @ManyToOne
    @JoinColumn(name="industry2",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industry2;


    /**
     * 行业门类（小类）
     */
    @ManyToOne
    @JoinColumn(name="industry3",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO industry3;


    /**
     * 从业人数
     */
    @Column(table = "yls_customer_corp")
    public Integer employeeNum;


    /**
     * 资产总额
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal assetsTotal;


    /**
     * 营业收入
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal operatingIncome;


    /**
     * 学校等级
     */
    @Column(table = "yls_customer_corp")
    public Short schoolGrade;


    /**
     * 医院等级
     */
    @Column(table = "yls_customer_corp")
    public Short hospitalGrade;


    /**
     * 企业规模（内部管理）
     */
    @Column(table = "yls_customer_corp")
    public Short enterScaleInner;


    /**
     * 企业规模（人行）
     */
    @Column(table = "yls_customer_corp")
    public Short enterScalePbc;


    /**
     * 企业规模（六部委）
     */
    @Column(name = "enter_scale_6m", table = "yls_customer_corp")
    public Short enterScale6m;


    /**
     * 有效期:自
     */
    @Column(table = "yls_customer_corp")
    public String startDateIdentity;


    /**
     * 至
     */
    @Column(table = "yls_customer_corp")
    public String endDateIdentity;


    /**
     * 最新年检日期
     */
    @Column(table = "yls_customer_corp")
    public String recentInspectDate;


    /**
     * 贷款卡号
     */
    @Column(table = "yls_customer_corp")
    public String loanCardNo;


    /**
     * 贷款卡是否有效
     */
    @Column(table = "yls_customer_corp")
    public Short ifValidLc;


    /**
     * 贷款卡最新年审时间
     */
    @Column(table = "yls_customer_corp")
    public String recentInspectDateLc;


    /**
     * 贷款卡最新年审结果
     */
    @Column(table = "yls_customer_corp")
    public Short recentInspectResultLc;


    /**
     * 营业执照号码
     */
    @Column(table = "yls_customer_corp")
    public String licenseNo;

    /**
     * 法定代表人编号
     */
//    public CustomerPersonRefVO pkCustomerPerson;

    /**
     * 实际控制人
     */
//    public CustomerRefVO actualControl;

    /**
     * 法定代表人(文本类型)
     */
    @Column(table = "yls_customer_corp")
    public String legalRepresentative;

    /**
     * 实际控制人(文本类型)
     */
    @Column(table = "yls_customer_corp")
    public String actualController;


    /**
     * 注册资本币种
     */
    @ManyToOne
    @JoinColumn(name = "capitalCur", referencedColumnName = "pkCurrtype", table = "yls_customer_corp")
    public CurrtypeRefVO capitalCur;


    /**
     * 注册资本
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal capital;


    /**
     * 实收资本币种
     */

    @ManyToOne
    @JoinColumn(name = "capitalCurPaidin", referencedColumnName = "pkCurrtype", table = "yls_customer_corp")
    public CurrtypeRefVO capitalCurPaidin;


    /**
     * 实收资本
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal capitalPaidin;


    /**
     * 营业执照登记日
     */
    @Column(table = "yls_customer_corp")
    public String startDateLicense;


    /**
     * 营业执照到期日
     */
    @Column(table = "yls_customer_corp")
    public String endDateLicense;


    /**
     * 营业执照最新年审日
     */
    @Column(table = "yls_customer_corp")
    public String recentInspectDateLicense;


    /**
     * 成立日期
     */
    @Column(table = "yls_customer_corp")
    public String establishDate;


    /**
     * 经营范围（限200个汉字）
     */
    @Column(table = "yls_customer_corp")
    public String bussinessScope;


    /**
     * 主营业务（限200个汉字）
     */
    @Column(table = "yls_customer_corp")
    public String primaryBussiness;


    /**
     * 税务登记证号（国税）
     */
    @Column(table = "yls_customer_corp")
    public String nationalTax;


    /**
     * 税务登记证号（地税）
     */
    @Column(table = "yls_customer_corp")
    public String landTax;


    /**
     * 是否集团公司（母公司）
     */
    @Column(table = "yls_customer_corp")
    public Short ifGroupCompany;


    /**
     * 有无进出口经营
     */
    @Column(table = "yls_customer_corp")
    public Short ifImportExport;


    /**
     * 是否上市公司
     */
    @Column(table = "yls_customer_corp")
    public Short ifListedCompany;


    /**
     * 是否政府融资背景
     */
    @Column(table = "yls_customer_corp")
    public Short ifGovPlatform;


    /**
     * 是否人民银行认定平台
     */
    @Column(table = "yls_customer_corp")
    public Short ifPbcPlatform;


    /**
     * 是否银监会认定平台
     */
    @Column(table = "yls_customer_corp")
    public Short ifCbrcPlatform;

    /**
     * 是否江苏省银监局平台
     */
    @Column(table = "yls_customer_corp")
    public Short ifJscbrcPlatform;


    /**
     * 是否环保行业企业
     */
    @Column(table = "yls_customer_corp")
    public Short ifEnvironmentalCorp;


    /**
     * 是否重点监测客户
     */
    @Column(table = "yls_customer_corp")
    public Short ifImportantCorp;


    /**
     * 是否科技型企业
     */
    @Column(table = "yls_customer_corp")
    public Short ifTechnicalCorp;


    /**
     * 所在国家（地区）
     */
    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "pkParameter", table = "yls_customer_corp")
    public ParmsRefVO country;


    /**
     * 注册地隶属
     */
    @Column(table = "yls_customer_corp")
    public Short regAddressMembership;


    /**
     * 地区（省）
     */
    @ManyToOne
    @JoinColumn(name = "province", referencedColumnName = "pkAreacl", table = "yls_customer_corp")
    public AreaclRefVO province;


    /**
     * 地区（市）
     */
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "pkAreacl", table = "yls_customer_corp")
    public AreaclRefVO city;

    /**
     * 地区（县/区）
     */
    @ManyToOne
    @JoinColumn(name = "district", referencedColumnName = "pkAreacl", table = "yls_customer_corp")
    public AreaclRefVO district;


    /**
     * 实际告知地址
     */
    @Column(table = "yls_customer_corp")
    public String informAddress;


    /**
     * 实际告知地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String informAddressZip;


    /**
     * 通讯地址
     */
    @Column(table = "yls_customer_corp")
    public String commAddress;


    /**
     * 通讯地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String commAddressZip;


    /**
     * 实际办公地址
     */
    @Column(table = "yls_customer_corp")
    public String officeAddress;


    /**
     * 实际办公地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String officeAddressZip;


    /**
     * 实际办公地所有权
     */
    @Column(table = "yls_customer_corp")
    public Short officeOwnership;


    /**
     * 备注
     */
    @Column(table = "yls_customer_corp")
    public String remarks;


    /**
     * 客户洗钱风险评级
     */
    @Column(table = "yls_customer_corp")
    public Short enterRating;


    /**
     * 公司网址
     */
    @Column(table = "yls_customer_corp")
    public String companyWebsite;


    /**
     * 传真
     */
    @Column(table = "yls_customer_corp")
    public String fax;


    /**
     * 公司邮箱
     */
    @Column(table = "yls_customer_corp")
    public String companyMailbox;


    /**
     * 科技型企业类型
     */
    @Column(table = "yls_customer_corp")
    public Short technicalType;

    /**
     * 单位客户ts
     */
    @Column(name = "ts", table = "yls_customer_corp")
    public Date tsC;

    /**
     * 电话
     */
    @Column(table = "yls_customer_corp")
    public String phone;


    /**
     * 客户号
     */
    @Column(table = "yls_customer_corp")
    public String customerNo;


    /**
     * 客户简称
     */

    @Column(table = "yls_customer_corp")
    public String customerShort;


    /**
     * 客户类型
     */
    @Column(table = "yls_customer_corp")
    public String cusotmerClass;

    /**
     * 客户类型
     */
//    public ParameterRefVO cusotmer_class_temp;


    /**
     * 隶属
     */
    @Column(table = "yls_customer_corp")
    public Short subjection;


    /**
     * 称号
     */
    @Column(table = "yls_customer_corp")
    public Short title;


    /**
     * 财务相关
     */
    @Column(table = "yls_customer_corp")
    public String financeRelated;


    /**
     * 设备相关
     */
    @Column(table = "yls_customer_corp")
    public String equipmentRelated;


    /**
     * 其他部门
     */
    @Column(table = "yls_customer_corp")
    public String otherDept;


    /**
     * 政府相关
     */
    @Column(table = "yls_customer_corp")
    public String governmentRelated;


    /**
     * 政府财政相关
     */
    @Column(table = "yls_customer_corp")
    public String governFinanceRelated;


    /**
     * 政府其他部门
     */
    @Column(table = "yls_customer_corp")
    public String governOtherSectors;

    /**
     * 是否财政
     */
    @Column(table = "yls_customer_corp")
    public Short ifFinance;

    /**
     * 快递公司
     */
    @ManyToOne
    @JoinColumn(name="expressCompany",referencedColumnName="pkParameter",table = "yls_customer_corp")
    public ParmsRefVO expressCompany;

    /**
     * 开票说明
     */
    @Column(table = "yls_customer_corp")
    public String invoiceExplain;

    /**
     * 开票说明
     */
//    public ParameterRefVO invoiceExplain;

//    public Boolean booleanOne;


    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    @Column(table = "yls_customer_corp")
    public Short regNumberType;


    /**
     * 注册登记号码   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    @Column(table = "yls_customer_corp")
    public String regNumber;


    /**
     * 版本号
     */

    public Integer versionNum;


    /**
     * 客户类别
     */
    @QueryCondition(func = MatchType.equal)
    public Short customerType;


    /**
     * 客户编号
     */
    @QueryCondition(func = MatchType.equal)
    public String customerCode;


    /**
     * 客户名称
     */
    @QueryCondition(func = MatchType.like)
    public String customerName;


    /**
     * 客户英文名
     */
    public String customerEngName;



    /**
     * 证件类型
     */
    public Short identityType;


    /**
     * 证件号码
     */
    public String identityNo;


//    /**
//     * 客户经理
//     */
//    @ManyToOne
//    @JoinColumn(name="pkPrjManager",referencedColumnName="cuserid",table = "yls_customer")
//    public UserRefVO pkPrjManager;

    /**
     * 部门名称
     */
//    public DeptdocRefVO pkDept;

    /**
     * 客户状态
     */
    public Short customerStatus;

    /**
     * 是否黑名单
     */
    public Short ifBlackList;

    /**
     * 冻结处理方式
     */
    public Short freezeTreatment;

    /**
     * 变更状态
     */
    public Short alteraStatus;

    /**
     * 单据状态
     */
    public Short billstatus;


    /**
     * 最新变更人
     */
//    @Column(table = "yls_customer")
//    public UserRefVO pkOperatorLst;



    /**
     * 最新变更日期
     */
    public String operateDateLst;


    /**
     * 最新变更时间
     */
    public String operateTimeLst;


    /**
     * 记账人
     */
//    public UserRefVO pkOperator;


    /**
     * 记账日期
     */
    public String operateDate;


    /**
     * 记账时间
     */
    @Column(name = "operateTime")
    public String operateTime;


    /**
     * 复核人
     */

//    public UserRefVO pkChecker;

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
//    public UserRefVO pkGrantor;


    /**
     * 授权日期
     */
    public String grantDate;


    /**
     * 授权时间
     */
    public String grantTime;

    /**
     * 生效日期
     */
    public String effectiveDate;

    /**
     * 机构
     */

    @ManyToOne
    @JoinColumn(name = "pkOrg", referencedColumnName = "pkOrg")
    public OrgRefVO pkOrg;

    /**
     * 机构信用代码”   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    public String orgCreditCode;

    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    public Short ifWarrantCust;

    /**
     * 是否最新
     */
    public Short ifNew;

    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdbCode;


    /**
     * 20180911 是否CRM系统推送客户
     */
    public Short ifCrmPush;

    @Override
    public Specification<CustomerCorpVO> toSpec() {
        return super.toSpecWithAnd();
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

    public ParmsRefVO getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(ParmsRefVO customerProperty) {
        this.customerProperty = customerProperty;
    }

    public ParmsRefVO getCustomerPropertyIn() {
        return customerPropertyIn;
    }

    public void setCustomerPropertyIn(ParmsRefVO customerPropertyIn) {
        this.customerPropertyIn = customerPropertyIn;
    }

    public ParmsRefVO getEconomicType() {
        return economicType;
    }

    public void setEconomicType(ParmsRefVO economicType) {
        this.economicType = economicType;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public ParmsRefVO getRegion() {
        return region;
    }

    public void setRegion(ParmsRefVO region) {
        this.region = region;
    }

    public ParmsRefVO getIndustryType() {
        return industryType;
    }

    public void setIndustryType(ParmsRefVO industryType) {
        this.industryType = industryType;
    }

    public ParmsRefVO getIndustryType1() {
        return industryType1;
    }

    public void setIndustryType1(ParmsRefVO industryType1) {
        this.industryType1 = industryType1;
    }

    public ParmsRefVO getIndustry() {
        return industry;
    }

    public void setIndustry(ParmsRefVO industry) {
        this.industry = industry;
    }

    public ParmsRefVO getIndustry1() {
        return industry1;
    }

    public void setIndustry1(ParmsRefVO industry1) {
        this.industry1 = industry1;
    }

    public ParmsRefVO getIndustry2() {
        return industry2;
    }

    public void setIndustry2(ParmsRefVO industry2) {
        this.industry2 = industry2;
    }

    public ParmsRefVO getIndustry3() {
        return industry3;
    }

    public void setIndustry3(ParmsRefVO industry3) {
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

    public CurrtypeRefVO getCapitalCur() {
        return capitalCur;
    }

    public void setCapitalCur(CurrtypeRefVO capitalCur) {
        this.capitalCur = capitalCur;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public CurrtypeRefVO getCapitalCurPaidin() {
        return capitalCurPaidin;
    }

    public void setCapitalCurPaidin(CurrtypeRefVO capitalCurPaidin) {
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

    public ParmsRefVO getCountry() {
        return country;
    }

    public void setCountry(ParmsRefVO country) {
        this.country = country;
    }

    public Short getRegAddressMembership() {
        return regAddressMembership;
    }

    public void setRegAddressMembership(Short regAddressMembership) {
        this.regAddressMembership = regAddressMembership;
    }

    public AreaclRefVO getProvince() {
        return province;
    }

    public void setProvince(AreaclRefVO province) {
        this.province = province;
    }

    public AreaclRefVO getCity() {
        return city;
    }

    public void setCity(AreaclRefVO city) {
        this.city = city;
    }

    public AreaclRefVO getDistrict() {
        return district;
    }

    public void setDistrict(AreaclRefVO district) {
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

    public Date getTsC() {
        return tsC;
    }

    public void setTsC(Date tsC) {
        this.tsC = tsC;
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

    public ParmsRefVO getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(ParmsRefVO expressCompany) {
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

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEngName() {
        return customerEngName;
    }

    public void setCustomerEngName(String customerEngName) {
        this.customerEngName = customerEngName;
    }

    public Short getIdentityType() {
        return identityType;
    }

    public void setIdentityType(Short identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public Short getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Short customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Short getIfBlackList() {
        return ifBlackList;
    }

    public void setIfBlackList(Short ifBlackList) {
        this.ifBlackList = ifBlackList;
    }

    public Short getFreezeTreatment() {
        return freezeTreatment;
    }

    public void setFreezeTreatment(Short freezeTreatment) {
        this.freezeTreatment = freezeTreatment;
    }

    public Short getAlteraStatus() {
        return alteraStatus;
    }

    public void setAlteraStatus(Short alteraStatus) {
        this.alteraStatus = alteraStatus;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getOperateDateLst() {
        return operateDateLst;
    }

    public void setOperateDateLst(String operateDateLst) {
        this.operateDateLst = operateDateLst;
    }

    public String getOperateTimeLst() {
        return operateTimeLst;
    }

    public void setOperateTimeLst(String operateTimeLst) {
        this.operateTimeLst = operateTimeLst;
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

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public OrgRefVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgRefVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOrgCreditCode() {
        return orgCreditCode;
    }

    public void setOrgCreditCode(String orgCreditCode) {
        this.orgCreditCode = orgCreditCode;
    }

    public Short getIfWarrantCust() {
        return ifWarrantCust;
    }

    public void setIfWarrantCust(Short ifWarrantCust) {
        this.ifWarrantCust = ifWarrantCust;
    }

    public Short getIfNew() {
        return ifNew;
    }

    public void setIfNew(Short ifNew) {
        this.ifNew = ifNew;
    }

    public String getMdbCode() {
        return mdbCode;
    }

    public void setMdbCode(String mdbCode) {
        this.mdbCode = mdbCode;
    }

    public Short getIfCrmPush() {
        return ifCrmPush;
    }

    public void setIfCrmPush(Short ifCrmPush) {
        this.ifCrmPush = ifCrmPush;
    }
}