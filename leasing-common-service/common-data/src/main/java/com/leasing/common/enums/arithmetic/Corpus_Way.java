package com.leasing.common.enums.arithmetic;

import com.leasing.common.enums.base.EnumType;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:wangjc@yonyou.com
 * @description:不规则测算本金法计算方式
 **/
public class Corpus_Way extends EnumType {

    public Corpus_Way(int code, String label){
        super(code, label);
    }

    /**单利法-0*/
    public final static Corpus_Way SIMPLE_WAY = new Corpus_Way(0, "单利法");
    /**复利法-1*/
    public final static Corpus_Way AGAIN_WAY = new Corpus_Way(1, "复利法");

}
