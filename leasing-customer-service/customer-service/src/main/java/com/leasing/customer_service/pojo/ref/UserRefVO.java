package com.leasing.customer_service.pojo.ref;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/


@Entity
@Table(name = "sm_user_view")
public class UserRefVO {

    @Id
    @Column(name = "cuserid")
    private String pk;

    @Column(name = "userName")
    private String name;

    @Column(name = "userCode")
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