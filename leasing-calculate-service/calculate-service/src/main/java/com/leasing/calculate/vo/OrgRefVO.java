package com.leasing.calculate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 机构RefVO
 * @date:2019/9/27
 * @author:Yjj@yonyou.com
 * @description:
 **/
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sm_org")
public class OrgRefVO {
    @Id
    private String pk_org;

    private String org_code;

    private String org_name;


    public String getPk_org() {
        return pk_org;
    }

    public void setPk_org(String pk_org) {
        this.pk_org = pk_org;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }
}