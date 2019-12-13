package com.leasing.common.entity.common.vo;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/12/11
 * @author:wangjc@yonyou.com
 * @description: 会计分摊使用VO
 **/
public class AccountTableZTUtilsVO {


    /**
     * 其中:去税手续费收入(已发生金额)
     */
    public BigDecimal srvfeeCash;

    /**
     * 其中:去税其它收入(已发生金额)
     */
    public BigDecimal cashIn;

    /**
     * 其中:去税其它支出(已发生金额)
     */
    public BigDecimal cashOut;
    //2016-06-07 wjj 测算参数新增进项税利率
    /**
     * 其中:进项税差额(已发生金额)
     */
    public BigDecimal inputTaxDiffCash;
    /**
     * 其中:进项税(已发生金额)
     */
    public BigDecimal inputTaxCash;
    //end

    /**
     * 手续费收入(总金额金额)
     */
    public BigDecimal srvfeeCashSum;

    /**
     * 其它收入(总金额金额)
     */
    public BigDecimal cashInSum;

    /**
     * 其它支出(总金额金额)
     */
    public BigDecimal cashOutSum;


    /**
     * 已发生会计利息 20160630 WJJ UPDATE 注解有问题是会计利息 不是租息
     */
    public BigDecimal accInterest;

    /** ADD WJJ 20160630 去税租息最后一期到减   */
    /**
     * 已发送 去税租息
     */
    public BigDecimal noTaxInterestCash;

    /**
     * 总 租息/1+t (租息/1+t 有可能不等去税会计分摊表中的去税租息)
     */
    public BigDecimal unTaxLeaseInterestSum;


    public BigDecimal getNoTaxInterestCash() {
        if(noTaxInterestCash == null){
            return BigDecimal.ZERO;
        }
        return noTaxInterestCash;
    }


    public void setNoTaxInterestCash(BigDecimal noTaxInterestCash) {
        this.noTaxInterestCash = noTaxInterestCash;
    }


    public BigDecimal getUnTaxLeaseInterestSum() {
        if(unTaxLeaseInterestSum == null){
            return BigDecimal.ZERO;
        }
        return unTaxLeaseInterestSum;
    }


    public void setUnTaxLeaseInterestSum(BigDecimal unTaxLeaseInterestSum) {
        this.unTaxLeaseInterestSum = unTaxLeaseInterestSum;
    }
    /** ADD END */

    public BigDecimal getSrvfeeCash() {
        if(srvfeeCash == null){
            return BigDecimal.ZERO;
        }
        return srvfeeCash;
    }


    public void setSrvfeeCash(BigDecimal srvfeeCash) {
        this.srvfeeCash = srvfeeCash;
    }


    public BigDecimal getCashIn() {
        if(cashIn == null){
            return BigDecimal.ZERO;
        }
        return cashIn;
    }


    public void setCashIn(BigDecimal cashIn) {
        this.cashIn = cashIn;
    }


    public BigDecimal getCashOut() {
        if(cashOut == null){
            return BigDecimal.ZERO;
        }
        return cashOut;
    }


    public void setCashOut(BigDecimal cashOut) {
        this.cashOut = cashOut;
    }


    public BigDecimal getAccInterest() {
        if(accInterest == null){
            return BigDecimal.ZERO;
        }
        return accInterest;
    }


    public void setAccInterest(BigDecimal accInterest) {
        this.accInterest = accInterest;
    }


    public BigDecimal getSrvfeeCashSum() {
        if(srvfeeCashSum == null){
            return BigDecimal.ZERO;
        }
        return srvfeeCashSum;
    }


    public void setSrvfeeCashSum(BigDecimal srvfeeCashSum) {
        this.srvfeeCashSum = srvfeeCashSum;
    }


    public BigDecimal getCashInSum() {
        if(cashInSum == null){
            return BigDecimal.ZERO;
        }
        return cashInSum;
    }


    public void setCashInSum(BigDecimal cashInSum) {
        this.cashInSum = cashInSum;
    }


    public BigDecimal getCashOutSum() {
        if(cashOutSum == null){
            return BigDecimal.ZERO;
        }
        return cashOutSum;
    }


    public void setCashOutSum(BigDecimal cashOutSum) {
        this.cashOutSum = cashOutSum;
    }

    //2016-06-07 wjj 测算参数新增进项税利率
    public BigDecimal getInputTaxDiffCash() {
        if (inputTaxDiffCash == null) {
            return BigDecimal.ZERO;
        }
        return inputTaxDiffCash;
    }


    public void setInputTaxDiffCash(BigDecimal inputTaxDiffCash) {
        this.inputTaxDiffCash = inputTaxDiffCash;
    }


    public BigDecimal getInputTaxCash() {
        if (inputTaxCash == null) {
            return BigDecimal.ZERO;
        }
        return inputTaxCash;
    }


    public void setInputTaxCash(BigDecimal inputTaxCash) {
        this.inputTaxCash = inputTaxCash;
    }

    //end




}
