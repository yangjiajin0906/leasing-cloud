package com.leasing.customer_service.utils;

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
