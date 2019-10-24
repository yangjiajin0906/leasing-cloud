package com.leasing.common.vo.foundation;

import com.leasing.common.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description: 人员基本档案实体对象
 **/
@Entity
@Table(name="bd_psnbasdoc")
public class PsnbasdocVO extends BaseEntity {

    /** 人员基本档案主键 */
    @Id
    public String pkPsnbasdoc;
    /** 家庭地址 */
    public String addr;
    /** 出生日期 */
    public String birthdate;
    /** 呼机 */
    public String bp;
    /** 脏位
     * 0 - 正常数据;
     * 1 - 脏数据;
     */
    public Integer dr;
    /** 电子邮件 */
    public String email;
    /** 家庭电话 */
    public String homephone;
    /** 身份证号 */
    public String id;
    /** 参加工作日期 */
    public String joinworkdate;
    /** 手机 */
    public String mobile;
    /** 办公电话 */
    public String officephone;
    /** 归属公司 */
    public String pk_corp;
    /** 邮政编码 */
    public String postalcode;
    /** 姓名 */
    public String psnname;
    /** 性别 */
    public String sex;
    /** 社会保障号 */
    public String ssnum;
    /** 曾用名 */
    public String usedname;
    /** 自定义项1 */
    public String vdef1;
    /** 自定义项10 */
    public String vdef10;
    /** 自定义项11 */
    public String vdef11;
    /** 自定义项12 */
    public String vdef12;
    /** 自定义项13 */
    public String vdef13;
    /** 自定义项14 */
    public String vdef14;
    /** 自定义项15 */
    public String vdef15;
    /** 自定义项16 */
    public String vdef16;
    /** 自定义项17 */
    public String vdef17;
    /** 自定义项18 */
    public String vdef18;
    /** 自定义项19 */
    public String vdef19;
    /** 自定义项2 */
    public String vdef2;
    /** 自定义项20 */
    public String vdef20;
    /** 自定义项3 */
    public String vdef3;
    /** 自定义项4 */
    public String vdef4;
    /** 自定义项5 */
    public String vdef5;
    /** 自定义项6 */
    public String vdef6;
    /** 自定义项7 */
    public String vdef7;
    /** 自定义项8 */
    public String vdef8;
    /** 自定义项9 */
    public String vdef9;

    public String getTableName() {
        return "bd_psnbasdoc";
    }

    public String getPk() {
        return pkPsnbasdoc;
    }

    public void setPk(String pk) {
        this.pkPsnbasdoc = pk;
    }

    public String getPkPsnbasdoc() {
        return pkPsnbasdoc;
    }

    public void setPkPsnbasdoc(String pkPsnbasdoc) {
        this.pkPsnbasdoc = pkPsnbasdoc;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoinworkdate() {
        return joinworkdate;
    }

    public void setJoinworkdate(String joinworkdate) {
        this.joinworkdate = joinworkdate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    public String getPk_corp() {
        return pk_corp;
    }

    public void setPk_corp(String pk_corp) {
        this.pk_corp = pk_corp;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSsnum() {
        return ssnum;
    }

    public void setSsnum(String ssnum) {
        this.ssnum = ssnum;
    }

    public String getUsedname() {
        return usedname;
    }

    public void setUsedname(String usedname) {
        this.usedname = usedname;
    }

    public String getVdef1() {
        return vdef1;
    }

    public void setVdef1(String vdef1) {
        this.vdef1 = vdef1;
    }

    public String getVdef10() {
        return vdef10;
    }

    public void setVdef10(String vdef10) {
        this.vdef10 = vdef10;
    }

    public String getVdef11() {
        return vdef11;
    }

    public void setVdef11(String vdef11) {
        this.vdef11 = vdef11;
    }

    public String getVdef12() {
        return vdef12;
    }

    public void setVdef12(String vdef12) {
        this.vdef12 = vdef12;
    }

    public String getVdef13() {
        return vdef13;
    }

    public void setVdef13(String vdef13) {
        this.vdef13 = vdef13;
    }

    public String getVdef14() {
        return vdef14;
    }

    public void setVdef14(String vdef14) {
        this.vdef14 = vdef14;
    }

    public String getVdef15() {
        return vdef15;
    }

    public void setVdef15(String vdef15) {
        this.vdef15 = vdef15;
    }

    public String getVdef16() {
        return vdef16;
    }

    public void setVdef16(String vdef16) {
        this.vdef16 = vdef16;
    }

    public String getVdef17() {
        return vdef17;
    }

    public void setVdef17(String vdef17) {
        this.vdef17 = vdef17;
    }

    public String getVdef18() {
        return vdef18;
    }

    public void setVdef18(String vdef18) {
        this.vdef18 = vdef18;
    }

    public String getVdef19() {
        return vdef19;
    }

    public void setVdef19(String vdef19) {
        this.vdef19 = vdef19;
    }

    public String getVdef2() {
        return vdef2;
    }

    public void setVdef2(String vdef2) {
        this.vdef2 = vdef2;
    }

    public String getVdef20() {
        return vdef20;
    }

    public void setVdef20(String vdef20) {
        this.vdef20 = vdef20;
    }

    public String getVdef3() {
        return vdef3;
    }

    public void setVdef3(String vdef3) {
        this.vdef3 = vdef3;
    }

    public String getVdef4() {
        return vdef4;
    }

    public void setVdef4(String vdef4) {
        this.vdef4 = vdef4;
    }

    public String getVdef5() {
        return vdef5;
    }

    public void setVdef5(String vdef5) {
        this.vdef5 = vdef5;
    }

    public String getVdef6() {
        return vdef6;
    }

    public void setVdef6(String vdef6) {
        this.vdef6 = vdef6;
    }

    public String getVdef7() {
        return vdef7;
    }

    public void setVdef7(String vdef7) {
        this.vdef7 = vdef7;
    }

    public String getVdef8() {
        return vdef8;
    }

    public void setVdef8(String vdef8) {
        this.vdef8 = vdef8;
    }

    public String getVdef9() {
        return vdef9;
    }

    public void setVdef9(String vdef9) {
        this.vdef9 = vdef9;
    }
}
