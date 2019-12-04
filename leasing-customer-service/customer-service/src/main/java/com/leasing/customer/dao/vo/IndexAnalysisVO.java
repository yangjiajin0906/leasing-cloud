package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.customer.dto.CustomerDTO;
import com.leasing.common.entity.foundation.vo.OrgVO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_index_analysis")
public class IndexAnalysisVO extends BaseVO {

    /**
     * 主键
     */
    private String pkIndexAnalysis;


    /**
     * 主表主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustomer")
    private CustomerDTO pkCustomer;

    /**
     * 数据采集主键
     */
    @ManyToOne
    @JoinColumn(name = "pkCustReport")
    private CustomerDTO pkCustReport;


    /**
     * 货币资金分析
     */
    private String pecuniaryResources;


    /**
     * 应收账款分析
     */
    private String accountsReceivable;


    /**
     * 其他应收款分析
     */
    private String otherReceivable;


    /**
     * 存货分析
     */
    private String stockAnalysis;


    /**
     * 应付账款分析
     */
    private String payableAccount;


    /**
     * 其他应付款分析
     */
    private String accountPayableOthers;


    /**
     * 备注
     */
    private String memo;


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
     * 应收账款
     */
    @Transient
    private List<AnalysisCashVO> accountsReceivableB;

    /**
     * 其他应收款
     */
    @Transient
    private List<AnalysisCashVO> otherReceivableB;
    /**
     * 应付账款
     */
    @Transient
    private List<AnalysisCashVO> payableAccountB;
    /**
     * 其他应付款
     */
    @Transient
    private List<AnalysisCashVO> accountPayableOthersB;
    /**
     * 存货（指标分析子表）
     */
    @Transient
    private List<AnalysisBalanceVO> analysisBalance;

    public String getPkIndexAnalysis() {
        return pkIndexAnalysis;
    }

    public void setPkIndexAnalysis(String pkIndexAnalysis) {
        this.pkIndexAnalysis = pkIndexAnalysis;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public CustomerDTO getPkCustReport() {
        return pkCustReport;
    }

    public void setPkCustReport(CustomerDTO pkCustReport) {
        this.pkCustReport = pkCustReport;
    }

    public String getPecuniaryResources() {
        return pecuniaryResources;
    }

    public void setPecuniaryResources(String pecuniaryResources) {
        this.pecuniaryResources = pecuniaryResources;
    }

    public String getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(String accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    public String getOtherReceivable() {
        return otherReceivable;
    }

    public void setOtherReceivable(String otherReceivable) {
        this.otherReceivable = otherReceivable;
    }

    public String getStockAnalysis() {
        return stockAnalysis;
    }

    public void setStockAnalysis(String stockAnalysis) {
        this.stockAnalysis = stockAnalysis;
    }

    public String getPayableAccount() {
        return payableAccount;
    }

    public void setPayableAccount(String payableAccount) {
        this.payableAccount = payableAccount;
    }

    public String getAccountPayableOthers() {
        return accountPayableOthers;
    }

    public void setAccountPayableOthers(String accountPayableOthers) {
        this.accountPayableOthers = accountPayableOthers;
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

    public List<AnalysisCashVO> getAccountsReceivableB() {
        return accountsReceivableB;
    }

    public void setAccountsReceivableB(List<AnalysisCashVO> accountsReceivableB) {
        this.accountsReceivableB = accountsReceivableB;
    }

    public List<AnalysisCashVO> getOtherReceivableB() {
        return otherReceivableB;
    }

    public void setOtherReceivableB(List<AnalysisCashVO> otherReceivableB) {
        this.otherReceivableB = otherReceivableB;
    }

    public List<AnalysisCashVO> getPayableAccountB() {
        return payableAccountB;
    }

    public void setPayableAccountB(List<AnalysisCashVO> payableAccountB) {
        this.payableAccountB = payableAccountB;
    }

    public List<AnalysisCashVO> getAccountPayableOthersB() {
        return accountPayableOthersB;
    }

    public void setAccountPayableOthersB(List<AnalysisCashVO> accountPayableOthersB) {
        this.accountPayableOthersB = accountPayableOthersB;
    }

    public List<AnalysisBalanceVO> getAnalysisBalance() {
        return analysisBalance;
    }

    public void setAnalysisBalance(List<AnalysisBalanceVO> analysisBalance) {
        this.analysisBalance = analysisBalance;
    }

    @Override
    public String getPk() {
        return pkIndexAnalysis;
    }

    @Override
    public void setPk(String pk) {
        this.pkIndexAnalysis = pk;
    }
}