package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 客户参照
 **/
@Entity
@Table(name = "(" +
        "select tcust.*, indust.*" +
        "  from (select vc.*," +
        "               vcn.customer_name    cust_name_new," +
        "               vcn.loan_card_no," +
        "               crmb.descriptor_data as cust_rating" +
        "          from v_customer vc" +
        "          left join (select cust.customer_code," +
        "                           cust.customer_name," +
        "                           cust.pk_customer," +
        "                           corp.loan_card_no" +
        "                      from yls_customer cust" +
        "                      left join yls_customer_corp corp" +
        "                        on corp.pk_customer = cust.pk_customer" +
        "                     where (cust.customer_code, cust.version_num) in" +
        "                           (select t.customer_code," +
        "                                   max(t.version_num) version_num" +
        "                              from yls_customer t" +
        "                             where t.billstatus = 9" +
        "                             group by t.customer_code)) vcn" +
        "            on vc.CUSTOMER_CODE = vcn.CUSTOMER_CODE" +
        "          left join (select cr.descriptor_data, cr.pk_customer" +
        "                      from (select ROW_NUMBER() OVER(partition by g.pk_customer order by g.rating_end_date desc, g.pk_customer_rating desc) rm," +
        "                                   g.pk_customer," +
        "                                   g.pk_customer_rating," +
        "                                   mb.descriptor_data" +
        "                              from yls_customer_rating g" +
        "                              left join yls_rating_maintain_b mb" +
        "                                on g.init_level = mb.pk_rating_maintain_b) cr" +
        "                     where cr.rm = 1) crmb" +
        "            on crmb.pk_customer = vc.PK_CUSTOMER) tcust" +
        "  left join (select industry.PK_INDUSTRY_TYPE as pk_industry3," +
        "                    industry.TYPE_NAME        as industry3," +
        "                    industry.PK_PARAMETER" +
        "               from yls_industry_type industry) indust" +
        "    on tcust.pk_industry1 = indust.PK_PARAMETER" +
        "" +
        "  " +
        " )")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class CustomerDTO extends BaseDTO {

    /**
     * 客户主键
     */
    @Id
    public String pkCustomer;

    /**
     * 客户编号
     */
    public String customerCode;

    /**
     * 客户名称
     */
    public String customerName;

    /**
     * 客户名称(最新)
     */
    public String custNameNew;

    /**
     * 客户类别
     */
    public Short customerType;
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
    /**
     * 客户状态
     */
    public Short customerStatus;

    /**
     * 冻结处理方式
     */
    public Short freezeTreatment;

    /**
     * 客户经理名称
     */
    @Transient
    public String userName;

    /**
     * 客户经理PK
     */
    public String customerManager;

    /**
     * 客户经理 名称
     */
    public String customerManagerNa;

    /**
     * 地区（省）
     */
    public String province;

    /**
     * 地区（省）名称
     */
    public String provinceNa;
    /**
     * 地区（市）
     */
    public String city;
    /**
     * 地区（县/区）
     */
    public String district;
    /**
     * 行业门类
     */
    public String industry;



    /**
     * 企业规模（内部管理）
     */
    public Short enterScaleInner;
    /**
     * 企业规模（六部委）
     */
    @Transient
    public Short enterScale6m;

    /**
     * 法定代表人(自:空)
     */
    public String legalRep;

    /**
     * 法定代表人(自:文本)
     */
    public String legalRepresentative;

    /**
     * 通讯地址(自:通讯地址)
     */
    public String commAddress;

    /**
     * 实际告知地址(自:实际告知地址)
     */
    public String informAddress;

    /**
     * 实际告知邮编(自:实际告知邮编)
     */
    public String informAddressZip;

    /**
     * 通讯地址邮编(自:通讯地址邮编)
     */
    public String commAddressZip;

    /**
     * 传真(自:空)
     */
    public String fax;

    /**
     * 公司邮箱(自:电子邮箱)
     */
    public String companyMailbox;

    /**
     * 税务登记证号(国税)(自:空)
     */
    public String nationalTax;

    /**
     * 行业类别 ParmsDTO
     */
    public String industryType;

    /**
     * 行业类别（名称）
     */
    public String industryTypeNa;

    /**
     * 客户号
     */
    public String customerNo;

    /**
     * 财务相关
     */
    public String financeRelated;

    /**
     * 设备相关
     */
    public String equipmentRelated;

    /**
     * 其他部门
     */
    public String otherDept;

    /**
     * 政府相关
     */
    public String governmentRelated;

    /**
     * 政府财政相关
     */
    public String governFinanceRelated;

    /**
     * 政府其他部门
     */
    public String governOtherSectors;

    /**
     * 单据状态
     */
    public Short billstatus;
    /**
     * 企业规模（人行）
     */
    public Short enterScalePbc;

    /**成立日期:*/
    public String establishDate;
    /**职工人数*/
    public Integer employeeNum;
    /**注册币种*/
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "capitalCur")
    public CurrtypeDTO capitalCur;
    /**注册资本*/
    public BigDecimal capital;
    /**注册地址*/
    public String regAddress;
    /**学校等级*/
    public Short schoolGrade;
    /**医院等级*/
    public Short hospitalGrade;
    /**
     * 客户状态
     */
    public Short ifNew;
    /**
     * 经济性质
     */
    public String economicType;

    /**
     * 客户性质
     */
    public String customerProperty;

    /**
     * 行业门类（大类）
     */
    public String industry1;
    /**
     * 行业门类（中类）
     */
    public String industry2;
    /**
     * 行业门类（大类）
     */
    public String pkIndustry1;
    /**
     * 行业门类（中类）
     */
    public String pkIndustry2;

    /** INSERT  【wangxy】 【2016-12-2】 【项目审批报告需求】<行业分类（集团口径）> */
    /**
     * 行业门类（集团口径）
     */
    public String industry3;

    /**
     * add by jiaoshy 征信接口  是否征信授权客户 2017-04-25
     * @return
     */
    public Short ifWarrantCust;

