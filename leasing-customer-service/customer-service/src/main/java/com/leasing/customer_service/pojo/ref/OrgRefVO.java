package com.leasing.customer_service.pojo.ref;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-09-25
 * @author:zhangzhhn@yonyou.com
 * @description: 机构参照VO
 **/

@Entity
@Table(name = "sm_org")
public class OrgRefVO {

    @Id
    @Column(name = "pkOrg")
    private String pk;
    @Column(name = "orgName",insertable = false, updatable = false)
    private String name;
    @Column(name = "orgName")
    private String code;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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
}