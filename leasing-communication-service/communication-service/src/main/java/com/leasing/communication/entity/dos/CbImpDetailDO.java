package com.leasing.communication.entity.dos;

import com.leasing.common.base.entity.BaseDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: 文件导入设置子表 明细设置信息
 **/
@Entity
@Table(name="yc_imp_detail")
public class CbImpDetailDO extends BaseDO {

    @Id
    private String pkImpDetail;

    /**
     * 主表主键
     */
    private String pkImpSet;

    /**
     * 业务类型
     */
    private Integer impType;

    /**
     * 导入顺序
     */
    private Integer impOrder;

    /**
     * 接口实现bean name
     */
    private String beanName;

    /**
     * 对应数据库表名
     */
    private String tableName;

    /**
     * 对应的持久类对象
     */
    private String entityName;

    public String getPkImpDetail() {
        return pkImpDetail;
    }

    public void setPkImpDetail(String pkImpDetail) {
        this.pkImpDetail = pkImpDetail;
    }

    public String getPkImpSet() {
        return pkImpSet;
    }

    public void setPkImpSet(String pkImpSet) {
        this.pkImpSet = pkImpSet;
    }

    public Integer getImpType() {
        return impType;
    }

    public void setImpType(Integer impType) {
        this.impType = impType;
    }

    public Integer getImpOrder() {
        return impOrder;
    }

    public void setImpOrder(Integer impOrder) {
        this.impOrder = impOrder;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
