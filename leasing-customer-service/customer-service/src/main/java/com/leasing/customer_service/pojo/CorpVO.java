package com.leasing.customer_service.pojo;

import com.leasing.customer_service.utils.BaseQuery;
import com.leasing.customer_service.utils.MatchType;
import com.leasing.customer_service.utils.QueryCondition;
import com.sun.istack.NotNull;
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
public class CorpVO extends BaseQuery<CustomerCorpVO> implements Serializable {

    /**
     * 企业客户主键
     */


    public String pk_customer_corp;

    @Id
    @Column(name = "pk_customer")
    public String pkCustomer;

    /**
     * 版本号
     */
    public Integer version_num_corp;


    /**
     * 客户性质
     */
    @ManyToOne
    @JoinColumn(name="customer_property",referencedColumnName="pk_parameter")
    public ParmsRefVO customer_property;


    /**
     * 经济性质
     */
    @ManyToOne
    @JoinColumn(name="economic_type",referencedColumnName="pk_parameter")
    public ParmsRefVO economic_type;


    /**
     * 注册地址
     */
    public String reg_address;


    /**
     * 区域
     */
    @ManyToOne
    @JoinColumn(name="region",referencedColumnName="pk_parameter")
    public ParmsRefVO region;


    /**
     * 行业类别
     */
    @ManyToOne
    @JoinColumn(name="industry_type",referencedColumnName="pk_parameter")
    public ParmsRefVO industry_type;


    /**
     * 二级行业类别
     */
    @ManyToOne
    @JoinColumn(name="industry_type1",referencedColumnName="pk_parameter")
    public ParmsRefVO industry_type1;


    /**
     * 行业门类
     */
    @ManyToOne
    @JoinColumn(name="industry",referencedColumnName="pk_parameter")
    public ParmsRefVO industry;


    /**
     * 行业门类（大类）
     */
    @ManyToOne
    @JoinColumn(name="industry1",referencedColumnName="pk_parameter")
    public ParmsRefVO industry1;


    /**
     * 行业门类（中类）
     */
    @ManyToOne
    @JoinColumn(name="industry2",referencedColumnName="pk_parameter")
    public ParmsRefVO industry2;


    /**
     * 行业门类（小类）
     */
    @ManyToOne
    @JoinColumn(name="industry3",referencedColumnName="pk_parameter")
    public ParmsRefVO industry3;


    /**
     * 从业人数
     */
    public Integer employee_num;


    /**
     * 资产总额
     */
    public BigDecimal assets_total;


    /**
     * 营业收入
     */
    public BigDecimal operating_income;


    /**
     * 学校等级
     */
    public Short school_grade;


    /**
     * 医院等级
     */
    public Short hospital_grade;


    /**
     * 企业规模（内部管理）
     */
    public Short enter_scale_inner;


    /**
     * 企业规模（人行）
     */
    public Short enter_scale_pbc;


    /**
     * 企业规模（六部委）
     */
    public Short enter_scale_6m;


    /**
     * 有效期:自
     */
    public String start_date_identity;


    /**
     * 至
     */
    public String end_date_identity;


    /**
     * 最新年检日期
     */
    public String recent_inspect_date;


    /**
     * 贷款卡号
     */
    public String loan_card_no;


    /**
     * 贷款卡是否有效
     */
    public Short if_valid_lc;


    /**
     * 贷款卡最新年审时间
     */
    public String recent_inspect_date_lc;


    /**
     * 贷款卡最新年审结果
     */
    public Short recent_inspect_result_lc;


    /**
     * 营业执照号码
     */
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
    public String legal_representative;

    /**
     * 实际控制人(文本类型)
     */
    public String actual_controller;


    /**
     * 注册资本币种
     */
    @ManyToOne
    @JoinColumn(name="capital_cur",referencedColumnName="pk_currtype")
    public CurrtypeRefVO capital_cur;


    /**
     * 注册资本
     */
    public BigDecimal capital;


    /**
     * 实收资本币种
     */
    @ManyToOne
    @JoinColumn(name="capital_cur_paidin",referencedColumnName="pk_currtype")
    public CurrtypeRefVO capital_cur_paidin;


    /**
     * 实收资本
     */
    public BigDecimal capital_paidin;


    /**
     * 营业执照登记日
     */
    public String start_date_license;


    /**
     * 营业执照到期日
     */
    public String end_date_license;


    /**
     * 营业执照最新年审日
     */
    public String recent_inspect_date_license;


    /**
     * 成立日期
     */
    public String establish_date;


