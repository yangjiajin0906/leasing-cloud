package com.leasing.common.entity.customer.dto;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description: 机构实体对象
 **/
@Entity
@Table(name="sm_org")
public class OrgDTO extends BaseEntity {

    @Id
    private String pkOrg;
    private String orgCode;
    private String shortName;
    private String orgName;
    private String parentPk;
    private String foundDate;
    private Short datastatus;
    private String operateDate;
    private String operateTime;
    private String loginTag;
    private String lockedTag;
    private Short orgLevel;
    private Short orgStatus;
    private String oneLevelOrg;
    private String isSpvcorp;

    private String refpk;
    private String refname;
    private String name;
    private String code;

    public String getRefpk() {
        return refpk;
    }

    public void setRefpk(String refpk) {
        this.refpk = refpk;
    }

    public String getRefname() {
        return refname;
    }

    public void setRefname(String refname) {
        this.refname = refname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPk() {
        return pkOrg;
    }

    public void setPk(String pk) {
        this.pkOrg = pk;
    }

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getTableName() {
        return "sm_org";
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentPk() {
        return parentPk;
    }

    public void setParentPk(String parentPk) {
        this.parentPk = parentPk;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public Short getDatastatus() {
        return datastatus;
    }

    public void setDatastatus(Short datastatus) {
        this.datastatus = datastatus;
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

    public String getLoginTag() {
        return loginTag;
    }

    public void setLoginTag(String loginTag) {
        this.loginTag = loginTag;
    }

    public String getLockedTag() {
        return lockedTag;
    }

    public void setLockedTag(String lockedTag) {
        this.lockedTag = lockedTag;
    }

    public Short getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Short orgLevel) {
        this.orgLevel = orgLevel;
    }

    public Short getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(Short orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOneLevelOrg() {
        return oneLevelOrg;
    }

    public void setOneLevelOrg(String oneLevelOrg) {
        this.oneLevelOrg = oneLevelOrg;
    }

    public String getIsSpvcorp() {
        return isSpvcorp;
    }

    public void setIsSpvcorp(String isSpvcorp) {
        this.isSpvcorp = isSpvcorp;
    }


}
