package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-24
 * @author:zhangzhhn@yonyou.com
 * @description: 客户来源
 **/
@Entity
@Table(name = "YLS_CUST_RELATED_COMPANY")
public class CustRelatedCompanyVO extends BaseVO {
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
    @Fetch(FetchMode.JOIN)
    private CustomerDTO pkCustomer;

    /**
     * 关联客户编号
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerRef")
    private CustomerDTO pkCustomerRef;

    /**
     * 关联客户名称
     */
    @Transient
    private String customerName;

    /**
     * 关联客户类别
     */
    @Transient
    private Short customerType;


    /**
     * 关系分类
     */
    private Short relationClass;


    /**
     * 客户关系
     */
    @ManyToOne
    @JoinColumn(name="relationRole")
    private ParameterDTO relationRole;


    /**
     * 其他关系类型
     */
    private Short billtype;

    /**
     * 单据状态
     */
    private Short sourceMethod;
    
    /**
     * 备注
     */
    private String memo;

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
     * 合同主键
     */
    private String pkContract;


    /**
     * 单据状态
     */
    private Short billstatus;

    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;

    /**
     * 操作时间
     */
    private String operateTime;

    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;

    private Short executiveType;

    /**
     * 类CustRelatedCompanyVO的构造方法
     */
    public CustRelatedCompanyVO() {
    }

    @Override
    public String getPk() {
        return this.pkCustRelatedCompany;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustRelatedCompany = pk;
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
     * @param key key
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
    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }
    /**
     * 客户主键的setter方法
     *
     * @param pkCustomer 客户主键
     */
    public void setPkCustomer(CustomerDTO pkCustomer){
        this.pkCustomer = pkCustomer;
    }
    /**
     * 关联客户编号的getter方法
     *
     * @return CustomerDTO
     */
    public CustomerDTO getPkCustomerRef() {
        return pkCustomerRef;
    }

    /**
     * 关联客户编号的setter方法
     *
     * @param pkCustomerRef 关联客户编号
     */
    public void setPkCustomerRef(CustomerDTO pkCustomerRef) {
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
     * @return ParameterDTO
     */
    public ParameterDTO getRelationRole() {
        return relationRole;
    }

    /**
     * 关联关系描述的setter方法
     *
     * @param relationRole 关联关系描述
     */
    public void setRelationRole(ParameterDTO relationRole) {
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
     * 复核人的getter方法
     *
     * @return UserRefVO
     */
    public UserVO getPkChecker() {
        return pkChecker;
    }
    /**
     * 复核人的setter方法
     *
     * @param pkChecker 复核人
     */
    public void setPkChecker(UserVO pkChecker){
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
    public UserVO getPkGrantor() {
        return pkGrantor;
    }
    /**
     * 授权人的setter方法
     *
     * @param pkGrantor 授权人
     */
    public void setPkGrantor(UserVO pkGrantor){
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

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public Short getExecutiveType() {
        return executiveType;
    }

    public void setExecutiveType(Short executiveType) {
        this.executiveType = executiveType;
    }
}