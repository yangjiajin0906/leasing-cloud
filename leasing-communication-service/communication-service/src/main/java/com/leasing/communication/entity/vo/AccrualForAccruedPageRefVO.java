package com.leasing.communication.entity.vo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leasing.common.entity.foundation.vo.CurrtypeVO;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.vo.foundation.CurrtypeVO;
import com.leasing.communication.entity.dto.CustomerDTO;

import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * <b>中投计提节点，计提按钮弹出款多选参照model</b>
 *
 * @author zoucr
 *
 */
@Entity
@Table(name="(select a.month," +
        "       nvl(decode(f.pk_lessee_protocol," +
        "                  null," +
        "                  a.cash," +
        "                  decode(a.month," +
        "                         substr(h.real_pay_date, 1, 7)," +
        "                         x.inter," +
        "                         a.cash))," +
        "           0) inter," +
        "       nvl(decode(f.pk_lessee_protocol," +
        "                  null," +
        "                  b.cash," +
        "                  decode(a.month," +
        "                         substr(h.real_pay_date, 1, 7)," +
        "                         x.srv," +
        "                         b.cash))," +
        "           0) srv," +
        "       nvl(decode(f.pk_lessee_protocol," +
        "                  null," +
        "                  c.cash," +
        "                  decode(a.month," +
        "                         substr(h.real_pay_date, 1, 7)," +
        "                         x.pri," +
        "                         c.cash))," +
        "           0) pri," +
        "       nvl(decode(f.pk_lessee_protocol," +
        "                  null," +
        "                  e.cash," +
        "                  decode(a.month," +
        "                         substr(h.real_pay_date, 1, 7)," +
        "                         x.bus," +
        "                         e.cash))," +
        "           0) bus," +
        "       a.source_bill," +
        "       a.pk_accrual," +
        "       f.pk_contract," +
        "       f.pk_customer_lessee as pk_customer," +
        "       f.pk_lessee_protocol," +
        "       f.assets_classify," +
        "       f.pk_currency as pk_currtype," +
        "       f.exchg_rate," +
        "       f.pk_glorgbook," +
        "       h.real_pay_date," +
        "       f.lease_flow," +
        "       f.appoint_rent_date," +
        "       p.mon," +
        "       nvl(a.if_begin, 1) if_begin," +
        "       aa.cash inter_actual" +
        "  from yls_accrual_c a" +
        " inner join yls_accrual_c aa" +
        "    on aa.pk_accrual = a.pk_accrual" +
        " inner join yls_lease_calculator_c g" +
        "    on a.source_bill = g.pk_lease_calculator" +
        " inner join yls_contract_c f" +
        "    on g.pk_contract = f.pk_contract" +
        " left join (select fc.pk_contract," +
        "                    decode(substr(max(month), 6, 2)," +
        "                           12," +
        "                           substr(max(month), 1, 4) + 1 || '-01'," +
        "                           substr(max(month), 1, 4) ||" +
        "                           decode(substr(max(month), 7, 1), 9, '-', '-0') ||" +
        "                           (substr(max(month), 7, 1) + 1)) mon" +
        "               from yls_accrual_c ac" +
        "              inner join yls_lease_calculator_c gc" +
        "                 on ac.source_bill = gc.pk_lease_calculator" +
        "              inner join yls_contract_c fc" +
        "                 on gc.pk_contract = fc.pk_contract" +
        "              where ac.if_begin = 0" +
        "              group by fc.pk_contract" +
        "             union all" +
        "             select fc.pk_contract, min(month) mon" +
        "               from yls_accrual_c ac" +
        "              inner join yls_lease_calculator_c gc" +
        "                 on ac.source_bill = gc.pk_lease_calculator" +
        "              inner join yls_contract_c fc" +
        "                 on gc.pk_contract = fc.pk_contract" +
        "              inner join (select pk_contract" +
        "                            from (select fc.pk_contract," +
        "                                         sum(decode(ac.if_begin, 0, 1, 0)) cou" +
        "                                    from yls_accrual_c ac" +
        "                                   inner join yls_lease_calculator_c gc" +
        "                                      on ac.source_bill =" +
        "                                         gc.pk_lease_calculator" +
        "                                   inner join yls_contract_c fc" +
        "                                      on gc.pk_contract = fc.pk_contract" +
        "                                   group by fc.pk_contract) vv" +
        "                           where vv.cou = 0) tem" +
        "                 on tem.pk_contract = fc.pk_contract" +
        "              group by fc.pk_contract) p" +
        "    on f.pk_contract = p.pk_contract" +
        "  left join (select g.pk_contract," +
        "                    nvl(sum(a.cash), 0) inter," +
        "                    nvl(sum(b.cash), 0) srv," +
        "                    nvl(sum(c.cash), 0) pri," +
        "                    nvl(sum(e.cash), 0) bus" +
        "               from yls_lease_calculator_c g" +
        "              inner join (select ip.pk_contract," +
        "                                substr(min(t1.real_pay_date), 1, 7) real_pay_date" +
        "                           from yls_loan_deal t1" +
        "                          inner join yls_loan_plan t2" +
        "                             on t1.pk_loan_deal = t2.pk_loan_deal" +
        "                          inner join (select pk_inout_plan,pk_contract" +
        "                                       from yls_inout_plan_c t3" +
        "                                      inner join yls_event_type et" +
        "                                         on t3.trans_type = et.pk_event_type" +
        "                                      where et.event_code in" +
        "                                            ('10101', '10102')) ip" +
        "                             on t2.pk_inout_plan = ip.pk_inout_plan" +
        "                          group by ip.pk_contract) h" +
        "                 on g.pk_contract = h.pk_contract" +
        "               left join yls_accrual_c a" +
        "                 on a.source_bill = g.pk_lease_calculator" +
        "               left join yls_accrual_c b" +
        "                 on a.source_bill = b.source_bill" +
        "                and a.month = b.month" +
        "                and b.busi_type = 11" +
        "               left join yls_accrual_c c" +
        "                 on a.source_bill = c.source_bill" +
        "                and a.month = c.month" +
        "                and c.busi_type = 12" +
        "               left join yls_accrual_c e" +
        "                 on a.source_bill = e.source_bill" +
        "                and a.month = e.month" +
        "                and e.busi_type = 13" +
        "              where a.busi_type = 0" +
        "                and a.month <= h.real_pay_date" +
        "              group by g.pk_contract) x" +
        "    on x.pk_contract = f.pk_contract" +
        " inner join (select t4.pk_contract, min(t1.real_pay_date) real_pay_date" +
        "               from yls_loan_deal t1" +
        "              inner join yls_loan_plan t2" +
        "                 on t1.pk_loan_deal = t2.pk_loan_deal" +
        "              inner join yls_inout_plan_c t3" +
        "                 on t2.pk_inout_plan = t3.pk_inout_plan" +
        "              inner join yls_contract_c t4" +
        "                 on t3.pk_contract = t4.pk_contract" +
        "              group by t4.pk_contract) h" +
        "    on f.pk_contract = h.pk_contract" +
        "  left join yls_accrual_c b" +
        "    on a.source_bill = b.source_bill" +
        "   and a.month = b.month" +
        "   and b.busi_type = 11" +
        "  left join yls_accrual_c c" +
        "    on a.source_bill = c.source_bill" +
        "   and a.month = c.month" +
        "   and c.busi_type = 12" +
        "  left join yls_accrual_c e" +
        "    on a.source_bill = e.source_bill" +
        "   and a.month = e.month" +
        "   and e.busi_type = 13" +
        " where a.busi_type = 0 and f.cont_status != 8" +
        "        )")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer","handler"})
