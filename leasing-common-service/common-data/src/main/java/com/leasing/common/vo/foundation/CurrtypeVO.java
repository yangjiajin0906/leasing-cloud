package com.leasing.common.vo.foundation;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "bd_currtype")
public class CurrtypeVO extends BaseEntity {

    @Id
    private String pkCurrtype;

    private String currbusidigit;

    private String currdigit;

    private String currtypecode;

    private String currtypename;

    private String currtypesign;

    private String dr;

    @Override
    public String getPk() {
        return this.pkCurrtype;
    }

    @Override
    public void setPk(String pk) {
        this.pkCurrtype = pk;
    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public String getCurrbusidigit() {
        return currbusidigit;
    }

    public void setCurrbusidigit(String currbusidigit) {
        this.currbusidigit = currbusidigit;
    }

    public String getCurrdigit() {
        return currdigit;
    }

    public void setCurrdigit(String currdigit) {
        this.currdigit = currdigit;
    }

    public String getCurrtypecode() {
        return currtypecode;
    }

    public void setCurrtypecode(String currtypecode) {
        this.currtypecode = currtypecode;
    }

    public String getCurrtypename() {
        return currtypename;
    }

    public void setCurrtypename(String currtypename) {
        this.currtypename = currtypename;
    }

    public String getCurrtypesign() {
        return currtypesign;
    }

    public void setCurrtypesign(String currtypesign) {
        this.currtypesign = currtypesign;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }
}