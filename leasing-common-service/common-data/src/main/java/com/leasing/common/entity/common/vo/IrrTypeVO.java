package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.entity.common.dos.IrrEventSetDO;
import com.leasing.common.entity.foundation.vo.UserVO;

import javax.persistence.*;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/30
 * @author:wangjc@yonyou.com
 * @description:irr影响主表
 **/
@Entity
@Table(name = "yls_irr_type")
@NamedQueries({
        @NamedQuery(name = "ListIrrType", query = "SELECT i from IrrTypeVO i " +
                " left join fetch i.pkOrg" +
                " left join fetch i.pkOperator " +
                " left join fetch i.pkDept "),
        @NamedQuery(name = "ListIrrType.count", query = "SELECT count(i.pkIrrType) FROM IrrTypeVO i")
})
public class IrrTypeVO extends BaseBusinessVO {
    public String getTableName(){return "yls_irr_type";}

    public String getPk(){return pkIrrType;}

    public void setPk(String pkIrrType){this.pkIrrType = pkIrrType;}

    public IrrTypeVO(){}

    @Id
    private String pkIrrType;

    /**
     * 影响Irr对象
     */
    private Short irrTypeName;

    /**
     * Irr计算模型
     */
    private Short irrModel;

    /**
     * 备注
     */
    private String memo;

    /**
     * 复核人
     */
    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    /**
     * 复核日期
     */
    private String checkDate;

    /**
     * 复核时间
     */
    private String checkTime;

    /**
     * 授权人
     */
    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    /**
     * 授权日期
     */
    private String grantDate;

    /**
     * 授权时间
     */
    private String grantTime;

//    @OneToMany(orphanRemoval=true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name="pkIrrType")
    @Transient
    private List<IrrEventSetDO> irrEventSet;

    public String getPkIrrType() {
        return pkIrrType;
    }

    public void setPkIrrType(String pkIrrType) {
        this.pkIrrType = pkIrrType;
    }

    public Short getIrrTypeName() {
        return irrTypeName;
    }

    public void setIrrTypeName(Short irrTypeName) {
        this.irrTypeName = irrTypeName;
    }

    public Short getIrrModel() {
        return irrModel;
    }

    public void setIrrModel(Short irrModel) {
        this.irrModel = irrModel;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public List<IrrEventSetDO> getIrrEventSet() {
        return irrEventSet;
    }

    public void setIrrEventSet(List<IrrEventSetDO> irrEventSet) {
        this.irrEventSet = irrEventSet;
    }
}