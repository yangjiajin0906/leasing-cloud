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
@Table(name = "yls_parameter")
@NoArgsConstructor
public class ParmsRefVO {

    @Id
    @Column (name = "pk_parameter")
    private String pk;

    @Column(name = "param_name")
    private String name;

    @Column(name = "param_code")
    private String code;
}