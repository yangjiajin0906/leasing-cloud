package com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO;

import com.leasing.common.base.entity.BaseRefVO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:jiaoshy@yonyou.com
 * @description: 厂商协议参照
 **/
@Entity
@Table(name = "(" +
        "SELECT CNT.PK_CONTRACT PK_CONTRACT," +
        "       CNT.CONT_NAME PROTOCOL_NAME," +
        "       CNT.CONT_CODE PROTOCOL_CODE," +
        "       PI.PROJECT_NAME APPROVAL_NAME," +
        "       PI.PROJECT_CODE APPROVAL_CODE," +
        "       CNTSPR.PROTOCOL_TYPE PROTOCOL_TYPE," +
        "       CNT.CONT_STATUS CONT_STATUS" +
        "  FROM YLS_CONTRACT CNT" +
        " INNER JOIN YLS_CONTRACT_SUPPLIER CNTSPR" +
        "    ON CNTSPR.PK_CONTRACT = CNT.PK_CONTRACT" +
        " INNER JOIN YLS_PROJECT_INFO PI" +
        "    ON PI.PK_PROJECT_INFO = CNT.PK_PROJECT)")
public class ProviderConferRefVO extends BaseRefVO {

    @Id
    public String pkContract;

    public String protocolCode;

    public String protocolName;

    public String approvalCode;

    public String approvalName;

    public Short protocolType;


//    public ProviderConferRefVO(String pkContract, String protocolCode, String protocolName, String approvalCode, String approvalName, Short protocolType) {
//        this.pkContract = pkContract;
//        this.protocolCode = protocolCode;
//        this.protocolName = protocolName;
//        this.approvalCode = approvalCode;
//        this.approvalName = approvalName;
//        this.protocolType = protocolType;
//        this.setPk(pkContract);
//        this.setApprovalCode(protocolCode);
//        this.setApprovalName(protocolName);
//    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

    public String getProtocolCode() {
        return protocolCode;
    }

    public void setProtocolCode(String protocolCode) {
        this.protocolCode = protocolCode;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public Short getProtocolType() {
        return protocolType;
    }

    public void setProtocolType(Short protocolType) {
        this.protocolType = protocolType;
    }
}
