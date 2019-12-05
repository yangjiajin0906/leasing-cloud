package com.leasing.communication.entity.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description 结帐表
 * @author Yangjiajin
 * @date 2019/11/29 14:31
 * @param
 * @return
 */
@Entity
@Table(name="gl_syssettled")
public class GlSyssettledVO {
    /**
     * 主键
     */
    @Id
    private String pkSyssettled;

    /**
     * 删除标志
     */
    private Long dr;

    /**
     * 节点号
     */
    private String funccode;

    /**
     * 主体帐簿
     */
    private String pkGlorgbook;

    /**
     * 结帐日期
     */
    private String settleddate;

    /**
     * 结帐期间
     */
    private String settledperiod;

    /**
     * 结帐年
     */
    private String settledyear;

    /**
     * 时间戳
     */
    private String ts;

    /**
     * 主键
     * @return PK_SYSSETTLED null
     */
    public String getPkSyssettled() {
        return pkSyssettled;
    }

    /**
     * 主键
     * @param pkSyssettled null
     */
    public void setPkSyssettled(String pkSyssettled) {
        this.pkSyssettled = pkSyssettled == null ? null : pkSyssettled.trim();
    }

    /**
     * 删除标志
     * @return DR 删除标志
     */
    public Long getDr() {
        return dr;
    }

    /**
     * 删除标志
     * @param dr 删除标志
     */
    public void setDr(Long dr) {
        this.dr = dr;
    }

    /**
     * 节点号
     * @return FUNCCODE 节点号
     */
    public String getFunccode() {
        return funccode;
    }

    /**
     * 节点号
     * @param funccode 节点号
     */
    public void setFunccode(String funccode) {
        this.funccode = funccode == null ? null : funccode.trim();
    }

    /**
     * 主体帐簿
     * @return PK_GLORGBOOK 主体帐簿
     */
    public String getPkGlorgbook() {
        return pkGlorgbook;
    }

    /**
     * 主体帐簿
     * @param pkGlorgbook 主体帐簿
     */
    public void setPkGlorgbook(String pkGlorgbook) {
        this.pkGlorgbook = pkGlorgbook == null ? null : pkGlorgbook.trim();
    }

    /**
     * 结帐日期
     * @return SETTLEDDATE 结帐日期
     */
    public String getSettleddate() {
        return settleddate;
    }

    /**
     * 结帐日期
     * @param settleddate 结帐日期
     */
    public void setSettleddate(String settleddate) {
        this.settleddate = settleddate == null ? null : settleddate.trim();
    }

    /**
     * 结帐期间
     * @return SETTLEDPERIOD 结帐期间
     */
    public String getSettledperiod() {
        return settledperiod;
    }

    /**
     * 结帐期间
     * @param settledperiod 结帐期间
     */
    public void setSettledperiod(String settledperiod) {
        this.settledperiod = settledperiod == null ? null : settledperiod.trim();
    }

    /**
     * 结帐年
     * @return SETTLEDYEAR 结帐年
     */
    public String getSettledyear() {
        return settledyear;
    }

    /**
     * 结帐年
     * @param settledyear 结帐年
     */
    public void setSettledyear(String settledyear) {
        this.settledyear = settledyear == null ? null : settledyear.trim();
    }

    /**
     * 时间戳
     * @return TS 时间戳
     */
    public String getTs() {
        return ts;
    }

    /**
     * 时间戳
     * @param ts 时间戳
     */
    public void setTs(String ts) {
        this.ts = ts == null ? null : ts.trim();
    }
}