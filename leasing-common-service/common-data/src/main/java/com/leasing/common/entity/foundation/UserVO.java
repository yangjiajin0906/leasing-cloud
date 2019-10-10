package com.leasing.common.entity.foundation;

import com.leasing.common.entity.base.BaseBusiEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-8
 * @author:lvcna@yonyou.com
 * @description: 用户实体类
 **/
@Entity
@Table(name="sm_user_view")
public class UserVO extends BaseBusiEntity {

    private String pk_user;
    private String user_name;
    private String user_code;
    private String password;
    private String begin_date;
    private String end_date;
    private Boolean locked_tag;
    private Boolean login_tag;
    private String memo;
    @ManyToOne
    @JoinColumn(name="pk_org")
    private OrgVO pk_org;
    private Boolean is_admin;
    private Short user_role;
    private String tel_no;
    private String psnname;
    private String psndeptname;

    public String getTableName() {
        return "sm_user_view";
    }

    public String getPk_user() {
        return pk_user;
    }

    public void setPk_user(String pk_user) {
        this.pk_user = pk_user;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public Boolean getLocked_tag() {
        return locked_tag;
    }

    public void setLocked_tag(Boolean locked_tag) {
        this.locked_tag = locked_tag;
    }

    public Boolean getLogin_tag() {
        return login_tag;
    }

    public void setLogin_tag(Boolean login_tag) {
        this.login_tag = login_tag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public OrgVO getPk_org() {
        return pk_org;
    }

    public void setPk_org(OrgVO pk_org) {
        this.pk_org = pk_org;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Short getUser_role() {
        return user_role;
    }

    public void setUser_role(Short user_role) {
        this.user_role = user_role;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
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

    public String getPk() {
        return pk_user;
    }

    public void setPk(String pk) {
        this.pk_user = pk;
    }


}
