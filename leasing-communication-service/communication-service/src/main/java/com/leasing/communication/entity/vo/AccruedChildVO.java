package com.leasing.communication.entity.vo;


import com.leasing.common.base.entity.BaseVO;

import javax.persistence.*;
import java.util.List;

/**
 * Description: 计提主表 共前台单独查询子表数据用 为了减少不必要的字段查询
 */
@Entity
@Table(name="yc_accrued")
public class AccruedChildVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    public String pkAccrued;


    /**
     * 计提子表(中投)
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pkAccrued")
    public List<AccruedDetailVO> pkAccruedDetail;

    @Override
    public String getPk() {
        return pkAccrued;
    }

    @Override
    public void setPk(String pk) {
        this.pkAccrued = pk;
    }

    /**
     * 类LeaseAccruedVO的构造方法
     */
    public AccruedChildVO() {
    }

    public String getPkAccrued() {
        return pkAccrued;
    }

    public void setPkAccrued(String pkAccrued) {
        this.pkAccrued = pkAccrued;
    }

    public List<AccruedDetailVO> getPkAccruedDetail() {
        return pkAccruedDetail;
    }

    public void setPkAccruedDetail(List<AccruedDetailVO> pkAccruedDetail) {
        this.pkAccruedDetail = pkAccruedDetail;
    }
}

