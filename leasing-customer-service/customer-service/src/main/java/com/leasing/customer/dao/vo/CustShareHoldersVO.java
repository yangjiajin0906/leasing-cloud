package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.CurrtypeVO;
import com.leasing.common.vo.foundation.UserVO;
import com.leasing.common.dto.customer.CustomerDTO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-28
 * @author:zhangzhhn@yonyou.com
 * @description: 股东情况
 **/
@Entity
@Table(name = "yls_cust_shareholders")
public class CustShareHoldersVO extends BaseVO {


    /**
     * 主键
     */
    @Id
    private String pkCustShareholders;


    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 关系分类
     */
    private Short relationClass;

    /**
     * 关系
     */
    @ManyToOne
    @JoinColumn(name = "relationRole")
    private ParameterDTO relationRole;


    /**
     * 股东名称
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerRef")
    private CustomerDTO pkCustomerRef;

    /**
     * 股东类别
     */
    @Transient
    private Short customerType;

    /**
     * 股东关系
     */
    private Short shareholderRole;

    /**
     * 股东名称
     */
    @Transient
    private String customerName;


    /**
     * 持股比例（%）
     */
    private String sharesRatio;


    /**
     * 出资方式
     */
    private Short contributeMethod;


    /**
     * 币种
     */
    @ManyToOne
    @JoinColumn(name = "pkCurrtype")
    private CurrtypeVO pkCurrtype;


    /**
     * 出资金额
     */
    private String planCash;


    /**
     * 出资时间
     */
    private String factDate;


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
     * 法定代表人编号
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerPerson")
    @Transient
    private CustomerDTO pkCustomerPerson;


    /**
     * 主键的getter方法
     * @return String
     */
    public String getPrimaryKey() {
        return pkCustShareholders;
    }



    /**
     * 主键的setter方法
     * @param key
     */
    public void setPrimaryKey(String key) {
        this.pkCustShareholders = key;
    }
    /**
     * 主键的getter方法
     *
     * @return String
     */
    public String getPkCustShareholders() {
        return pkCustShareholders;
    }

    /**
     * 主键的setter方法
     *
     * @param pkCustShareholders 主键
     */
    public void setPkCustShareholders(String pkCustShareholders) {
        this.pkCustShareholders = pkCustShareholders;
    }

    /**
     * 主表主键的getter方法
     *
     * @return CustomerRefVO
     */
    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }
    /**
     * 主表主键的setter方法
     *
     * @param pkCustomer 主表主键
     */
    public void setPkCustomer(CustomerDTO pkCustomer){
        this.pkCustomer = pkCustomer;
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
     * 关联关系的getter方法
     *
     * @return ParmsRefVO
     */
    public ParameterDTO getRelationRole() {
        return relationRole;
    }

    /**
     * 关联关系的setter方法
     *
     * @param relationRole 关联关系
     */
    public void setRelationRole(ParameterDTO relationRole) {
        this.relationRole = relationRole;
    }

    /**
     * 股东名称的getter方法
     *
     * @return CustomerShareRefVO
     */
    public CustomerDTO getPkCustomerRef() {
        return pkCustomerRef;
    }

    /**
     * 股东名称的setter方法
     *
     * @param pkCustomerRef 股东名称
     */
    public void setPkCustomerRef(CustomerDTO pkCustomerRef) {
        this.pkCustomerRef = pkCustomerRef;
    }

    /**
     * 持股比例（%）的getter方法
     *
     * @return String
     */
    public String getSharesRatio() {
        return sharesRatio;
    }

    /**
     * 持股比例（%）的setter方法
     *
     * @param sharesRatio 持股比例（%）
     */
    public void setSharesRatio(String sharesRatio) {
        this.sharesRatio = sharesRatio;
    }

    /**
     * 出资方式的getter方法
     *
     * @return Short
     */
    public Short getContributeMethod() {
        return contributeMethod;
    }

    /**
     * 出资方式的setter方法
     *
     * @param contributeMethod 出资方式
     */
    public void setContributeMethod(Short contributeMethod) {
        this.contributeMethod = contributeMethod;
    }


    /**
     * 币种的getter方法
     *
     * @return String
     */
    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    /**
     * 币种的setter方法
     *
     * @param pkCurrtype 币种
     */
    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    /**
     * 出资金额的getter方法
     *
     * @return String
     */
    public String getPlanCash() {
        return planCash;
    }

    /**
     * 出资金额的setter方法
     *
     * @param planCash 出资金额
     */
    public void setPlanCash(String planCash) {
        this.planCash = planCash;
    }

    /**
     * 出资时间的getter方法
     *
     * @return String
     */
    public String getFactDate() {
        return factDate;
    }

    /**
     * 出资时间的setter方法
     *
     * @param factDate 出资时间
     */
    public void setFactDate(String factDate) {
        this.factDate = factDate;
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

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 股东关系
     */
    public Short getShareholderRole() {
        return shareholderRole;
    }

    /**
     * 股东关系
     */
    public void setShareholderRole(Short shareholderRole) {
        this.shareholderRole = shareholderRole;
    }

    public CustomerDTO getPkCustomerPerson() {
        return pkCustomerPerson;
    }

    public void setPkCustomerPerson(CustomerDTO pkCustomerPerson) {
        this.pkCustomerPerson = pkCustomerPerson;
    }

    @Override
    public String getPk() {
        return this.pkCustShareholders;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustShareholders = pk;
    }
}