package com.leasing.project.refVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/9/26
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "sm_org")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class OrgRefVO {

    @Id
    @Column(name = "pk_org")
    public String pk;

    @Column(name = "org_code")
    public String code;

    @Column(name = "org_name")
    public String name;

    @Column(name = "short_name")
    public String shortName;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
