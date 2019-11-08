package com.leasing.communication.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:Yjj@yonyou.com
 * @description:
 **/
public class Address {
    @Excel(name = "编号", orderNum = "0")
    private String id;

    @Excel(name = "地址", orderNum = "1")
    private String name;

    @Excel(name = "类别", replace = {"家里_1", "公司_2"}, orderNum = "2")
    private String type;

    @Excel(name = "开放时间", exportFormat = "yyyy-MM-dd",importFormat = "yyyy-MM-dd", orderNum = "3")
    private Date time;

    @Excel(name = "地址2", orderNum = "4")
    private String name2;

    @Excel(name = "地址3", orderNum = "5")
    private String name3;

    @Excel(name = "地址4", orderNum = "6")
    private String name4;

    @Excel(name = "地址5", orderNum = "7")
    private String name5;

    @Excel(name = "地址6", orderNum = "8")
    private String name6;

    @Excel(name = "地址7", orderNum = "9")
    private String name7;

    @Excel(name = "地址8", orderNum = "10")
    private String name8;

    @Excel(name = "地址9", orderNum = "11")
    private String name9;

    @Excel(name = "地址10", orderNum = "12")
    private String name10;

    @Excel(name = "地址11", orderNum = "13")
    private String name11;

    @Excel(name = "地址12", orderNum = "14")
    private String name12;

    @Excel(name = "地址13", orderNum = "15")
    private String name13;

    @Excel(name = "地址14", orderNum = "16")
    private String name14;

    @Excel(name = "地址15", orderNum = "17")
    private String name15;

    @Excel(name = "地址16", orderNum = "18")
    private String name16;

    @Excel(name = "地址17", orderNum = "19")
    private String name17;

    @Excel(name = "地址18", orderNum = "20")
    private String name18;

    @Excel(name = "地址19", orderNum = "21")
    private String name19;

    @Excel(name = "地址20", orderNum = "22")
    private String name20;

    @Excel(name = "地址21", orderNum = "23")
    private String name21;

    @Excel(name = "地址22", orderNum = "24")
    private String name22;

    @Excel(name = "地址23", orderNum = "25")
    private String name23;

    @Excel(name = "地址24", orderNum = "26")
    private String name24;

    @Excel(name = "地址25", orderNum = "27")
    private String name25;

    @Excel(name = "地址26", orderNum = "28")
    private String name26;

    @Excel(name = "地址27", orderNum = "29")
    private String name27;

    @Excel(name = "地址28", orderNum = "30")
    private String name28;

    @Excel(name = "地址29", orderNum = "31")
    private String name29;

    @Excel(name = "地址30", orderNum = "32")
    private String name30;

    @Excel(name = "地址31", orderNum = "33")
    private String name31;

    @Excel(name = "地址32", orderNum = "34")
    private String name32;

    @Excel(name = "地址33", orderNum = "35")
    private String name33;

    @Excel(name = "地址34", orderNum = "36")
    private String name34;

    @Excel(name = "地址35", orderNum = "37")
    private String name35;

    @Excel(name = "地址36", orderNum = "38")
    private String name36;

    @Excel(name = "地址38", orderNum = "39")
    private String name38;

    @Excel(name = "地址39", orderNum = "40")
    private String name39;

    @Excel(name = "地址40", orderNum = "41")
    private String name40;

    @Excel(name = "地址41", orderNum = "42")
    private String name41;

    @Excel(name = "地址42", orderNum = "43")
    private String name42;

    @Excel(name = "地址43", orderNum = "44")
    private String name43;

    @Excel(name = "地址44", orderNum = "45")
    private String name44;

    @Excel(name = "地址45", orderNum = "46")
    private String name45;

    @Excel(name = "地址46", orderNum = "47")
    private String name46;

    @Excel(name = "地址47", orderNum = "48")
    private String name47;

    public Address() {}

    public Address(String id, String name, String type, Date time, String name2, String name3, String name4, String name5, String name6, String name7, String name8, String name9, String name10, String name11, String name12, String name13, String name14, String name15, String name16, String name17, String name18, String name19, String name20, String name21, String name22, String name23, String name24, String name25, String name26, String name27, String name28, String name29, String name30, String name31, String name32, String name33, String name34, String name35, String name36, String name38, String name39, String name40, String name41, String name42, String name43, String name44, String name45, String name46, String name47) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
        this.name5 = name5;
        this.name6 = name6;
        this.name7 = name7;
        this.name8 = name8;
        this.name9 = name9;
        this.name10 = name10;
        this.name11 = name11;
        this.name12 = name12;
        this.name13 = name13;
        this.name14 = name14;
        this.name15 = name15;
        this.name16 = name16;
        this.name17 = name17;
        this.name18 = name18;
        this.name19 = name19;
        this.name20 = name20;
        this.name21 = name21;
        this.name22 = name22;
        this.name23 = name23;
        this.name24 = name24;
        this.name25 = name25;
        this.name26 = name26;
        this.name27 = name27;
        this.name28 = name28;
        this.name29 = name29;
        this.name30 = name30;
        this.name31 = name31;
        this.name32 = name32;
        this.name33 = name33;
        this.name34 = name34;
        this.name35 = name35;
        this.name36 = name36;
        this.name38 = name38;
        this.name39 = name39;
        this.name40 = name40;
        this.name41 = name41;
        this.name42 = name42;
        this.name43 = name43;
        this.name44 = name44;
        this.name45 = name45;
        this.name46 = name46;
        this.name47 = name47;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public String getName7() {
        return name7;
    }

