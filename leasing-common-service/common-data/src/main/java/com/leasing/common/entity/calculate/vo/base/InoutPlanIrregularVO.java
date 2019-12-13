//package com.leasing.common.entity.calculate.vo.base;
//
//import com.leasing.common.base.entity.BaseEntity;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//
//@Entity
//@Table(name="yls_inout_plan")
//public class InoutPlanIrregularVO extends BaseEntity {
//    @Override
//    public String getPk() {
//        return pk_inout_plan;
//    }
//
//    @Override
//    public void setPk(String pk) {
//        this.pk_inout_plan = pk;
//    }
//
//    /**
//     * 主键
//     */
//    public String pk_inout_plan;
//    /**
//     * 客户名称
//     */
//    public CustomerRefVO pk_customer;
//    /**
//     * 主表主键
//     */
//    public LeaseCalculatorIrregularVO pk_lease_calculator; //主表主键
//    /**
//     * 收取期次
//     */
//    public String lease_time;
//    /**
//     * 计算日期
//     */
//    public String cal_date;
//    /**
//     * 计划收取日期
//     */
//    public String plan_date;
//    /**
//     * 交易类别
//     */
//    public EventTypeRefVO trans_type;
//    /**
//     * 收支方向
//     */
//    public Short direction;
//    /**
//     * 租金
//     */
//    public BigDecimal lease_cash;
//    /**
//     * 租金税额
//     */
//    public BigDecimal lease_cash_tax;
//    /**
//     * 租金税额(重算)
//     */
//    public BigDecimal lease_cash_tax_fin;
//
//    /**
//     * 租金(不含税)
//     */
//    public BigDecimal lease_cash_corpus;
//
//    /**
//     * 利息
//     */
//    public BigDecimal lease_interest;
//    /**
//     * 利息税额
//     */
//    public BigDecimal lease_interest_tax;
//    /**
//     * 利息税额(重算)
//     */
//    public BigDecimal lease_interest_tax_fin;
//    /**
//     * 本金
//     */
//    public BigDecimal lease_corpus;
//    /**
//     * 本金税额
//     */
//    public BigDecimal lease_corpus_tax;
//    /**
//     * 本金税额(重算)
//     */
//    public BigDecimal lease_corpus_tax_fin;
//    /**
//     * 剩余本金
//     */
//    public BigDecimal corpus_balance;
//    /**
//     * 剩余租金
//     */
//    public BigDecimal lease_balance;
//    /**
//     * 手续费分摊金额
//     */
//    public BigDecimal srvfee_share;
//
//    /**
//     * 租金浮动比例
//     */
//    public BigDecimal rent_float_ratio;
//    /**
//     * 备注
//     */
//    public String memo;
//
//    /**
//     * 生成方式
//     */
//    public Short make_method;
//
//    /**
//     * 租金表类型
//     * */
//    public Short rent_type;
//    /**
//     * 数据类型
//     */
//    public String source_billtype;
//    /**
//     * 租赁收入
//     */
//    public BigDecimal lease_cash_in;
//    /**
//     * 其中:去税租息
//     */
//    public BigDecimal no_tax_interest;
//    /**
//     * 其中:去税手续费收入
//     */
//    public BigDecimal no_tax_srvfee;
//    /**
//     * 其中:去税其它支出
//     */
//    public BigDecimal no_tax_otherout;
//    /**
//     * 其中:去税其它收入
//     */
//    public BigDecimal no_tax_otherin;
//    /**
//     * 税金
//     */
//    public BigDecimal sum_tax;
//
//    /**
//     * 商业折扣
//     */
//    public BigDecimal trade_discount;
//
//    /**
//     * 税率
//     */
//    public Short tax_rate;
//
//    /**会计租金*/
//    public BigDecimal lease_cash_fin;
//    /**会计本金*/
//    public BigDecimal lease_corpus_fin;
//    /**会计利息*/
//    public BigDecimal lease_interest_fin;
//    /**
//     * 剩余本金(重算)
//     */
//    public BigDecimal corpus_balance_fin;
//
//
//    /**
//     * 分拆租金（中投）
//     */
//    public BigDecimal divide_cash;
//    /**
//     * 分拆本金（中投）
//     */
//    public BigDecimal divide_corpus;
//    /**
//     * 分拆利息（中投）
//     */
//    public BigDecimal divide_interest;
//
//    /**
//     * 新去税租息
//     */
//    public BigDecimal input_tax;
//
//    /**
//     * 进项税
//     */
//    public BigDecimal input_tax_diff;
//
//    /** ADD WJJ 20160701 税种空*/
//    /**
//     * 税种
//     */
//    public Short tax_mode;
//    public Short getTax_mode() {
//        return tax_mode;
//    }
//
//    public void setTax_mode(Short tax_mode) {
//        this.tax_mode = tax_mode;
//    }
//    /** ADD END */
//    /**
//     * @return the divide_cash
//     */
//    public BigDecimal getDivide_cash() {
//        return divide_cash;
//    }
//
//    /**
//     * @param divide_cash the divide_cash to set
//     */
//    public void setDivide_cash(BigDecimal divide_cash) {
//        this.divide_cash = divide_cash;
//    }
//
//    /**
//     * @return the divide_corpus
//     */
//    public BigDecimal getDivide_corpus() {
//        return divide_corpus;
//    }
//
//    /**
//     * @param divide_corpus the divide_corpus to set
//     */
//    public void setDivide_corpus(BigDecimal divide_corpus) {
//        this.divide_corpus = divide_corpus;
//    }
//
//    /**
//     * @return the divide_interest
//     */
//    public BigDecimal getDivide_interest() {
//        return divide_interest;
//    }
//
//    /**
//     * @param divide_interest the divide_interest to set
//     */
//    public void setDivide_interest(BigDecimal divide_interest) {
//        this.divide_interest = divide_interest;
//    }
//
//    /**
//     * 类InoutPlanVO的构造方法
//     */
//    public InoutPlanIrregularVO() {
//    }
//
//    /**
//     * 返回主键
//     *
//     * @return String 主键
//     */
//    public String getPrimaryKey() {
//        return pk_inout_plan;
//    }
//
//    /**
//     * 设置主键
//     *
//     * @return key 主键
//     */
//    public void setPrimaryKey(String key) {
//        this.pk_inout_plan = key;
//    }
//
//    /**
//     * 主键的getter方法
//     *
//     * @return String
//     */
//    public String getPk_inout_plan() {
//        return pk_inout_plan;
//    }
//
//    public BigDecimal getRent_float_ratio() {
//        return rent_float_ratio;
//    }
//
//    public void setRent_float_ratio(BigDecimal rent_float_ratio) {
//        this.rent_float_ratio = rent_float_ratio;
//    }
//
//    /**
//     * 主键的setter方法
//     *
//     * @param pk_inout_plan 主键
//     */
//    public void setPk_inout_plan(String pk_inout_plan) {
//        this.pk_inout_plan = pk_inout_plan;
//    }
//
//    /**
//     * 主表主键的getter方法
//     *
//     * @return String
//     */
//    public LeaseCalculatorIrregularVO getPk_lease_calculator() {
//        return pk_lease_calculator;
//    }
//
//    /**
//     * 主表主键的setter方法
//     *
//     * @param LeaseCalculatorIrregularVO 主表主键
//     */
//    public void setPk_lease_calculator(LeaseCalculatorIrregularVO pk_lease_calculator) {
//        this.pk_lease_calculator = pk_lease_calculator;
//    }
//
//    /**
//     * 收取期次的getter方法
//     *
//     * @return String
//     */
//    public String getLease_time() {
//        return lease_time;
//    }
//
//    /**
//     * 收取期次的setter方法
//     *
//     * @param lease_time 收取期次
//     */
//    public void setLease_time(String lease_time) {
//        this.lease_time = lease_time;
//    }
//
//    /**
//     * 计算日期的getter方法
//     *
//     * @return String
//     */
//    public String getCal_date() {
//        return cal_date;
//    }
//
//    /**
//     * 计算日期的setter方法
//     *
//     * @param cal_date 计算日期
//     */
//    public void setCal_date(String cal_date) {
//        this.cal_date = cal_date;
//    }
//
//    /**
//     * 计划收取日期的getter方法
//     *
//     * @return String
//     */
//    public String getPlan_date() {
//        return plan_date;
//    }
//
//    /**
//     * 计划收取日期的setter方法
//     *
//     * @param plan_date 计划收取日期
//     */
//    public void setPlan_date(String plan_date) {
//        this.plan_date = plan_date;
//    }
//
//    /**
//     * 交易类别的getter方法
//     *
//     * @return String
//     */
//    public EventTypeRefVO getTrans_type() {
//        return trans_type;
//    }
//
//    /**
//     * 交易类别的setter方法
//     *
//     * @param trans_type 交易类别
//     */
//    public void setTrans_type(EventTypeRefVO trans_type) {
//        this.trans_type = trans_type;
//    }
//
//    /**
//     * 收支方向的getter方法
//     *
//     * @return Short
//     */
//    public Short getDirection() {
//        return direction;
//    }
//
//    /**
//     * 收支方向的setter方法
//     *
//     * @param direction 收支方向
//     */
//    public void setDirection(Short direction) {
//        this.direction = direction;
//    }
//
//    /**
//     * 租金的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_cash() {
//        if(lease_cash == null){
//            return BigDecimal.ZERO;
//        } else {
//            return lease_cash;
//        }
//
//    }
//
//    /**
//     * 租金的setter方法
//     *
//     * @param lease_cash 租金
//     */
//    public void setLease_cash(BigDecimal lease_cash) {
//        this.lease_cash = lease_cash;
//    }
//
//    /**
//     * 租金税额的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_cash_tax() {
//        if(lease_cash_tax == null){
//            return BigDecimal.ZERO;
//        }else{
//            return lease_cash_tax;
//        }
//    }
//
//    /**
//     * 租金税额的setter方法
//     *
//     * @param lease_cash_tax 租金税额
//     */
//    public void setLease_cash_tax(BigDecimal lease_cash_tax) {
//        this.lease_cash_tax = lease_cash_tax;
//    }
//
//    /**
//     * 租金(不含税)的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_cash_corpus() {
//        if(lease_cash == null){
//            return BigDecimal.ZERO;
//        }else {
//            return this.lease_cash_corpus = lease_cash.subtract(getLease_cash_tax());
//        }
//
//    }
//
//    /**
//     * 租金(不含税)的setter方法
//     *
//     * @param lease_cash_corpus 租金(不含税)
//     */
//    public void setLease_cash_corpus(BigDecimal lease_cash_corpus) {
//        this.lease_cash_corpus = lease_cash_corpus;
//        if (lease_cash != null && lease_cash_tax != null) {
//            this.lease_cash_corpus = lease_cash.subtract(lease_cash_tax);
//        }
//    }
//
//    /**
//     * 利息的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_interest() {
//        if(lease_interest == null){
//            return BigDecimal.ZERO;
//        }else{
//            return lease_interest;
//        }
//    }
//
//    /**
//     * 利息的setter方法
//     *
//     * @param lease_interest 利息
//     */
//    public void setLease_interest(BigDecimal lease_interest) {
//        this.lease_interest = lease_interest;
//    }
//
//    /**
//     * 利息税额的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_interest_tax() {
//        if(lease_interest_tax == null){
//            return BigDecimal.ZERO;
//        }else{
//            return lease_interest_tax;
//        }
//
//    }
//
//    /**
//     * 利息税额的setter方法
//     *
//     * @param lease_interest_tax 利息税额
//     */
//    public void setLease_interest_tax(BigDecimal lease_interest_tax) {
//        this.lease_interest_tax = lease_interest_tax;
//    }
//
//    /**
//     * 本金的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_corpus() {
//        if(lease_corpus == null){
//            return BigDecimal.ZERO;
//        } else {
//            return lease_corpus;
//        }
//    }
//
//    /**
//     * 本金的setter方法
//     *
//     * @param lease_corpus 本金
//     */
//    public void setLease_corpus(BigDecimal lease_corpus) {
//        this.lease_corpus = lease_corpus;
//    }
//
//    /**
//     * 本金税额的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_corpus_tax() {
//        return lease_corpus_tax;
//    }
//
//    /**
//     * 本金税额的setter方法
//     *
//     * @param lease_corpus_tax 本金税额
//     */
//    public void setLease_corpus_tax(BigDecimal lease_corpus_tax) {
//        this.lease_corpus_tax = lease_corpus_tax;
//    }
//
//    /**
//     * 剩余本金的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getCorpus_balance() {
//        return corpus_balance;
//    }
//
//    /**
//     * 剩余本金的setter方法
//     *
//     * @param corpus_balance 剩余本金
//     */
//    public void setCorpus_balance(BigDecimal corpus_balance) {
//        this.corpus_balance = corpus_balance;
//    }
//
//    /**
//     * 剩余租金的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getLease_balance() {
//        return lease_balance;
//    }
//
//    /**
//     * 剩余租金的setter方法
//     *
//     * @param lease_balance 剩余租金
//     */
//    public void setLease_balance(BigDecimal lease_balance) {
//        this.lease_balance = lease_balance;
//    }
//
//    /**
//     * 手续费分摊金额的getter方法
//     *
//     * @return BigDecimal
//     */
//    public BigDecimal getSrvfee_share() {
//        return srvfee_share;
//    }
//
//    /**
//     * 手续费分摊金额的setter方法
//     *
//     * @param srvfee_share 手续费分摊金额
//     */
//    public void setSrvfee_share(BigDecimal srvfee_share) {
//        this.srvfee_share = srvfee_share;
//    }
//
//    /**
//     * 备注的getter方法
//     *
//     * @return String
//     */
//    public String getMemo() {
//        return memo;
//    }
//
//    /**
//     * 备注的setter方法
//     *
//     * @param memo 备注
//     */
//    public void setMemo(String memo) {
//        this.memo = memo;
//    }
//
//    /**
//     * 获得子表表名
//     *
//     * @return String
//     */
//    public String getChildrenTableName() {
//        return "yls_inout_plan";
//    }
//
//    /**
//     * 获得子表主键定义
//     *
//     * @return String
//     */
//    public String getPKFieldName() {
//        return "pk_inout_plan";
//    }
//
//    /**
//     * 获得主表主键定义
//     *
//     * @return String
//     */
//    public String getParentPKFieldName() {
//        return "pk_lease_calculator";
//    }
//
//    /**
//     * 获得主表对象
//     *
//     * @return String
//     */
//    public ParentValueObject getParentValueObject() {
//        return pk_lease_calculator;
//    }
//
//    public Short getMake_method() {
//        return make_method;
//    }
//
//    public void setMake_method(Short make_method) {
//        this.make_method = make_method;
//    }
//
//    /**
//     * @return the rent_type
//     */
//    public Short getRent_type() {
//        return rent_type;
//    }
//
//    /**
//     * @param rent_type the rent_type to set
//     */
//    public void setRent_type(Short rent_type) {
//        this.rent_type = rent_type;
//    }
//
//    /**
//     * @return the pk_customer
//     */
//    public CustomerRefVO getPk_customer() {
//        return pk_customer;
//    }
//
//    /**
//     * @param pk_customer the pk_customer to set
//     */
//    public void setPk_customer(CustomerRefVO pk_customer) {
//        this.pk_customer = pk_customer;
//    }
//
//    /**
//     * @return the source_billtype
//     */
//    public String getSource_billtype() {
//        return source_billtype;
//    }
//
//    /**
//     * @param source_billtype the source_billtype to set
//     */
//    public void setSource_billtype(String source_billtype) {
//        this.source_billtype = source_billtype;
//    }
//
//    /**
//     * @return the lease_cash_in
//     */
//    public BigDecimal getLease_cash_in() {
//        return lease_cash_in;
//    }
//
//    /**
//     * @param lease_cash_in the lease_cash_in to set
//     */
//    public void setLease_cash_in(BigDecimal lease_cash_in) {
//        this.lease_cash_in = lease_cash_in;
//    }
//
//    /**
//     * @return the no_tax_interest
//     */
//    public BigDecimal getNo_tax_interest() {
//        return no_tax_interest;
//    }
//
//    /**
//     * @param no_tax_interest the no_tax_interest to set
//     */
//    public void setNo_tax_interest(BigDecimal no_tax_interest) {
//        this.no_tax_interest = no_tax_interest;
//    }
//
//    /**
//     * @return the no_tax_srvfee
//     */
//    public BigDecimal getNo_tax_srvfee() {
//        return no_tax_srvfee;
//    }
//
//    /**
//     * @param no_tax_srvfee the no_tax_srvfee to set
//     */
//    public void setNo_tax_srvfee(BigDecimal no_tax_srvfee) {
//        this.no_tax_srvfee = no_tax_srvfee;
//    }
//
//    /**
//     * @return the no_tax_otherout
//     */
//    public BigDecimal getNo_tax_otherout() {
//        return no_tax_otherout;
//    }
//
//    /**
//     * @param no_tax_otherout the no_tax_otherout to set
//     */
//    public void setNo_tax_otherout(BigDecimal no_tax_otherout) {
//        this.no_tax_otherout = no_tax_otherout;
//    }
//
//    /**
//     * @return the no_tax_otherin
//     */
//    public BigDecimal getNo_tax_otherin() {
//        return no_tax_otherin;
//    }
//
//    /**
//     * @param no_tax_otherin the no_tax_otherin to set
//     */
//    public void setNo_tax_otherin(BigDecimal no_tax_otherin) {
//        this.no_tax_otherin = no_tax_otherin;
//    }
//
//    /**
//     * @return the sum_tax
//     */
//    public BigDecimal getSum_tax() {
//        return sum_tax;
//    }
//
//    /**
//     * @param sum_tax the sum_tax to set
//     */
//    public void setSum_tax(BigDecimal sum_tax) {
//        this.sum_tax = sum_tax;
//    }
//
//    /**
//     * @return the trade_discount
//     */
//    public BigDecimal getTrade_discount() {
//        return trade_discount;
//    }
//
//    /**
//     * @param trade_discount the trade_discount to set
//     */
//    public void setTrade_discount(BigDecimal trade_discount) {
//        this.trade_discount = trade_discount;
//    }
//
//    /**
//     * @return the tax_rate
//     */
//    public Short getTax_rate() {
//        return tax_rate;
//    }
//
//    /**
//     * @param tax_rate the tax_rate to set
//     */
//    public void setTax_rate(Short tax_rate) {
//        this.tax_rate = tax_rate;
//    }
//
//    /**
//     * @return the lease_cash_fin
//     */
//    public BigDecimal getLease_cash_fin() {
//        return lease_cash_fin;
//    }
//
//    /**
//     * @param lease_cash_fin the lease_cash_fin to set
//     */
//    public void setLease_cash_fin(BigDecimal lease_cash_fin) {
//        this.lease_cash_fin = lease_cash_fin;
//    }
//
//    /**
//     * @return the lease_corpus_fin
//     */
//    public BigDecimal getLease_corpus_fin() {
//        return lease_corpus_fin;
//    }
//
//    /**
//     * @param lease_corpus_fin the lease_corpus_fin to set
//     */
//    public void setLease_corpus_fin(BigDecimal lease_corpus_fin) {
//        this.lease_corpus_fin = lease_corpus_fin;
//    }
//
//    /**
//     * @return the lease_interest_fin
//     */
//    public BigDecimal getLease_interest_fin() {
//        return lease_interest_fin;
//    }
//
//    /**
//     * @param lease_interest_fin the lease_interest_fin to set
//     */
//    public void setLease_interest_fin(BigDecimal lease_interest_fin) {
//        this.lease_interest_fin = lease_interest_fin;
//    }
//
//    /**
//     * @return the corpus_balance_fin
//     */
//    public BigDecimal getCorpus_balance_fin() {
//        return corpus_balance_fin;
//    }
//
//    /**
//     * @param corpus_balance_fin the corpus_balance_fin to set
//     */
//    public void setCorpus_balance_fin(BigDecimal corpus_balance_fin) {
//        this.corpus_balance_fin = corpus_balance_fin;
//    }
//
//    /**
//     * @return the lease_cash_tax_fin
//     */
//    public BigDecimal getLease_cash_tax_fin() {
//        return lease_cash_tax_fin;
//    }
//
//    /**
//     * @param lease_cash_tax_fin the lease_cash_tax_fin to set
//     */
//    public void setLease_cash_tax_fin(BigDecimal lease_cash_tax_fin) {
//        this.lease_cash_tax_fin = lease_cash_tax_fin;
//    }
//
//    /**
//     * @return the lease_interest_tax_fin
//     */
//    public BigDecimal getLease_interest_tax_fin() {
//        return lease_interest_tax_fin;
//    }
//
//    /**
//     * @param lease_interest_tax_fin the lease_interest_tax_fin to set
//     */
//    public void setLease_interest_tax_fin(BigDecimal lease_interest_tax_fin) {
//        this.lease_interest_tax_fin = lease_interest_tax_fin;
//    }
//
//    /**
//     * @return the lease_corpus_tax_fin
//     */
//    public BigDecimal getLease_corpus_tax_fin() {
//        return lease_corpus_tax_fin;
//    }
//
//    /**
//     * @param lease_corpus_tax_fin the lease_corpus_tax_fin to set
//     */
//    public void setLease_corpus_tax_fin(BigDecimal lease_corpus_tax_fin) {
//        this.lease_corpus_tax_fin = lease_corpus_tax_fin;
//    }
//
//    public BigDecimal getInput_tax() {
//        return input_tax;
//    }
//
//    public void setInput_tax(BigDecimal input_tax) {
//        this.input_tax = input_tax;
//    }
//
//    public BigDecimal getInput_tax_diff() {
//        return input_tax_diff;
//    }
//
//    public void setInput_tax_diff(BigDecimal input_tax_diff) {
//        this.input_tax_diff = input_tax_diff;
//    }
//
//    /**
//     * 会计分摊表显示事件
//     *
//     */
//    public String rent_memo;
//    public String rent_event_type;
//
//    public String getRent_memo() {
//        return rent_memo;
//    }
//    public void setRent_memo(String rent_memo) {
//        this.rent_memo = rent_memo;
//    }
//    public String getRent_event_type() {
//        return rent_event_type;
//    }
//    public void setRent_event_type(String rent_event_type) {
//        this.rent_event_type = rent_event_type;
//    }
//
//
//}
//
