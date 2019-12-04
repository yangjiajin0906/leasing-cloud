package com.leasing.common.refvo.base;

public class UserrefVO {
    private String pkUser;
    private String userName;
    private String userCode;
    private OrgrefVO org;

    public UserrefVO(String pkUser,String userName,String userCode,String pkOrg,String orgName,String orgCode){
        this.pkUser=pkUser;
        this.userName=userName;
        this.userCode=userCode;
        OrgrefVO org =new OrgrefVO();
        org.setPkOrg(pkOrg);
        org.setOrgName(orgName);
        org.setOrgCode(orgCode);
        this.org=org;
    }

    public String getPkUser() {
        return pkUser;
    }

    public void setPkUser(String pkUser) {
        this.pkUser = pkUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public OrgrefVO getOrg() {
        return org;
    }

    public void setOrg(OrgrefVO org) {
        this.org = org;
    }
}
