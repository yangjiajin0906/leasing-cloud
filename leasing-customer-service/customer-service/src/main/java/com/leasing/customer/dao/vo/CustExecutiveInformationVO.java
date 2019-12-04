package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.entity.foundation.vo.OrgVO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 高管信息
 **/
@Entity
@Table(name = "YLS_CUST_RELATED_COMPANY")
public class CustExecutiveInformationVO extends BaseVO {
    /**
     * 主键
     */
    @Id
    private String pkCustRelatedCompany;


    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 关联客户编号 家族成员姓名
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerRef")
    private CustomerDTO pkCustomerRef;

    /**
     * 关系分类
     */
    private Short relationClass;


    /**
     * 客户关系
     */
    @ManyToOne
    @JoinColumn(name = "relationRole")
    private ParameterDTO relationRole;


    /**
     * 其他关系类型
     */
    private Short billtype;

    /**
     * 高管人员类别
     */
    private Short executiveType;


    /**
     * 工作简历
     */
    private String jobResume;


    /**
     * 家族关系
     */
    private Short familyRelation;


    /**
     * 关联家族企业名称
     */
    @ManyToOne
    @JoinColumn(name = "memberContainsCorp")
    private CustomerDTO memberContainsCorp;


    /**
     * 备注
     */
    private String memo;

    /**
     * 关联家族企业名称(虚拟字段,数据库中没此字段)
     */
    @Transient
    private String customerName;

    /**
     * 关联家族企业类别(虚拟字段,数据库中没此字段)
     */
    @Transient
    private Short customerType;


    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 记账人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 记账日期
     */
    private String operateDate;


    /**
     * 记账时间
     */
    private String operateTime;


    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;


    /**
     * 复核时间
     */
    private String checkTime;


    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;


    /**
     * 授权时间
     */
    private String grantTime;


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;


    public String getPkCustRelatedCompany() {
        return pkCustRelatedCompany;
    }

    public void setPkCustRelatedCompany(String pkCustRelatedCompany) {
        this.pkCustRelatedCompany = pkCustRelatedCompany;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public CustomerDTO getPkCustomerRef() {
        return pkCustomerRef;
    }

    public void setPkCustomerRef(CustomerDTO pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    public Short getRelationClass() {
        return relationClass;
    }

    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    public ParameterDTO getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(ParameterDTO relationRole) {
        this.relationRole = relationRole;
    }

    public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
    }

    public Short getExecutiveType() {
        return executiveType;
    }

    public void setExecutiveType(Short executiveType) {
        this.executiveType = executiveType;
    }

    public String getJobResume() {
        return jobResume;
    }

    public void setJobResume(String jobResume) {
        this.jobResume = jobResume;
    }

    public Short getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(Short familyRelation) {
        this.familyRelation = familyRelation;
    }

    public CustomerDTO getMemberContainsCorp() {
        return memberContainsCorp;
    }

    public void setMemberContainsCorp(CustomerDTO memberContainsCorp) {
        this.memberContainsCorp = memberContainsCorp;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    @Override
    public String getPk() {
        return pkCustRelatedCompany;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustRelatedCompany = pk;
    }
}