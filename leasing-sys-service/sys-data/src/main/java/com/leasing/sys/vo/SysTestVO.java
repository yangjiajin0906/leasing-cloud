package com.leasing.sys.vo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @project:leasing-cloud
 * @date:2019-9-29
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yls_sys_test")
public class SysTestVO {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "roleSeq")
    @TableGenerator(name = "roleSeq", allocationSize = 1, table = "seq_table", pkColumnName = "seq_id", valueColumnName = "seq_count")
    private Long pkSysTest;

    private Long pk;

    private BigDecimal shuzi;

    private String zifuchuan;

    private String riqishijian;

    private String riqi;

    @Version
    private Timestamp version;


    public Long getPkSysTest() {
        return pkSysTest;
    }

    public void setPkSysTest(Long pkSysTest) {
        this.pkSysTest = pkSysTest;
    }

    public BigDecimal getShuzi() {
        return shuzi;
    }

    public void setShuzi(BigDecimal shuzi) {
        this.shuzi = shuzi;
    }

    public String getZifuchuan() {
        return zifuchuan;
    }

    public void setZifuchuan(String zifuchuan) {
        this.zifuchuan = zifuchuan;
    }

    public String getRiqishijian() {
        return riqishijian;
    }

    public void setRiqishijian(String riqishijian) {
        this.riqishijian = riqishijian;
    }

    public String getRiqi() {
        return riqi;
    }

    public void setRiqi(String riqi) {
        this.riqi = riqi;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
    }
}
