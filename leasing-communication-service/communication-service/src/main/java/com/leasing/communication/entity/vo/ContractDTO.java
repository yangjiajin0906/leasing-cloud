package com.leasing.communication.entity.vo;

import com.leasing.common.base.entity.BaseVO;

import javax.persistence.*;

/**
 * @project:leasing-cloud
 * @date:2019/11/28
 * @author:Yjj@yonyou.com
 * @description: 合同
 **/
@Entity
@Table(name="yc_contract")
public class ContractDTO extends BaseVO{
    /**
     * 合同主键
     */
    @Id
    public String pkContract;

//    /**
//     * 合同名称
//     */
//    public String contName;

    /**
     * 起租流程
     */
    public Short leaseFlow;

    /**
     * 合同编号
     */

    public String contCode;

    @Override
    public String getPk() {
        return pkContract;
    }

    @Override
    public void setPk(String pk) {
        this.pkContract = pk;
    }

    public String getPkContract() {
        return pkContract;
    }

    public void setPkContract(String pkContract) {
        this.pkContract = pkContract;
    }

//    public String getContName() {
//        return contName;
//    }
//
//    public void setContName(String contName) {
//        this.contName = contName;
//    }

    public String getContCode() {
        return contCode;
    }

    public void setContCode(String contCode) {
        this.contCode = contCode;
    }

    public Short getLeaseFlow() {
        return leaseFlow;
    }

    public void setLeaseFlow(Short leaseFlow) {
        this.leaseFlow = leaseFlow;
    }


}