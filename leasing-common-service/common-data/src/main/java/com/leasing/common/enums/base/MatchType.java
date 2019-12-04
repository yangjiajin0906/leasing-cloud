package com.leasing.common.enums.base;

/**
 * @project:leasing-cloud
 * @date:2019/10/22
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public enum MatchType {
    equal,        // filed = value
    //下面四个用于Number类型的比较
    gt,   // filed > value
    ge,   // field >= value
    lt,              // field < value
    le,      // field <= value

    notEqual,            // field != value
    like,   // field like value
    notLike,    // field not like value

    // 下面四个用于可比较类型(Comparable)的比较
    greaterThan,        // field > value
    greaterThanOrEqualTo,   // field >= value
    lessThan,               // field < value
    lessThanOrEqualTo   // field <= value
}
