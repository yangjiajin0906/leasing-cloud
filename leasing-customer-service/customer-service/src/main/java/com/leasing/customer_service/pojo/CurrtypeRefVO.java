package com.leasing.customer_service.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Data
@Entity
@NoArgsConstructor
@Table(name = "bd_currtype")
public class CurrtypeRefVO {

    @Id
    @Column(name = "pk_currtype")
    private String pk;

    @Column(name = "currtypename")
    private String name;

    @Column(name = "currtypecode")
    private String code;
}