package com.leasing.customer_service.pojo;


import com.leasing.customer_service.pojo.ref.CustomerRefVO;
import com.leasing.customer_service.pojo.ref.OrgRefVO;
import com.leasing.customer_service.pojo.ref.ParmsRefVO;
import com.leasing.customer_service.pojo.ref.UserRefVO;
import com.leasing.customer_service.utils.BaseQuery;
import com.leasing.customer_service.utils.QueryCondition;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;

/**
 * Title: 租赁账户管理系统<br>
 * Description: 关联企业类<br>
 * Copyright: Copyright (c) 2010<br>
 * Company: UFIDA<br>
 *
 * @author fjd
 * @version
 */
@Entity
@Table(name = "yls_cust_related_company")
public class CustRelatedCompanyVO extends BaseQuery<CustRelatedCompanyVO> {

    /**
     * 主键
     */
    @Id
    public String pkCustRelatedCompany;


    /**
     * 客户主键
     */
    @ManyToOne
    @QueryCondition
    @JoinColumn(name="pkCustomer",referencedColumnName="pkCustomer")
    public CustomerRefVO pkCustomer;

    /**
     * 关联客户编号
     */
    @ManyToOne
    @JoinColumn(name="pkCustomerRef",referencedColumnName="pkCustomer")
    public CustomerRefVO pkCustomerRef;

    /**
     * 关联客户名称
     */
    @Transient
    public String customerName;

    /**
     * 关联客户类别
     */
    @Transient
    public Short customerType;


    /**
     * 关系分类
     */
    public Short relationClass;


    /**
     * 客户关系
     */
    @ManyToOne
    @JoinColumn(name="relationRole",referencedColumnName="pkParameter")
    public ParmsRefVO relationRole;


    /**
     * 其他关系类型
     */
    public Short billtype;

    /**
     * 单据状态
     */
    public Short sourceMethod;



    /**
     * 备注
     */
    public String memo;


    /**
     * 单据状态
     */
    public Short billstatus;


    /**
     * 记账人
     */
    @ManyToOne
    @JoinColumn(name="pkOperator",referencedColumnName="cuserid")
    public UserRefVO pkOperator;

    /**
     * 记账日期
     */
    public String operateDate;


