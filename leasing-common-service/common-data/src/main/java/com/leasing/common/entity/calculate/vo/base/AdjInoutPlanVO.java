package com.leasing.common.entity.calculate.vo.base;

import com.leasing.common.entity.common.ref.EventTypeRefVO;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:Yjj@yonyou.com
 * @description: 调息申请VO类
 **/
public class AdjInoutPlanVO {
    /**
     * 主键
     */
    public String pk_adj_inout_plan;
    /**
     * 调息申请主键
     */
    public String pk_adjust_apply; //调息申请主键
    /**
     * 客户主键
     */
    public String pk_customer;
    /**
     * 主表主键
     */
    public String source_bill;
    /**
     * 来源单据类型
     */
    public String source_billtype;
    /**
     * 收取期次
     */
    public String lease_time;
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
    public EventTypeRefVO trans_type;
    /**
     * 收支方向
     */
    public Short direction;
    /**
     * 租金税额
     */
    public BigDecimal lease_cash_tax;
    /**
     * 利息税额
     */
    public BigDecimal lease_interest_tax;

    /**
     * 租金
     */
    public BigDecimal lease_cash;
    /**
     * 本金
     */
    public BigDecimal lease_corpus;
    /**
     * 利息
     */
    public BigDecimal lease_interest;

    /**
     * 利息差
     */
    public BigDecimal lease_interest_diff;

    /**
     * 剩余本金
     */
    public BigDecimal corpus_balance;

    /**
     * 租金(调息前)
     */
    public BigDecimal lease_cash_old;
    /**
     * 本金(调息前)
     */
    public BigDecimal lease_corpus_old;
    /**
     * 利息(调息前)
     */
    public BigDecimal lease_interest_old;
    /**
     * 剩余本金(调息前)
     */
    public BigDecimal corpus_balance_old;


    /**
     * 租金(调息前-会计)
     */
    public BigDecimal lease_cash_fin_old;
    /**
     * 本金(调息前-会计)
     */
    public BigDecimal lease_corpus_fin_old;
    /**
     * 利息(调息前-会计)
     */
    public BigDecimal lease_interest_fin_old;
    /**
     * 剩余本金(调息前-会计)
     */
    public BigDecimal corpus_balance_fin_old;

    /**
     * 本金税额
     */
    public BigDecimal lease_corpus_tax;
    /**
     * 剩余租金
     */
    public BigDecimal lease_balance;
    /**
     * 手续费分摊金额
     */
    public BigDecimal srvfee_share;
    /**
     * 租金浮动比例
     */
    public BigDecimal rent_float_ratio;
    /**
     * 生成方式
     */
    public Short make_method;
    /**
     * 租金表类型
     */
    public Short rent_type;
    /**
     * 备注
     */
    public String memo;
    /**
     * 上期计划收取日期（必须有值）
     */
    public String last_plan_date;
    /**
     * 是否调息
     */
    public Short isAdjust;

    /**
     * 执行状态(款)
     */
    public Short exec_status;


    /**
     * 资产状态
     */
    public Short asset_status;


    /**
     * 冻结金额(款)
     */
    public BigDecimal freeze_cash;


    /**
     * 实际发生额(款)
     */
    public BigDecimal fact_cash;


    /**
     * 对应支付频率
     */
    public Short paymentFrequency;
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
     * 税金总和
     */
    public BigDecimal sum_tax;
    /**
     * 商业折扣
     */
    public BigDecimal trade_discount;
    /**
     * 利率上浮
     */
    public BigDecimal rate_up;

    /**会计租金*/
    public BigDecimal lease_cash_fin;
    /**会计本金*/
    public BigDecimal lease_corpus_fin;
    /**会计利息*/
    public BigDecimal lease_interest_fin;
    /**
     * 租金税额(重算)
     */
    public BigDecimal lease_cash_tax_fin;
    /**
     * 利息税额(重算)
     */
    public BigDecimal lease_interest_tax_fin;
    /**
     * 本金税额(重算)
     */
    public BigDecimal lease_corpus_tax_fin;
    /**
     * 剩余本金(重算)
     */
    public BigDecimal corpus_balance_fin;

    /**
     * 税率
     */
    public Short tax_rate;
    /**
     * 是否最新
     */
    public Short if_new;

    /**
     * 是否重置保证金冲抵
     * 调息保证金冲抵重新分配调用
     */
    public boolean is_reset_depost;

