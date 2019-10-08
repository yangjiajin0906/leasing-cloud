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
@Table(name = "bd_deptdoc")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class DeptdocRefVO {
    @Id
    @Column(name = "pk_deptdoc")
    public String pk;

    @Column(name = "deptcode")
    public String code;

    @Column(name = "deptname")
    public String name;

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
}
