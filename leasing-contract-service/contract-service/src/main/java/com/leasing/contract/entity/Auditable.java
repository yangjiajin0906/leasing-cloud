package com.leasing.contract.entity;

import lombok.Data;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * @project:leasing-cloud
 * @date:2019/9/25
 * @author:wangjc@yonyou.com
 * @description:
 **/
@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @LastModifiedBy
    protected U pk_operator;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date ts=new Date() ;
}