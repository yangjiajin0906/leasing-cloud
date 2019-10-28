package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:在建期利息处理方式
 **/
public class Construction_Interest_Method extends EnumType {

    public Construction_Interest_Method(int code, String label) {
        super(code, label);
    }
    /**
     * 非资本化-0
     */
    public final static Construction_Interest_Method  CAPITALIZATION_NON = new Construction_Interest_Method(0, "非资本化");
    /**
     * 资本化-1
     */
    public final static Construction_Interest_Method  CAPITALIZATION = new Construction_Interest_Method(1, "资本化");


}