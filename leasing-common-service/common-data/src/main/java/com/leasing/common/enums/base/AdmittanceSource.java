package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:
 **/
public class AdmittanceSource  extends EnumType {

    public AdmittanceSource(int code, String lable) {
        super(code, lable);
    }

    public final static AdmittanceSource FINANCE  = new AdmittanceSource(1, "承租人");
    public final static AdmittanceSource MANAGEMENT = new AdmittanceSource(2, "担保人");
}
