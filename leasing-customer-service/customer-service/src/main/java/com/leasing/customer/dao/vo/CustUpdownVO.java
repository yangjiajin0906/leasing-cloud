package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 上下游客户
 **/
@Entity
@Table(name = "yls_cust_updown")
public class CustUpdownVO extends BaseVO {
    /**
     * 主键
     */
    @Id
    private String pkCustUpdown;


    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
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
    @JoinColumn(name = "relationRole")
    private ParameterDTO relationRole;


    /**
     * 供应（销售）产品/商品名称
     */
    private String supplyProduct;


    /**
     * 供应（销售）额
     */
    private BigDecimal supplyAmount;


    /**
     * 供应（销售）比例
     */
    private BigDecimal supplyScale;


    /**
     * 结算方式及周期
     */
    private String settleMemo;


    /**
     * 应付金额
     */
    private BigDecimal planCash;


    /**
     * 上下游类别
     */
    private Short updownType;


    /**
     * 备注
     */
    private String memo;


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

    /**
     * 合同主键
     */
    private String pkContract;

    public String getPkCustUpdown() {
        return pkCustUpdown;
    }

    public void setPkCustUpdown(String pkCustUpdown) {
        this.pkCustUpdown = pkCustUpdown;
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

    public String getSupplyProduct() {
        return supplyProduct;
    }

    public void setSupplyProduct(String supplyProduct) {
        this.supplyProduct = supplyProduct;
    }

    public BigDecimal getSupplyAmount() {
        return supplyAmount;
    }

    public void setSupplyAmount(BigDecimal supplyAmount) {
        this.supplyAmount = supplyAmount;
    }

    public BigDecimal getSupplyScale() {
        return supplyScale;
    }

    public void setSupplyScale(BigDecimal supplyScale) {
        this.supplyScale = supplyScale;
    }

    public String getSettleMemo() {
        return settleMemo;
    }

    public void setSettleMemo(String settleMemo) {
        this.settleMemo = settleMemo;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public Short getUpdownType() {
        return updownType;
    }

    public void setUpdownType(Short updownType) {
        this.updownType = updownType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    @Override
    public String getPk() {
        return pkCustUpdown;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustUpdown = pk;
    }
}