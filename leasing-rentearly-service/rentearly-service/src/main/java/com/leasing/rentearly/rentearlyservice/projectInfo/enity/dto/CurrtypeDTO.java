package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 币种参照
 **/
@Entity
@Table(name = "bd_currtype")
public class CurrtypeDTO extends BaseEntity {
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

    @Override
    public String getPk() {
        return pkCurrtype;
    }

    @Override
    public void setPk(String pk) {
        this.pkCurrtype = pk;
    }
}
