package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseBusinessVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer_relation")
public class CustomerRelationVO extends BaseBusinessVO {

    @Id
    private String pkCustomerRelationship;

    private Short relationType;

    private String grantTime;

    private String relationReverse;

    private String relationRole;


    private String grantDate;

    private String checkDate;

    private String checkTime;

    private String relationSource;

    @ManyToOne
    @JoinColumn(name = "pkChecker")
    private UserVO pkChecker;

    @ManyToOne
    @JoinColumn(name = "pkGrantor")
    private UserVO pkGrantor;

    public String getPkCustomerRelationship() {
        return pkCustomerRelationship;
    }

    public void setPkCustomerRelationship(String pkCustomerRelationship) {
        this.pkCustomerRelationship = pkCustomerRelationship;
    }

    public Short getRelationType() {
        return relationType;
    }

    public void setRelationType(Short relationType) {
        this.relationType = relationType;
    }

    public String getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(String grantTime) {
        this.grantTime = grantTime;
    }

    public String getRelationReverse() {
        return relationReverse;
    }

    public void setRelationReverse(String relationReverse) {
        this.relationReverse = relationReverse;
    }

    public String getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(String relationRole) {
        this.relationRole = relationRole;
    }

    public String getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
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

    public String getRelationSource() {
        return relationSource;
    }

    public void setRelationSource(String relationSource) {
        this.relationSource = relationSource;
    }

    public UserVO getPkChecker() {
        return pkChecker;
    }

    public void setPkChecker(UserVO pkChecker) {
        this.pkChecker = pkChecker;
    }

    public UserVO getPkGrantor() {
        return pkGrantor;
    }

    public void setPkGrantor(UserVO pkGrantor) {
        this.pkGrantor = pkGrantor;
    }

    @Override
    public String getPk() {
        return pkCustomerRelationship;
    }

    @Override
    public void setPk(String pk) {
        this.pkCustomerRelationship = pk;
    }


}