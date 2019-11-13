package com.leasing.communication.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.leasing.communication.entity.base.FileBaseBusinessDO;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Person extends FileBaseBusinessDO {
    @Excel(name = "姓名", orderNum = "7")
    private String name;

//    @Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "8")
//    private Integer sex;
//
//    @Excel(name = "生日", exportFormat = "yyyy-MM-dd HH:mm:ss", importFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "9")
//    private Date birthday;
//
//    @Excel(name = "金额",orderNum = "10")
//    private BigDecimal totalAmount;
//
//    @Excel(name = "汇率", orderNum = "11")
//    private Double ratio;
//
//    @Excel(name = "服务费收入基数", orderNum = "12")
//    public Long srvfeeBase;

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

//    public Integer getSex() {
//        return sex;
//    }
//
//    public void setSex(Integer sex) {
//        this.sex = sex;
//    }
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public BigDecimal getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(BigDecimal totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public Double getRatio() {
//        return ratio;
//    }
//
//    public void setRatio(Double ratio) {
//        this.ratio = ratio;
//    }
//
//    public Long getSrvfeeBase() {
//        return srvfeeBase;
//    }
//
//    public void setSrvfeeBase(Long srvfeeBase) {
//        this.srvfeeBase = srvfeeBase;
//    }
}