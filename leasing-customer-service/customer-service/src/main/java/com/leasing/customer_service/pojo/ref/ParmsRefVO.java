package com.leasing.customer_service.pojo.ref;

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
    @Column (name = "pkParameter")
    private String pk;

    @Column(name = "paramName")
    private String name;

    @Column(name = "paramCode")
    private String code;
}