    /**
     * 核销状态
     */
    public Short charge_off_status;

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
     * 利息差额
     */
    public BigDecimal interest_first;

    /** ADD 20160622 合同台帐查询进销税差额 */
    /**
     * 进销税差额
     */
    public BigDecimal input_tax_diff;

    /**
     * 进销税
     */
    public BigDecimal input_tax;

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

    /**
     * 是否重置保证金冲抵
     * 调息保证金冲抵重新分配调用
     */
    public boolean isIs_reset_depost() {
        return is_reset_depost;
    }
    /**
     * 是否重置保证金冲抵
     * 调息保证金冲抵重新分配调用
     */
    public void setIs_reset_depost(boolean is_reset_depost) {
        this.is_reset_depost = is_reset_depost;
    }
    /**会计租金*/
    public BigDecimal getLease_cash_fin() {
        return lease_cash_fin;
    }
    /**会计租金*/
    public void setLease_cash_fin(BigDecimal lease_cash_fin) {
        this.lease_cash_fin = lease_cash_fin;
    }
    /**会计本金*/
    public BigDecimal getLease_corpus_fin() {
        return lease_corpus_fin;
    }
    /**会计本金*/
    public void setLease_corpus_fin(BigDecimal lease_corpus_fin) {
        this.lease_corpus_fin = lease_corpus_fin;
    }
    /**会计利息*/
    public BigDecimal getLease_interest_fin() {
        return lease_interest_fin;
    }
    /**会计利息*/
    public void setLease_interest_fin(BigDecimal lease_interest_fin) {
        this.lease_interest_fin = lease_interest_fin;
    }
    /**
     * 租金税额(重算)
     */
    public BigDecimal getLease_cash_tax_fin() {
        return lease_cash_tax_fin;
    }
    /**
     * 租金税额(重算)
     */
    public void setLease_cash_tax_fin(BigDecimal lease_cash_tax_fin) {
        this.lease_cash_tax_fin = lease_cash_tax_fin;
    }
    /**
     * 利息税额(重算)
     */
    public BigDecimal getLease_interest_tax_fin() {
        return lease_interest_tax_fin;
    }
    /**
     * 利息税额(重算)
     */
    public void setLease_interest_tax_fin(BigDecimal lease_interest_tax_fin) {
        this.lease_interest_tax_fin = lease_interest_tax_fin;
    }
    /**
     * 本金税额(重算)
     */
    public BigDecimal getLease_corpus_tax_fin() {
        return lease_corpus_tax_fin;
    }
    /**
     * 本金税额(重算)
     */
    public void setLease_corpus_tax_fin(BigDecimal lease_corpus_tax_fin) {
        this.lease_corpus_tax_fin = lease_corpus_tax_fin;
    }
    /**
     * 剩余本金(重算)
     */
    public BigDecimal getCorpus_balance_fin() {
        return corpus_balance_fin;
    }
    /**
     * 剩余本金(重算)
     */
    public void setCorpus_balance_fin(BigDecimal corpus_balance_fin) {
        this.corpus_balance_fin = corpus_balance_fin;
    }
    /**
     * 税率
     */
    public Short getTax_rate() {
        return tax_rate;
    }
    /**
     * 税率
     */
    public void setTax_rate(Short tax_rate) {
        this.tax_rate = tax_rate;
    }
    /**
     * 是否最新
     */
    public Short getIf_new() {
        return if_new;
    }
    /**
     * 是否最新
     */
    public void setIf_new(Short if_new) {
        this.if_new = if_new;
    }
    /**
     * 上期计划收取日期（必须有值）
     */
    public String getLast_plan_date() {
        return last_plan_date;
    }
    /**
     * 上期计划收取日期（必须有值）
     */
    public void setLast_plan_date(String last_plan_date) {
        this.last_plan_date = last_plan_date;
    }

    /**
     * 类AdjInoutPlanVO的构造方法
     */
    public AdjInoutPlanVO() {
    }

    /**
     * 返回主键
     *
     * @return String 主键
     */
    public String getPrimaryKey() {
        return pk_adj_inout_plan;
    }

    /**
     * 设置主键
     *
     * @return key 主键
     */
    public void setPrimaryKey(String key) {
        this.pk_adj_inout_plan = key;
    }