public class AccrualForAccruedPageRefVO {
    private static final long serialVersionUID = 334579052232820078L;

    /**
     * 主键
     */
    @Id
    public String pkAccrual;

    /**
     * 来源单据
     */
    public String sourceBill;

    /**
     * 计提月份
     */
    public String month;

    /**
     * 上次计提月份
     */
    public String mon;

    /**
     * 利息计提
     */
    public BigDecimal inter;
    /**
     * 手续费计提
     */
    public BigDecimal srv;
    /**
     * 其他收入计提
     */
    public BigDecimal pri;
    /**
     * 其他支出计提
     */
    public BigDecimal bus;

    /**
     * 客户
     */
    @ManyToOne()
    @JoinColumn(name="pkCustomer")
    public CustomerDTO pkCustomer;
    /**
     * 合同
     */
    @ManyToOne()
    @JoinColumn(name="pkContract")
    public ContractCRefVO pkContract;

    /**
     * 资产五级分类
     */
    public Short assetsClassify;

    /**
     * 币种
     */
    @ManyToOne()
    @JoinColumn(name="pkCurrtype")
    public CurrtypeVO pkCurrtype;
    /**
     * 汇率
     */
    public BigDecimal exchgRate;
    /**
     * 核算主体
     */
    public String pkGlorgbook;
//    @ManyToOne()
//    @JoinColumn(name="pkGlorgbook")
//    public GlorgbookRefVO pkGlorgbook;

