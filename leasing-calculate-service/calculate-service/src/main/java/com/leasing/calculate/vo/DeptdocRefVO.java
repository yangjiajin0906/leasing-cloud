package com.leasing.calculate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud 部门RefVO
 * @date:2019/9/27
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="bd_deptdoc")
public class DeptdocRefVO {
    @Id
    @Column(name="pk_deptdoc")
    public String pk;

    @Column(name="deptcode")
    public String code;

    @Column(name="deptname")
    public String name;
}