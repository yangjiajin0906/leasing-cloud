package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:批处理信息中关联类型
 **/
public class RelatedType extends EnumType {

    public RelatedType(int code, String label) {
        super(code, label);
    }

    /**租赁合同*/
    public static final RelatedType LEASE_CONTRACT = new RelatedType(0,"租赁合同");
    /**贷款合同*/
    public static final RelatedType LOAD_CONTRACT = new RelatedType(1,"贷款合同");
    /**其他*/
    public static final RelatedType OTHERS = new RelatedType(-1,"其他");

}