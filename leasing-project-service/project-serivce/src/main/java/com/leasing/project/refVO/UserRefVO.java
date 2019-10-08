package com.leasing.project.refVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/9/26
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "sm_user_view")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class UserRefVO {

    @Id
    @Column(name = "pk_user")
    public String pk;

    @Column(name = "user_code")
    public String code;

    @Column(name = "user_name")
    public String name;

    @Column(name = "user_role")
    public String user_role;

    @Column(name = "psnname")
    public String psnname;

    @Column(name = "deptname")
    public String psndeptname;

   // @Column(name = "pk_deptdoc")
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pk_deptdoc", referencedColumnName = "pk_deptdoc")
    public DeptdocRefVO pk_deptdoc;

    //@Column(name = "pk_org")
    @ManyToOne(fetch = FetchType.LAZY) //JPA注释： 一对一 关系
    @JoinColumn(name = "pk_org", referencedColumnName = "pk_org")
    public OrgRefVO pk_org;

    @Column(name = "pk_userde_user")
    public String pk_userde_user;

    @Column(name = "pk_userde_code")
    public String pk_userde_code;

    @Column(name = "pk_userde_name")
    public String pk_userde_name;

    @Column(name = "cuserid")
    public String cuserid;

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

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getPsndeptname() {
        return psndeptname;
    }

    public void setPsndeptname(String psndeptname) {
        this.psndeptname = psndeptname;
    }

    public DeptdocRefVO getPk_deptdoc() {
        return pk_deptdoc;
    }

    public void setPk_deptdoc(DeptdocRefVO pk_deptdoc) {
        this.pk_deptdoc = pk_deptdoc;
    }

    public OrgRefVO getPk_org() {
        return pk_org;
    }

    public void setPk_org(OrgRefVO pk_org) {
        this.pk_org = pk_org;
    }

    public String getPk_userde_user() {
        return pk_userde_user;
    }

    public void setPk_userde_user(String pk_userde_user) {
        this.pk_userde_user = pk_userde_user;
    }

    public String getPk_userde_code() {
        return pk_userde_code;
    }

    public void setPk_userde_code(String pk_userde_code) {
        this.pk_userde_code = pk_userde_code;
    }

    public String getPk_userde_name() {
        return pk_userde_name;
    }

    public void setPk_userde_name(String pk_userde_name) {
        this.pk_userde_name = pk_userde_name;
    }

    public String getCuserid() {
        return cuserid;
    }

    public void setCuserid(String cuserid) {
        this.cuserid = cuserid;
    }
}