    /**
     * 主键的getter方法
     *
     * @return String
     */
    public String getPk_adj_inout_plan() {
        return pk_adj_inout_plan;
    }

    /**
     * 主键的setter方法
     *
     * @param pk_adj_inout_plan 主键
     */
    public void setPk_adj_inout_plan(String pk_adj_inout_plan) {
        this.pk_adj_inout_plan = pk_adj_inout_plan;
    }


    /**
     * 客户主键的getter方法
     *
     * @return CustomerRefVO 客户主键
     */
    public String getPk_customer() {
        return pk_customer;
    }

    /**
     * 客户主键的setter方法
     *
     * @param CustomerRefVO 客户主键
     */
    public void setPk_customer(String pk_customer) {
        this.pk_customer = pk_customer;
    }

    /**
     * 主表主键的getter方法
     *
     * @return String
     */
    public String getSource_bill() {
        return source_bill;
    }

    /**
     * 主表主键的setter方法
     *
     * @param source_bill 主表主键
     */
    public void setSource_bill(String source_bill) {
        this.source_bill = source_bill;
    }

    /**
     * 来源单据类型的getter方法
     *
     * @return BilltypeRefVO 来源单据类型
     */
    public String getSource_billtype() {
        return source_billtype;
    }

    /**
     * 来源单据类型的setter方法
     *
     * @param BilltypeRefVO 来源单据类型
     */
    public void setSource_billtype(String source_billtype) {
        this.source_billtype = source_billtype;
    }

    /**
     * 收取期次的getter方法
     *
     * @return String
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

    /**
     * 交易类别的getter方法
     *
     * @return String
     */
    public EventTypeRefVO getTrans_type() {
        return trans_type;
    }

