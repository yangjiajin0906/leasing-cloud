package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.foundation.vo.AreaclVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_contract")
public class CbContractVO extends BaseVO {
    @Id
    private String pkContract;

    /**
     * 合同状态
     */
    private Integer contStatus;

    /**
     * 业务名称
     */
    private Integer businessName;

    /**
     * 集团名称
     */
    private String groupName;

    /**
     * 合同编号
     */
    private String contCode;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户身份证号
     */
    private String identityNo;

    /**
     * 起租流程
     */
    private Integer leaseFlow;

    /**
     * 合同签订日
     */
    private String contSignedDate;

    /**
     * 合同投放日
     */
    private String contLoan;

    /**
     * 合同实际起租日
     */
    private String leaseDateFact;

    /**
     * 合同结束日期
     */
    private String contEndDate;

    /**
     * 还款频率
     */
    private Integer refundFrequency;

    /**
     * 还款结构
     */
    private Integer refundStructure;

    /**
     * 租金总计
     */
    private BigDecimal leaseCashSum;

    /**
     * 本金金额
     */
    private BigDecimal corpusAmount;

    /**
     * 利息金额
     */
    private BigDecimal interestAmount;

    /**
     * 租赁方式
     */
    private Integer leaseType;

    /**
     * 市场IRR
     */
    private BigDecimal marketIrr;

    /**
     * 会计IRR
     */
    private BigDecimal financeIrr;

    /**
     * 客户所属省
     */
    private AreaclVO customerProvince;

    /**
     * 客户所属城市
     */
    private AreaclVO customerCity;

    /**
     * 客户所属地区
     */
    private AreaclVO customerRegion;

    /**
     * 收票类型
     */
    private Integer ticketType;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商银行账号
     */
    private String supplierBankAccount;

    /**
     * 出租人名称
     */
    private String lessorName;

    /**
     * 租金回收方式
     */
    private Integer leaseRecycling;

    /**
     * 收款银行账号
     */
    private String gatherBankAccount;

    /**
     * 收款银行开户行
     */
    private String gatherOpenBank;

    /**
     * 是否有平台方保证金增信
     */
    private Integer ifDepositCredit;

    /**
     * 合作平台方
     */
    private String cooperationPlatform;

    /**
     * 保证金额度/保证金比例
     */
    private BigDecimal depositRatio;

    /**
     * 运营商套餐金额
     */
    private BigDecimal operatorAmount;

    /**
     * 运营商套餐期限
     */
    private Integer operatorDeadline;

    /**
     * 终端名称
     */
    private String terminalName;

    /**
     * 终端型号
     */
    private String terminalType;

    /**
     * 附件地址
     */
    private String docUrl;

    /**
     * 来源系统
     */
    private String pkSystem;

    /**
     * 资产五级分类
     */
    private Integer assetsClassify;

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
