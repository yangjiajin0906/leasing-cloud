package com.leasing.calculate.entity.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 利率管理DTO类
 * @date:2019/9/25
 * @author:Yjj@yonyou.com
 * @description:
 **/

@Entity
@Table(name="yls_interrate")
public class InterrateRefDTO {
    @Id
    public String pkInterrate;
    /**
     * 启用日期
     */
    public String start_date;

    /**
     * 备注
     */
    public String memo;

    /**
     * 利率编码
     */
    public String interrateCode;
    /**
     * 单据状态
     */
    public Short billstatus;

    public InterrateRefDTO() {
    }


    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public String getInterrateCode() {
        return interrateCode;
    }

    public void setInterrateCode(String interrateCode) {
        this.interrateCode = interrateCode;
    }

    /**
     * 启用日期的getter方法
     *
     * @return String
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * 启用日期的setter方法
     *
     * @param start_date 启用日期
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
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

    public String getPkInterrate() {
        return pkInterrate;
    }

    public void setPkInterrate(String pkInterrate) {
        this.pkInterrate = pkInterrate;
    }
}