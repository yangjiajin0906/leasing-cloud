package com.leasing.common.entity.common.vo;

import com.leasing.common.base.entity.BaseBusinessVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:系统类VO
 **/
@Entity
@Table(name="yl_system")
public class SystemVO extends BaseBusinessVO {
    public String getTableName() {
        return "yl_system";
    }

    public String getPk(){return pkSystem;}

    public void setPk(String pkSystem){
        this.pkSystem=pkSystem;
    }

    @Id
    private String pkSystem;

    private String systemCode;

    private String systemName;

    public SystemVO(){}

    public SystemVO(String pkSystem){
        this.pkSystem = pkSystem;
    }

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