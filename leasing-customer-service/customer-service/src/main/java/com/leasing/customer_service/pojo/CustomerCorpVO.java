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
@Getter
@Setter
@NoArgsConstructor
@SecondaryTable(name = "yls_customer_corp", pkJoinColumns =
        {@PrimaryKeyJoinColumn(name = "pk_customer", referencedColumnName = "pk_customer")})
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
    @JoinColumn(table = "yls_customer_corp")
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
    @Where(clause = "customer_type = 0")
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
    public String operate_time;


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
}