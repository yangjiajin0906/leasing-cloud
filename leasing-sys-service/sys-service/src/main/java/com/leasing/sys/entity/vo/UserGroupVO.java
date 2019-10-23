//package com.leasing.common.entity.sys;
//
//import com.leasing.common.entity.base.BusinessEntity;
//import com.leasing.common.entity.foundation.UserVO;
//
//import javax.persistence.*;
//
///**
// * @project:leasing-cloud
// * @date:2019/10/15
// * @author:wangjc@yonyou.com
// * @description:
// **/
//@Entity
//@Table(name="sm_user_group")
//public class UserGroupVO extends BusinessEntity {
//    //关联pk暂时为String  需修改为所在对象的VO
//    public String getTableName() {
//        return "sm_user_group";
//    }
//
//    public String getPk(){return pkUserGroup;}
//
//    public void setPk(String pkUserGroup){
//        this.pkUserGroup=pkUserGroup;
//    }
//
//    @Id
//    private String pkUserGroup;
//
//    @ManyToOne()
//    @JoinColumn(name = "pkUser")
//    private UserVO pkUser;
//
//    private String groupCode;
//
//    private String groupName;
//
//    public UserGroupVO(){}
//
//    public String getPkUserGroup() {
//        return pkUserGroup;
//    }
//
//    public void setPkUserGroup(String pkUserGroup) {
//        this.pkUserGroup = pkUserGroup;
//    }
//
//    public UserVO getPkUser() {
//        return pkUser;
//    }
//
//    public void setPkUser(UserVO pkUser) {
//        this.pkUser = pkUser;
//    }
//
//    public String getGroupCode() {
//        return groupCode;
//    }
//
//    public void setGroupCode(String groupCode) {
//        this.groupCode = groupCode;
//    }
//
//    public String getGroupName() {
//        return groupName;
//    }
//
//    public void setGroupName(String groupName) {
//        this.groupName = groupName;
//    }
//}