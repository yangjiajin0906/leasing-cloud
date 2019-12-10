package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseBusinessDO;
import com.leasing.communication.entity.dto.SourceSystemDTO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: 文件导入设置业务对象
 **/
@Entity
@Table(name = "yc_imp_set")
public class CbImpSetDO extends BaseBusinessDO {

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
    @JoinColumn(name = "pkImpDetail")
    private List<CbImpDetailDO> detailList;

    /**
     * 是否生效
     */
    private Short effective;

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

    public List<CbImpDetailDO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CbImpDetailDO> detailList) {
        this.detailList = detailList;
    }

    public Short getEffective() {
        return effective;
    }

    public void setEffective(Short effective) {
        this.effective = effective;
    }

    @Override
    public String getPk() {
        return pkImpSet;
    }

    @Override
    public void setPk(String pk) {
        this.pkImpSet = pk;
    }
}
