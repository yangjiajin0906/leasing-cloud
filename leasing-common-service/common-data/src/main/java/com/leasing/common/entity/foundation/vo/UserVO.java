package com.leasing.common.entity.foundation.vo;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.entity.customer.dto.DeptDTO;
import com.leasing.common.entity.customer.dto.OrgDTO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 用户实体类
 **/
@Entity
@Table(name = "sm_user_view")
public class UserVO extends BaseEntity {

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
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgDTO pkOrg;
    private String isAdmin;
    private Short userRole;
    private String telNo;
    private String psnname;
    private String deptname;
    @ManyToOne
    @JoinColumn(name = "pkDeptdoc")
    private DeptDTO pkDeptdoc;
    private String pkUserdeCode;
    private String pkUserdeUser;
    @Transient
    private String tokenid;

    public String getTableName() {
        return "sm_user_view";
    }

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

    public OrgDTO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgDTO pkOrg) {
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

    public String getPkUserdeCode() {
        return pkUserdeCode;
    }

    public void setPkUserdeCode(String pkUserdeCode) {
        this.pkUserdeCode = pkUserdeCode;
    }

    public String getPkUserdeUser() {
        return pkUserdeUser;
    }

    public void setPkUserdeUser(String pkUserdeUser) {
        this.pkUserdeUser = pkUserdeUser;
    }

    public DeptDTO getPkDeptdoc() {
        return pkDeptdoc;
    }

    public void setPkDeptdoc(DeptDTO pkDeptdoc) {
        this.pkDeptdoc = pkDeptdoc;
    }

    @Override
    public String getPk() {
        return pkUser;
    }

    @Override
    public void setPk(String pk) {
        this.pkUser = pk;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }
}
