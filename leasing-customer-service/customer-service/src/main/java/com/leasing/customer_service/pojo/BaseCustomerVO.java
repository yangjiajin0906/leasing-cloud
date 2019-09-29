package com.leasing.customer_service.pojo;

import com.leasing.customer_service.utils.BaseQuery;
import com.leasing.customer_service.utils.MatchType;
import com.leasing.customer_service.utils.QueryCondition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
//@Entity
//@Table(name = "yls_customer")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseCustomerVO<T> extends BaseQuery<T> {

    /**
     * 客户主键
     */
    @Id
    public String pkCustomer;

    /**
     * 版本号
     */
    public Integer versionNum;


    /**
     * 客户类别
     */
    @QueryCondition(func = MatchType.equal)
    public Short customerType;


    /**
     * 客户编号
     */
    @QueryCondition(func = MatchType.equal)
    public String customerCode;


    /**
     * 客户名称
     */
    @QueryCondition(func = MatchType.like)
    @Column(name = "customer_name")
    public String customerName;


    /**
     * 客户英文名
     */
    public String customer_eng_name;


    /**
     * 证件类型
     */
    public Short identity_type;


    /**
     * 证件号码
     */
    public String identity_no;


//    /**
//     * 客户经理
//     */
//    public UserRefVO pk_prj_manager;

    /**
     * 部门名称
     */
//    public DeptdocRefVO pk_dept;

    /**
     * 客户状态
     */
    public Short customer_status;

    /**
     * 是否黑名单
     */
    public Short if_black_list;

    /**
     * 冻结处理方式
     */
    public Short freeze_treatment;

    /**
     * 变更状态
     */
    public Short altera_status;

    /**
     * 单据状态
     */
    @Column(name = "billstatus")
    public Short billstatus;


    /**
     * 最新变更人
     */
//    public UserRefVO pk_operator_lst;


    /**
     * 最新变更日期
     */
    public String operate_date_lst;


    /**
     * 最新变更时间
     */
    public String operate_time_lst;


    /**
     * 记账人
     */
//    public UserRefVO pk_operator;

    /**
     * 记账日期
     */
    public String operate_date;


    /**
     * 记账时间
     */
    public String operate_time;


    /**
     * 复核人
     */
//    public UserRefVO pk_checker;

    /**
     * 复核日期
     */
    public String check_date;


    /**
     * 复核时间
     */
    public String check_time;


    /**
     * 授权人
     */
//    public UserRefVO pk_grantor;

    /**
     * 授权日期
     */
    public String grant_date;


    /**
     * 授权时间
     */
    public String grant_time;

    /**
     * 生效日期
     */
    public String effective_date;

    /**
     * 机构
     */

    @OneToOne
    @JoinColumn(name = "pkOrg", referencedColumnName = "pk_org")
    public OrgRefVO pkOrg;

    /**
     * 机构信用代码”   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    public String org_credit_code;

    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    public Short if_warrant_cust;

    /**
     * 是否最新
     */
    public Short if_new;


    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdb_code;


    /**
     * 20180911 是否CRM系统推送客户
     */
    public Short if_crm_push;

    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomer_eng_name() {
        return customer_eng_name;
    }

    public void setCustomer_eng_name(String customer_eng_name) {
        this.customer_eng_name = customer_eng_name;
    }

    public Short getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(Short identity_type) {
        this.identity_type = identity_type;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public Short getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(Short customer_status) {
        this.customer_status = customer_status;
    }

    public Short getIf_black_list() {
        return if_black_list;
    }

    public void setIf_black_list(Short if_black_list) {
        this.if_black_list = if_black_list;
    }

    public Short getFreeze_treatment() {
        return freeze_treatment;
    }

    public void setFreeze_treatment(Short freeze_treatment) {
        this.freeze_treatment = freeze_treatment;
    }

    public Short getAltera_status() {
        return altera_status;
    }

    public void setAltera_status(Short altera_status) {
        this.altera_status = altera_status;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getOperate_date_lst() {
        return operate_date_lst;
    }

    public void setOperate_date_lst(String operate_date_lst) {
        this.operate_date_lst = operate_date_lst;
    }

    public String getOperate_time_lst() {
        return operate_time_lst;
    }

    public void setOperate_time_lst(String operate_time_lst) {
        this.operate_time_lst = operate_time_lst;
    }

    public String getOperate_date() {
        return operate_date;
    }

    public void setOperate_date(String operate_date) {
        this.operate_date = operate_date;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public String getGrant_date() {
        return grant_date;
    }

    public void setGrant_date(String grant_date) {
        this.grant_date = grant_date;
    }

    public String getGrant_time() {
        return grant_time;
    }

    public void setGrant_time(String grant_time) {
        this.grant_time = grant_time;
    }

    public String getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(String effective_date) {
        this.effective_date = effective_date;
    }

    public OrgRefVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgRefVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOrg_credit_code() {
        return org_credit_code;
    }

    public void setOrg_credit_code(String org_credit_code) {
        this.org_credit_code = org_credit_code;
    }

    public Short getIf_warrant_cust() {
        return if_warrant_cust;
    }

    public void setIf_warrant_cust(Short if_warrant_cust) {
        this.if_warrant_cust = if_warrant_cust;
    }

    public Short getIf_new() {
        return if_new;
    }

    public void setIf_new(Short if_new) {
        this.if_new = if_new;
    }

    public String getMdb_code() {
        return mdb_code;
    }

    public void setMdb_code(String mdb_code) {
        this.mdb_code = mdb_code;
    }

    public Short getIf_crm_push() {
        return if_crm_push;
    }

    public void setIf_crm_push(Short if_crm_push) {
        this.if_crm_push = if_crm_push;
    }

    @Override
    public Specification<T> toSpec() {
        return null;
    }
}