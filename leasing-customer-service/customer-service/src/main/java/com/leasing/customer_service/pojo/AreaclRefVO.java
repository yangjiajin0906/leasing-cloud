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
@Table(name = "bd_areacl")
@Entity
@NoArgsConstructor
public class AreaclRefVO {

    @Id
    @Column(name = "pk_areacl")
    private String pk;

    @Column(name = "areaclname")
    private String name;

    @Column(name = "areaclcode")
    private String code;
}