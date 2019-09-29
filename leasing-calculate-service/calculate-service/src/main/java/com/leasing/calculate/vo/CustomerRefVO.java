package com.leasing.calculate.vo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @project:leasing-cloud 客户基本信息表Ref类
 * @date:2019/9/25
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="yls_customer")
public class CustomerRefVO {
    /**
     * 客户主键
     */
    @Id
    public String pk_customer;

    /**
     * 客户编号
     */
    public String customer_code;

    /**
     * 客户名称
     */
    public String customer_name;


}