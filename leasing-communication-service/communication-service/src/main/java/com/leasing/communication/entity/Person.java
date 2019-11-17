package com.leasing.communication.entity;

import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.communication.interfaces.ExcelTag;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description: poi实体对象
 **/
public class Person extends FileBaseBusinessDO {

    @ExcelTag(tag = "姓名")
    private String name;

    @ExcelTag(tag = "性别")
    private Integer sex;

    @ExcelTag(tag = "生日")
    private Date birthday;

    @ExcelTag(tag = "金额")
    private BigDecimal totalAmount;

    @ExcelTag(tag = "税率")
    private Double ratio;

    @ExcelTag(tag = "哈哈")
    public Long srvfeeBase;

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }

    public Person() {}

    public Person(String name, Short billstatus, String pkOperator, String operateDate, String operateTime, String pkOrg, String pkDept) {
        this.name = name;
        this.pkOperator = pkOperator;
        this.operateDate = operateDate;
        this.operateTime = operateTime;
        this.pkOrg = pkOrg;
        this.pkDept = pkDept;
        this.billstatus = billstatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getRatio() {
        return ratio;
    }

    public void setRatio(Double ratio) {
        this.ratio = ratio;
    }

    public Long getSrvfeeBase() {
        return srvfeeBase;
    }

    public void setSrvfeeBase(Long srvfeeBase) {
        this.srvfeeBase = srvfeeBase;
    }
}