package com.leasing.calculate.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 合同Ref VO
 * @date:2019/9/25
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_contract")
public class ContractRefVO {
        /**
         * 合同主键
         */
        @Id
        public String pk_contract;
        /**
         * 项目主键
         */
        public String pk_project;

        //public ProjectInfoRefVO project;

//        public ProjectInfoRefVO getProject() {
//            if (project == null && getPk_project() != null) {
//                project = (ProjectInfoRefVO)QuerySplitRefUtil.getUtil().createRefVO(ProjectInfoRefVO.class, getPk_project());
//            }
//            return project;
//        }
//
//        public void setProject(ProjectInfoRefVO project) {
//            this.project = project;
//            if (project != null) {
//                this.pk_project = project.getPk();
//            }
//        }
        /**
         * 项目编号
         */
        //public String prj_code;
        /**
         * 项目名称
         */
        //public String prj_name;
//        /**
//         * 项目批次
//         */
//        public String prj_batch;
        /**
         * 回租类别
         */
        public String leaseback_category;
        /**
         * 是否有共同承租人
         */
        public String if_together_lessee;
        /**
         * 是否担保
         */
        public String if_guarantee;
        /**
         * 担保方式
         */
        public String guarantee_way;
        /**
         * 投放金额
         */
        public String loan_cash;
        /**
         * 合同编号
         */
        public String cont_code;
        /**
         * 合同名称
         */
        public String cont_name;
        /**
         * 起租日期
         */
        @Column(name="lease_date_fact")
        public String start_date;
        /**
         * 合同年份
         */
        public String cont_year;
        /**
         * 合同号
         */
        public String cont_number;
        /**
         * 合同签订日
         */
        public String cont_signed_date;
        /**
         * 设备金额
         */
        public String machine_amount;
        /**
         * 合同金额
         */
        public String cont_amount;
        /**
         * 合同截止日期
         */
        public String cont_end_date;
        /**
         * 合同批次
         */
        public String cont_batch;
        /**
         * 合同状态
         */
        public String cont_status;
        /**
         * 合同生成规则
         */
        public String pk_contract_rule;
        /**
         * 出租人客户主键
         */
        public String pk_customer_lessor;
//        /**
//         * 出租人名称
//         */
//        public String lessor_name;
//        /**
//         * 出租人编号
//         */
//        public String lessor_code;
//        /**
//         * 出租人法定代表人
//         */
//        public String lessor_legal;
//        /**
//         * 出租人地址
//         */
//        public String lessor_address;
//        /**
//         * 出租人邮编
//         */
//        public String lessor_postal_code;
//        /**
//         * 出租人电话
//         */
//        public String lessor_phone;
//        /**
//         * 出租人传真
//         */
//        public String lessor_fax;
//        /**
//         * 出租人联系人
//         */
//        public String pk_lessor_contact;
//        /**
//         * 出租人联系人名称
//         */
//        public String lessor_contact_name;
//        /**
//         * 出租人邮箱
//         */
//        public String lessor_email;
//        /**
//         * 出租人纳税人识别号
//         */
//        public String lessor_taxpayer_num;
        /**
         * 出租人纳税人识别号
         */
        public String pk_customer_lessee;
//        /**
//         * 承租人编号
//         */
//        public String lessee_code;
//        /**
//         * 承租人名称
//         */
//        public String lessee_name;
//        /**
//         * 承租人法定代表人
//         */
//        public String lessee_legal;
//        /**
//         * 承租人地址
//         */
//        public String lessee_address;
//        /**
//         * 承租人邮编
//         */
//        public String lessee_postal_code;
//        /**
//         * 承租人电话
//         */
//        public String lessee_phone;
//        /**
//         * 承租人传真
//         */
//        public String lessee_fax;
//        /**
//         * 承租人联系人
//         */
//        public String pk_lessee_contact;
//        /**
//         * 承租人联系人名称
//         */
//        public String lessee_contact_name;
//        /**
//         * 承租人邮箱
//         */
//        public String lessee_emal;
        /**
         * 交货地点
         */
        public String delivery_address;
        /**
         * 安装使用地点
         */
        public String install_use_address;
        /**
         * 交货时间
         */
        public String delivery_time;
        /**
         * 报价测算主键
         */
        public String pk_lease_calculator;
        /**
         * 供应商框架协议
         */
        //public String pk_framework_deal;
        /**
         * 限额结果
         */
        public String limit_result;
        /**
         * 限额方案主键
         */
        public String pk_limit_plan;
        /**
         * 调息类别
         */
        public String adjust_type;
        /**
         * 调息时点
         */
        public String adjust_time;
        /**
         * 调息方式
         */
        public String adjust_method;
        /**
         * 开票方式
         */
        public Short invoice_method;
        /**
         * 开票条件
         */
        public String invoice_condition;
        /**
         * 开票提前天数
         */
        public String invoice_advance_days;
        /**
         * 是否调息
         */
        public String if_adjust;
        /**
         * 合同起始日期
         */
        public String cont_start_date;
        /**
         * 项目经理
         */
        public String pk_prj_manager;
        /**
         * 部门主键
         */
        public String pk_dept;
        /**
         * 授权人
         */
        public String pk_grantor;
        /**
         * 授权日期
         */
        public String grant_date;
        /**
         * 授权时间
         */
        public String grant_time;

        /**
         * 客户名称
         */
        //public String customer_name;

        /**
         * 租赁方式
         */
        //public Short lease_method;

        /**
         *  税种
         */
        @Column(name="tax_type")
        public Short tax_mod;

        /**
         *  本金是否开票
         */
        //public Short if_corpus_tickets;

        /**
         *  类型：1、协议，0、合同
         */
        @Column(name="cont_type")
        public Short tp;

        /**
         * add by jiaoshy
         * 咨询费主键
         * @return
         *
         */
        public String pk_lease_contract;





}