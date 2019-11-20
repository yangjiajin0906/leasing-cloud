package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.CurrtypeVO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;
import com.leasing.customer.dao.dos.CustAssetsDO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_cust_external_finance")
public class CustExternalFinanceVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkCustExternalFinance;

    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 贷款机构编号
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerRef")
    private CustomerDTO pkCustomerRef;

    /**
     * 贷款机构名称
     */
    @Transient
    private String customerName;

    /**
     * 贷款机构类别
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
     * 融资品种
     */
    private Short financeType;

    /**
     * 融资币种
     */
    @ManyToOne
    @JoinColumn(name = "pkCurrtype")
    private CurrtypeVO pkCurrtype;

    /**
     * 融资金额（元）
     */
    private BigDecimal planCash;

    /**
     * 还款周期
     */
    private Short repaymentPeriod;

    /**
     * 利率
     */
    private BigDecimal interestRate;

    /**
     * 起始日期
     */
    private String startDate;

    /**
     * 截止日期
     */
    private String endDate;

    /**
     * 担保方式
     */
    private Short guaranteeMethod;

    /**
     * 保证金
     */
    private BigDecimal deposit;

    /**
     * 总敞口余额（元）
     */
    private BigDecimal balance;

    /**
     * 余额日期
     */
    private String balanceDate;

    /**
     * 融资信贷类型
     */
    private Short creditType;

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
     * 抵质押物件（不动产）
     */
    @Transient
    private List<CustAssetsDO> custMortgageEstate;
    /**
     * 抵质押物件（动产）
     */
    @Transient
    private List<CustAssetsDO> custMortgageProperty;
    /**
     * 质押物件（权利）
     */
    @Transient
    private List<CustAssetsDO> custPledgeWarrant;
    /**
     * 质押物件（动产）
     */
    @Transient
    private List<CustAssetsDO> custPledgeProperty;

    public String getPkCustExternalFinance() {
        return pkCustExternalFinance;
    }

    public void setPkCustExternalFinance(String pkCustExternalFinance) {
        this.pkCustExternalFinance = pkCustExternalFinance;
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

    public Short getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Short financeType) {
        this.financeType = financeType;
    }

    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getPlanCash() {
        return planCash;
    }

    public void setPlanCash(BigDecimal planCash) {
        this.planCash = planCash;
    }

    public Short getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public void setRepaymentPeriod(Short repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Short getGuaranteeMethod() {
        return guaranteeMethod;
    }

    public void setGuaranteeMethod(Short guaranteeMethod) {
        this.guaranteeMethod = guaranteeMethod;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(String balanceDate) {
        this.balanceDate = balanceDate;
    }

    public Short getCreditType() {
        return creditType;
    }

    public void setCreditType(Short creditType) {
        this.creditType = creditType;
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

    public List<CustAssetsDO> getCustMortgageEstate() {
        return custMortgageEstate;
    }

    public void setCustMortgageEstate(List<CustAssetsDO> custMortgageEstate) {
        this.custMortgageEstate = custMortgageEstate;
    }

    public List<CustAssetsDO> getCustMortgageProperty() {
        return custMortgageProperty;
    }

    public void setCustMortgageProperty(List<CustAssetsDO> custMortgageProperty) {
        this.custMortgageProperty = custMortgageProperty;
    }

    public List<CustAssetsDO> getCustPledgeWarrant() {
        return custPledgeWarrant;
    }

    public void setCustPledgeWarrant(List<CustAssetsDO> custPledgeWarrant) {
        this.custPledgeWarrant = custPledgeWarrant;
    }

    public List<CustAssetsDO> getCustPledgeProperty() {
        return custPledgeProperty;
    }

    public void setCustPledgeProperty(List<CustAssetsDO> custPledgeProperty) {
        this.custPledgeProperty = custPledgeProperty;
    }

    @Override
    public String getPk() {
        return pkCustExternalFinance;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustExternalFinance = pk;
    }
}