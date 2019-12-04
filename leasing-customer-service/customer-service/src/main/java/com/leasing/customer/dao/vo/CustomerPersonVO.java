package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.entity.foundation.vo.AreaclVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人表
 **/
@Entity
@Table(name = "yls_customer_person")
public class CustomerPersonVO extends BaseVO {
    /**
     * 主键
     */
    @Id
    private String pkCustomerPerson;

    /**
     * 版本号
     */
    private Integer versionNumPerson;

    /**
     * 客户类型
     */
    private String cusotmerClass;

    /**
     * 客户类型
     */
    @ManyToOne
    @JoinColumn(name = "cusotmerClassTemp")
    @Transient
    private ParameterDTO cusotmerClassTemp;

    /**
     * 性别
     */
    private Short sex;


    /**
     * 出生日期
     */
    private String birthday;


    /**
     * 民族
     */
    private Short nation;


    /**
     * 政治面貌
     */
    private Short politics;


    /**
     * 户籍地址
     */
    private String permanentAddress;


    /**
     * 婚姻状况
     */
    private Short marryStatus;


    /**
     * 个人年收入（元）
     */
    private BigDecimal personAnnualIncome;


    /**
     * 家庭月收入（元）
     */
    private BigDecimal familyAnnualIncome;


    /**
     * 最高学位
     */
    private Short maxDegree;


    /**
     * 最高学历
     */
    private Short maxEducation;


    /**
     * 毕业年份（最高学历）
     */
    private String graduateYear;


    /**
     * 毕业学校（最高学历）
     */
    private String graduateSchool;

    /**
     * 单位所属行业
     */
    @ManyToOne
    @JoinColumn(name = "employerIndustry")
    private ParameterDTO employerIndustry;

    /**
     * 单位所属行业
     */
    @ManyToOne
    @JoinColumn(name = "employerIndustry1")
    private ParameterDTO employerIndustry1;

    /**
     * 单位名称
     */
    private String employerName;

    /**
     * 单位地址
     */
    private String employerAddress;

    /**
     * 单位邮箱
     */
    private String employerEmail;

    /**
     * 单位电话
     */
    private String employerTel;

    /**
     * 部门
     */
    private String department;

    /**
     * 职业
     */
    private String job;

    /**
     * 职务
     */
    private String duty;

    /**
     * 职称
     */
    private String officalTitle;


    /**
     * 贷款卡号
     */
    private String loanCardNo;

    /**
     * 本单位工作起始日
     */
    private String startDateJob;

    /**
     * 工资账号
     */
    private String wagesAccountNo;

    /**
     * 工资账号开户行
     */
    private String wagesAccountBank;

    /**
     * 兴趣爱好（限200汉字）
     */
    private String interests;

    /**
     * 备注（限200汉字）
     */
    private String memo;

    /**
     * 住宅电话
     */
    private String homePhone;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 居住状态
     */
    private Short homeStatus;

    /**
     * 居住地址
     */
    private String homeAddr;

    /**
     * 居住地址邮编
     */
    private String homePostcode;

    /**
     * 通讯地址
     */
    private String commAddr;

    /**
     * 通讯地址邮编
     */
    private String commPostcode;

    /**
     * 传真
     */
    private String fax;
    /**
     * 地区（省）
     */
    @ManyToOne
    @JoinColumn(name = "province")
    private AreaclVO province;

    /**
     * 地区（市）
     */
    @ManyToOne
    @JoinColumn(name = "city")
    private AreaclVO city;

    /**
     * 地区（县/区）
     */
    @ManyToOne
    @JoinColumn(name = "district")
    private AreaclVO district;

    @Transient
    private String booleanOne;


    public String getPkCustomerPerson() {
        return pkCustomerPerson;
    }

    public void setPkCustomerPerson(String pkCustomerPerson) {
        this.pkCustomerPerson = pkCustomerPerson;
    }

    public Integer getVersionNumPerson() {
        return versionNumPerson;
    }

    public void setVersionNumPerson(Integer versionNumPerson) {
        this.versionNumPerson = versionNumPerson;
    }

    public String getCusotmerClass() {
        return cusotmerClass;
    }

