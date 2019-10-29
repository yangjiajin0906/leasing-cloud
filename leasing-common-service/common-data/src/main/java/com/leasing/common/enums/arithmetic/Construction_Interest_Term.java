package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:在建期利率按照期利率计算还是日利率
 **/
public class Construction_Interest_Term extends EnumType {

    public Construction_Interest_Term(int code, String label) {
        super(code, label);
    }
    /**
     * 期利率计算-0
     */
    public final static Construction_Interest_Term IT_TERM = new Construction_Interest_Term(0, "期利率计算");
    /**
     * 支出-1
     */
    public final static Construction_Interest_Term IT_DAY = new Construction_Interest_Term(1, "日利率计算");

}
