package com.leasing.sys.entity.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 用户实体类
 **/
@Entity
@Table(name = "sm_user_view")
public class UserDO extends BaseDO{

    @Id
    private String pkUser;
    private String userName;
    private String userCode;
    private String password;
    private String beginDate;
    private String endDate;
    private String lockedTag;
    private String loginTag;
    private String memo;
    private String pkOrg;
    private String isAdmin;
    private Short userRole;
    private String telNo;
    private String psnname;
    private String deptname;
    @Transient
    private String pkOperator;
    private String psndeptname;

    public String getPkUser() {
        return pkUser;
    }

    public void setPkUser(String pkUser) {
        this.pkUser = pkUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLockedTag() {
        return lockedTag;
    }

    public void setLockedTag(String lockedTag) {
        this.lockedTag = lockedTag;
    }

    public String getLoginTag() {
        return loginTag;
    }

    public void setLoginTag(String loginTag) {
        this.loginTag = loginTag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Short getUserRole() {
        return userRole;
    }

    public void setUserRole(Short userRole) {
        this.userRole = userRole;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(String pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getPsndeptname() {
        return psndeptname;
    }

    public void setPsndeptname(String psndeptname) {
        this.psndeptname = psndeptname;
    }

    @Override
    public String getPk() {
        return pkUser;
    }

    @Override
    public void setPk(String pk) {
        this.pkUser = pk;
    }
}