    public void setName7(String name7) {
        this.name7 = name7;
    }

    public String getName8() {
        return name8;
    }

    public void setName8(String name8) {
        this.name8 = name8;
    }

    public String getName9() {
        return name9;
    }

    public void setName9(String name9) {
        this.name9 = name9;
    }

    public String getName10() {
        return name10;
    }

    public void setName10(String name10) {
        this.name10 = name10;
    }

    public String getName11() {
        return name11;
    }

    public void setName11(String name11) {
        this.name11 = name11;
    }

    public String getName12() {
        return name12;
    }

    public void setName12(String name12) {
        this.name12 = name12;
    }

    public String getName13() {
        return name13;
    }

    public void setName13(String name13) {
        this.name13 = name13;
    }

    public String getName14() {
        return name14;
    }

    public void setName14(String name14) {
        this.name14 = name14;
    }

    public String getName15() {
        return name15;
    }

    public void setName15(String name15) {
        this.name15 = name15;
    }

    public String getName16() {
        return name16;
    }

    public void setName16(String name16) {
        this.name16 = name16;
    }

    public String getName17() {
        return name17;
    }

    public void setName17(String name17) {
        this.name17 = name17;
    }

    public String getName18() {
        return name18;
    }

    public void setName18(String name18) {
        this.name18 = name18;
    }

    public String getName19() {
        return name19;
    }

    public void setName19(String name19) {
        this.name19 = name19;
    }

    public String getName20() {
        return name20;
    }

    public void setName20(String name20) {
        this.name20 = name20;
    }

    public String getName21() {
        return name21;
    }

    public void setName21(String name21) {
        this.name21 = name21;
    }

    public String getName22() {
        return name22;
    }

    public void setName22(String name22) {
        this.name22 = name22;
    }

    public String getName23() {
        return name23;
    }

    public void setName23(String name23) {
        this.name23 = name23;
    }

    public String getName24() {
        return name24;
    }

    public void setName24(String name24) {
        this.name24 = name24;
    }

    public String getName25() {
        return name25;
    }

    public void setName25(String name25) {
        this.name25 = name25;
    }

    public String getName26() {
        return name26;
    }

    public void setName26(String name26) {
        this.name26 = name26;
    }

    public String getName27() {
        return name27;
    }

    public void setName27(String name27) {
        this.name27 = name27;
    }

    public String getName28() {
        return name28;
    }

    public void setName28(String name28) {
        this.name28 = name28;
    }

    public String getName29() {
        return name29;
    }

    public void setName29(String name29) {
        this.name29 = name29;
    }

    public String getName30() {
        return name30;
    }

    public void setName30(String name30) {
        this.name30 = name30;
    }

    public String getName31() {
        return name31;
    }

    public void setName31(String name31) {
        this.name31 = name31;
    }

    public String getName32() {
        return name32;
    }

    public void setName32(String name32) {
        this.name32 = name32;
    }

    public String getName33() {
        return name33;
    }

    public void setName33(String name33) {
        this.name33 = name33;
    }

    public String getName34() {
        return name34;
    }

    public void setName34(String name34) {
        this.name34 = name34;
    }

    public String getName35() {
        return name35;
    }

    public void setName35(String name35) {
        this.name35 = name35;
    }

    public String getName36() {
        return name36;
    }

    public void setName36(String name36) {
        this.name36 = name36;
    }

    public String getName38() {
        return name38;
    }

    public void setName38(String name38) {
        this.name38 = name38;
    }

    public String getName39() {
        return name39;
    }

    public void setName39(String name39) {
        this.name39 = name39;
    }

    public String getName40() {
        return name40;
    }

    public void setName40(String name40) {
        this.name40 = name40;
    }

    public String getName41() {
        return name41;
    }

    public void setName41(String name41) {
        this.name41 = name41;
    }

    public String getName42() {
        return name42;
    }

    public void setName42(String name42) {
        this.name42 = name42;
    }

    public String getName43() {
        return name43;
    }

    public void setName43(String name43) {
        this.name43 = name43;
    }

    public String getName44() {
        return name44;
    }

    public void setName44(String name44) {
        this.name44 = name44;
    }

    public String getName45() {
        return name45;
    }

    public void setName45(String name45) {
        this.name45 = name45;
    }

    public String getName46() {
        return name46;
    }

    public void setName46(String name46) {
        this.name46 = name46;
    }

    public String getName47() {
        return name47;
    }

    public void setName47(String name47) {
        this.name47 = name47;
    }
}