    /**
     * 实际付款日期
     */
    public String realPayDate;

    /**
     * 起租流程
     */
    public Short leaseFlow;

    /**
     * 子合同主键
     */

    public String pkLesseeProtocol;

    /**
     * 计提标识
     */
    public Short ifBegin;

    /**
     * 约定起租日
     */
    public String appointRentDate;

    /**
     * 实际本月计提利息(用来解决月末计提)
     */
    public BigDecimal interActual;

    @Transient
    public String pk;

    @Transient
    public String name;

    @Transient
    public String code;

    public String getName(){
        return null;
    }

    public String getCode(){
        return null;
    }

    public void setName(String name) {
        this.name = null;
    }

    public void setCode(String code) {
        this.code = null;
    }

    public String getPk() {
        return pkAccrual;
    }

    public void setPk(String pk) {
        this.pkAccrual = pk;
    }

    /**
     * 实际本月计提利息(用来解决月末计提)get方法
     */
    public BigDecimal getInterActual() {
        return interActual;
    }
    /**
     * 实际本月计提利息(用来解决月末计提) set方法
     */
    public void setInterActual(BigDecimal interActual) {
        this.interActual = interActual;
    }

    /**
     * 约定起租日get方法
     */
    public String getAppointRentDate() {
        return appointRentDate;
    }

    /**
     * 约定起租日set方法
     */
    public void setAppointRentDate(String appointRentDate) {
        this.appointRentDate = appointRentDate;
    }

    public String getPkAccrual() {
        return pkAccrual;
    }

    public void setPkAccrual(String pkAccrual) {
        this.pkAccrual = pkAccrual;
    }

    public String getSourceBill() {
        return sourceBill;
    }

    public void setSourceBill(String sourceBill) {
        this.sourceBill = sourceBill;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getInter() {
        return inter;
    }

    public void setInter(BigDecimal inter) {
        this.inter = inter;
    }

    public BigDecimal getSrv() {
        return srv;
    }

    public void setSrv(BigDecimal srv) {
        this.srv = srv;
    }

    public BigDecimal getPri() {
        return pri;
    }

    public void setPri(BigDecimal pri) {
        this.pri = pri;
    }

    public BigDecimal getBus() {
        return bus;
    }

    public void setBus(BigDecimal bus) {
        this.bus = bus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public CustomerDTO getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(CustomerDTO pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public ContractCRefVO getPkContract() {
        return pkContract;
    }

    public void setPkContract(ContractCRefVO pkContract) {
        this.pkContract = pkContract;
    }

    public Short getAssetsClassify() {
        return assetsClassify;
    }

    public void setAssetsClassify(Short assetsClassify) {
        this.assetsClassify = assetsClassify;
    }

    public CurrtypeVO getPkCurrtype() {
        return pkCurrtype;
    }

    public void setPkCurrtype(CurrtypeVO pkCurrtype) {
        this.pkCurrtype = pkCurrtype;
    }

    public BigDecimal getExchgRate() {
        return exchgRate;
    }

    public void setExchgRate(BigDecimal exchgRate) {
        this.exchgRate = exchgRate;
    }

    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook;
    }

    public String getRealPayDate() {
        return realPayDate;
    }

    public void setRealPayDate(String realPayDate) {
        this.realPayDate = realPayDate;
    }

    public Short getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Short leaseFlow) {
        this.leaseFlow = leaseFlow;
    }

    public String getPkLesseeProtocol() {
        return pkLesseeProtocol;
    }

    public void setPkLesseeProtocol(String pkLesseeProtocol) {
        this.pkLesseeProtocol = pkLesseeProtocol;
    }

    public Short getIfBegin() {
        return ifBegin;
    }

    public void setIfBegin(Short ifBegin) {
        this.ifBegin = ifBegin;
    }
}
