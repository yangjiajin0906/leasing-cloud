package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer_person")
public class CustomerPersonDO extends BaseDO {

    @Id
    private String pkCustomerPerson;

    private String birthday;

    private Short politics;

    private String graduateSchool;

    private String employerAddress;

    private Short nation;

    private String city;

    private String employerName;

    private String loanCardNo;

    private String memo;

    private String homeAddr;

    private String pkCustomer;

    private Short marryStatus;

    private String wagesAccountBank;

    private String employerIndustry1;

    private String province;

    private String homePostcode;

    private BigDecimal personAnnualIncome;

    private Short versionNumPerson;

    private String graduateYear;

    private String commAddr;

    private String permanentAddress;

    private Short homeStatus;

    private String department;

    private String fax;

    private String email;

    private BigDecimal familyAnnualIncome;

    private String employerTel;

    private String officalTitle;

    private Short sex;

    private String homePhone;

    private String mobile;

    private String startDateJob;

    private Short maxEducation;

    private String employerIndustry;

    private String employerEmail;

    private String district;

    private String cusotmerClass;

    private String wagesAccountNo;

    private String duty;

    private Short maxDegree;

    private String job;

    private String interests;

    private String commPostcode;

    public String getPkCustomerPerson() {
        return pkCustomerPerson;
    }

    public void setPkCustomerPerson(String pkCustomerPerson) {
        this.pkCustomerPerson = pkCustomerPerson;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Short getPolitics() {
        return politics;
    }

    public void setPolitics(Short politics) {
        this.politics = politics;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public Short getNation() {
        return nation;
    }

    public void setNation(Short nation) {
        this.nation = nation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getLoanCardNo() {
        return loanCardNo;
    }

    public void setLoanCardNo(String loanCardNo) {
        this.loanCardNo = loanCardNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Short getMarryStatus() {
        return marryStatus;
    }

    public void setMarryStatus(Short marryStatus) {
        this.marryStatus = marryStatus;
    }

    public String getWagesAccountBank() {
        return wagesAccountBank;
    }

    public void setWagesAccountBank(String wagesAccountBank) {
        this.wagesAccountBank = wagesAccountBank;
    }

    public String getEmployerIndustry1() {
        return employerIndustry1;
    }

    public void setEmployerIndustry1(String employerIndustry1) {
        this.employerIndustry1 = employerIndustry1;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getHomePostcode() {
        return homePostcode;
    }

    public void setHomePostcode(String homePostcode) {
        this.homePostcode = homePostcode;
    }

    public BigDecimal getPersonAnnualIncome() {
        return personAnnualIncome;
    }

    public void setPersonAnnualIncome(BigDecimal personAnnualIncome) {
        this.personAnnualIncome = personAnnualIncome;
    }

    public Short getVersionNumPerson() {
        return versionNumPerson;
    }

    public void setVersionNumPerson(Short versionNumPerson) {
        this.versionNumPerson = versionNumPerson;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getCommAddr() {
        return commAddr;
    }

    public void setCommAddr(String commAddr) {
        this.commAddr = commAddr;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Short getHomeStatus() {
        return homeStatus;
    }

    public void setHomeStatus(Short homeStatus) {
        this.homeStatus = homeStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getFamilyAnnualIncome() {
        return familyAnnualIncome;
    }

    public void setFamilyAnnualIncome(BigDecimal familyAnnualIncome) {
        this.familyAnnualIncome = familyAnnualIncome;
    }

    public String getEmployerTel() {
        return employerTel;
    }

    public void setEmployerTel(String employerTel) {
        this.employerTel = employerTel;
    }

    public String getOfficalTitle() {
        return officalTitle;
    }

    public void setOfficalTitle(String officalTitle) {
        this.officalTitle = officalTitle;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
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

    public String getStartDateJob() {
        return startDateJob;
    }

    public void setStartDateJob(String startDateJob) {
        this.startDateJob = startDateJob;
    }

    public Short getMaxEducation() {
        return maxEducation;
    }

    public void setMaxEducation(Short maxEducation) {
        this.maxEducation = maxEducation;
    }

    public String getEmployerIndustry() {
        return employerIndustry;
    }

    public void setEmployerIndustry(String employerIndustry) {
        this.employerIndustry = employerIndustry;
    }

    public String getEmployerEmail() {
        return employerEmail;
    }

    public void setEmployerEmail(String employerEmail) {
        this.employerEmail = employerEmail;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCusotmerClass() {
        return cusotmerClass;
    }

    public void setCusotmerClass(String cusotmerClass) {
        this.cusotmerClass = cusotmerClass;
    }

    public String getWagesAccountNo() {
        return wagesAccountNo;
    }

    public void setWagesAccountNo(String wagesAccountNo) {
        this.wagesAccountNo = wagesAccountNo;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Short getMaxDegree() {
        return maxDegree;
    }

    public void setMaxDegree(Short maxDegree) {
        this.maxDegree = maxDegree;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getCommPostcode() {
        return commPostcode;
    }

    public void setCommPostcode(String commPostcode) {
        this.commPostcode = commPostcode;
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