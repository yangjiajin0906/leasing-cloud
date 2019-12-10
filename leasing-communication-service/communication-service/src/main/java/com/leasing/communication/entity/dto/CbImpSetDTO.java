package com.leasing.communication.entity.dto;

import com.leasing.common.base.entity.BaseBusinessDTO;
import com.leasing.common.base.repository.support.StringModalType;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-9
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yc_imp_set")
public class CbImpSetDTO extends BaseBusinessDTO {

    /**
     * 主键
     */
    @Id
    private String pkImpSet;

    /**
     * 来源系统
     */
    @ManyToOne
    @JoinColumn(name = "pkSystem")
    private SourceSystemDTO pkSystem;

    /**
     * 子表信息
     */
    @OneToMany(cascade={CascadeType.ALL},fetch= FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name="pkImpSet")
    private List<CbImpDetailDTO> detailList;

    /**
     * 是否生效
     */
    private Short effective;

    //时间戳
    @Version
    private StringModalType ts;

    public String getPkImpSet() {
        return pkImpSet;
    }

    public void setPkImpSet(String pkImpSet) {
        this.pkImpSet = pkImpSet;
    }

    public SourceSystemDTO getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(SourceSystemDTO pkSystem) {
        this.pkSystem = pkSystem;
    }

    public List<CbImpDetailDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CbImpDetailDTO> detailList) {
        this.detailList = detailList;
    }

    public Short getEffective() {
        return effective;
    }

    public void setEffective(Short effective) {
        this.effective = effective;
    }

    public StringModalType getTs() {
        return ts;
    }

    public void setTs(StringModalType ts) {
        this.ts = ts;
    }
}
