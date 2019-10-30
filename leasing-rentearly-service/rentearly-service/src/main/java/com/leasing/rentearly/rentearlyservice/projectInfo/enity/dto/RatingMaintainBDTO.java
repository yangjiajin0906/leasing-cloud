package com.leasing.rentearly.rentearlyservice.projectInfo.enity.dto;

import com.leasing.common.base.entity.BaseEntity;
import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 客户评级参照
 **/
@Entity
@Table(name = "yls_rating_maintain_b")
public class RatingMaintainBDTO extends BaseEntity {
    @Id
    @Column(name = "pk_rating_maintain_b")
    public String pkRatingMaintainB;

    public String serialNumber;

    public String descriptorData;

//    public RatingMaintainBDTO(String pkRatingMaintainB, String serialNumber, String descriptorData) {
//        this.pkRatingMaintainB = pkRatingMaintainB;
//        this.serialNumber = serialNumber;
//        this.descriptorData = descriptorData;
//        this.setCode(serialNumber);
//        this.setName(descriptorData);
//        this.setPk(pkRatingMaintainB);
//    }

    public String getPkRatingMaintainB() {
        return pkRatingMaintainB;
    }

    public void setPkRatingMaintainB(String pkRatingMaintainB) {
        this.pkRatingMaintainB = pkRatingMaintainB;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescriptorData() {
        return descriptorData;
    }

    public void setDescriptorData(String descriptorData) {
        this.descriptorData = descriptorData;
    }

    @Override
    public String getPk() {
        return pkRatingMaintainB;
    }

    @Override
    public void setPk(String pk) {
        this.pkRatingMaintainB = pk;
    }
}
