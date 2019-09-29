package com.leasing.customer_service.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-09-25
 * @author:zhangzhhn@yonyou.com
 * @description: 机构参照VO
 **/

@Entity
@Table(name = "sm_org")
@NoArgsConstructor
@Data
public class OrgRefVO {

    @Id
    @Column(name = "pk_org")
    private String pkOrg;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "org_code")
    private String orgCode;
}