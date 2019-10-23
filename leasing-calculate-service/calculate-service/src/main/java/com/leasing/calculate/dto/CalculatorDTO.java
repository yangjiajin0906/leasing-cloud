package com.leasing.calculate.dto;

import com.leasing.common.vo.foundation.UserVO;
import lombok.Value;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/10/18
 * @author:Yjj@yonyou.com
 * @description: 报价DTO
 **/
@Entity
@Table(name="yls_lease_calculator")
public class CalculatorDTO {

    @Id
    public String pkLeaseCalculator;
    public String quotCode;
    public String quotName;

    @ManyToOne()
    @JoinColumn(name = "pkChecker")
    public UserVO pkChecker;

    public CalculatorDTO(String pkLeaseCalculator, String quotCode, String quotName) {
        this.pkLeaseCalculator = pkLeaseCalculator;
        this.quotCode = quotCode;
        this.quotName = quotName;
    }


    public String getPkLeaseCalculator() {
        return pkLeaseCalculator;
    }

    public void setPkLeaseCalculator(String pkLeaseCalculator) {
        this.pkLeaseCalculator = pkLeaseCalculator;
    }

    public String getQuotCode() {
        return quotCode;
    }

    public void setQuotCode(String quotCode) {
        this.quotCode = quotCode;
    }

    public String getQuotName() {
        return quotName;
    }

    public void setQuotName(String quotName) {
        this.quotName = quotName;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "pkLeaseCalculator='" + pkLeaseCalculator + '\'' +
                ", quotCode='" + quotCode + '\'' +
                ", quotName='" + quotName + '\'' +
                ", pkChecker=" + pkChecker +
                '}';
    }

}