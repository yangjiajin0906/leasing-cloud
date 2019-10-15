package com.leasing.common.entity.foundation;

import com.leasing.common.entity.base.BaseEntity;
import com.leasing.common.entity.base.BusinessEntity;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 用户实体类
 **/
@Entity
@Table(name="sm_user_view")
public class UserVO extends BaseEntity {

    @Id
    private String pkUser;
    private String userName;
    private String userCode;
    private String password;
    private String beginDate;
    private String endDate;
    private Boolean lockedTag;
    private Boolean loginTag;
    private String memo;
    @ManyToOne
    @JoinColumn(name="pkOrg")
    private OrgVO pkOrg;
    private Boolean isAdmin;
    private Short userRole;
    private String telNo;
    private String psnname;
    private String deptname;

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

    public Boolean getLockedTag() {
        return lockedTag;
    }

    public void setLockedTag(Boolean lockedTag) {
        this.lockedTag = lockedTag;
    }

    public Boolean getLoginTag() {
        return loginTag;
    }

    public void setLoginTag(Boolean loginTag) {
        this.loginTag = loginTag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
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

    @Override
    public String getPk() {
        return pkUser;
    }

    @Override
    public void setPk(String pk) {
        this.pkUser = pk;
    }
}
