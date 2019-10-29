package com.leasing.common.ref.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/18
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class OrgrefVO {
    private String pkOrg;
    private String orgCode;
    private String orgName;

    public String getPkOrg() {
        return pkOrg;
    }

    public void setPkOrg(String pkOrg) {
        this.pkOrg = pkOrg;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public OrgrefVO(String pkOrg,String orgCode,String orgName){
        this.pkOrg=pkOrg;
        this.orgCode=orgCode;
        this.orgName=orgName;
    }
    public OrgrefVO(){}
}