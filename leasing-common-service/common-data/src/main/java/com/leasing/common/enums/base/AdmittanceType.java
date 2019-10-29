package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class AdmittanceType  extends EnumType {

    public AdmittanceType(int code, String lable) {
        super(code, lable);
    }

    public final static AdmittanceType FINANCE  = new AdmittanceType(1, "财务指标");
    public final static AdmittanceType MANAGEMENT = new AdmittanceType(2, "经营性指标");
    public final static AdmittanceType EXCEPTION = new AdmittanceType(3, "例外指标");
}