//    public CustomerDTO(String pkCustomer, String customerCode, String customerName, String custNameNew, Short customerType, String customerEngName, Short identityType, String identityNo, Short customerStatus, Short freezeTreatment, String userName, String customerManager, String customerManagerNa, String province, String provinceNa, String city, String district, String industry, Short enterScaleInner, Short enterScale6m, String legalRep, String legalRepresentative, String commAddress, String informAddress, String informAddressZip, String commAddressZip, String fax, String companyMailbox, String nationalTax, String industryType, String industryTypeNa, String customerNo, String financeRelated, String equipmentRelated, String otherDept, String governmentRelated, String governFinanceRelated, String governOtherSectors, Short billstatus, Short enterScalePbc, String establishDate, Integer employeeNum, CurrtypeDTO capitalCur, BigDecimal capital, String regAddress, Short schoolGrade, Short hospitalGrade, Short ifNew, String economicType, String customerProperty, String industry1, String industry2, String pkIndustry1, String pkIndustry2, String industry3, Short ifWarrantCust) {
//        this.pkCustomer = pkCustomer;
//        this.customerCode = customerCode;
//        this.customerName = customerName;
//        this.custNameNew = custNameNew;
//        this.customerType = customerType;
//        this.customerEngName = customerEngName;
//        this.identityType = identityType;
//        this.identityNo = identityNo;
//        this.customerStatus = customerStatus;
//        this.freezeTreatment = freezeTreatment;
//        this.userName = userName;
//        this.customerManager = customerManager;
//        this.customerManagerNa = customerManagerNa;
//        this.province = province;
//        this.provinceNa = provinceNa;
//        this.city = city;
//        this.district = district;
//        this.industry = industry;
//        this.enterScaleInner = enterScaleInner;
//        this.enterScale6m = enterScale6m;
//        this.legalRep = legalRep;
//        this.legalRepresentative = legalRepresentative;
//        this.commAddress = commAddress;
//        this.informAddress = informAddress;
//        this.informAddressZip = informAddressZip;
//        this.commAddressZip = commAddressZip;
//        this.fax = fax;
//        this.companyMailbox = companyMailbox;
//        this.nationalTax = nationalTax;
//        this.industryType = industryType;
//        this.industryTypeNa = industryTypeNa;
//        this.customerNo = customerNo;
//        this.financeRelated = financeRelated;
//        this.equipmentRelated = equipmentRelated;
//        this.otherDept = otherDept;
//        this.governmentRelated = governmentRelated;
//        this.governFinanceRelated = governFinanceRelated;
//        this.governOtherSectors = governOtherSectors;
//        this.billstatus = billstatus;
//        this.enterScalePbc = enterScalePbc;
//        this.establishDate = establishDate;
//        this.employeeNum = employeeNum;
//        this.capitalCur = capitalCur;
//        this.capital = capital;
//        this.regAddress = regAddress;
//        this.schoolGrade = schoolGrade;
//        this.hospitalGrade = hospitalGrade;
//        this.ifNew = ifNew;
//        this.economicType = economicType;
//        this.customerProperty = customerProperty;
//        this.industry1 = industry1;
//        this.industry2 = industry2;
//        this.pkIndustry1 = pkIndustry1;
//        this.pkIndustry2 = pkIndustry2;
//        this.industry3 = industry3;
//        this.ifWarrantCust = ifWarrantCust;
//        this.setCode(customerCode);
//        this.setName(customerName);
//        this.setPk(pkCustomer);
//    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
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

    public String getCustNameNew() {
        return custNameNew;
    }

    public void setCustNameNew(String custNameNew) {
        this.custNameNew = custNameNew;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
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

    public Short getFreezeTreatment() {
        return freezeTreatment;
    }

    public void setFreezeTreatment(Short freezeTreatment) {
        this.freezeTreatment = freezeTreatment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCustomerManager() {
        return customerManager;
    }

    public void setCustomerManager(String customerManager) {
        this.customerManager = customerManager;
    }

    public String getCustomerManagerNa() {
        return customerManagerNa;
    }

    public void setCustomerManagerNa(String customerManagerNa) {
        this.customerManagerNa = customerManagerNa;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceNa() {
        return provinceNa;
    }

    public void setProvinceNa(String provinceNa) {
        this.provinceNa = provinceNa;
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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Short getEnterScaleInner() {
        return enterScaleInner;
    }

    public void setEnterScaleInner(Short enterScaleInner) {
        this.enterScaleInner = enterScaleInner;
    }

    public Short getEnterScale6m() {
        return enterScale6m;
    }

    public void setEnterScale6m(Short enterScale6m) {
        this.enterScale6m = enterScale6m;
    }

    public String getLegalRep() {
        return legalRep;
    }

    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCommAddress() {
        return commAddress;
    }

    public void setCommAddress(String commAddress) {
        this.commAddress = commAddress;
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

    public String getCommAddressZip() {
        return commAddressZip;
    }

    public void setCommAddressZip(String commAddressZip) {
        this.commAddressZip = commAddressZip;
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

    public String getNationalTax() {
        return nationalTax;
    }

    public void setNationalTax(String nationalTax) {
        this.nationalTax = nationalTax;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getIndustryTypeNa() {
        return industryTypeNa;
    }

    public void setIndustryTypeNa(String industryTypeNa) {
        this.industryTypeNa = industryTypeNa;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
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

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public Short getEnterScalePbc() {
        return enterScalePbc;
    }

    public void setEnterScalePbc(Short enterScalePbc) {
        this.enterScalePbc = enterScalePbc;
    }

    public String getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(String establishDate) {
        this.establishDate = establishDate;
    }

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public CurrtypeDTO getCapitalCur() {
        return capitalCur;
    }

    public void setCapitalCur(CurrtypeDTO capitalCur) {
        this.capitalCur = capitalCur;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
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

    public Short getIfNew() {
        return ifNew;
    }

    public void setIfNew(Short ifNew) {
        this.ifNew = ifNew;
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
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

    public String getPkIndustry1() {
        return pkIndustry1;
    }

    public void setPkIndustry1(String pkIndustry1) {
        this.pkIndustry1 = pkIndustry1;
    }

    public String getPkIndustry2() {
        return pkIndustry2;
    }

    public void setPkIndustry2(String pkIndustry2) {
        this.pkIndustry2 = pkIndustry2;
    }

    public String getIndustry3() {
        return industry3;
    }

    public void setIndustry3(String industry3) {
        this.industry3 = industry3;
    }

    public Short getIfWarrantCust() {
        return ifWarrantCust;
    }

    public void setIfWarrantCust(Short ifWarrantCust) {
        this.ifWarrantCust = ifWarrantCust;
    }

    public String getPk() {
        return pkCustomer;
    }

    public void setPk(String pk) {
        this.pkCustomer = pk;
    }
    @Transient
    public String name;

    @Transient
    public String code;
    public String getName(){
        return customerName;
    }

    public String getCode(){
        return customerCode;
    }

    public void setName(String name) {
        this.name = this.customerName;
    }

    public void setCode(String code) {
        this.code = this.customerCode;
    }
}
