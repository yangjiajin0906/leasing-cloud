package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.base.entity.BaseDTO;
import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 币种参照
 **/
@Entity
@Table(name = "bd_currtype")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class CurrtypeDTO extends BaseDTO {
    @Id
    public String pkCurrtype;

    public String currtypecode;

    public String currtypename;

    public String currtypesign;

//    public CurrtypeDTO(String pkCurrtype, String currtypecode, String currtypename, String currtypesign) {
//        this.pkCurrtype = pkCurrtype;
//        this.currtypecode = currtypecode;
//        this.currtypename = currtypename;
//        this.currtypesign = currtypesign;
//        this.setCode(currtypecode);
//        this.setName(currtypename);
//        this.setPk(pkCurrtype);
//    }

    public String getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(String pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
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

    public String getPk() {
        return pkCurrtype;
    }

    public void setPk(String pk) {
        this.pkCurrtype = pk;
    }

    @Transient
    public String name;

    @Transient
    public String code;
    public String getName(){
        return currtypename;
    }

    public String getCode(){
        return currtypecode;
    }

    public void setName(String name) {
        this.name = this.currtypename;
    }

    public void setCode(String code) {
        this.code = this.currtypecode;
    }
}
