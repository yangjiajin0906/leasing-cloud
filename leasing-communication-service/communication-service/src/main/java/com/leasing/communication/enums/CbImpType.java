package com.leasing.communication.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-12-8
 * @author:lvcna@yonyou.com
 * @description: C端业务导入单据类型
 **/
public enum CbImpType {

    //合同
    CONTRACT(0, "CONTRACT", "合同业务"),
    //客户
    CUSTOMER(1, "CUSTOMER", "客户业务"),
    //开票
    INVOICE(2, "INVOICE", "开票业务"),
    //收支计划
    INOUTPLAN(3, "INOUTPLAN", "收款计划业务"),
    //付款
    PAY(4, "PAY", "付款业务"),
    //保证金收取
    MARGINCOLLECTION(5, "MARGINCOLLECTION", "保证金收取业务"),
    //保证金冲抵
    MARGINOFFSET(6, "MARGINOFFSET", "保证金冲抵业务"),
    //逾期
    OVERDUECONTRACT(7, "OVERDUECONTRACT", "逾期业务"),
    //不良合同
    BADCONTRACT(8, "BADCONTRACT", "不良合同类型"),
    //提前结清
    EARLYSETTLEMENT(9, "EARLYSETTLEMENT", "合同类型"),
    ;

    private Integer type;
    private String business;
    private String busiType;

    CbImpType(Integer type, String business, String busiType){
        this.type = type;
        this.business = business;
        this.busiType = busiType;
    }

    public Integer getType() {
        return type;
    }

    public String getBusiness() {
        return business;
    }

    public String getBusiType() {
        return busiType;
    }

    /**
     * 根据type获取枚举实例
     * @param type
     * @return
     */
    public static CbImpType getImpType(Integer type){
        for(CbImpType cbImpType : CbImpType.values()){
            if(type.equals(cbImpType.getType())){
                return cbImpType;
            }
        }
        return null;
    }

    /**
     * 缓存Type : Business 信息
     * @return
     */
    public static Map<Integer,String> cacheType(){
        Map<Integer,String> map = new HashMap();
        for(CbImpType cbImpType : CbImpType.values()){
            map.put(cbImpType.getType(), cbImpType.getBusiness());
        }
        return map;
    }

    /**
     * 缓存Type : BusiType 信息
     * @return
     */
    public static Map<Integer,String> cacheBusiType(){
        Map<Integer,String> map = new HashMap();
        for(CbImpType cbImpType : CbImpType.values()){
            map.put(cbImpType.getType(), cbImpType.getBusiType());
        }
        return map;
    }
}
