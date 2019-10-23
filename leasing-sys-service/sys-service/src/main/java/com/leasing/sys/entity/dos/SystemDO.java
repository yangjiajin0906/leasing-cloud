package com.leasing.sys.entity.dos;

import com.leasing.common.base.entity.BaseBusinessDO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Entity
@Table(name="sm_system")
public class SystemDO extends BaseBusinessDO {
    public String getTableName() {
        return "sm_system";
    }

    public String getPk(){return pkSystem;}

    public void setPk(String pkSystem){
        this.pkSystem=pkSystem;
    }

    @Id
    private String pkSystem;

    private String systemCode;

    private String systemName;

    public String getPkSystem() {
        return pkSystem;
    }

    public void setPkSystem(String pkSystem) {
        this.pkSystem = pkSystem;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}