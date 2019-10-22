package com.leasing.calculate.vo;

import com.leasing.calculate.entity.CustomerRefVO;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud 收支计划表
 * @date:2019/10/11
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class LeasePlanVO {
    /**
     * 收取期次
     */
    public String lease_time;
    /**
     * 收取期次(调息)
     */
    public String lease_time_old;
    /**
     * 计算日期
     */
    public String cal_date;
    /**
     * 计划收取日期
     */
    public String plan_date;
    /**
     * 交易类别
     */
    public String trans_type;

    /**
     * 交易类别(调息)
     */
    public String trans_type_old;

    /**
     * 收支方向
     */
    public Short direction;
    /**
     * 租金/发生额
     */
    public BigDecimal lease_cash;
    /**
     * 租金税
     */
    public BigDecimal lease_cash_tax;

    /**
     * 本金税
     */
    public BigDecimal lease_corpus_tax;

    /**
     * 利息税
     */
    public BigDecimal lease_interest_tax;
    /**
     * 租金税(重算)
     */
    public BigDecimal lease_cash_tax_fin;

    /**
     * 本金税(重算)
     */
    public BigDecimal lease_corpus_tax_fin;

    /**
     * 利息税(重算)
     */
    public BigDecimal lease_interest_tax_fin;
    /**
     * 租金(重算)
     */
    public BigDecimal lease_cash_fin;

    /**
     * 本金(重算)
     */
    public BigDecimal lease_corpus_fin;

    /**
     * 利息(重算)
     */
    public BigDecimal lease_interest_fin;
    /**
     * 剩余本金(重算)
     */
    public BigDecimal corpus_balance_fin;

    /**
     * 其中：本金
     */
    public BigDecimal lease_corpus;
    /**
     * 其中：利息
     */
    public BigDecimal lease_interest;
    /**
     * 剩余本金
     */
    public BigDecimal corpus_balance;
    /** ADD 20160606 新去税租息 */
    /**
     * 进项税差额
     */
    public BigDecimal input_tax_diff;
    /**
     * 进项税
     */
    public BigDecimal input_tax;
    /** ADD END */
    /**
     *
     * 服务费分摊金额
     *
     */
    public BigDecimal srvfee_share;

    /**
     * 是否需要重新计算利息,false不重新计算，true重新计算
     */
    public boolean newInterrateFlag;

    /**
     * 租金表类别-区分是在建期还是普通（等）
     */
    public Short rent_type;

    /**
     * 年利率
     */
    public BigDecimal rateValue;
    /**
     * 对应支付频率
     */
    Short paymentFrequency;


    /**
     * 客户信息
     */
    public CustomerRefVO pk_customer;

    /**
     * 是否提前还款
     */
    public Short if_prepayment_rent;

    /**
     * 是否提前还款
     */
    public Short getIf_prepayment_rent() {
        return if_prepayment_rent;
    }
    /**
     * 是否提前还款
     */
    public void setIf_prepayment_rent(Short if_prepayment_rent) {
        this.if_prepayment_rent = if_prepayment_rent;
    }

    /**
     * 备注
     */
    public String memo;

    /**
     * 租赁收入
     */
    public BigDecimal lease_cash_in;
    /**
     * 其中:去税租息
     */
    public BigDecimal no_tax_interest;
    /**
     * 其中:去税手续费收入
     */
    public BigDecimal no_tax_srvfee;
    /**
     * 其中:去税其它支出
     */
    public BigDecimal no_tax_otherout;
    /**
     * 其中:去税其它收入
     */
    public BigDecimal no_tax_otherin;
    /**
     * 税金
     */
    public BigDecimal sum_tax;

    /**
     * 生成方式
     */
    public Short make_method;

    /**
     * 因为开发初期没有想到
     * 投放的计划是计算日期会不同
     * 所以 后台使用了plan_date做算法的日期
     * 现在只好用right_date 存放 plan_date（计划日期）
     * 的过滤字段
     */
    public String right_date;

    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;

    /**
     * 是否调息
     */
    public Short isAdjust;

    /**
     * 利率
     */
    public Short tax_rate;

    /**
     * 核销状态
     */
    public Short charge_off_status;

    /**
     * 实际执行金额
     */
    public BigDecimal fact_cash;

    /**
     * 分拆租金（中投）
     */
    public BigDecimal divide_cash;
    /**
     * 分拆本金（中投）
     */
    public BigDecimal divide_corpus;
    /**
     * 分拆利息（中投）
     */
    public BigDecimal divide_interest;

    /**
     * 剩余本金
     */
    public BigDecimal lease_balance;

    /**
     * @return the divide_cash
     */
    public BigDecimal getDivide_cash() {
        return divide_cash;
    }
    /**
     * @param divide_cash the divide_cash to set
     */
    public void setDivide_cash(BigDecimal divide_cash) {
        this.divide_cash = divide_cash;
    }
    /**
     * @return the divide_corpus
     */
    public BigDecimal getDivide_corpus() {
        return divide_corpus;
    }
    /**
     * @param divide_corpus the divide_corpus to set
     */
    public void setDivide_corpus(BigDecimal divide_corpus) {
        this.divide_corpus = divide_corpus;
    }
    /**
     * @return the divide_interest
     */
    public BigDecimal getDivide_interest() {
        return divide_interest;
    }
    /**
     * @param divide_interest the divide_interest to set
     */
    public void setDivide_interest(BigDecimal divide_interest) {
        this.divide_interest = divide_interest;
    }
    /**
     * 是否调息
     */
    public Short getIsAdjust() {
        return isAdjust;
    }
    /**
     * 是否调息
     */
    public void setIsAdjust(Short isAdjust) {
        this.isAdjust = isAdjust;
    }

    /**
     * 收取期次的getter方法
     *
     * @return Integer
     */
    public String getLease_time() {
        return lease_time;
    }

    /**
     * 收取期次的setter方法
     *
     * @param lease_time 收取期次
     */
    public void setLease_time(String lease_time) {
        this.lease_time = lease_time;
    }

    /**
     * 计算日期的getter方法
     *
     * @return String
     */
    public String getCal_date() {
        return cal_date;
    }

    /**
     * 计算日期的setter方法
     *
     * @param cal_date 计算日期
     */
    public void setCal_date(String cal_date) {
        this.cal_date = cal_date;
    }

    /**
     * 计划收取日期的getter方法
     *
     * @return String
     */
    public String getPlan_date() {
        return plan_date;
    }

    /**
     * 计划收取日期的setter方法
     *
     * @param plan_date 计划收取日期
     */
    public void setPlan_date(String plan_date) {
        this.plan_date = plan_date;
    }


    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }

    /**
     * 收支方向的getter方法
     *
     * @return Short
     */
    public Short getDirection() {
        return direction;
    }

    /**
     * 收支方向的setter方法
     *
     * @param direction 收支方向
     */
    public void setDirection(Short direction) {
        this.direction = direction;
    }
    /**
     * 租金/发生额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * 租金/发生额的setter方法
     *
     * @param lease_cash 租金/发生额
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

    /**
     * 税额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash_tax() {
        if(lease_cash_tax == null){
            return BigDecimal.ZERO;
        }else {
            return lease_cash_tax;
        }

    }

    /**
     * 税额的setter方法
     *
     * @param lease_cash_tax 税额
     */
    public void setLease_cash_tax(BigDecimal lease_cash_tax) {
        this.lease_cash_tax = lease_cash_tax;
    }

    /**
     * 其中：本金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_corpus() {
        return lease_corpus;
    }

    /**
     * 其中：本金的setter方法
     *
     * @param lease_corpus 其中：本金
     */
    public void setLease_corpus(BigDecimal lease_corpus) {
        this.lease_corpus = lease_corpus;
    }

    /**
     * 其中：利息的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_interest() {
        return lease_interest;
    }

    /**
     * 其中：利息的setter方法
     *
     * @param lease_interest 其中：利息
     */
    public void setLease_interest(BigDecimal lease_interest) {
        this.lease_interest = lease_interest;
    }

    /**
     * 剩余本金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getCorpus_balance() {
        return corpus_balance;
    }

    /**
     * 剩余本金的setter方法
     *
     * @param corpus_balance 剩余本金
     */
    public void setCorpus_balance(BigDecimal corpus_balance) {
        this.corpus_balance = corpus_balance;
    }
    /**
     * 是否需要重新计算利息,false不重新计算，true重新计算
     * @return
     */
    public boolean getNewInterrateFlag() {
        return newInterrateFlag;
    }
    /**
     * 是否需要重新计算利息,false不重新计算，true重新计算
     * @param newInterrateFlag
     */
    public void setNewInterrateFlag(boolean newInterrateFlag) {
        this.newInterrateFlag = newInterrateFlag;
    }
    /**
     * 租金表类别-区分是在建期还是普通（等）
     * @return
     */
    public Short getRent_type() {
        return rent_type;
    }
    /**
     * 租金表类别-区分是在建期还是普通（等）
     * @param rent_type
     */
    public void setRent_type(Short rent_type) {
        this.rent_type = rent_type;
    }

    /**
     * 年利率
     * @return
     */
    public BigDecimal getRateValue() {
        return rateValue;
    }

    /**
     * 年利率
     * @param rateValue
     */
    public void setRateValue(BigDecimal rateValue) {
        this.rateValue = rateValue;
    }

    /**
     * @return the srvfee_share
     */
    public BigDecimal getSrvfee_share() {
        return srvfee_share;
    }

    /**
     * @param srvfee_share the srvfee_share to set
     */
    public void setSrvfee_share(BigDecimal srvfee_share) {
        this.srvfee_share = srvfee_share;
    }

    /**
     * @return the lease_corpus_tax
     */
    public BigDecimal getLease_corpus_tax() {
        if(lease_corpus_tax == null){
            return BigDecimal.ZERO;
        }else {
            return lease_corpus_tax;
        }

    }

    /**
     * @param lease_corpus_tax the lease_corpus_tax to set
     */
    public void setLease_corpus_tax(BigDecimal lease_corpus_tax) {
        this.lease_corpus_tax = lease_corpus_tax;
    }

    /**
     * @return the lease_interest_tax
     */
    public BigDecimal getLease_interest_tax() {
        if(lease_interest_tax == null){
            return BigDecimal.ZERO;
        } else {
            return lease_interest_tax;
        }
    }

    /**
     * @param lease_interest_tax the lease_interest_tax to set
     */
    public void setLease_interest_tax(BigDecimal lease_interest_tax) {
        this.lease_interest_tax = lease_interest_tax;
    }

    /**
     * 对应支付频率
     * @return
     */
    public Short getPaymentFrequency() {
        return paymentFrequency;
    }

    /**
     * 对应支付频率
     * @param paymentFrequency
     */
    public void setPaymentFrequency(Short paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    /**
     * @return the pk_customer
     */
    public CustomerRefVO getPk_customer() {
        return pk_customer;
    }

    /**
     * @param pk_customer the pk_customer to set
     */
    public void setPk_customer(CustomerRefVO pk_customer) {
        this.pk_customer = pk_customer;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the lease_cash_in
     */
    public BigDecimal getLease_cash_in() {
        return lease_cash_in;
    }

    /**
     * @param lease_cash_in the lease_cash_in to set
     */
    public void setLease_cash_in(BigDecimal lease_cash_in) {
        this.lease_cash_in = lease_cash_in;
    }

    /**
     * @return the no_tax_interest
     */
    public BigDecimal getNo_tax_interest() {
        return no_tax_interest;
    }

    /**
     * @param no_tax_interest the no_tax_interest to set
     */
    public void setNo_tax_interest(BigDecimal no_tax_interest) {
        this.no_tax_interest = no_tax_interest;
    }

    /**
     * @return the no_tax_srvfee
     */
    public BigDecimal getNo_tax_srvfee() {
        if(no_tax_srvfee == null){
            return BigDecimal.ZERO;
        }
        return no_tax_srvfee;
    }

    /**
     * @param no_tax_srvfee the no_tax_srvfee to set
     */
    public void setNo_tax_srvfee(BigDecimal no_tax_srvfee) {
        this.no_tax_srvfee = no_tax_srvfee;
    }

    /**
     * @return the no_tax_otherout
     */
    public BigDecimal getNo_tax_otherout() {
        if(no_tax_otherout == null){
            return BigDecimal.ZERO;
        }
        return no_tax_otherout;
    }

    /**
     * @param no_tax_otherout the no_tax_otherout to set
     */
    public void setNo_tax_otherout(BigDecimal no_tax_otherout) {
        this.no_tax_otherout = no_tax_otherout;
    }

    /**
     * @return the no_tax_otherin
     */
    public BigDecimal getNo_tax_otherin() {
        if(no_tax_otherin == null){
            return BigDecimal.ZERO;
        }
        return no_tax_otherin;
    }

    /**
     * @param no_tax_otherin the no_tax_otherin to set
     */
    public void setNo_tax_otherin(BigDecimal no_tax_otherin) {
        this.no_tax_otherin = no_tax_otherin;
    }

    /**
     * @return the sum_tax
     */
    public BigDecimal getSum_tax() {
        return sum_tax;
    }

    /**
     * @param sum_tax the sum_tax to set
     */
    public void setSum_tax(BigDecimal sum_tax) {
        this.sum_tax = sum_tax;
    }

    /**
     * @return the make_method
     */
    public Short getMake_method() {
        return make_method;
    }

    /**
     * @param make_method the make_method to set
     */
    public void setMake_method(Short make_method) {
        this.make_method = make_method;
    }

    /**
     * @return the right_date
     */
    public String getRight_date() {
        return right_date;
    }

    /**
     * @param right_date the right_date to set
     */
    public void setRight_date(String right_date) {
        this.right_date = right_date;
    }

    /**
     * @return the trade_discount
     */
    public BigDecimal getTrade_discount() {
        return trade_discount;
    }

    /**
     * @param trade_discount the trade_discount to set
     */
    public void setTrade_discount(BigDecimal trade_discount) {
        this.trade_discount = trade_discount;
    }
    /**
     * @return the tax_rate
     */
    public Short getTax_rate() {
        return tax_rate;
    }
    /**
     * @param tax_rate the tax_rate to set
     */
    public void setTax_rate(Short tax_rate) {
        this.tax_rate = tax_rate;
    }
    /**
     * @return the lease_cash_fin
     */
    public BigDecimal getLease_cash_fin() {
        return lease_cash_fin;
    }
    /**
     * @param lease_cash_fin the lease_cash_fin to set
     */
    public void setLease_cash_fin(BigDecimal lease_cash_fin) {
        this.lease_cash_fin = lease_cash_fin;
    }
    /**
     * @return the lease_corpus_fin
     */
    public BigDecimal getLease_corpus_fin() {
        return lease_corpus_fin;
    }
    /**
     * @param lease_corpus_fin the lease_corpus_fin to set
     */
    public void setLease_corpus_fin(BigDecimal lease_corpus_fin) {
        this.lease_corpus_fin = lease_corpus_fin;
    }
    /**
     * @return the lease_interest_fin
     */
    public BigDecimal getLease_interest_fin() {
        if(lease_interest_fin == null){
            return BigDecimal.ZERO;
        }
        return lease_interest_fin;
    }
    /**
     * @param lease_interest_fin the lease_interest_fin to set
     */
    public void setLease_interest_fin(BigDecimal lease_interest_fin) {
        this.lease_interest_fin = lease_interest_fin;
    }
    /**
     * @return the corpus_balance_fin
     */
    public BigDecimal getCorpus_balance_fin() {
        return corpus_balance_fin;
    }
    /**
     * @param corpus_balance_fin the corpus_balance_fin to set
     */
    public void setCorpus_balance_fin(BigDecimal corpus_balance_fin) {
        this.corpus_balance_fin = corpus_balance_fin;
    }
    /**
     * @return the lease_cash_tax_fin
     */
    public BigDecimal getLease_cash_tax_fin() {
        return lease_cash_tax_fin;
    }
    /**
     * @param lease_cash_tax_fin the lease_cash_tax_fin to set
     */
    public void setLease_cash_tax_fin(BigDecimal lease_cash_tax_fin) {
        this.lease_cash_tax_fin = lease_cash_tax_fin;
    }
    /**
     * @return the lease_corpus_tax_fin
     */
    public BigDecimal getLease_corpus_tax_fin() {
        return lease_corpus_tax_fin;
    }
    /**
     * @param lease_corpus_tax_fin the lease_corpus_tax_fin to set
     */
    public void setLease_corpus_tax_fin(BigDecimal lease_corpus_tax_fin) {
        this.lease_corpus_tax_fin = lease_corpus_tax_fin;
    }
    /**
     * @return the lease_interest_tax_fin
     */
    public BigDecimal getLease_interest_tax_fin() {
        return lease_interest_tax_fin;
    }
    /**
     * @param lease_interest_tax_fin the lease_interest_tax_fin to set
     */
    public void setLease_interest_tax_fin(BigDecimal lease_interest_tax_fin) {
        this.lease_interest_tax_fin = lease_interest_tax_fin;
    }
    /**
     * @return the charge_off_status
     */
    public Short getCharge_off_status() {
        return charge_off_status;
    }
    /**
     * @param charge_off_status the charge_off_status to set
     */
    public void setCharge_off_status(Short charge_off_status) {
        this.charge_off_status = charge_off_status;
    }
    /**
     * 收取期次(调息)
     */
    public String getLease_time_old() {
        return lease_time_old;
    }
    /**
     * 收取期次(调息)
     */
    public void setLease_time_old(String lease_time_old) {
        this.lease_time_old = lease_time_old;
    }
    /**
     * 交易类别(调息)
     */
    public String getTrans_type_old() {
        return trans_type_old;
    }
    /**
     * 交易类别(调息)
     */
    public void setTrans_type_old(String trans_type_old) {
        this.trans_type_old = trans_type_old;
    }
    /**
     * @return the fact_cash
     */
    public BigDecimal getFact_cash() {
        return fact_cash;
    }
    /**
     * @param fact_cash the fact_cash to set
     */
    public void setFact_cash(BigDecimal fact_cash) {
        this.fact_cash = fact_cash;
    }

    /**
     * 剩余本金 get方法
     */
    public BigDecimal getLease_balance() {
        return lease_balance;
    }

    /**
     * 剩余本金 set方法
     */
    public void setLease_balance(BigDecimal lease_balance) {
        this.lease_balance = lease_balance;
    }


    // by lihongjian 营改增 @2016/05/11 ADD START
    /**
     * 收税模式
     */
    public Short tax_mode;

    public Short getTax_mode() {
        return tax_mode;
    }

    public void setTax_mode(Short tax_mode) {
        this.tax_mode = tax_mode;
    }

    // 租金-增值税
    public BigDecimal lease_cash_added;
    // 租金-营业税
    public BigDecimal lease_cash_sales;
    //租金税金-增值税
    public BigDecimal lease_cash_tax_added;
    //租金税金-营业税
    public BigDecimal lease_cash_tax_sales;
    //租金税金-增值税-本金
    public BigDecimal lease_corpus_tax_added;
    //租金税金-增值税-利息
    public BigDecimal lease_interest_tax_added;
    //租金税金-营业税-本金
    public BigDecimal lease_corpus_tax_sales;
    //租金税金-营业税-利息
    public BigDecimal lease_interest_tax_sales;
    //增值税 本金
    public BigDecimal lease_corpus_added;
    //营业税 本金
    public BigDecimal lease_corpus_sales;
    //增值税 利息
    public BigDecimal lease_interest_added;
    //营业税 本金
    public BigDecimal lease_interest_sales;


    public BigDecimal getLease_corpus_added() {
        return lease_corpus_added;
    }
    public void setLease_corpus_added(BigDecimal lease_corpus_added) {
        this.lease_corpus_added = lease_corpus_added;
    }
    public BigDecimal getLease_corpus_sales() {
        return lease_corpus_sales;
    }
    public void setLease_corpus_sales(BigDecimal lease_corpus_sales) {
        this.lease_corpus_sales = lease_corpus_sales;
    }
    public BigDecimal getLease_interest_added() {
        return lease_interest_added;
    }
    public void setLease_interest_added(BigDecimal lease_interest_added) {
        this.lease_interest_added = lease_interest_added;
    }
    public BigDecimal getLease_interest_sales() {
        return lease_interest_sales;
    }
    public void setLease_interest_sales(BigDecimal lease_interest_sales) {
        this.lease_interest_sales = lease_interest_sales;
    }
    public BigDecimal getLease_cash_tax_added() {
        return lease_cash_tax_added;
    }

    public void setLease_cash_tax_added(BigDecimal lease_cash_tax_added) {
        this.lease_cash_tax_added = lease_cash_tax_added;
    }

    public BigDecimal getLease_cash_tax_sales() {
        return lease_cash_tax_sales;
    }

    public void setLease_cash_tax_sales(BigDecimal lease_cash_tax_sales) {
        this.lease_cash_tax_sales = lease_cash_tax_sales;
    }

    public BigDecimal getLease_cash_added() {
        return lease_cash_added;
    }

    public void setLease_cash_added(BigDecimal lease_cash_added) {
        this.lease_cash_added = lease_cash_added;
    }

    public BigDecimal getLease_cash_sales() {
        return lease_cash_sales;
    }

    public void setLease_cash_sales(BigDecimal lease_cash_sales) {
        this.lease_cash_sales = lease_cash_sales;
    }

    public BigDecimal getLease_corpus_tax_added() {
        return lease_corpus_tax_added;
    }

    public void setLease_corpus_tax_added(BigDecimal lease_corpus_tax_added) {
        this.lease_corpus_tax_added = lease_corpus_tax_added;
    }

    public BigDecimal getLease_interest_tax_added() {
        return lease_interest_tax_added;
    }

    public void setLease_interest_tax_added(BigDecimal lease_interest_tax_added) {
        this.lease_interest_tax_added = lease_interest_tax_added;
    }

    public BigDecimal getLease_corpus_tax_sales() {
        return lease_corpus_tax_sales;
    }

    public void setLease_corpus_tax_sales(BigDecimal lease_corpus_tax_sales) {
        this.lease_corpus_tax_sales = lease_corpus_tax_sales;
    }

    public BigDecimal getLease_interest_tax_sales() {
        return lease_interest_tax_sales;
    }

    public void setLease_interest_tax_sales(BigDecimal lease_interest_tax_sales) {
        this.lease_interest_tax_sales = lease_interest_tax_sales;
    }
    /** ADD 20160606 新去税租息 */
    public BigDecimal getInput_tax_diff() {
        return input_tax_diff;
    }
    public void setInput_tax_diff(BigDecimal input_tax_diff) {
        this.input_tax_diff = input_tax_diff;
    }
    public BigDecimal getInput_tax() {
        return input_tax;
    }
    public void setInput_tax(BigDecimal input_tax) {
        this.input_tax = input_tax;
    }

    /** ADD END */

    // by lihongjian 营改增 @2016/05/11 ADD END
    /**BUG修改  罚息关联收支*/
    /**
     * 罚息关联收支
     */
    public String inout_penalty ;

    public String getInout_penalty() {
        return inout_penalty;
    }
    public void setInout_penalty(String inout_penalty) {
        this.inout_penalty = inout_penalty;
    }

}