    /**
     * 交易类别的setter方法
     *
     * @param trans_type 交易类别
     */
    public void setTrans_type(EventTypeRefVO trans_type) {
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
     * 租金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash() {
        return lease_cash;
    }

    /**
     * 租金的setter方法
     *
     * @param lease_cash 租金
     */
    public void setLease_cash(BigDecimal lease_cash) {
        this.lease_cash = lease_cash;
    }

    /**
     * 租金税额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_cash_tax() {
        return lease_cash_tax;
    }

    /**
     * 租金税额的setter方法
     *
     * @param lease_cash_tax 租金税额
     */
    public void setLease_cash_tax(BigDecimal lease_cash_tax) {
        this.lease_cash_tax = lease_cash_tax;
    }

    /**
     * 利息的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_interest() {
        return lease_interest;
    }

    /**
     * 利息的setter方法
     *
     * @param lease_interest 利息
     */
    public void setLease_interest(BigDecimal lease_interest) {
        this.lease_interest = lease_interest;
    }

    /**
     * 利息税额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_interest_tax() {
        return lease_interest_tax;
    }

    /**
     * 利息税额的setter方法
     *
     * @param lease_interest_tax 利息税额
     */
    public void setLease_interest_tax(BigDecimal lease_interest_tax) {
        this.lease_interest_tax = lease_interest_tax;
    }

    /**
     * 本金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_corpus() {
        return lease_corpus;
    }

    /**
     * 本金的setter方法
     *
     * @param lease_corpus 本金
     */
    public void setLease_corpus(BigDecimal lease_corpus) {
        this.lease_corpus = lease_corpus;
    }

    /**
     * 本金税额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_corpus_tax() {
        return lease_corpus_tax;
    }

    /**
     * 本金税额的setter方法
     *
     * @param lease_corpus_tax 本金税额
     */
    public void setLease_corpus_tax(BigDecimal lease_corpus_tax) {
        this.lease_corpus_tax = lease_corpus_tax;
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
     * 剩余租金的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getLease_balance() {
        return lease_balance;
    }

    /**
     * 剩余租金的setter方法
     *
     * @param lease_balance 剩余租金
     */
    public void setLease_balance(BigDecimal lease_balance) {
        this.lease_balance = lease_balance;
    }

    /**
     * 手续费分摊金额的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getSrvfee_share() {
        return srvfee_share;
    }

    /**
     * 手续费分摊金额的setter方法
     *
     * @param srvfee_share 手续费分摊金额
     */
    public void setSrvfee_share(BigDecimal srvfee_share) {
        this.srvfee_share = srvfee_share;
    }

    /**
     * 租金浮动比例的getter方法
     *
     * @return BigDecimal
     */
    public BigDecimal getRent_float_ratio() {
        return rent_float_ratio;
    }

    /**
     * 租金浮动比例的setter方法
     *
     * @param rent_float_ratio 租金浮动比例
     */
    public void setRent_float_ratio(BigDecimal rent_float_ratio) {
        this.rent_float_ratio = rent_float_ratio;
    }

    /**
     * 生成方式的getter方法
     *
     * @return Short
     */
    public Short getMake_method() {
        return make_method;
    }

    /**
     * 生成方式的setter方法
     *
     * @param make_method 生成方式
     */
    public void setMake_method(Short make_method) {
        this.make_method = make_method;
    }

    /**
     * 租金表类型的getter方法
     *
     * @return Short
     */
    public Short getRent_type() {
        return rent_type;
    }

    /**
     * 租金表类型的setter方法
     *
     * @param rent_type 租金表类型
     */
    public void setRent_type(Short rent_type) {
        this.rent_type = rent_type;
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
     * 获得子表表名
     *
     * @return String
     */
    public String getChildrenTableName() {
        return "yls_adj_inout_plan";
    }

    /**
     * 获得子表主键定义
     *
     * @return String
     */
    public String getPKFieldName() {
        return "pk_adj_inout_plan";
    }

    /**
     * 获得主表主键定义
     *
     * @return String
     */
    public String getParentPKFieldName() {
        return "pk_adjust_apply";
    }

    /**
     * 获得主表对象
     *
     * @return String
     */
//    public ParentValueObject getParentValueObject() {
//        return null;
//    }
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
     * 执行状态(款)
     */
    public Short getExec_status() {
        return exec_status;
    }
    /**
     * 执行状态(款)
     */
    public void setExec_status(Short exec_status) {
        this.exec_status = exec_status;
    }
    /**
     * 资产状态
     */
    public Short getAsset_status() {
        return asset_status;
    }
    /**
     * 资产状态
     */
    public void setAsset_status(Short asset_status) {
        this.asset_status = asset_status;
    }
    /**
     * 冻结金额(款)
     */
    public BigDecimal getFreeze_cash() {
        return freeze_cash;
    }
    /**
     * 冻结金额(款)
     */
    public void setFreeze_cash(BigDecimal freeze_cash) {
        this.freeze_cash = freeze_cash;
    }
    /**
     * 实际发生额(款)
     */
    public BigDecimal getFact_cash() {
        return fact_cash;
    }
    /**
     * 实际发生额(款)
     */
    public void setFact_cash(BigDecimal fact_cash) {
        this.fact_cash = fact_cash;
    }
    /**
     * 对应支付频率
     */
    public Short getPaymentFrequency() {
        return paymentFrequency;
    }
    /**
     * 对应支付频率
     */
    public void setPaymentFrequency(Short paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
    /**
     * 租赁收入
     */
    public BigDecimal getLease_cash_in() {
        return lease_cash_in;
    }
    /**
     * 租赁收入
     */
    public void setLease_cash_in(BigDecimal lease_cash_in) {
        this.lease_cash_in = lease_cash_in;
    }
    /**
     * 其中:去税租息
     */
    public BigDecimal getNo_tax_interest() {
        return no_tax_interest;
    }
    /**
     * 其中:去税租息
     */
    public void setNo_tax_interest(BigDecimal no_tax_interest) {
        this.no_tax_interest = no_tax_interest;
    }
    /**
     * 其中:去税手续费收入
     */
    public BigDecimal getNo_tax_srvfee() {
        return no_tax_srvfee;
    }
    /**
     * 其中:去税手续费收入
     */
    public void setNo_tax_srvfee(BigDecimal no_tax_srvfee) {
        this.no_tax_srvfee = no_tax_srvfee;
    }
    /**
     * 其中:去税其它支出
     */
    public BigDecimal getNo_tax_otherout() {
        return no_tax_otherout;
    }
    /**
     * 其中:去税其它支出
     */
    public void setNo_tax_otherout(BigDecimal no_tax_otherout) {
        this.no_tax_otherout = no_tax_otherout;
    }
    /**
     * 其中:去税其它收入
     */
    public BigDecimal getNo_tax_otherin() {
        return no_tax_otherin;
    }
    /**
     * 其中:去税其它收入
     */
    public void setNo_tax_otherin(BigDecimal no_tax_otherin) {
        this.no_tax_otherin = no_tax_otherin;
    }
    /**
     * 税金总和
     */
    public BigDecimal getSum_tax() {
        return sum_tax;
    }
    /**
     * 税金总和
     */
    public void setSum_tax(BigDecimal sum_tax) {
        this.sum_tax = sum_tax;
    }
    /**
     * 商业折扣
     */
    public BigDecimal getTrade_discount() {
        return trade_discount;
    }
    /**
     * 商业折扣
     */
    public void setTrade_discount(BigDecimal trade_discount) {
        this.trade_discount = trade_discount;
    }
    /**
     * 利率上浮
     */
    public BigDecimal getRate_up() {
        return rate_up;
    }
    /**
     * 利率上浮
     */
    public void setRate_up(BigDecimal rate_up) {
        this.rate_up = rate_up;
    }

    /**
     * 租金(调息前)
     */
    public BigDecimal getLease_cash_old() {
        return lease_cash_old;
    }
    /**
     * 租金(调息前)
     */
    public void setLease_cash_old(BigDecimal lease_cash_old) {
        this.lease_cash_old = lease_cash_old;
    }
    /**
     * 本金(调息前)
     */
    public BigDecimal getLease_corpus_old() {
        return lease_corpus_old;
    }
    /**
     * 本金(调息前)
     */
    public void setLease_corpus_old(BigDecimal lease_corpus_old) {
        this.lease_corpus_old = lease_corpus_old;
    }
    /**
     * 利息(调息前)
     */
    public BigDecimal getLease_interest_old() {
        return lease_interest_old;
    }
    /**
     * 利息(调息前)
     */
    public void setLease_interest_old(BigDecimal lease_interest_old) {
        this.lease_interest_old = lease_interest_old;
    }
    /**
     * 剩余本金(调息前)
     */
    public BigDecimal getCorpus_balance_old() {
        return corpus_balance_old;
    }
    /**
     * 剩余本金(调息前)
     */
    public void setCorpus_balance_old(BigDecimal corpus_balance_old) {
        this.corpus_balance_old = corpus_balance_old;
    }
    /**
     * 核销状态
     */
    public Short getCharge_off_status() {
        return charge_off_status;
    }
    /**
     * 核销状态
     */
    public void setCharge_off_status(Short charge_off_status) {
        this.charge_off_status = charge_off_status;
    }
    /**
     * 利息差
     */
    public BigDecimal getLease_interest_diff() {
        return lease_interest_diff;
    }
    /**
     * 利息差
     */
    public void setLease_interest_diff(BigDecimal lease_interest_diff) {
        this.lease_interest_diff = lease_interest_diff;
    }
    public String getPk_adjust_apply() {
        return pk_adjust_apply;
    }
    public void setPk_adjust_apply(String pk_adjust_apply) {
        this.pk_adjust_apply = pk_adjust_apply;
    }
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
    public BigDecimal getLease_cash_fin_old() {
        return lease_cash_fin_old;
    }
    public void setLease_cash_fin_old(BigDecimal lease_cash_fin_old) {
        this.lease_cash_fin_old = lease_cash_fin_old;
    }
    public BigDecimal getLease_corpus_fin_old() {
        return lease_corpus_fin_old;
    }
    public void setLease_corpus_fin_old(BigDecimal lease_corpus_fin_old) {
        this.lease_corpus_fin_old = lease_corpus_fin_old;
    }
    public BigDecimal getLease_interest_fin_old() {
        return lease_interest_fin_old;
    }
    public void setLease_interest_fin_old(BigDecimal lease_interest_fin_old) {
        this.lease_interest_fin_old = lease_interest_fin_old;
    }
    public BigDecimal getCorpus_balance_fin_old() {
        return corpus_balance_fin_old;
    }
    public void setCorpus_balance_fin_old(BigDecimal corpus_balance_fin_old) {
        this.corpus_balance_fin_old = corpus_balance_fin_old;
    }
    /**
     * 利息差额
     */
    public BigDecimal getInterest_first() {
        return interest_first;
    }
    /**
     * 利息差额
     */
    public void setInterest_first(BigDecimal interest_first) {
        this.interest_first = interest_first;
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
    // by lihongjian 营改增 @2016/05/11 ADD END
}