    /**
     * 记账时间
     */
    public String operateTime;


    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name="pkChecker",referencedColumnName="cuserid")
    public UserRefVO pkChecker;

    /**
     * 复核日期
     */
    public String checkDate;


    /**
     * 复核时间
     */
    public String checkTime;


    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name="pkGrantor",referencedColumnName="cuserid")
    public UserRefVO pkGrantor;

    /**
     * 授权日期
     */
    public String grantDate;


    /**
     * 授权时间
     */
    public String grantTime;


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name="pkOrg",referencedColumnName="pkOrg")
    public OrgRefVO pkOrg;

    /**
     * 合同主键
     */
    public String pkContract;

    /**
     * 类CustRelatedCompanyVO的构造方法
     */
    public CustRelatedCompanyVO() {
    }

    /**
     * 主键的getter方法
     * @return String
     */
    public String getPrimaryKey() {
        return pkCustRelatedCompany;
    }

    /**
     * 主键的setter方法
     * @param key
     */
    public void setPrimaryKey(String key) {
        this.pkCustRelatedCompany = key;
    }
    /**
     * 主键的getter方法
     *
     * @return String
     */
    public String getPkCustRelatedCompany() {
        return pkCustRelatedCompany;
    }

    /**
     * 主键的setter方法
     *
     * @param pkCustRelatedCompany 主键
     */
    public void setPkCustRelatedCompany(String pkCustRelatedCompany) {
        this.pkCustRelatedCompany = pkCustRelatedCompany;
    }

    /**
     * 客户主键的getter方法
     *
     * @return CustomerRefVO
     */
    public CustomerRefVO getPkCustomer() {
        return pkCustomer;
    }
    /**
     * 客户主键的setter方法
     *
     * @param pkCustomer 客户主键
     */
    public void setPkCustomer(CustomerRefVO pkCustomer){
        this.pkCustomer = pkCustomer;
    }
    /**
     * 关联客户编号的getter方法
     *
     * @return CustomerRefVO
     */
    public CustomerRefVO getPkCustomerRef() {
        return pkCustomerRef;
    }

    /**
     * 关联客户编号的setter方法
     *
     * @param pkCustomerRef 关联客户编号
     */
    public void setPkCustomerRef(CustomerRefVO pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    /**
     * 关系分类的getter方法
     *
     * @return Short
     */
    public Short getRelationClass() {
        return relationClass;
    }

    /**
     * 关系分类的setter方法
     *
     * @param relationClass 关系分类
     */
    public void setRelationClass(Short relationClass) {
        this.relationClass = relationClass;
    }

    /**
     * 关联关系描述的getter方法
     *
     * @return ParmsRefVO
     */
    public ParmsRefVO getRelationRole() {
        return relationRole;
    }

    /**
     * 关联关系描述的setter方法
     *
     * @param relationRole 关联关系描述
     */
    public void setRelationRole(ParmsRefVO relationRole) {
        this.relationRole = relationRole;
    }

    /**
     * 备注的getter方法
     *
     * @return String
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注的setter方法
     *
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 单据状态的getter方法
     *
     * @return Short
     */
    public Short getBillstatus() {
        return billstatus;
    }

    /**
     * 单据状态的setter方法
     *
     * @param billstatus 单据状态
     */
    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    /**
     * 记账人的getter方法
     *
     * @return UserRefVO
     */
    public UserRefVO getPkOperator() {
        return pkOperator;
    }
    /**
     * 记账人的setter方法
     *
     * @param pkOperator 记账人
     */
    public void setPkOperator(UserRefVO pkOperator){
        this.pkOperator = pkOperator;
    }
    /**
     * 记账日期的getter方法
     *
     * @return String
     */
    public String getOperateDate() {
        return operateDate;
    }

    /**
     * 记账日期的setter方法
     *
     * @param operateDate 记账日期
     */
    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    /**
     * 记账时间的getter方法
     *
     * @return String
     */
    public String getOperateTime() {
        return operateTime;
    }

    /**
     * 记账时间的setter方法
     *
     * @param operateTime 记账时间
     */
    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 复核人的getter方法
     *
     * @return UserRefVO
     */
    public UserRefVO getPkChecker() {
        return pkChecker;
    }
    /**
     * 复核人的setter方法
     *
     * @param pkChecker 复核人
     */
    public void setPkChecker(UserRefVO pkChecker){
        this.pkChecker = pkChecker;
    }
    /**
     * 复核日期的getter方法
     *
     * @return String
     */
    public String getCheckDate() {
        return checkDate;
    }

    /**
     * 复核日期的setter方法
     *
     * @param checkDate 复核日期
     */
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 复核时间的getter方法
     *
     * @return String
     */
    public String getCheckTime() {
        return checkTime;
    }

    /**
     * 复核时间的setter方法
     *
     * @param checkTime 复核时间
     */
    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * 授权人的getter方法
     *
     * @return UserRefVO
     */
    public UserRefVO getPkGrantor() {
        return pkGrantor;
    }
    /**
     * 授权人的setter方法
     *
     * @param pkGrantor 授权人
     */
    public void setPkGrantor(UserRefVO pkGrantor){
        this.pkGrantor = pkGrantor;
    }
    /**
     * 授权日期的getter方法
     *
     * @return String
     */
    public String getGrantDate() {
        return grantDate;
    }

    /**
     * 授权日期的setter方法
     *
     * @param grantDate 授权日期
     */
    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    /**
     * 授权时间的getter方法
     *
     * @return String
     */
    public String getGrantTime() {
        return grantTime;
    }

    /**
     * 授权时间的setter方法
     *
     * @param grantTime 授权时间
     */
    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    /**
     * 机构的getter方法
     *
     * @return OrgRefVO
     */
    public OrgRefVO getPkOrg() {
        return pkOrg;
    }
    /**
     * 机构的setter方法
     *
     * @param pkOrg 机构
     */
    public void setPkOrg(OrgRefVO pkOrg){
        this.pkOrg = pkOrg;
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

    public Short getBilltype() {
        return billtype;
    }

    public void setBilltype(Short billtype) {
        this.billtype = billtype;
    }

    /**
     * 单据状态
     */
    public Short getSourceMethod() {
        return sourceMethod;
    }

    /**
     * 单据状态
     */
    public void setSourceMethod(Short sourceMethod) {
        this.sourceMethod = sourceMethod;
    }

    /**
     * 合同主键
     */
    public String getPkContract() {
        return pkContract;
    }

    /**
     * 合同主键
     */
    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }


    @Override
    public Specification<CustRelatedCompanyVO> toSpec() {
        return super.toSpecWithAnd();
    }
}

