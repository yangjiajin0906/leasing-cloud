package com.leasing.customer.dao.vo;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.vo.foundation.OrgVO;
import com.leasing.common.vo.foundation.UserVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019-11-06
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Entity
@Table(name = "yls_customer_relationship")
public class CustomerRelationshipVO extends BaseVO {

    /**
     * 主键
     */
    @Id
    private String pkCustomerRelationship;


    /**
     * 关系类型
     */
    private Short relationType;


    /**
     * 客户关系
     */
    @ManyToOne
    @JoinColumn(name = "relationRole")
    private ParameterDTO relationRole;


    /**
     * 反向关系
     */
    @ManyToOne
    @JoinColumn(name = "relationReverse")
    private ParameterDTO relationReverse;


    /**
     * 关系来源
     */
    private String relationSource;


    /**
     * 单据状态
     */
    private Short billstatus;


    /**
     * 操作人
     */
    @ManyToOne
    @JoinColumn(name = "pkOperator")
    private UserVO pkOperator;

    /**
     * 操作日期
     */
    private String operateDate;


    /**
     * 操作时间
     */
    private String operateTime;


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


    /**
     * 机构
     */
    @ManyToOne
    @JoinColumn(name = "pkOrg")
    private OrgVO pkOrg;

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

    public ParameterDTO getRelationRole() {
        return relationRole;
    }

    public void setRelationRole(ParameterDTO relationRole) {
        this.relationRole = relationRole;
    }

    public ParameterDTO getRelationReverse() {
        return relationReverse;
    }

    public void setRelationReverse(ParameterDTO relationReverse) {
        this.relationReverse = relationReverse;
    }

    public String getRelationSource() {
        return relationSource;
    }

    public void setRelationSource(String relationSource) {
        this.relationSource = relationSource;
    }

    public Short getBillstatus() {
        return billstatus;
    }

    public void setBillstatus(Short billstatus) {
        this.billstatus = billstatus;
    }

    public UserVO getPkOperator() {
        return pkOperator;
    }

    public void setPkOperator(UserVO pkOperator) {
        this.pkOperator = pkOperator;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
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

    public OrgVO getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(OrgVO pkOrg) {
        this.pkOrg = pkOrg;
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