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
@Table(name = "bd_areacl")
public class AreaclVO extends BaseEntity {

    @Id
    private String pkAreacl;

    private String areaclcode;

    private String areaclname;

    private String dr;

    private String pkCorp;


    @Override
    public String getPk() {
        return this.pkAreacl;
    }

    @Override
    public void setPk(String pk) {
        this.pkAreacl = pk;
    }

    public String getPkAreacl() {
        return pkAreacl;
    }

    public void setPkAreacl(String pkAreacl) {
        this.pkAreacl = pkAreacl;
    }

    public String getAreaclcode() {
        return areaclcode;
    }

    public void setAreaclcode(String areaclcode) {
        this.areaclcode = areaclcode;
    }

    public String getAreaclname() {
        return areaclname;
    }

    public void setAreaclname(String areaclname) {
        this.areaclname = areaclname;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(String pkCorp) {
        this.pkCorp = pkCorp;
    }

}