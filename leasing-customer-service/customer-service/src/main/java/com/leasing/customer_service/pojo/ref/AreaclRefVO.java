package com.leasing.customer_service.pojo.ref;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/

@Entity
@Table(name = "bd_areacl")
public class AreaclRefVO {

    @Id
    @Column(name = "pkAreacl")
    private String pk;

    @Column(name = "areaclname")
    private String name;

    @Column(name = "areaclcode")
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