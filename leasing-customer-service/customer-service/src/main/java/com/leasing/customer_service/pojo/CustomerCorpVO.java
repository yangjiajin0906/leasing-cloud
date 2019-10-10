package com.leasing.customer_service.pojo;

import com.leasing.customer_service.utils.BaseQuery;
import com.leasing.customer_service.utils.MatchType;
import com.leasing.customer_service.utils.QueryCondition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer")
@SecondaryTable(name = "yls_customer_corp", pkJoinColumns =
        {@PrimaryKeyJoinColumn(name = "pk_customer", referencedColumnName = "pk_customer")})
@Where(clause = "customer_type = 0 and if_new = 0")
public class CustomerCorpVO extends BaseQuery<CustomerCorpVO> implements Serializable {

    /**
     * 企业客户主键
     */

//    @Column(name = "yls_customer_corp", table = "yls_customer_corp")
//    public String pk_customer_corp;

    @Id
    @Column(name = "pk_customer")
    public String pkCustomer;

    /**
     * 版本号
     */
    @Column(table = "yls_customer_corp")
    public Integer version_num_corp;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customer_property",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO customer_property;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customer_property_in",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO customer_property_in;

    /**
     * 经济性质
     */
    @ManyToOne
    @JoinColumn(name="economic_type",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO economic_type;


    /**
     * 注册地址
     */
    @Column(table = "yls_customer_corp")
    public String reg_address;


    /**
     * 区域
     */
    @ManyToOne
    @JoinColumn(name="region",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO region;


    /**
     * 行业类别
     */
    @ManyToOne
    @JoinColumn(name="industry_type",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry_type;


    /**
     * 二级行业类别
     */
    @ManyToOne
    @JoinColumn(name="industry_type1",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry_type1;


    /**
     * 行业门类
     */
    @ManyToOne
    @JoinColumn(name="industry",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry;


    /**
     * 行业门类（大类）
     */
    @ManyToOne
    @JoinColumn(name="industry1",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry1;


    /**
     * 行业门类（中类）
     */
    @ManyToOne
    @JoinColumn(name="industry2",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry2;


    /**
     * 行业门类（小类）
     */
    @ManyToOne
    @JoinColumn(name="industry3",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO industry3;


    /**
     * 从业人数
     */
    @Column(table = "yls_customer_corp")
    public Integer employee_num;


    /**
     * 资产总额
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal assets_total;


    /**
     * 营业收入
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal operating_income;


    /**
     * 学校等级
     */
    @Column(table = "yls_customer_corp")
    public Short school_grade;


    /**
     * 医院等级
     */
    @Column(table = "yls_customer_corp")
    public Short hospital_grade;


    /**
     * 企业规模（内部管理）
     */
    @Column(table = "yls_customer_corp")
    public Short enter_scale_inner;


    /**
     * 企业规模（人行）
     */
    @Column(table = "yls_customer_corp")
    public Short enter_scale_pbc;


    /**
     * 企业规模（六部委）
     */
    @Column(table = "yls_customer_corp")
    public Short enter_scale_6m;


    /**
     * 有效期:自
     */
    @Column(table = "yls_customer_corp")
    public String start_date_identity;


    /**
     * 至
     */
    @Column(table = "yls_customer_corp")
    public String end_date_identity;


    /**
     * 最新年检日期
     */
    @Column(table = "yls_customer_corp")
    public String recent_inspect_date;


    /**
     * 贷款卡号
     */
    @Column(table = "yls_customer_corp")
    public String loan_card_no;


    /**
     * 贷款卡是否有效
     */
    @Column(table = "yls_customer_corp")
    public Short if_valid_lc;


    /**
     * 贷款卡最新年审时间
     */
    @Column(table = "yls_customer_corp")
    public String recent_inspect_date_lc;


    /**
     * 贷款卡最新年审结果
     */
    @Column(table = "yls_customer_corp")
    public Short recent_inspect_result_lc;


    /**
     * 营业执照号码
     */
    @Column(table = "yls_customer_corp")
    public String license_no;

    /**
     * 法定代表人编号
     */
//    public CustomerPersonRefVO pk_customer_person;

    /**
     * 实际控制人
     */
//    public CustomerRefVO actual_control;

    /**
     * 法定代表人(文本类型)
     */
    @Column(table = "yls_customer_corp")
    public String legal_representative;

    /**
     * 实际控制人(文本类型)
     */
    @Column(table = "yls_customer_corp")
    public String actual_controller;


    /**
     * 注册资本币种
     */
    @ManyToOne
    @JoinColumn(name = "capital_cur", referencedColumnName = "pk_currtype", table = "yls_customer_corp")
    public CurrtypeRefVO capital_cur;


    /**
     * 注册资本
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal capital;


    /**
     * 实收资本币种
     */

    @ManyToOne
    @JoinColumn(name = "capital_cur_paidin", referencedColumnName = "pk_currtype", table = "yls_customer_corp")
    public CurrtypeRefVO capital_cur_paidin;


    /**
     * 实收资本
     */
    @Column(table = "yls_customer_corp")
    public BigDecimal capital_paidin;


    /**
     * 营业执照登记日
     */
    @Column(table = "yls_customer_corp")
    public String start_date_license;


    /**
     * 营业执照到期日
     */
    @Column(table = "yls_customer_corp")
    public String end_date_license;


    /**
     * 营业执照最新年审日
     */
    @Column(table = "yls_customer_corp")
    public String recent_inspect_date_license;


    /**
     * 成立日期
     */
    @Column(table = "yls_customer_corp")
    public String establish_date;


    /**
     * 经营范围（限200个汉字）
     */
    @Column(table = "yls_customer_corp")
    public String bussiness_scope;


    /**
     * 主营业务（限200个汉字）
     */
    @Column(table = "yls_customer_corp")
    public String primary_bussiness;


    /**
     * 税务登记证号（国税）
     */
    @Column(table = "yls_customer_corp")
    public String national_tax;


    /**
     * 税务登记证号（地税）
     */
    @Column(table = "yls_customer_corp")
    public String land_tax;


    /**
     * 是否集团公司（母公司）
     */
    @Column(table = "yls_customer_corp")
    public Short if_group_company;


    /**
     * 有无进出口经营
     */
    @Column(table = "yls_customer_corp")
    public Short if_import_export;


    /**
     * 是否上市公司
     */
    @Column(table = "yls_customer_corp")
    public Short if_listed_company;


    /**
     * 是否政府融资背景
     */
    @Column(table = "yls_customer_corp")
    public Short if_gov_platform;


    /**
     * 是否人民银行认定平台
     */
    @Column(table = "yls_customer_corp")
    public Short if_pbc_platform;


    /**
     * 是否银监会认定平台
     */
    @Column(table = "yls_customer_corp")
    public Short if_cbrc_platform;

    /**
     * 是否江苏省银监局平台
     */
    @Column(table = "yls_customer_corp")
    public Short if_jscbrc_platform;


    /**
     * 是否环保行业企业
     */
    @Column(table = "yls_customer_corp")
    public Short if_environmental_corp;


    /**
     * 是否重点监测客户
     */
    @Column(table = "yls_customer_corp")
    public Short if_important_corp;


    /**
     * 是否科技型企业
     */
    @Column(table = "yls_customer_corp")
    public Short if_technical_corp;


    /**
     * 所在国家（地区）
     */
    @ManyToOne
    @JoinColumn(name = "country", referencedColumnName = "pk_parameter", table = "yls_customer_corp")
    public ParmsRefVO country;


    /**
     * 注册地隶属
     */
    @Column(table = "yls_customer_corp")
    public Short reg_address_membership;


    /**
     * 地区（省）
     */
    @ManyToOne
    @JoinColumn(name = "province", referencedColumnName = "pk_areacl", table = "yls_customer_corp")
    public AreaclRefVO province;


    /**
     * 地区（市）
     */
    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "pk_areacl", table = "yls_customer_corp")
    public AreaclRefVO city;

    /**
     * 地区（县/区）
     */
    @ManyToOne
    @JoinColumn(name = "district", referencedColumnName = "pk_areacl", table = "yls_customer_corp")
    public AreaclRefVO district;


    /**
     * 实际告知地址
     */
    @Column(table = "yls_customer_corp")
    public String inform_address;


    /**
     * 实际告知地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String inform_address_zip;


    /**
     * 通讯地址
     */
    @Column(table = "yls_customer_corp")
    public String comm_address;


    /**
     * 通讯地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String comm_address_zip;


    /**
     * 实际办公地址
     */
    @Column(table = "yls_customer_corp")
    public String office_address;


    /**
     * 实际办公地址邮编
     */
    @Column(table = "yls_customer_corp")
    public String office_address_zip;


    /**
     * 实际办公地所有权
     */
    @Column(table = "yls_customer_corp")
    public Short office_ownership;


    /**
     * 备注
     */
    @Column(table = "yls_customer_corp")
    public String remarks;


    /**
     * 客户洗钱风险评级
     */
    @Column(table = "yls_customer_corp")
    public Short enter_rating;


    /**
     * 公司网址
     */
    @Column(table = "yls_customer_corp")
    public String company_website;


    /**
     * 传真
     */
    @Column(table = "yls_customer_corp")
    public String fax;


    /**
     * 公司邮箱
     */
    @Column(table = "yls_customer_corp")
    public String company_mailbox;


    /**
     * 科技型企业类型
     */
    @Column(table = "yls_customer_corp")
    public Short technical_type;

    /**
     * 单位客户ts
     */
    @Column(name = "ts", table = "yls_customer_corp")
    public Date ts_c;

    /**
     * 电话
     */
    @Column(table = "yls_customer_corp")
    public String phone;


    /**
     * 客户号
     */
    @Column(table = "yls_customer_corp")
    public String customer_no;


    /**
     * 客户简称
     */

    @Column(table = "yls_customer_corp")
    public String customer_short;


    /**
     * 客户类型
     */
    @Column(table = "yls_customer_corp")
    public String cusotmer_class;

    /**
     * 客户类型
     */
//    public ParameterRefVO cusotmer_class_temp;


    /**
     * 隶属
     */
    @Column(table = "yls_customer_corp")
    public Short subjection;


    /**
     * 称号
     */
    @Column(table = "yls_customer_corp")
    public Short title;


    /**
     * 财务相关
     */
    @Column(table = "yls_customer_corp")
    public String finance_related;


    /**
     * 设备相关
     */
    @Column(table = "yls_customer_corp")
    public String equipment_related;


    /**
     * 其他部门
     */
    @Column(table = "yls_customer_corp")
    public String other_dept;


    /**
     * 政府相关
     */
    @Column(table = "yls_customer_corp")
    public String government_related;


    /**
     * 政府财政相关
     */
    @Column(table = "yls_customer_corp")
    public String govern_finance_related;


    /**
     * 政府其他部门
     */
    @Column(table = "yls_customer_corp")
    public String govern_other_sectors;

    /**
     * 是否财政
     */
    @Column(table = "yls_customer_corp")
    public Short if_finance;

    /**
     * 快递公司
     */
    @ManyToOne
    @JoinColumn(name="express_company",referencedColumnName="pk_parameter",table = "yls_customer_corp")
    public ParmsRefVO express_company;

    /**
     * 开票说明
     */
    @Column(table = "yls_customer_corp")
    public String invoiceExplain;

    /**
     * 开票说明
     */
//    public ParameterRefVO invoice_explain;

//    public Boolean boolean_one;


    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    @Column(table = "yls_customer_corp")
    public Short reg_number_type;


    /**
     * 注册登记号码   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    @Column(table = "yls_customer_corp")
    public String reg_number;


    /**
     * 版本号
     */

    public Integer versionNum;


    /**
     * 客户类别
     */
    @QueryCondition(func = MatchType.equal)
//    @Column(table = "yls_customer")

    public Short customerType;


    /**
     * 客户编号
     */
    @QueryCondition(func = MatchType.equal)
//    @Column(table = "yls_customer")
    public String customerCode;


    /**
     * 客户名称
     */
    @QueryCondition(func = MatchType.like)
    @Column(name = "customer_name")
    public String customerName;


    /**
     * 客户英文名
     */
    public String customer_eng_name;


    /**
     * 证件类型
     */
    public Short identity_type;


    /**
     * 证件号码
     */
    public String identity_no;


//    /**
//     * 客户经理
//     */
//    @Column(table = "yls_customer")
//    public UserRefVO pk_prj_manager;

    /**
     * 部门名称
     */
//    public DeptdocRefVO pk_dept;

    /**
     * 客户状态
     */
    public Short customer_status;

    /**
     * 是否黑名单
     */
    public Short if_black_list;

    /**
     * 冻结处理方式
     */
    public Short freeze_treatment;

    /**
     * 变更状态
     */
    public Short altera_status;

    /**
     * 单据状态
     */
    public Short billstatus;


    /**
     * 最新变更人
     */
//    @Column(table = "yls_customer")
//    public UserRefVO pk_operator_lst;


    /**
     * 最新变更日期
     */
    public String operate_date_lst;


    /**
     * 最新变更时间
     */
    public String operate_time_lst;


    /**
     * 记账人
     */
//    @Column(table = "yls_customer")
//    public UserRefVO pk_operator;

    /**
     * 记账日期
     */
    public String operate_date;


    /**
     * 记账时间
     */
    @Column(name = "operate_time")
    public String operateTime;


    /**
     * 复核人
     */
//    @Column(table = "yls_customer")
//    public UserRefVO pk_checker;

    /**
     * 复核日期
     */
    public String check_date;


    /**
     * 复核时间
     */
    public String check_time;


    /**
     * 授权人
     */
//    @Column(table = "yls_customer")
//    public UserRefVO pk_grantor;

    /**
     * 授权日期
     */
    public String grant_date;


    /**
     * 授权时间
     */
    public String grant_time;

    /**
     * 生效日期
     */
    public String effective_date;

    /**
     * 机构
     */

    @ManyToOne
    @JoinColumn(name = "pkOrg", referencedColumnName = "pk_org")
    public OrgRefVO pkOrg;

    /**
     * 机构信用代码”   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    public String org_credit_code;

    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    public Short if_warrant_cust;

    /**
     * 是否最新
     */
    @Where(clause = "if_new =0")
    public Short if_new;


    /**
     * @usage 201403聚信增加
     * @description 主数据编码
     */
    public String mdb_code;


    /**
     * 20180911 是否CRM系统推送客户
     */
    public Short if_crm_push;

    @Override
    public Specification<CustomerCorpVO> toSpec() {
        return super.toSpecWithAnd();
    }


    public String getPkCustomer() {
        return pkCustomer;
    }

    public void setPkCustomer(String pkCustomer) {
        this.pkCustomer = pkCustomer;
    }

    public Integer getVersion_num_corp() {
        return version_num_corp;
    }

    public void setVersion_num_corp(Integer version_num_corp) {
        this.version_num_corp = version_num_corp;
    }

    public ParmsRefVO getCustomer_property() {
        return customer_property;
    }

    public void setCustomer_property(ParmsRefVO customer_property) {
        this.customer_property = customer_property;
    }

    public ParmsRefVO getCustomer_property_in() {
        return customer_property_in;
    }

    public void setCustomer_property_in(ParmsRefVO customer_property_in) {
        this.customer_property_in = customer_property_in;
    }

    public ParmsRefVO getEconomic_type() {
        return economic_type;
    }

    public void setEconomic_type(ParmsRefVO economic_type) {
        this.economic_type = economic_type;
    }

    public String getReg_address() {
        return reg_address;
    }

    public void setReg_address(String reg_address) {
        this.reg_address = reg_address;
    }

    public ParmsRefVO getRegion() {
        return region;
    }

    public void setRegion(ParmsRefVO region) {
        this.region = region;
    }

    public ParmsRefVO getIndustry_type() {
        return industry_type;
    }

    public void setIndustry_type(ParmsRefVO industry_type) {
        this.industry_type = industry_type;
    }

    public ParmsRefVO getIndustry_type1() {
        return industry_type1;
    }

    public void setIndustry_type1(ParmsRefVO industry_type1) {
        this.industry_type1 = industry_type1;
    }

    public ParmsRefVO getIndustry() {
        return industry;
    }

    public void setIndustry(ParmsRefVO industry) {
        this.industry = industry;
    }

    public ParmsRefVO getIndustry1() {
        return industry1;
    }

    public void setIndustry1(ParmsRefVO industry1) {
        this.industry1 = industry1;
    }

    public ParmsRefVO getIndustry2() {
        return industry2;
    }

    public void setIndustry2(ParmsRefVO industry2) {
        this.industry2 = industry2;
    }

    public ParmsRefVO getIndustry3() {
        return industry3;
    }

    public void setIndustry3(ParmsRefVO industry3) {
        this.industry3 = industry3;
    }

    public Integer getEmployee_num() {
        return employee_num;
    }

    public void setEmployee_num(Integer employee_num) {
        this.employee_num = employee_num;
    }

    public BigDecimal getAssets_total() {
        return assets_total;
    }

    public void setAssets_total(BigDecimal assets_total) {
        this.assets_total = assets_total;
    }

    public BigDecimal getOperating_income() {
        return operating_income;
    }

    public void setOperating_income(BigDecimal operating_income) {
        this.operating_income = operating_income;
    }

    public Short getSchool_grade() {
        return school_grade;
    }

    public void setSchool_grade(Short school_grade) {
        this.school_grade = school_grade;
    }

    public Short getHospital_grade() {
        return hospital_grade;
    }

    public void setHospital_grade(Short hospital_grade) {
        this.hospital_grade = hospital_grade;
    }

    public Short getEnter_scale_inner() {
        return enter_scale_inner;
    }

    public void setEnter_scale_inner(Short enter_scale_inner) {
        this.enter_scale_inner = enter_scale_inner;
    }

    public Short getEnter_scale_pbc() {
        return enter_scale_pbc;
    }

    public void setEnter_scale_pbc(Short enter_scale_pbc) {
        this.enter_scale_pbc = enter_scale_pbc;
    }

    public Short getEnter_scale_6m() {
        return enter_scale_6m;
    }

    public void setEnter_scale_6m(Short enter_scale_6m) {
        this.enter_scale_6m = enter_scale_6m;
    }

    public String getStart_date_identity() {
        return start_date_identity;
    }

    public void setStart_date_identity(String start_date_identity) {
        this.start_date_identity = start_date_identity;
    }

    public String getEnd_date_identity() {
        return end_date_identity;
    }

    public void setEnd_date_identity(String end_date_identity) {
        this.end_date_identity = end_date_identity;
    }

    public String getRecent_inspect_date() {
        return recent_inspect_date;
    }

    public void setRecent_inspect_date(String recent_inspect_date) {
        this.recent_inspect_date = recent_inspect_date;
    }

    public String getLoan_card_no() {
        return loan_card_no;
    }

    public void setLoan_card_no(String loan_card_no) {
        this.loan_card_no = loan_card_no;
    }

    public Short getIf_valid_lc() {
        return if_valid_lc;
    }

    public void setIf_valid_lc(Short if_valid_lc) {
        this.if_valid_lc = if_valid_lc;
    }

    public String getRecent_inspect_date_lc() {
        return recent_inspect_date_lc;
    }

    public void setRecent_inspect_date_lc(String recent_inspect_date_lc) {
        this.recent_inspect_date_lc = recent_inspect_date_lc;
    }

    public Short getRecent_inspect_result_lc() {
        return recent_inspect_result_lc;
    }

    public void setRecent_inspect_result_lc(Short recent_inspect_result_lc) {
        this.recent_inspect_result_lc = recent_inspect_result_lc;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public String getLegal_representative() {
        return legal_representative;
    }

    public void setLegal_representative(String legal_representative) {
        this.legal_representative = legal_representative;
    }

    public String getActual_controller() {
        return actual_controller;
    }

    public void setActual_controller(String actual_controller) {
        this.actual_controller = actual_controller;
    }

    public CurrtypeRefVO getCapital_cur() {
        return capital_cur;
    }

    public void setCapital_cur(CurrtypeRefVO capital_cur) {
        this.capital_cur = capital_cur;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public CurrtypeRefVO getCapital_cur_paidin() {
        return capital_cur_paidin;
    }

    public void setCapital_cur_paidin(CurrtypeRefVO capital_cur_paidin) {
        this.capital_cur_paidin = capital_cur_paidin;
    }

    public BigDecimal getCapital_paidin() {
        return capital_paidin;
    }

    public void setCapital_paidin(BigDecimal capital_paidin) {
        this.capital_paidin = capital_paidin;
    }

    public String getStart_date_license() {
        return start_date_license;
    }

    public void setStart_date_license(String start_date_license) {
        this.start_date_license = start_date_license;
    }

    public String getEnd_date_license() {
        return end_date_license;
    }

    public void setEnd_date_license(String end_date_license) {
        this.end_date_license = end_date_license;
    }

    public String getRecent_inspect_date_license() {
        return recent_inspect_date_license;
    }

    public void setRecent_inspect_date_license(String recent_inspect_date_license) {
        this.recent_inspect_date_license = recent_inspect_date_license;
    }

    public String getEstablish_date() {
        return establish_date;
    }

    public void setEstablish_date(String establish_date) {
        this.establish_date = establish_date;
    }

    public String getBussiness_scope() {
        return bussiness_scope;
    }

    public void setBussiness_scope(String bussiness_scope) {
        this.bussiness_scope = bussiness_scope;
    }

    public String getPrimary_bussiness() {
        return primary_bussiness;
    }

    public void setPrimary_bussiness(String primary_bussiness) {
        this.primary_bussiness = primary_bussiness;
    }

    public String getNational_tax() {
        return national_tax;
    }

    public void setNational_tax(String national_tax) {
        this.national_tax = national_tax;
    }

    public String getLand_tax() {
        return land_tax;
    }

    public void setLand_tax(String land_tax) {
        this.land_tax = land_tax;
    }

    public Short getIf_group_company() {
        return if_group_company;
    }

    public void setIf_group_company(Short if_group_company) {
        this.if_group_company = if_group_company;
    }

    public Short getIf_import_export() {
        return if_import_export;
    }

    public void setIf_import_export(Short if_import_export) {
        this.if_import_export = if_import_export;
    }

    public Short getIf_listed_company() {
        return if_listed_company;
    }

    public void setIf_listed_company(Short if_listed_company) {
        this.if_listed_company = if_listed_company;
    }

    public Short getIf_gov_platform() {
        return if_gov_platform;
    }

    public void setIf_gov_platform(Short if_gov_platform) {
        this.if_gov_platform = if_gov_platform;
    }

    public Short getIf_pbc_platform() {
        return if_pbc_platform;
    }

    public void setIf_pbc_platform(Short if_pbc_platform) {
        this.if_pbc_platform = if_pbc_platform;
    }

    public Short getIf_cbrc_platform() {
        return if_cbrc_platform;
    }

    public void setIf_cbrc_platform(Short if_cbrc_platform) {
        this.if_cbrc_platform = if_cbrc_platform;
    }

    public Short getIf_jscbrc_platform() {
        return if_jscbrc_platform;
    }

    public void setIf_jscbrc_platform(Short if_jscbrc_platform) {
        this.if_jscbrc_platform = if_jscbrc_platform;
    }

    public Short getIf_environmental_corp() {
        return if_environmental_corp;
    }

    public void setIf_environmental_corp(Short if_environmental_corp) {
        this.if_environmental_corp = if_environmental_corp;
    }

    public Short getIf_important_corp() {
        return if_important_corp;
    }

    public void setIf_important_corp(Short if_important_corp) {
        this.if_important_corp = if_important_corp;
    }

    public Short getIf_technical_corp() {
        return if_technical_corp;
    }

    public void setIf_technical_corp(Short if_technical_corp) {
        this.if_technical_corp = if_technical_corp;
    }

    public ParmsRefVO getCountry() {
        return country;
    }

    public void setCountry(ParmsRefVO country) {
        this.country = country;
    }

    public Short getReg_address_membership() {
        return reg_address_membership;
    }

    public void setReg_address_membership(Short reg_address_membership) {
        this.reg_address_membership = reg_address_membership;
    }

    public AreaclRefVO getProvince() {
        return province;
    }

    public void setProvince(AreaclRefVO province) {
        this.province = province;
    }

    public AreaclRefVO getCity() {
        return city;
    }

    public void setCity(AreaclRefVO city) {
        this.city = city;
    }

    public AreaclRefVO getDistrict() {
        return district;
    }

    public void setDistrict(AreaclRefVO district) {
        this.district = district;
    }

    public String getInform_address() {
        return inform_address;
    }

    public void setInform_address(String inform_address) {
        this.inform_address = inform_address;
    }

    public String getInform_address_zip() {
        return inform_address_zip;
    }

    public void setInform_address_zip(String inform_address_zip) {
        this.inform_address_zip = inform_address_zip;
    }

    public String getComm_address() {
        return comm_address;
    }

    public void setComm_address(String comm_address) {
        this.comm_address = comm_address;
    }

    public String getComm_address_zip() {
        return comm_address_zip;
    }

    public void setComm_address_zip(String comm_address_zip) {
        this.comm_address_zip = comm_address_zip;
    }

    public String getOffice_address() {
        return office_address;
    }

    public void setOffice_address(String office_address) {
        this.office_address = office_address;
    }

    public String getOffice_address_zip() {
        return office_address_zip;
    }

    public void setOffice_address_zip(String office_address_zip) {
        this.office_address_zip = office_address_zip;
    }

    public Short getOffice_ownership() {
        return office_ownership;
    }

    public void setOffice_ownership(Short office_ownership) {
        this.office_ownership = office_ownership;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Short getEnter_rating() {
        return enter_rating;
    }

    public void setEnter_rating(Short enter_rating) {
        this.enter_rating = enter_rating;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompany_mailbox() {
        return company_mailbox;
    }

    public void setCompany_mailbox(String company_mailbox) {
        this.company_mailbox = company_mailbox;
    }

    public Short getTechnical_type() {
        return technical_type;
    }

    public void setTechnical_type(Short technical_type) {
        this.technical_type = technical_type;
    }

    public Date getTs_c() {
        return ts_c;
    }

    public void setTs_c(Date ts_c) {
        this.ts_c = ts_c;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomer_no() {
        return customer_no;
    }

    public void setCustomer_no(String customer_no) {
        this.customer_no = customer_no;
    }

    public String getCustomer_short() {
        return customer_short;
    }

    public void setCustomer_short(String customer_short) {
        this.customer_short = customer_short;
    }

    public String getCusotmer_class() {
        return cusotmer_class;
    }

    public void setCusotmer_class(String cusotmer_class) {
        this.cusotmer_class = cusotmer_class;
    }

    public Short getSubjection() {
        return subjection;
    }

    public void setSubjection(Short subjection) {
        this.subjection = subjection;
    }

    public Short getTitle() {
        return title;
    }

    public void setTitle(Short title) {
        this.title = title;
    }

    public String getFinance_related() {
        return finance_related;
    }

    public void setFinance_related(String finance_related) {
        this.finance_related = finance_related;
    }

    public String getEquipment_related() {
        return equipment_related;
    }

    public void setEquipment_related(String equipment_related) {
        this.equipment_related = equipment_related;
    }

    public String getOther_dept() {
        return other_dept;
    }

    public void setOther_dept(String other_dept) {
        this.other_dept = other_dept;
    }

    public String getGovernment_related() {
        return government_related;
    }

    public void setGovernment_related(String government_related) {
        this.government_related = government_related;
    }

    public String getGovern_finance_related() {
        return govern_finance_related;
    }

    public void setGovern_finance_related(String govern_finance_related) {
        this.govern_finance_related = govern_finance_related;
    }

    public String getGovern_other_sectors() {
        return govern_other_sectors;
    }

    public void setGovern_other_sectors(String govern_other_sectors) {
        this.govern_other_sectors = govern_other_sectors;
    }

    public Short getIf_finance() {
        return if_finance;
    }

    public void setIf_finance(Short if_finance) {
        this.if_finance = if_finance;
    }

    public ParmsRefVO getExpress_company() {
        return express_company;
    }

    public void setExpress_company(ParmsRefVO express_company) {
        this.express_company = express_company;
    }

    public String getInvoiceExplain() {
        return invoiceExplain;
    }

    public void setInvoiceExplain(String invoiceExplain) {
        this.invoiceExplain = invoiceExplain;
    }

    public Short getReg_number_type() {
        return reg_number_type;
    }

    public void setReg_number_type(Short reg_number_type) {
        this.reg_number_type = reg_number_type;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public Integer getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(Integer versionNum) {
        this.versionNum = versionNum;
    }

    public Short getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Short customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomer_eng_name() {
        return customer_eng_name;
    }

    public void setCustomer_eng_name(String customer_eng_name) {
        this.customer_eng_name = customer_eng_name;
    }

    public Short getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(Short identity_type) {
        this.identity_type = identity_type;
    }

    public String getIdentity_no() {
        return identity_no;
    }

    public void setIdentity_no(String identity_no) {
        this.identity_no = identity_no;
    }

    public Short getCustomer_status() {
        return customer_status;
    }

    public void setCustomer_status(Short customer_status) {
        this.customer_status = customer_status;
    }

    public Short getIf_black_list() {
        return if_black_list;
    }

    public void setIf_black_list(Short if_black_list) {
        this.if_black_list = if_black_list;
    }

    public Short getFreeze_treatment() {
        return freeze_treatment;
    }

    public void setFreeze_treatment(Short freeze_treatment) {
        this.freeze_treatment = freeze_treatment;
    }

    public Short getAltera_status() {
        return altera_status;
    }

    public void setAltera_status(Short altera_status) {
        this.altera_status = altera_status;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getOperate_date_lst() {
        return operate_date_lst;
    }

    public void setOperate_date_lst(String operate_date_lst) {
        this.operate_date_lst = operate_date_lst;
    }

    public String getOperate_time_lst() {
        return operate_time_lst;
    }

    public void setOperate_time_lst(String operate_time_lst) {
        this.operate_time_lst = operate_time_lst;
    }

    public String getOperate_date() {
        return operate_date;
    }

    public void setOperate_date(String operate_date) {
        this.operate_date = operate_date;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }

    public String getCheck_date() {
        return check_date;
    }

    public void setCheck_date(String check_date) {
        this.check_date = check_date;
    }

    public String getCheck_time() {
        return check_time;
    }

    public void setCheck_time(String check_time) {
        this.check_time = check_time;
    }

    public String getGrant_date() {
        return grant_date;
    }

    public void setGrant_date(String grant_date) {
        this.grant_date = grant_date;
    }

    public String getGrant_time() {
        return grant_time;
    }

    public void setGrant_time(String grant_time) {
        this.grant_time = grant_time;
    }

    public String getEffective_date() {
        return effective_date;
    }

    public void setEffective_date(String effective_date) {
        this.effective_date = effective_date;
    }

    public OrgRefVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgRefVO pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOrg_credit_code() {
        return org_credit_code;
    }

    public void setOrg_credit_code(String org_credit_code) {
        this.org_credit_code = org_credit_code;
    }

    public Short getIf_warrant_cust() {
        return if_warrant_cust;
    }

    public void setIf_warrant_cust(Short if_warrant_cust) {
        this.if_warrant_cust = if_warrant_cust;
    }

    public Short getIf_new() {
        return if_new;
    }

    public void setIf_new(Short if_new) {
        this.if_new = if_new;
    }

    public String getMdb_code() {
        return mdb_code;
    }

    public void setMdb_code(String mdb_code) {
        this.mdb_code = mdb_code;
    }

    public Short getIf_crm_push() {
        return if_crm_push;
    }

    public void setIf_crm_push(Short if_crm_push) {
        this.if_crm_push = if_crm_push;
    }
}