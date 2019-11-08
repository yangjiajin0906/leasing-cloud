package com.leasing.communication.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Person {
    @Excel(name = "姓名", orderNum = "0")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "1")
    private int sex;

    @Excel(name = "生日", exportFormat = "yyyy-MM-dd", importFormat = "yyyy-MM-dd",orderNum = "2")
    private Date birthday;

    @Excel(name = "金额",orderNum = "3")
    private BigDecimal totalAmount;

    @Excel(name = "汇率", orderNum = "4")
    private Double ratio;

    @Excel(name = "服务费收入基数", orderNum = "5")
    public Long srvfeeBase;

    public Person() {}

    public Person(String name, int sex, Date birthday, BigDecimal totalAmount, Double ratio, Long srvfeeBase) {
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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