package com.leasing.customer.dao.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_medical_qualify")
public class CustMedicalQualifyDO extends BaseBusinessDO {

    @Id
    private String pkMedicalQualify;

    private BigDecimal regCapital;

    private String medicalNo;

    private Short medicalNumber;

    private BigDecimal revenueTax;

    private String localProfile;

    private String memo;

    private String buildDate;

    private String regTitle;

    private String pkCustomer;

    private String regJob;

    private String regName;

    private String regRanking;

    private BigDecimal publicBudget;

    private BigDecimal govDisposableFinance;

    private String regNumber;

    private String regionMemo;

    private String noaccodrReason;

    private Short ifNegative;

    private BigDecimal generalTransfer;

    private String negativeReason;

    private Short regionNumber;

    private BigDecimal superiorSubsidy;

    private Short ifAccord;

    private String bornDate;

    private BigDecimal govBalance;

    private String checkDate;

    private BigDecimal regionGdp;

    private Short medicalType;

    private String checkTime;

    private Short regEducation;

    private BigDecimal specialTransfer;

    private String medicalProfile;

    private BigDecimal tenantLiabilityRatio;

    private String nativePlace;

    private String improperReason;

    private String sourceBill;

    private String region;

    private String pkChecker;

    private String localRanking;

    @Override
    public String getPk() {
        return this.pkMedicalQualify;
    }

    @Override
    public void setPk(String pk) {
        this.pkMedicalQualify = pk;
    }
}