    public void setCusotmerClass(String cusotmerClass) {
        this.cusotmerClass = cusotmerClass;
    }

    public ParameterDTO getCusotmerClassTemp() {
        return cusotmerClassTemp;
    }

    public void setCusotmerClassTemp(ParameterDTO cusotmerClassTemp) {
        this.cusotmerClassTemp = cusotmerClassTemp;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Short getNation() {
        return nation;
    }

    public void setNation(Short nation) {
        this.nation = nation;
    }

    public Short getPolitics() {
        return politics;
    }

    public void setPolitics(Short politics) {
        this.politics = politics;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Short getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Short marryStatus) {
        this.marryStatus = marryStatus;
    }

    public BigDecimal getPersonAnnualIncome() {
        return personAnnualIncome;
    }

    public void setPersonAnnualIncome(BigDecimal personAnnualIncome) {
        this.personAnnualIncome = personAnnualIncome;
    }

    public BigDecimal getFamilyAnnualIncome() {
        return familyAnnualIncome;
    }

    public void setFamilyAnnualIncome(BigDecimal familyAnnualIncome) {
        this.familyAnnualIncome = familyAnnualIncome;
    }

    public Short getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(Short maxDegree) {
        this.maxDegree = maxDegree;
    }

    public Short getMaxEducation() {
        return maxEducation;
    }

    public void setMaxEducation(Short maxEducation) {
        this.maxEducation = maxEducation;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public ParameterDTO getEmployerIndustry() {
        return employerIndustry;
    }

    public void setEmployerIndustry(ParameterDTO employerIndustry) {
        this.employerIndustry = employerIndustry;
    }

    public ParameterDTO getEmployerIndustry1() {
        return employerIndustry1;
    }

    public void setEmployerIndustry1(ParameterDTO employerIndustry1) {
        this.employerIndustry1 = employerIndustry1;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getEmployerTel() {
        return employerTel;
    }

    public void setEmployerTel(String employerTel) {
        this.employerTel = employerTel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getOfficalTitle() {
        return officalTitle;
    }

    public void setOfficalTitle(String officalTitle) {
        this.officalTitle = officalTitle;
    }

    public String getLoanCardNo() {
        return loanCardNo;
    }

    public void setLoanCardNo(String loanCardNo) {
        this.loanCardNo = loanCardNo;
    }

    public String getStartDateJob() {
        return startDateJob;
    }

    public void setStartDateJob(String startDateJob) {
        this.startDateJob = startDateJob;
    }

    public String getWagesAccountNo() {
        return wagesAccountNo;
    }

    public void setWagesAccountNo(String wagesAccountNo) {
        this.wagesAccountNo = wagesAccountNo;
    }

    public String getWagesAccountBank() {
        return wagesAccountBank;
    }

    public void setWagesAccountBank(String wagesAccountBank) {
        this.wagesAccountBank = wagesAccountBank;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getHomeStatus() {
        return homeStatus;
    }

    public void setHomeStatus(Short homeStatus) {
        this.homeStatus = homeStatus;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getHomePostcode() {
        return homePostcode;
    }

    public void setHomePostcode(String homePostcode) {
        this.homePostcode = homePostcode;
    }

    public String getCommAddr() {
        return commAddr;
    }

    public void setCommAddr(String commAddr) {
        this.commAddr = commAddr;
    }

    public String getCommPostcode() {
        return commPostcode;
    }

    public void setCommPostcode(String commPostcode) {
        this.commPostcode = commPostcode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public AreaclVO getProvince() {
        return province;
    }

    public void setProvince(AreaclVO province) {
        this.province = province;
    }

    public AreaclVO getCity() {
        return city;
    }

    public void setCity(AreaclVO city) {
        this.city = city;
    }

    public AreaclVO getDistrict() {
        return district;
    }

    public void setDistrict(AreaclVO district) {
        this.district = district;
    }

    public String getBooleanOne() {
        return booleanOne;
    }

    public void setBooleanOne(String booleanOne) {
        this.booleanOne = booleanOne;
    }

    @Override
    public String getPk() {
        return pkCustomerPerson;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerPerson = pk;
    }
}