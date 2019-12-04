package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.dto.customer.ContractDTO;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.dto.customer.LesseeProtocolDTO;
import com.leasing.common.dto.customer.ProjectInfoDTO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.entity.foundation.vo.UserVO;
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
@Table(name = "yls_cust_pledge")
public class CustPledgeVO extends BaseBusinessVO {


    /**
     * 主键
     */
    @Id
    private String pkCustPledge;

    /**
     * 总承租人合作协议主键
     */
    private LesseeProtocolDTO pkLesseeProtocol;

    /**
     * 客户主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 被担保企业编号
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomerRef")
    private CustomerDTO pkCustomerRef;

    /**
     * 被担保企业名称
     */
    @Transient
    private String customerName;

    /**
     * 被担保企业类别
     */
    @Transient
    private Short customerType;


    /**
     * 债权方
     */
    private String bondBank;


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
     * 反担保
     */
    private Short ifAntiGuarantee;


    /**
     * 币种
     */
    @ManyToOne
    @JoinColumn(name = "pkCurrtype")
    private CurrtypeVO pkCurrtype;


    /**
     * 担保金额
     */
    private BigDecimal planCash;

    /**
     * 担保项目名称
     */
    private ProjectInfoDTO pkAssureProject;


    /**
     * 是否手工录入
     */
    private Short ifManualEntry;


    /**
     * 起始日期
     */
    private String startDate;


    /**
     * 截止日期
     */
    private String endDate;


    /**
     * 提供担保原因
     */
    private String reason;

    /**
     * 担保方式
     */
    private Short guaranteeMethod;

    /**
     * 合同
     */
    private ContractDTO pkContract;

    /**
     * 备注
     */
    private String memo;
    

    /**
     * 是否版本最新
     */
    private Short ifVersionNew;

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
     * 来源单据类型
     */
    private String sourceBilltype;


    /**
     * 来源单据主键
     */
    private String sourceBill;

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
//    /**
//     * 担保信息
//     */
//    @Transient
//    private List<CustAssetsDO> businessBack;
//    /** ADD WJJ 20170525 BUG修改 start*/
    /**
     * 是否上报征信
     */
    private Short creditInvestigation;

    public String getPkCustPledge() {
        return pkCustPledge;
    }

    public void setPkCustPledge(String pkCustPledge) {
        this.pkCustPledge = pkCustPledge;
    }

    public LesseeProtocolDTO getPkLesseeProtocol() {
        return pkLesseeProtocol;
    }

    public void setPkLesseeProtocol(LesseeProtocolDTO pkLesseeProtocol) {
        this.pkLesseeProtocol = pkLesseeProtocol;
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

    public String getBondBank() {
        return bondBank;
    }

    public void setBondBank(String bondBank) {
        this.bondBank = bondBank;
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

    public Short getIfAntiGuarantee() {
        return ifAntiGuarantee;
    }

    public void setIfAntiGuarantee(Short ifAntiGuarantee) {
        this.ifAntiGuarantee = ifAntiGuarantee;
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

    public ProjectInfoDTO getPkAssureProject() {
        return pkAssureProject;
    }

    public void setPkAssureProject(ProjectInfoDTO pkAssureProject) {
        this.pkAssureProject = pkAssureProject;
    }

    public Short getIfManualEntry() {
        return ifManualEntry;
    }

    public void setIfManualEntry(Short ifManualEntry) {
        this.ifManualEntry = ifManualEntry;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Short getGuaranteeMethod() {
        return guaranteeMethod;
    }

    public void setGuaranteeMethod(Short guaranteeMethod) {
        this.guaranteeMethod = guaranteeMethod;
    }

    public ContractDTO getPkContract() {
        return pkContract;
    }

    public void setPkContract(ContractDTO pkContract) {
        this.pkContract = pkContract;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Short getIfVersionNew() {
        return ifVersionNew;
    }

    public void setIfVersionNew(Short ifVersionNew) {
        this.ifVersionNew = ifVersionNew;
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

    public String getSourceBilltype() {
        return sourceBilltype;
    }

    public void setSourceBilltype(String sourceBilltype) {
        this.sourceBilltype = sourceBilltype;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
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

    public Short getCreditInvestigation() {
        return creditInvestigation;
    }

    public void setCreditInvestigation(Short creditInvestigation) {
        this.creditInvestigation = creditInvestigation;
    }

    /** ADD WJJ 20170525 BUG修改 end*/


    
    @Override
    public String getPk() {
        return pkCustPledge;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustPledge = pk;
    }
}