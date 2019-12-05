package com.leasing.communication.entity.dos;

import com.leasing.common.base.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.common.base.annotation.Excel;
import com.leasing.communication.utils.Excel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/11
 * @author:Yjj@yonyou.com
 * @description: 2c客户信息
 **/
@Entity
@Table(name="yc_customer")
public class CustomerDO extends FileBaseBusinessDO {
    /**
     * 主键
     */
    @Id
    private String pkCustomer;

    /**
     * 客户编码
     */
    @Excel(titleName = "客户编码", orderNum = 8)
    private String customerCode;

    /**
     * 客户名称
     */
    @Excel(titleName = "客户名称", orderNum = 9)
    private String customerName;

    /**
     * 证件类型
     */
    @Excel(titleName = "证件类型", orderNum = 10)
    private Integer identityType;

    /**
     * 证件号码
     */
    @Excel(titleName = "证件号码", orderNum = 11)
    private String identityNo;

    /**
     * 出生日期
     */
    @Excel(titleName = "出生日期", orderNum = 12)
    private String birthday;

    /**
     * 签发机关
     */
    @Excel(titleName = "签发机关", orderNum = 13)
    private String issuingAuthority;

    /**
     * 有效期限
     */
    @Excel(titleName = "有效期限", orderNum = 14)
    private Integer validTerm;

    /**
     * 年龄
     */
    @Excel(titleName = "年龄", orderNum = 15)
    private Integer age;

    /**
     * 性别
     */
    @Excel(titleName = "性别", orderNum = 16)
    private Integer sex;

    /**
     * 文化程度
     */
    @Excel(titleName = "文化程度", orderNum = 17)
    private Integer levelOfEducation;

    /**
     * 联系方式
     */
    @Excel(titleName = "联系方式", orderNum = 18)
    private String contact;

    /**
     * 婚姻状况
     */
    @Excel(titleName = "婚姻状况", orderNum = 19)
    private Integer marryStatus;

    /**
     * 子女情况
     */
    @Excel(titleName = "子女情况", orderNum = 20)
    private String childrenStatus;

    /**
     * 子女上学情况
     */
    @Excel(titleName = "子女上学情况", orderNum = 21)
    private String childrenSchoolStatus;

    /**
     * 行业类型
     */
    @Excel(titleName = "行业类型", orderNum = 22)
    private String industryType;

    /**
     * 职称
     */
    @Excel(titleName = "职称", orderNum = 23)
    private Integer officalTitle;

    /**
     * 职业
     */
    @Excel(titleName = "职业", orderNum = 24)
    private String job;

    /**
     * 户籍地址
     */
    @Excel(titleName = "户籍地址", orderNum = 25)
    private String permanentAddress;

    /**
     * 居住地址
     */
    @Excel(titleName = "居住地址", orderNum = 26)
    private String homeAddr;

    /**
     * 单位名称
     */
    @Excel(titleName = "单位名称", orderNum = 27)
    private String employerName;

    /**
     * 单位地址
     */
    @Excel(titleName = "单位地址", orderNum = 28)
    private String employerAddress;

    /**
     * 单位性质
     */
    @Excel(titleName = "单位性质", orderNum = 29)
    private String employerNature;

    /**
     * 本单位工作年限
     */
    @Excel(titleName = "本单位工作年限", orderNum = 30)
    private Integer lengthOfService;

    /**
     * 本地居住年限（年）
     */
    @Excel(titleName = "本地居住年限（年）", orderNum = 31)
    private Integer lengthLocalResidence;

    /**
     * 是否有房产
     */
    @Excel(titleName = "是否有房产", orderNum = 32)
    private Integer realEstate;

    /**
     * 产权所有人
     */
    @Excel(titleName = "产权所有人", orderNum = 33)
    private String titleHolder;

    /**
     * 房产面积（平方米）
     */
    @Excel(titleName = "房产面积（平方米）", orderNum = 34)
    private BigDecimal theHousingArea;

    /**
     * 房产所在地
     */
    @Excel(titleName = "房产所在地", orderNum = 35)
    private String realEstateHome;

    /**
     * 详细地址
     */
    @Excel(titleName = "详细地址", orderNum = 36)
    private String detailedAddress;

    /**
     * 房产性质
     */
    @Excel(titleName = "房产性质", orderNum = 37)
    private String realEstateProperties;

    /**
     * 房产区域
     */
    @Excel(titleName = "房产区域", orderNum = 38)
    private String realEstateArea;

    /**
     * 年固定收入（元）
     */
    @Excel(titleName = "年固定收入（元）", orderNum = 39)
    private BigDecimal fixedAnnualIncome;

    /**
     * 征信时间
     */
    @Excel(titleName = "征信时间", orderNum = 40)
    private String creditTime;

    /**
     * 征信对象类型
     */
    @Excel(titleName = "征信对象类型", orderNum = 41)
    private String creditObjType;

    /**
     * 征信结果
     */
    @Excel(titleName = "征信结果", orderNum = 42)
    private String creditResult;

    /**
     * 征信原因描述
     */
    @Excel(titleName = "征信原因描述", orderNum = 43)
    private String creditReasonDescribe;

