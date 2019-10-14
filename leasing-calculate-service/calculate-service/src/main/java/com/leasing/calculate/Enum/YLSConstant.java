package com.leasing.calculate.Enum;

import com.leasing.calculate.entity.CurrtypeRefVO;
import com.leasing.calculate.vo.EventTypeRefVO;

/**
 * @project:leasing-cloud
 * @date:2019/10/10
 * @author:Yjj@yonyou.com
 * @description:
 *
 * Title: 融资租赁管理系统<br>
 * Description: 租赁系统常量类<br>
 * Copyright: Copyright (c) 2013<br>
 * Company: Yonyou Financial<br>
 *
 **/
public class YLSConstant {
    // 参数字典
    public static final int PARAM_TYPE_DICTIONARY = 0;
    // 数据字典
    public static final int PARAM_TYPE_DATA = 1;
    // 运行参数
    public static final int PARAM_TYPE_RUN = 2;
    // UI设置
    public static final int PARAM_TYPE_UI = 3;

    // 人民币
    public static final CurrtypeRefVO RMB = new CurrtypeRefVO();

    /**
     * 保证金冲抵
     */
    public static final EventTypeRefVO DEPOST_CHARGE = new EventTypeRefVO();
    /**
     * 保证金退还
     */
    public static final EventTypeRefVO DEPOST_BACK = new EventTypeRefVO();


    static {
        RMB.setPk(ParamValueConstant.CURRENCY_RMB_PK);
        RMB.setName("人民币");
        RMB.setCode(ParamValueConstant.CURRENCY_RMB_CODE);
        //保证金冲抵
        DEPOST_CHARGE.setPk(ParamValueConstant.DEPOST_CHARGE_PK);
        DEPOST_CHARGE.setName(ParamValueConstant.DEPOST_CHARGE_NAME);
        DEPOST_CHARGE.setCode(ParamValueConstant.DEPOST_CHARGE_CODE);
        //保证金退还
        DEPOST_BACK.setPk(ParamValueConstant.DEPOST_BACK_PK);
        DEPOST_BACK.setName(ParamValueConstant.DEPOST_BACK_NAME);
        DEPOST_BACK.setCode(ParamValueConstant.DEPOST_BACK_CODE);

    }

    /** 公式规则 */
    public static final String MATCH_RULE = "match_rule";
    /** 会计分录-科目 */
    public static final String ACCSUBJ_RULE = "accsubj_rule";
    /** 会计分录-摘要 */
    public static final String MEMO_RULE = "memo_rule";
    /** 取值公式 */
    public static final String FACT_RULE = "fact_rule";
    /** 辅助核算 */
    public static final String FREE_VALUE_RULE = "free_value_rule";
    /** 业务流水影响因素 */
    public static final String EFFECT_RULE = "effect_rule";
    public static final String DATA_ITEM = "data_item";

    /** 合同辅助核算自定义项 */
    public static final String CONTRACT_FREE_VALUE = "0001AA1000000004O8BV";

    /** 项目辅助核算自定义项 */
    public static final String PROJECT_FREE_VALUE = "0001AA100000000504KK";

    /** 资金合同辅助核算自定义项 */
    public static final String CAPITAL_CONTRACT_FREE_VALUE = "0001AD1000000000T66M";

    /**
     * 江租核算主体pk(江苏金融租赁有限公司2013账薄)
     */
    public static final String GLORGBOOK_CONT_JZ ="0001LS100000000006KI";

    /** 常量- true */
    public static final String CON_TRUE = "true";
    /** 常量- 是 */
    public static final String CON_TRUE_CN = "是";

    /** 常量- 0 */
    public static final String CUSTFLAG_ZERO = "0";
    /** 常量- 4 */
    public static final String CUSTFLAG_FOUR = "4";

    /** 科目体系 */
    public static final String LEASE_MAKE = "租赁业务科目方案";
    /** 集团pk*/
    public static final String GROUP_PK = "0001";

    /**
     * 限额方案类型编码
     */
    public static final String LIMITTYPE_2640001 = "2640001";
    public static final String LIMITTYPE_2640002 = "2640002";
    public static final String LIMITTYPE_2640003 = "2640003";
    public static final String LIMITTYPE_2640004 = "2640004";



    /**
     * 资金余额表中用于记录预付款的专用主键
     */
    public static final String CAPITAL_PREPAID_PK = "00000000000000000000";

    /** INSERT  【 wangjj】 【2017年1月10日】 【BUG修改】<BUG号 ZTYW-501号> */
    /** 投资产品名称辅助核算自定义项 *///0001AA1000000009KSBN  0001AA1000000009DQ6I
    public static final String INVEST_FREE_VALUE = "0001A91000000009KSBN";
    /** INSERT  END */
    /** 常量- 0 */
    public static final String CUSTFLAG_TWO = "2";
    /** 常量- 4 */
    public static final String CUSTFLAG_THREE = "3";
}