package com.leasing.common.entity.foundation;

import com.leasing.common.entity.base.BaseBusiEntity;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-10-10
 * @author:lvcna@yonyou.com
 * @description: 个人档案实体对象
 **/
@Entity
@Table(name="bd_psndoc")
public class PsndocVO extends BaseBusiEntity {

    @Id
    private String pkPsndoc;
    private String psncode;
    private String psnname;
    private String pkCorp;
    @ManyToOne
    @JoinColumn(name="pk_psnbasdoc")
    private PsnbasdocVO pkPsnbasdoc;


    public String getTableName() {
        return "bd_psndoc";
    }

    public String getPk() {
        return pkPsndoc;
    }

    public void setPk(String pk) {
        this.pkPsndoc = pk;
    }

    public String getPkPsndoc() {
        return pkPsndoc;
    }

    public void setPkPsndoc(String pkPsndoc) {
        this.pkPsndoc = pkPsndoc;
    }

    public String getPsncode() {
        return psncode;
    }

    public void setPsncode(String psncode) {
        this.psncode = psncode;
    }

    public String getPsnname() {
        return psnname;
    }

    public void setPsnname(String psnname) {
        this.psnname = psnname;
    }

    public String getPkCorp() {
        return pkCorp;
    }

    public void setPkCorp(String pkCorp) {
        this.pkCorp = pkCorp;
    }

    public PsnbasdocVO getPkPsnbasdoc() {
        return pkPsnbasdoc;
    }

    public void setPkPsnbasdoc(PsnbasdocVO pkPsnbasdoc) {
        this.pkPsnbasdoc = pkPsnbasdoc;
    }
}
