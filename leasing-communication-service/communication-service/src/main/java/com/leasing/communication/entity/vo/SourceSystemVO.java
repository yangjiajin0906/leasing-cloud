package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Entity
@Table(name="yc_source_system")
public class SourceSystemVO extends BaseVO {

    @Id
    private String pkSourceSystem;

    private String systemName;

    private String systemCode;


    public String getPkSourceSystem() {
        return pkSourceSystem;
    }

    public void setPkSourceSystem(String pkSourceSystem) {
        this.pkSourceSystem = pkSourceSystem;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    @Override
    public String getPk() {
        return null;
    }

    @Override
    public void setPk(String pk) {

    }
}
