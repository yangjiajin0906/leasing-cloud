package com.leasing.communication.entity.vo;


import com.leasing.common.base.entity.BaseVO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Title: 租赁账户管理系统<br>
 * Description: 计提主表(中投)类<br>
 * Copyright: Copyright (c) 2010<br>
 * Company: UFIDA<br>
 *
 * @author
 * @version
 */
@Entity
@Table(name="yls_lease_accrued")
public class AccruedChildVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    public String pkLeaseAccrued;


    /**
     * 计提子表(中投)
     */
    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="pkLeaseAccrued")
    public List<AccruedBVO> leaseAccruedB;

    @Override
    public String getPk() {
        return pkLeaseAccrued;
    }

    @Override
    public void setPk(String pk) {
        this.pkLeaseAccrued = pk;
    }

    /**
     * 类LeaseAccruedVO的构造方法
     */
    public AccruedChildVO() {
    }

    public String getPkLeaseAccrued() {
        return pkLeaseAccrued;
    }

    public void setPkLeaseAccrued(String pkLeaseAccrued) {
        this.pkLeaseAccrued = pkLeaseAccrued;
    }

    public List<AccruedBVO> getLeaseAccruedB() {
        return leaseAccruedB;
    }

    public void setLeaseAccruedB(List<AccruedBVO> leaseAccruedB) {
        this.leaseAccruedB = leaseAccruedB;
    }
}