    /**
     * 征信评分
     */
    @Excel(titleName = "征信评分", orderNum = 44)
    private String creditRating;

    /**
     * 征信编号
     */
    @Excel(titleName = "征信编号", orderNum = 45)
    private String creditCode;

    /**
     * 征信生成时间
     */
    @Excel(titleName = "征信生成时间", orderNum = 46)
    private String creditGenerateTime;

    /**
     * 联系人姓名
     */
    @Excel(titleName = "联系人姓名", orderNum = 47)
    private String linkmanName;

    /**
     * 联系人联系方式
     */
    @Excel(titleName = "联系人联系方式", orderNum = 48)
    private String linkmanContact;

    /**
     * 联系人与承租人关系
     */
    @Excel(titleName = "联系人与承租人关系", orderNum = 49)
    private Integer linkmanLesseeRelationship;

    /**
     * 联系人居住地址
     */
    @Excel(titleName = "联系人居住地址", orderNum = 50)
    private String linkmanAddress;

    /**
     * 配偶姓名
     */
    @Excel(titleName = "配偶姓名", orderNum = 51)
    private String spouseName;

    /**
     * 配偶证件类型
     */
    @Excel(titleName = "配偶证件类型", orderNum = 52)
    private Integer spouseIdentityType;

    /**
     * 配偶证件号码
     */
    @Excel(titleName = "配偶证件号码", orderNum = 53)
    private String spouseIdentityNo;

    /**
     * 配偶年龄
     */
    @Excel(titleName = "配偶年龄", orderNum = 54)
    private Integer spouseAge;

    /**
     * 配偶联系方式
     */
    @Excel(titleName = "配偶联系方式", orderNum = 55)
    private String spouseContact;

    /**
     * 配偶文化程度
     */
    @Excel(titleName = "配偶文化程度", orderNum = 56)
    private Integer spouseLevelEducation;

    /**
     * 配偶工作单位名称
     */
    @Excel(titleName = "配偶工作单位名称", orderNum = 57)
    private String spouseEmployerName;

    /**
     * 配偶单位电话
     */
    @Excel(titleName = "配偶单位电话", orderNum = 58)
    private String spouseEmployerPhone;

    /**
     * 配偶单位地址
     */
    @Excel(titleName = "配偶单位地址", orderNum = 59)
    private String spouseEmployerAddress;

    /**
     * 配偶单位性质
     */
    @Excel(titleName = "配偶单位性质", orderNum = 60)
    private String spouseEmployerNature;

    /**
     * 担保人姓名
     */
    @Excel(titleName = "担保人姓名", orderNum = 61)
    private String guarantorName;

    /**
     * 担保人证件类型
     */
    @Excel(titleName = "担保人证件类型", orderNum = 62)
    private Integer guarantorIdentityType;

    /**
     * 担保人证件号
     */
    @Excel(titleName = "担保人证件号", orderNum = 63)
    private String guarantorIdentityNo;

    /**
     * 担保人出生日期
     */
    @Excel(titleName = "担保人出生日期", orderNum = 64)
    private String guarantorBirthday;

    /**
     * 担保人性别
     */
    @Excel(titleName = "担保人性别", orderNum = 65)
    private Integer guarantorSex;

    /**
     * 担保人年龄
     */
    @Excel(titleName = "担保人年龄", orderNum = 66)
    private Integer guarantorAge;

    /**
     * 担保人联系方式
     */
    @Excel(titleName = "担保人联系方式", orderNum = 67)
    private String guarantorContact;

    /**
     * 担保人与承租人关系
     */
    @Excel(titleName = "担保人与承租人关系", orderNum = 68)
    private String guarantorLesseeRelationship;

    /**
     * 担保人年收入
     */
    @Excel(titleName = "担保人年收入", orderNum = 69)
    private BigDecimal guarantorAnnualIncome;

    /**
     * 担保人婚姻状况
     */
    @Excel(titleName = "担保人婚姻状况", orderNum = 70)
    private Integer guarantorMarryStatus;

    /**
     * 担保人居住地址
     */
    @Excel(titleName = "担保人居住地址", orderNum = 71)
    private String guarantorAddress;

    /**
     * 担保人单位名称
     */
    @Excel(titleName = "担保人单位名称", orderNum = 72)
    private String guarantorEmployerName;

    /**
     * 担保人单位地址
     */
    @Excel(titleName = "担保人单位地址", orderNum = 73)
    private String guarantorEmployerAddress;

    /**
     * 担保人单位电话
     */
    @Excel(titleName = "担保人单位电话", orderNum = 74)
    private String guarantorEmployerPhone;

    /**
     * 担保人担保能力说明
     */
    @Excel(titleName = "担保人担保能力说明", orderNum = 74)
    private String guarantorDescribe;

    /**
     * 持卡人姓名
     */
    @Excel(titleName = "持卡人姓名", orderNum = 75)
    private String cardholderName;

    /**
     * 卡号
     */
    @Excel(titleName = "卡号", orderNum = 76)
    private String cardNo;

    /**
     * 开户银行
     */
    @Excel(titleName = "开户银行", orderNum = 77)
    private String bank;

    /**
     * 开户行号
     */
    @Excel(titleName = "开户行号", orderNum = 78)
    private String bankNo;

