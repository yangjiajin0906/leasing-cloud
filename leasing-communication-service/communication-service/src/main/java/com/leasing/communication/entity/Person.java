package com.leasing.communication.entity;

import com.leasing.communication.entity.base.FileBaseBusinessDO;
import com.leasing.communication.utils.Excel;

import java.math.BigDecimal;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description: poi实体对象
 **/
public class Person extends FileBaseBusinessDO {

    private String name;

    @Excel(orderNum = 1, titleName = "性别")
    private Integer sex;

    @Excel(orderNum = 1, titleName = "生日")
    private String birthday;

    @Excel(orderNum = 1, titleName = "金额")
    private BigDecimal totalAmount;

    @Excel(orderNum = 1, titleName = "税率")
    private Double ratio;

    @Excel(orderNum = 1, titleName = "哈哈")
    public Long srvfeeBase;

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }

    public Person() {}

    public Person(String name, Integer sex, String birthday, BigDecimal totalAmount, Double ratio, Long srvfeeBase) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.totalAmount = totalAmount;
        this.ratio = ratio;
        this.srvfeeBase = srvfeeBase;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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