    /**
     * 经营范围（限200个汉字）
     */
    public String bussiness_scope;


    /**
     * 主营业务（限200个汉字）
     */
    public String primary_bussiness;


    /**
     * 税务登记证号（国税）
     */
    public String national_tax;


    /**
     * 税务登记证号（地税）
     */
    public String land_tax;


    /**
     * 是否集团公司（母公司）
     */
    public Short if_group_company;


    /**
     * 有无进出口经营
     */
    public Short if_import_export;


    /**
     * 是否上市公司
     */
    public Short if_listed_company;


    /**
     * 是否政府融资背景
     */
    public Short if_gov_platform;


    /**
     * 是否人民银行认定平台
     */
    public Short if_pbc_platform;


    /**
     * 是否银监会认定平台
     */
    public Short if_cbrc_platform;

    /**
     * 是否江苏省银监局平台
     */
    public Short if_jscbrc_platform;


    /**
     * 是否环保行业企业
     */
    public Short if_environmental_corp;


    /**
     * 是否重点监测客户
     */
    public Short if_important_corp;


    /**
     * 是否科技型企业
     */
    public Short if_technical_corp;


    /**
     * 所在国家（地区）
     */
    @ManyToOne
    @JoinColumn(name="country",referencedColumnName="pk_parameter")
    public ParmsRefVO country;


    /**
     * 注册地隶属
     */
    public Short reg_address_membership;


    /**
     * 地区（省）
     */
    @ManyToOne
    @JoinColumn(name="province",referencedColumnName="pk_areacl")
    public AreaclRefVO province;


    /**
     * 地区（市）
     */
    @ManyToOne
    @JoinColumn(name="city",referencedColumnName="pk_areacl")
    public AreaclRefVO city;
//
//    /**
//     * 地区（县/区）
//     */
    @ManyToOne
    @JoinColumn(name="district",referencedColumnName="pk_areacl")
    public AreaclRefVO district;


    /**
     * 实际告知地址
     */
    public String inform_address;


    /**
     * 实际告知地址邮编
     */
    public String inform_address_zip;


    /**
     * 通讯地址
     */
    public String comm_address;


    /**
     * 通讯地址邮编
     */
    public String comm_address_zip;


    /**
     * 实际办公地址
     */
    public String office_address;


    /**
     * 实际办公地址邮编
     */
    public String office_address_zip;


    /**
     * 实际办公地所有权
     */
    public Short office_ownership;


    /**
     * 备注
     */
    public String remarks;


    /**
     * 客户洗钱风险评级
     */
    public Short enter_rating;


    /**
     * 公司网址
     */
    public String company_website;


    /**
     * 传真
     */
    public String fax;


    /**
     * 公司邮箱
     */
    public String company_mailbox;


    /**
     * 科技型企业类型
     */
    public Short technical_type;

    /**
     * 单位客户ts
     */
    @Column(name = "ts")
    public Date ts_c;

    /**
     * 电话
     */
    public String phone;


    /**
     * 客户号
     */
    public String customer_no;


    /**
     * 客户简称
     */
    public String customer_short;


    /**
     * 客户类型
     */
    public String cusotmer_class;

    /**
     * 客户类型
     */
//    public ParameterRefVO cusotmer_class_temp;


    /**
     * 隶属
     */
    public Short subjection;


    /**
     * 称号
     */
    public Short title;


    /**
     * 财务相关
     */
    public String finance_related;


    /**
     * 设备相关
     */
    public String equipment_related;


    /**
     * 其他部门
     */
    public String other_dept;


    /**
     * 政府相关
     */
    public String government_related;


    /**
     * 政府财政相关
     */
    public String govern_finance_related;


    /**
     * 政府其他部门
     */
    public String govern_other_sectors;

    /**
     * 是否财政
     */
    public Short if_finance;

    /**
     * 快递公司
     */
    @ManyToOne
    @JoinColumn(name="express_company",referencedColumnName="pk_parameter")
    public ParmsRefVO express_company;

    /**
     * 开票说明
     */
    public String invoiceExplain;

    /**
     * 开票说明
     */
//    public ParameterRefVO invoice_explain;

//    public Boolean boolean_one;


    /**
     * 注册登记号类型   用于征信接口  ADD by jiaoshy  2017-04-05
     */
    public Short reg_number_type;


    /**
     * 注册登记号码   用于征信接口    ADD by jiaoshy   2017-04-05
     */
    public String reg_number;

    @Override
    public Specification<CustomerCorpVO> toSpec() {
        return super.toSpecWithAnd();
    }
}