    /**
     * 手机号
     */
    @Excel(titleName = "手机号", orderNum = 79)
    private String iphoneNo;

    @Override
    public String getPk() {
        return pkCustomer;
    }

    @Override
    public void setPk(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public CustomerDO() {
    }

    public CustomerDO(String pkCustomer, String customerCode, String customerName, Integer identityType, String identityNo, String birthday, String issuingAuthority, Integer validTerm, Integer age, Integer sex, Integer levelOfEducation, String contact, Integer marryStatus, String childrenStatus, String childrenSchoolStatus, String industryType, Integer officalTitle, String job, String permanentAddress, String homeAddr, String employerName, String employerAddress, String employerNature, Integer lengthOfService, Integer lengthLocalResidence, Integer realEstate, String titleHolder, BigDecimal theHousingArea, String realEstateHome, String detailedAddress, String realEstateProperties, String realEstateArea, BigDecimal fixedAnnualIncome, String creditTime, String creditObjType, String creditResult, String creditReasonDescribe, String creditRating, String creditCode, String creditGenerateTime, String linkmanName, String linkmanContact, Integer linkmanLesseeRelationship, String linkmanAddress, String spouseName, Integer spouseIdentityType, String spouseIdentityNo, Integer spouseAge, String spouseContact, Integer spouseLevelEducation, String spouseEmployerName, String spouseEmployerPhone, String spouseEmployerAddress, String spouseEmployerNature, String guarantorName, Integer guarantorIdentityType, String guarantorIdentityNo, String guarantorBirthday, Integer guarantorSex, Integer guarantorAge, String guarantorContact, String guarantorLesseeRelationship, BigDecimal guarantorAnnualIncome, Integer guarantorMarryStatus, String guarantorAddress, String guarantorEmployerName, String guarantorEmployerAddress, String guarantorEmployerPhone, String guarantorDescribe, String cardholderName, String cardNo, String bank, String bankNo, String iphoneNo) {
        this.pkCustomer = pkCustomer;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.identityType = identityType;
        this.identityNo = identityNo;
        this.birthday = birthday;
        this.issuingAuthority = issuingAuthority;
        this.validTerm = validTerm;
        this.age = age;
        this.sex = sex;
        this.levelOfEducation = levelOfEducation;
        this.contact = contact;
        this.marryStatus = marryStatus;
        this.childrenStatus = childrenStatus;
        this.childrenSchoolStatus = childrenSchoolStatus;
        this.industryType = industryType;
        this.officalTitle = officalTitle;
        this.job = job;
        this.permanentAddress = permanentAddress;
        this.homeAddr = homeAddr;
        this.employerName = employerName;
        this.employerAddress = employerAddress;
        this.employerNature = employerNature;
        this.lengthOfService = lengthOfService;
        this.lengthLocalResidence = lengthLocalResidence;
        this.realEstate = realEstate;
        this.titleHolder = titleHolder;
        this.theHousingArea = theHousingArea;
        this.realEstateHome = realEstateHome;
        this.detailedAddress = detailedAddress;
        this.realEstateProperties = realEstateProperties;
        this.realEstateArea = realEstateArea;
        this.fixedAnnualIncome = fixedAnnualIncome;
        this.creditTime = creditTime;
        this.creditObjType = creditObjType;
        this.creditResult = creditResult;
        this.creditReasonDescribe = creditReasonDescribe;
        this.creditRating = creditRating;
        this.creditCode = creditCode;
        this.creditGenerateTime = creditGenerateTime;
        this.linkmanName = linkmanName;
        this.linkmanContact = linkmanContact;
        this.linkmanLesseeRelationship = linkmanLesseeRelationship;
        this.linkmanAddress = linkmanAddress;
        this.spouseName = spouseName;
        this.spouseIdentityType = spouseIdentityType;
        this.spouseIdentityNo = spouseIdentityNo;
        this.spouseAge = spouseAge;
        this.spouseContact = spouseContact;
        this.spouseLevelEducation = spouseLevelEducation;
        this.spouseEmployerName = spouseEmployerName;
        this.spouseEmployerPhone = spouseEmployerPhone;
        this.spouseEmployerAddress = spouseEmployerAddress;
        this.spouseEmployerNature = spouseEmployerNature;
        this.guarantorName = guarantorName;
        this.guarantorIdentityType = guarantorIdentityType;
        this.guarantorIdentityNo = guarantorIdentityNo;
        this.guarantorBirthday = guarantorBirthday;
        this.guarantorSex = guarantorSex;
        this.guarantorAge = guarantorAge;
        this.guarantorContact = guarantorContact;
        this.guarantorLesseeRelationship = guarantorLesseeRelationship;
        this.guarantorAnnualIncome = guarantorAnnualIncome;
        this.guarantorMarryStatus = guarantorMarryStatus;
        this.guarantorAddress = guarantorAddress;
        this.guarantorEmployerName = guarantorEmployerName;
        this.guarantorEmployerAddress = guarantorEmployerAddress;
        this.guarantorEmployerPhone = guarantorEmployerPhone;
        this.guarantorDescribe = guarantorDescribe;
        this.cardholderName = cardholderName;
        this.cardNo = cardNo;
        this.bank = bank;
        this.bankNo = bankNo;
        this.iphoneNo = iphoneNo;
    }

    /**
     * 主键
     * @return PK_CUSTOMER 主键
     */
    public String getPkCustomer() {
        return pkCustomer;
    }

    /**
     * 主键
     * @param pkCustomer 主键
     */
    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer == null ? null : pkCustomer.trim();
    }

