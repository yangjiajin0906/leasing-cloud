package com.leasing.calculate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/9/27
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sm_user_view")
public class UserRefVO {
    @Id
    public String pk_user;

    public Short user_role;
    //public DeptTreeRefVO pk_deptdoc;
    //public Short busi_role;
    @ManyToOne()
    @JoinColumn(name = "pk_org", referencedColumnName = "pk_org")
    public OrgRefVO pk_org;//机构
    //public boolean isAdmin;

    //public OrgRefVO org_name;
    //public DeptTreeRefVO deptname;
    public String psnname;
    //public String psndeptname;
    public String pk_userde_user;
    public String pk_userde_code;
    public String pk_userde_name;
    /**ADD WJJ 20160815 发送消息通知 */
    public String cuserid;
}