    /**
     * 客户编码
     * @return CUSTOMER_CODE 客户编码
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * 客户编码
     * @param customerCode 客户编码
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode == null ? null : customerCode.trim();
    }

    /**
     * 客户名称
     * @return CUSTOMER_NAME 客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户名称
     * @param customerName 客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 证件类型
     * @return IDENTITY_TYPE 证件类型
     */
    public Integer getIdentityType() {
        return identityType;
    }

    /**
     * 证件类型
     * @param identityType 证件类型
     */
    public void setIdentityType(Integer identityType) {
        this.identityType = identityType;
    }

    /**
     * 证件号码
     * @return IDENTITY_NO 证件号码
     */
    public String getIdentityNo() {
        return identityNo;
    }

    /**
     * 证件号码
     * @param identityNo 证件号码
     */
    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo == null ? null : identityNo.trim();
    }

    /**
     * 出生日期
     * @return BIRTHDAY 出生日期
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 出生日期
     * @param birthday 出生日期
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 签发机关
     * @return ISSUING_AUTHORITY 签发机关
     */
    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    /**
     * 签发机关
     * @param issuingAuthority 签发机关
     */
    public void setIssuingAuthority(String issuingAuthority) {
        this.issuingAuthority = issuingAuthority == null ? null : issuingAuthority.trim();
    }

    /**
     * 有效期限
     * @return VALID_TERM 有效期限
     */
    public Integer getValidTerm() {
        return validTerm;
    }

    /**
     * 有效期限
     * @param validTerm 有效期限
     */
    public void setValidTerm(Integer validTerm) {
        this.validTerm = validTerm;
    }

    /**
     * 年龄
     * @return AGE 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别
     * @return SEX 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 文化程度
     * @return LEVEL_OF_EDUCATION 文化程度
     */
    public Integer getLevelOfEducation() {
        return levelOfEducation;
    }

    /**
     * 文化程度
     * @param levelOfEducation 文化程度
     */
    public void setLevelOfEducation(Integer levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    /**
     * 联系方式
     * @return CONTACT 联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 联系方式
     * @param contact 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 婚姻状况
     * @return MARRY_STATUS 婚姻状况
     */
    public Integer getMarryStatus() {
        return marryStatus;
    }

    /**
     * 婚姻状况
     * @param marryStatus 婚姻状况
     */
    public void setMarryStatus(Integer marryStatus) {
        this.marryStatus = marryStatus;
    }

    /**
     * 子女情况
     * @return CHILDREN_STATUS 子女情况
     */
    public String getChildrenStatus() {
        return childrenStatus;
    }

    /**
     * 子女情况
     * @param childrenStatus 子女情况
     */
    public void setChildrenStatus(String childrenStatus) {
        this.childrenStatus = childrenStatus == null ? null : childrenStatus.trim();
    }

    /**
     * 子女上学情况
     * @return CHILDREN_SCHOOL_STATUS 子女上学情况
     */
    public String getChildrenSchoolStatus() {
        return childrenSchoolStatus;
    }

    /**
     * 子女上学情况
     * @param childrenSchoolStatus 子女上学情况
     */
    public void setChildrenSchoolStatus(String childrenSchoolStatus) {
        this.childrenSchoolStatus = childrenSchoolStatus == null ? null : childrenSchoolStatus.trim();
    }

    /**
     * 行业类型
     * @return INDUSTRY_TYPE 行业类型
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * 行业类型
     * @param industryType 行业类型
     */
    public void setIndustryType(String industryType) {
        this.industryType = industryType == null ? null : industryType.trim();
    }

    /**
     * 职称
     * @return OFFICAL_TITLE 职称
     */
    public Integer getOfficalTitle() {
        return officalTitle;
    }

    /**
     * 职称
     * @param officalTitle 职称
     */
    public void setOfficalTitle(Integer officalTitle) {
        this.officalTitle = officalTitle;
    }

    /**
     * 职业
     * @return JOB 职业
     */
    public String getJob() {
        return job;
    }

    /**
     * 职业
     * @param job 职业
     */
    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    /**
     * 户籍地址
     * @return PERMANENT_ADDRESS 户籍地址
     */
    public String getPermanentAddress() {
        return permanentAddress;
    }

    /**
     * 户籍地址
     * @param permanentAddress 户籍地址
     */
    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress == null ? null : permanentAddress.trim();
    }

    /**
     * 居住地址
     * @return HOME_ADDR 居住地址
     */
    public String getHomeAddr() {
        return homeAddr;
    }

    /**
     * 居住地址
     * @param homeAddr 居住地址
     */
    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr == null ? null : homeAddr.trim();
    }

    /**
     * 单位名称 年固定收入（元）
     * @return EMPLOYER_NAME 单位名称 年固定收入（元）
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * 单位名称 年固定收入（元）
     * @param employerName 单位名称 年固定收入（元）
     */
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    /**
     * 单位地址
     * @return EMPLOYER_ADDRESS 单位地址
     */
    public String getEmployerAddress() {
        return employerAddress;
    }

    /**
     * 单位地址
     * @param employerAddress 单位地址
     */
    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress == null ? null : employerAddress.trim();
    }

    /**
     * 单位性质
     * @return EMPLOYER_NATURE 单位性质
     */
    public String getEmployerNature() {
        return employerNature;
    }

    /**
     * 单位性质
     * @param employerNature 单位性质
     */
    public void setEmployerNature(String employerNature) {
        this.employerNature = employerNature == null ? null : employerNature.trim();
    }

    /**
     * 本单位工作年限
     * @return LENGTH_OF_SERVICE 本单位工作年限
     */
    public Integer getLengthOfService() {
        return lengthOfService;
    }

    /**
     * 本单位工作年限
     * @param lengthOfService 本单位工作年限
     */
    public void setLengthOfService(Integer lengthOfService) {
        this.lengthOfService = lengthOfService;
    }

    /**
     * 本地居住年限（年）
     * @return LENGTH_LOCAL_RESIDENCE 本地居住年限（年）
     */
    public Integer getLengthLocalResidence() {
        return lengthLocalResidence;
    }

    /**
     * 本地居住年限（年）
     * @param lengthLocalResidence 本地居住年限（年）
     */
    public void setLengthLocalResidence(Integer lengthLocalResidence) {
        this.lengthLocalResidence = lengthLocalResidence;
    }

    /**
     * 是否有房产
     * @return REAL_ESTATE 是否有房产
     */
    public Integer getRealEstate() {
        return realEstate;
    }

    /**
     * 是否有房产
     * @param realEstate 是否有房产
     */
    public void setRealEstate(Integer realEstate) {
        this.realEstate = realEstate;
    }

    /**
     * 产权所有人
     * @return TITLE_HOLDER 产权所有人
     */
    public String getTitleHolder() {
        return titleHolder;
    }

    /**
     * 产权所有人
     * @param titleHolder 产权所有人
     */
    public void setTitleHolder(String titleHolder) {
        this.titleHolder = titleHolder == null ? null : titleHolder.trim();
    }

    /**
     * 房产面积（平方米）
     * @return THE_HOUSING_AREA 房产面积（平方米）
     */
    public BigDecimal getTheHousingArea() {
        return theHousingArea;
    }

    /**
     * 房产面积（平方米）
     * @param theHousingArea 房产面积（平方米）
     */
    public void setTheHousingArea(BigDecimal theHousingArea) {
        this.theHousingArea = theHousingArea;
    }

    /**
     * 房产所在地
     * @return REAL_ESTATE_HOME 房产所在地
     */
    public String getRealEstateHome() {
        return realEstateHome;
    }

    /**
     * 房产所在地
     * @param realEstateHome 房产所在地
     */
    public void setRealEstateHome(String realEstateHome) {
        this.realEstateHome = realEstateHome == null ? null : realEstateHome.trim();
    }

    /**
     * 详细地址
     * @return DETAILED_ADDRESS 详细地址
     */
    public String getDetailedAddress() {
        return detailedAddress;
    }

    /**
     * 详细地址
     * @param detailedAddress 详细地址
     */
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    /**
     * 房产性质
     * @return REAL_ESTATE_PROPERTIES 房产性质
     */
    public String getRealEstateProperties() {
        return realEstateProperties;
    }

    /**
     * 房产性质
     * @param realEstateProperties 房产性质
     */
    public void setRealEstateProperties(String realEstateProperties) {
        this.realEstateProperties = realEstateProperties == null ? null : realEstateProperties.trim();
    }

    /**
     * 房产区域
     * @return REAL_ESTATE_AREA 房产区域
     */
    public String getRealEstateArea() {
        return realEstateArea;
    }

    /**
     * 房产区域
     * @param realEstateArea 房产区域
     */
    public void setRealEstateArea(String realEstateArea) {
        this.realEstateArea = realEstateArea == null ? null : realEstateArea.trim();
    }

    /**
     * 年固定收入（元）
     * @return FIXED_ANNUAL_INCOME 年固定收入（元）
     */
    public BigDecimal getFixedAnnualIncome() {
        return fixedAnnualIncome;
    }

    /**
     * 年固定收入（元）
     * @param fixedAnnualIncome 年固定收入（元）
     */
    public void setFixedAnnualIncome(BigDecimal fixedAnnualIncome) {
        this.fixedAnnualIncome = fixedAnnualIncome;
    }

    /**
     * 征信时间
     * @return CREDIT_TIME 征信时间
     */
    public String getCreditTime() {
        return creditTime;
    }

    /**
     * 征信时间
     * @param creditTime 征信时间
     */
    public void setCreditTime(String creditTime) {
        this.creditTime = creditTime == null ? null : creditTime.trim();
    }

    /**
     * 征信对象类型
     * @return CREDIT_OBJ_TYPE 征信对象类型
     */
    public String getCreditObjType() {
        return creditObjType;
    }

    /**
     * 征信对象类型
     * @param creditObjType 征信对象类型
     */
    public void setCreditObjType(String creditObjType) {
        this.creditObjType = creditObjType == null ? null : creditObjType.trim();
    }

    /**
     * 征信结果
     * @return CREDIT_RESULT 征信结果
     */
    public String getCreditResult() {
        return creditResult;
    }

    /**
     * 征信结果
     * @param creditResult 征信结果
     */
    public void setCreditResult(String creditResult) {
        this.creditResult = creditResult == null ? null : creditResult.trim();
    }

    /**
     * 征信原因描述
     * @return CREDIT_REASON_DESCRIBE 征信原因描述
     */
    public String getCreditReasonDescribe() {
        return creditReasonDescribe;
    }

    /**
     * 征信原因描述
     * @param creditReasonDescribe 征信原因描述
     */
    public void setCreditReasonDescribe(String creditReasonDescribe) {
        this.creditReasonDescribe = creditReasonDescribe == null ? null : creditReasonDescribe.trim();
    }

    /**
     * 征信评分
     * @return CREDIT_RATING 征信评分
     */
    public String getCreditRating() {
        return creditRating;
    }

    /**
     * 征信评分
     * @param creditRating 征信评分
     */
    public void setCreditRating(String creditRating) {
        this.creditRating = creditRating == null ? null : creditRating.trim();
    }

    /**
     * 征信编号
     * @return CREDIT_CODE 征信编号
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 征信编号
     * @param creditCode 征信编号
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    /**
     * 征信生成时间
     * @return CREDIT_GENERATE_TIME 征信生成时间
     */
    public String getCreditGenerateTime() {
        return creditGenerateTime;
    }

    /**
     * 征信生成时间
     * @param creditGenerateTime 征信生成时间
     */
    public void setCreditGenerateTime(String creditGenerateTime) {
        this.creditGenerateTime = creditGenerateTime == null ? null : creditGenerateTime.trim();
    }

    /**
     * 联系人姓名
     * @return LINKMAN_NAME 联系人姓名
     */
    public String getLinkmanName() {
        return linkmanName;
    }

    /**
     * 联系人姓名
     * @param linkmanName 联系人姓名
     */
    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName == null ? null : linkmanName.trim();
    }

    /**
     * 联系人联系方式
     * @return LINKMAN_CONTACT 联系人联系方式
     */
    public String getLinkmanContact() {
        return linkmanContact;
    }

    /**
     * 联系人联系方式
     * @param linkmanContact 联系人联系方式
     */
    public void setLinkmanContact(String linkmanContact) {
        this.linkmanContact = linkmanContact == null ? null : linkmanContact.trim();
    }

    /**
     * 联系人与承租人关系
     * @return LINKMAN_LESSEE_RELATIONSHIP 联系人与承租人关系
     */
    public Integer getLinkmanLesseeRelationship() {
        return linkmanLesseeRelationship;
    }

    /**
     * 联系人与承租人关系
     * @param linkmanLesseeRelationship 联系人与承租人关系
     */
    public void setLinkmanLesseeRelationship(Integer linkmanLesseeRelationship) {
        this.linkmanLesseeRelationship = linkmanLesseeRelationship;
    }

    /**
     * 联系人居住地址
     * @return LINKMAN_ADDRESS 联系人居住地址
     */
    public String getLinkmanAddress() {
        return linkmanAddress;
    }

    /**
     * 联系人居住地址
     * @param linkmanAddress 联系人居住地址
     */
    public void setLinkmanAddress(String linkmanAddress) {
        this.linkmanAddress = linkmanAddress == null ? null : linkmanAddress.trim();
    }

    /**
     * 配偶姓名
     * @return SPOUSE_NAME 配偶姓名
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * 配偶姓名
     * @param spouseName 配偶姓名
     */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName == null ? null : spouseName.trim();
    }

    /**
     * 配偶证件类型
     * @return SPOUSE_IDENTITY_TYPE 配偶证件类型
     */
    public Integer getSpouseIdentityType() {
        return spouseIdentityType;
    }

    /**
     * 配偶证件类型
     * @param spouseIdentityType 配偶证件类型
     */
    public void setSpouseIdentityType(Integer spouseIdentityType) {
        this.spouseIdentityType = spouseIdentityType;
    }

    /**
     * 配偶证件号码
     * @return SPOUSE_IDENTITY_NO 配偶证件号码
     */
    public String getSpouseIdentityNo() {
        return spouseIdentityNo;
    }

    /**
     * 配偶证件号码
     * @param spouseIdentityNo 配偶证件号码
     */
    public void setSpouseIdentityNo(String spouseIdentityNo) {
        this.spouseIdentityNo = spouseIdentityNo == null ? null : spouseIdentityNo.trim();
    }

    /**
     * 配偶年龄
     * @return SPOUSE_AGE 配偶年龄
     */
    public Integer getSpouseAge() {
        return spouseAge;
    }

    /**
     * 配偶年龄
     * @param spouseAge 配偶年龄
     */
    public void setSpouseAge(Integer spouseAge) {
        this.spouseAge = spouseAge;
    }

    /**
     * 配偶联系方式
     * @return SPOUSE_CONTACT 配偶联系方式
     */
    public String getSpouseContact() {
        return spouseContact;
    }

    /**
     * 配偶联系方式
     * @param spouseContact 配偶联系方式
     */
    public void setSpouseContact(String spouseContact) {
        this.spouseContact = spouseContact == null ? null : spouseContact.trim();
    }

    /**
     * 配偶文化程度
     * @return SPOUSE_LEVEL_EDUCATION 配偶文化程度
     */
    public Integer getSpouseLevelEducation() {
        return spouseLevelEducation;
    }

    /**
     * 配偶文化程度
     * @param spouseLevelEducation 配偶文化程度
     */
    public void setSpouseLevelEducation(Integer spouseLevelEducation) {
        this.spouseLevelEducation = spouseLevelEducation;
    }

    /**
     * 配偶工作单位名称
     * @return SPOUSE_EMPLOYER_NAME 配偶工作单位名称
     */
    public String getSpouseEmployerName() {
        return spouseEmployerName;
    }

    /**
     * 配偶工作单位名称
     * @param spouseEmployerName 配偶工作单位名称
     */
    public void setSpouseEmployerName(String spouseEmployerName) {
        this.spouseEmployerName = spouseEmployerName == null ? null : spouseEmployerName.trim();
    }

    /**
     * 配偶单位电话
     * @return SPOUSE_EMPLOYER_PHONE 配偶单位电话
     */
    public String getSpouseEmployerPhone() {
        return spouseEmployerPhone;
    }

    /**
     * 配偶单位电话
     * @param spouseEmployerPhone 配偶单位电话
     */
    public void setSpouseEmployerPhone(String spouseEmployerPhone) {
        this.spouseEmployerPhone = spouseEmployerPhone == null ? null : spouseEmployerPhone.trim();
    }

    /**
     * 配偶单位地址
     * @return SPOUSE_EMPLOYER_ADDRESS 配偶单位地址
     */
    public String getSpouseEmployerAddress() {
        return spouseEmployerAddress;
    }

    /**
     * 配偶单位地址
     * @param spouseEmployerAddress 配偶单位地址
     */
    public void setSpouseEmployerAddress(String spouseEmployerAddress) {
        this.spouseEmployerAddress = spouseEmployerAddress == null ? null : spouseEmployerAddress.trim();
    }

    /**
     * 配偶单位性质
     * @return SPOUSE_EMPLOYER_NATURE 配偶单位性质
     */
    public String getSpouseEmployerNature() {
        return spouseEmployerNature;
    }

    /**
     * 配偶单位性质
     * @param spouseEmployerNature 配偶单位性质
     */
    public void setSpouseEmployerNature(String spouseEmployerNature) {
        this.spouseEmployerNature = spouseEmployerNature == null ? null : spouseEmployerNature.trim();
    }

    /**
     * 担保人姓名
     * @return GUARANTOR_NAME 担保人姓名
     */
    public String getGuarantorName() {
        return guarantorName;
    }

    /**
     * 担保人姓名
     * @param guarantorName 担保人姓名
     */
    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName == null ? null : guarantorName.trim();
    }

    /**
     * 担保人证件类型
     * @return GUARANTOR_IDENTITY_TYPE 担保人证件类型
     */
    public Integer getGuarantorIdentityType() {
        return guarantorIdentityType;
    }

    /**
     * 担保人证件类型
     * @param guarantorIdentityType 担保人证件类型
     */
    public void setGuarantorIdentityType(Integer guarantorIdentityType) {
        this.guarantorIdentityType = guarantorIdentityType;
    }

    /**
     * 担保人证件号
     * @return GUARANTOR_IDENTITY_NO 担保人证件号
     */
    public String getGuarantorIdentityNo() {
        return guarantorIdentityNo;
    }

    /**
     * 担保人证件号
     * @param guarantorIdentityNo 担保人证件号
     */
    public void setGuarantorIdentityNo(String guarantorIdentityNo) {
        this.guarantorIdentityNo = guarantorIdentityNo == null ? null : guarantorIdentityNo.trim();
    }

    /**
     * 担保人出生日期
     * @return GUARANTOR_BIRTHDAY 担保人出生日期
     */
    public String getGuarantorBirthday() {
        return guarantorBirthday;
    }

    /**
     * 担保人出生日期
     * @param guarantorBirthday 担保人出生日期
     */
    public void setGuarantorBirthday(String guarantorBirthday) {
        this.guarantorBirthday = guarantorBirthday == null ? null : guarantorBirthday.trim();
    }

    /**
     * 担保人性别
     * @return GUARANTOR_SEX 担保人性别
     */
    public Integer getGuarantorSex() {
        return guarantorSex;
    }

    /**
     * 担保人性别
     * @param guarantorSex 担保人性别
     */
    public void setGuarantorSex(Integer guarantorSex) {
        this.guarantorSex = guarantorSex;
    }

    /**
     * 担保人年龄
     * @return GUARANTOR_AGE 担保人年龄
     */
    public Integer getGuarantorAge() {
        return guarantorAge;
    }

    /**
     * 担保人年龄
     * @param guarantorAge 担保人年龄
     */
    public void setGuarantorAge(Integer guarantorAge) {
        this.guarantorAge = guarantorAge;
    }

    /**
     * 担保人联系方式
     * @return GUARANTOR_CONTACT 担保人联系方式
     */
    public String getGuarantorContact() {
        return guarantorContact;
    }

    /**
     * 担保人联系方式
     * @param guarantorContact 担保人联系方式
     */
    public void setGuarantorContact(String guarantorContact) {
        this.guarantorContact = guarantorContact == null ? null : guarantorContact.trim();
    }

    /**
     * 担保人与承租人关系
     * @return GUARANTOR_LESSEE_RELATIONSHIP 担保人与承租人关系
     */
    public String getGuarantorLesseeRelationship() {
        return guarantorLesseeRelationship;
    }

    /**
     * 担保人与承租人关系
     * @param guarantorLesseeRelationship 担保人与承租人关系
     */
    public void setGuarantorLesseeRelationship(String guarantorLesseeRelationship) {
        this.guarantorLesseeRelationship = guarantorLesseeRelationship == null ? null : guarantorLesseeRelationship.trim();
    }

    /**
     * 担保人年收入
     * @return GUARANTOR_ANNUAL_INCOME 担保人年收入
     */
    public BigDecimal getGuarantorAnnualIncome() {
        return guarantorAnnualIncome;
    }

    /**
     * 担保人年收入
     * @param guarantorAnnualIncome 担保人年收入
     */
    public void setGuarantorAnnualIncome(BigDecimal guarantorAnnualIncome) {
        this.guarantorAnnualIncome = guarantorAnnualIncome;
    }

    /**
     * 担保人婚姻状况
     * @return GUARANTOR_MARRY_STATUS 担保人婚姻状况
     */
    public Integer getGuarantorMarryStatus() {
        return guarantorMarryStatus;
    }

    /**
     * 担保人婚姻状况
     * @param guarantorMarryStatus 担保人婚姻状况
     */
    public void setGuarantorMarryStatus(Integer guarantorMarryStatus) {
        this.guarantorMarryStatus = guarantorMarryStatus;
    }

    /**
     * 担保人居住地址
     * @return GUARANTOR__ADDRESS 担保人居住地址
     */
    public String getGuarantorAddress() {
        return guarantorAddress;
    }

    /**
     * 担保人居住地址
     * @param guarantorAddress 担保人居住地址
     */
    public void setGuarantorAddress(String guarantorAddress) {
        this.guarantorAddress = guarantorAddress == null ? null : guarantorAddress.trim();
    }

    /**
     * 担保人单位名称
     * @return GUARANTOR_EMPLOYER_NAME 担保人单位名称
     */
    public String getGuarantorEmployerName() {
        return guarantorEmployerName;
    }

    /**
     * 担保人单位名称
     * @param guarantorEmployerName 担保人单位名称
     */
    public void setGuarantorEmployerName(String guarantorEmployerName) {
        this.guarantorEmployerName = guarantorEmployerName == null ? null : guarantorEmployerName.trim();
    }

    /**
     * 担保人单位地址
     * @return GUARANTOR_EMPLOYER_ADDRESS 担保人单位地址
     */
    public String getGuarantorEmployerAddress() {
        return guarantorEmployerAddress;
    }

    /**
     * 担保人单位地址
     * @param guarantorEmployerAddress 担保人单位地址
     */
    public void setGuarantorEmployerAddress(String guarantorEmployerAddress) {
        this.guarantorEmployerAddress = guarantorEmployerAddress == null ? null : guarantorEmployerAddress.trim();
    }

    /**
     * 担保人单位电话
     * @return GUARANTOR_EMPLOYER_PHONE 担保人单位电话
     */
    public String getGuarantorEmployerPhone() {
        return guarantorEmployerPhone;
    }

    /**
     * 担保人单位电话
     * @param guarantorEmployerPhone 担保人单位电话
     */
    public void setGuarantorEmployerPhone(String guarantorEmployerPhone) {
        this.guarantorEmployerPhone = guarantorEmployerPhone == null ? null : guarantorEmployerPhone.trim();
    }

    /**
     * 担保人担保能力说明
     * @return GUARANTOR_DESCRIBE 担保人担保能力说明
     */
    public String getGuarantorDescribe() {
        return guarantorDescribe;
    }

    /**
     * 担保人担保能力说明
     * @param guarantorDescribe 担保人担保能力说明
     */
    public void setGuarantorDescribe(String guarantorDescribe) {
        this.guarantorDescribe = guarantorDescribe == null ? null : guarantorDescribe.trim();
    }

    /**
     * 持卡人姓名
     * @return CARDHOLDER_NAME 持卡人姓名
     */
    public String getCardholderName() {
        return cardholderName;
    }

    /**
     * 持卡人姓名
     * @param cardholderName 持卡人姓名
     */
    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName == null ? null : cardholderName.trim();
    }

    /**
     * 卡号
     * @return CARD_NO 卡号
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 卡号
     * @param cardNo 卡号
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    /**
     * 开户银行
     * @return BANK 开户银行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 开户银行
     * @param bank 开户银行
     */
    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    /**
     * 开户行号
     * @return BANK_NO 开户行号
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     * 开户行号
     * @param bankNo 开户行号
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getIphoneNo() {
        return iphoneNo;
    }

    public void setIphoneNo(String iphoneNo) {
        this.iphoneNo = iphoneNo;
    }
}