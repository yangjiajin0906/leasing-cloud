//package com.leasing.calculate.utils;
//
//import com.leasing.calculate.Enum.Billstatus;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.TransactionCallback;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static com.leasing.calculate.utils.GeneralOperatUtils.getCurDate;
//import static com.leasing.calculate.utils.GeneralOperatUtils.getCurTs;
//
///**
// * @project:leasing-cloud
// * @date:2019/10/9
// * @author:Yjj@yonyou.com
// * @description:
// **/
//public class CodeRuleUtil {
//
//    /**
//     * 生成编号规则
//     * @param obj
//     * @return
//     *
//     * <p>调用方法：继承LasBaseBusinessBO，调用getCodeRule(map);
//     *
//     * <p>调用规则：Map封装一下信息<br>
//     * 2、CodeRuleKey.FUN_CODE：节点编号<br>
//     * 3、CodeRuleKey.VARIABLE_NAME：变量名称<br>
//     * 4、其他的安装在rule.xml中的存入值<br>
//     * 注：节点编号与变量名称一定要有，因为是通过这两因素确定编码规则的<br>
//     *
//     * <p>举例：收租编号<br>
//     * 规则：客户号 + 年份 + 顺序号<br>
//     * Map map = new HashMap();<br>
//     * map.put(CodeRuleKey.FUN_CODE, getClientENV().getValue(CodeRuleKey.FUN_CODE));<br>
//     * map.put(CodeRuleKey.VARIABLE_NAME, "收租编号");<br>
//     * map.put(CodeRuleKey.?, "C1001"); <br>
//     */
//    public String getCodeRule(final Map<String, String> rootParam) {
//        final String variableName = rootParam.get(CodeRuleKey.VARIABLE_NAME);
//        final String funCode = rootParam.get(CodeRuleKey.FUN_CODE);
//        final String currentDate = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
//
//        /*如果传入的参数中有"制定日期",需要对指定的日期进行格式分析*/
//        if (rootParam.containsKey(CodeRuleKey.FIX_DATE)) {
//            String fixDate = rootParam.get(CodeRuleKey.FIX_DATE);
//            if (StringUtils.isNotBlank(fixDate)) {
//                rootParam.put(CodeRuleKey.FIX_DATE, fixDate.replace("-", ""));
//            }
//        }
//
//        /*
//         * 之所以不用VO加载，是因为随着时间的推移，子表的数据会越来越大。
//         */
//        //获取编码规则设置主表信息
//        Map<String,Object> codeRuleMap = getCodeRule(funCode, variableName);
//        //获取编码规则设置子表非序列号的设置信息
//        List<Map<String,Object>> noLiquidTypes = getCodeRuleTypeWithNoLiquid((String)codeRuleMap.get("PK_CODERULE"));
//
//        //解析非序列号的编号设置
//        if (!noLiquidTypes.isEmpty()) {
//            String code = "";      // 规则CODE
//            Integer bitNum = null; // 位数
//            String fillSign = "";  // 补位符
//            for (Map<String,Object> codeRuleType : noLiquidTypes) {
//                code = (String)codeRuleType.get("RULE_CODE");// 规则CODE
//                if (codeRuleType.get("BIT_NUMBER") != null) {
//                    bitNum = ((BigDecimal)codeRuleType.get("BIT_NUMBER")).intValue();// 位数
//                }else{
//                    bitNum=null;
//                }
//                fillSign = TypeCast.toString(codeRuleType.get("FILL_SIGN"));// 补位符
//
//                if (CodeRuleKey.YEAR.equals(code)) {//年份
//                    String year = getCurDate().substring(0, 4);
//                    rootParam.put(code, year);
//                } else if (CodeRuleKey.MONTH.equals(code)) {//月份
//                    String month = getCurDate().substring(5, 7);
//                    rootParam.put(code, month);
//                } else if (CodeRuleKey.DATE.equals(code)) {//日期
//                    String dateValue = currentDate;
//                    if (bitNum != null) {
//                        dateValue = dateValue.substring((dateValue.length() - bitNum), dateValue.length());
//                    }
//                    rootParam.put(code, dateValue);
//                }  else {
//                    if (bitNum != null) {
//                        String value = rootParam.get(code);
//                        if (StringUtils.isNotBlank(value)) {
//                            int len = value.trim().length();
//                            if (bitNum > len) {
//                                //如果所取尾数大于value本身的长度需要补位
//                                StringBuffer sb = new StringBuffer();
//                                for (int j = 0; j < (bitNum - len); j++) {
//                                    sb.append(fillSign);
//                                }
//                                sb.append(value);
//                                rootParam.put(code, sb.toString());
//                            } else {
//                                value = value.substring((value.length() - bitNum), value.length());
//                                rootParam.put(code, value);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        String codeRuleName = (String)codeRuleMap.get("CODE_RULE_NAME");
//        String rule = FormulaUtils.getStrSql(codeRuleName, "codeRuleName");// 翻译编码规则公式
//        rootParam.put(CodeRuleKey.LIQUID, "");//先放一个空字符串，否则解析"referSort"最后面会有"null"
//        String referSort = (String)FormulaUtils.getValue(rule, rootParam);//编号前缀
//
//        //处理顺序号
//        String liquid = dealLiquid((String)codeRuleMap.get("PK_CODERULE"), referSort);
//        rootParam.put(CodeRuleKey.LIQUID, liquid.toString());
//
//        String code = String.valueOf(FormulaUtils.getValue(rule, rootParam));
//        return code;
//
//    }
//
//    /**
//     * <b>根据节点编号及参数名称获取编码规则设置主表信息</b>
//     * @param pk_funcregister String 节点主键
//     * @param variableName String 参数名称
//     * @return Map
//     */
//    private  Map<String,Object> getCodeRule(String fun_code,String variableName) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" SELECT  ");
//        sql.append("   A.PK_CODERULE PK_CODERULE, ");
//        sql.append("   A.CODE_RULE_NAME CODE_RULE_NAME ");
//        sql.append(" FROM YLS_CODERULE A ");
//        sql.append(" INNER JOIN SM_FUNCREGISTER B ON A.BUSINESS_POINT = B.CFUNID ");
//        sql.append(" WHERE B.FUN_CODE = ? ");
//        sql.append(" AND A.VARIABLE_NAME = ? ");
//        sql.append(" AND A.BILLSTATUS = ? ");
//        Object[] args = new Object[] { fun_code, variableName, Billstatus.CHECK.getShort() };
//        List list = getJdbcTemplate().queryForList(sql.toString(), args);;
//        if (list != null && !list.isEmpty()) {
//            return (Map<String,Object>)list.get(0);
//        } else {
//            throw new BusinessException("【" + variableName + "】编码规则设置未定义或者丢失，请联系管理员。");
//        }
//    }
//
//    /**
//     * <b>获取非序列号的设置信息</b>
//     * @param pk_coderule
//     * @return
//     */
//    private List<Map<String,Object>> getCodeRuleTypeWithNoLiquid(String pk_coderule) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" SELECT  ");
//        sql.append("   RULE_CODE, ");
//        sql.append("   BIT_NUMBER, ");
//        sql.append("   FILL_SIGN  ");
//        sql.append(" FROM YLS_CODERULE_TYPE A ");
//        sql.append(" WHERE PK_CODERULE = ? ");
//        sql.append(" AND RULE_CODE <> ? ");
//
//        Object[] args = new Object[] {pk_coderule,CodeRuleKey.LIQUID};
//        return getJdbcTemplate().queryForList(sql.toString(), args);
//    }
//
//    /**
//     * <b>处理编码规则的序列号</b>
//     * <p>采用现成安全和独立事物
//     * @param rootMap
//     */
//    private synchronized String dealLiquid(final String pk_coderule,final String referSort) {
//        TransactionCallback callback = new TransactionCallback() {
//
//            @Override
//            public Object doInTransaction(TransactionStatus arg0) {
//                //获取序列号设置信息
//                List<Map<String,Object>> liquidTypes = getCodeRuleTypeWithLiquid(pk_coderule,referSort);
//                StringBuffer liquid = new StringBuffer();
//                if (!liquidTypes.isEmpty()) {
//                    Map<String,Object> originalMap = null;//初始设置的
//                    Map<String,Object> currentUsedMap = null;//当前使用
//                    boolean isCopy = true;
//                    for (Map map : liquidTypes) {
//                        String referSort = (String)map.get("REFER_SORT");
//                        if (StringUtils.isNotBlank(referSort)) {
//                            if (currentUsedMap == null) {
//                                currentUsedMap = map;
//                            } else {
//                                Integer initValue_1 = null;
//                                if (map.get("INITIAL_VALUE") != null) {
//                                    initValue_1 = ((BigDecimal)map.get("INITIAL_VALUE")).intValue();
//                                }
//                                initValue_1 = initValue_1 == null ? 0 : initValue_1;
//                                Integer initValue_2 = null;
//                                if (currentUsedMap.get("INITIAL_VALUE") != null) {
//                                    initValue_2 = ((BigDecimal)currentUsedMap.get("INITIAL_VALUE")).intValue();
//                                }
//                                initValue_2 = initValue_2 == null ? 0 : initValue_2;
//
//                                if (initValue_1.compareTo(initValue_2) > 0) {
//                                    currentUsedMap = map;
//                                }
//                            }
//                            isCopy = false;
//                        } else {
//                            originalMap = map;
//                        }
//                    }
//
//                    if (currentUsedMap != null) {
//                        originalMap = currentUsedMap;
//                    }
//
//                    String fillSign = (String)originalMap.get("FILL_SIGN");
//                    Integer bitNum = null;
//                    if (originalMap.get("BIT_NUMBER") != null) {
//                        bitNum = ((BigDecimal)originalMap.get("BIT_NUMBER")).intValue();
//                    }
//                    Integer initValue = null;
//                    if (originalMap.get("INITIAL_VALUE") != null) {
//                        initValue = ((BigDecimal)originalMap.get("INITIAL_VALUE")).intValue();
//                    }
//                    initValue = initValue == null ? 1 : initValue;
//                    if (bitNum != null) {
//                        int length = String.valueOf(initValue).length();
//                        if (bitNum > length) {
//                            for (int i = 0; i < bitNum - length; i++) {
//                                if (StringUtils.isNotBlank(fillSign)) {
//                                    liquid.append(fillSign);
//                                } else {
//                                    liquid.append("0");
//                                }
//                            }
//                        }
//                    }
//                    liquid.append(initValue);
//
//                    if (isCopy) {
//                        originalMap.put("INITIAL_VALUE", ++initValue);
//                        originalMap.put("REFER_SORT", referSort);
//                        insertCoderuleType(originalMap);
//                    } else {
//                        originalMap.put("INITIAL_VALUE", ++initValue);
//                        updateCoderuleType(originalMap);
//                    }
//
//                }
//                return liquid.toString();
//            }
//
//        };
//        return (String)independenceTrasaction(callback);
//    }
//
//    /**
//     * <b>获取序列号的设置信息</b>
//     * @param pk_coderule
//     * @return
//     */
//    private List<Map<String,Object>> getCodeRuleTypeWithLiquid(String pk_coderule,String refer_sort) {
//        StringBuffer sql = new StringBuffer();
//        sql.append(" SELECT  ");
//        sql.append("   PK_CODERULE_TYPE, ");
//        sql.append("   PK_CODERULE, ");
//        sql.append("   CODERULE_TYPE, ");
//        sql.append("   RULE_CODE, ");
//        sql.append("   BIT_NUMBER, ");
//        sql.append("   FILL_SIGN, ");
//        sql.append("   REFER_SORT, ");
//        sql.append("   INITIAL_VALUE ");
//        sql.append(" FROM YLS_CODERULE_TYPE A ");
//        sql.append(" WHERE PK_CODERULE = ? ");
//        sql.append(" AND RULE_CODE = ? ");
//        sql.append(" AND (REFER_SORT IS NULL OR REFER_SORT = ?) ");
//        sql.append(" FOR UPDATE");
//
//        Object[] args = new Object[] {pk_coderule,CodeRuleKey.LIQUID,refer_sort};
//        return getJdbcTemplate().queryForList(sql.toString(), args);
//    }
//
//    /**
//     * 插入编码规则设置
//     * @param coderuletypeMap
//     */
//    private  void insertCoderuleType(Map<String,Object> coderuletypeMap) {
//        Map params = new HashMap();
//        params.put("PK_CODERULE_TYPE", UUIDUtil.getUUID());
//        params.put("PK_CODERULE", coderuletypeMap.get("PK_CODERULE"));
//        params.put("CODERULE_TYPE", coderuletypeMap.get("CODERULE_TYPE"));
//        params.put("RULE_CODE", coderuletypeMap.get("RULE_CODE"));
//        params.put("BIT_NUMBER", coderuletypeMap.get("BIT_NUMBER"));
//        params.put("FILL_SIGN", coderuletypeMap.get("FILL_SIGN"));
//        params.put("INITIAL_VALUE", coderuletypeMap.get("INITIAL_VALUE"));
//        params.put("REFER_SORT", coderuletypeMap.get("REFER_SORT"));
//        params.put("TS", getCurTs());
//        insertTable("YLS_CODERULE_TYPE", params);
//    }
//    /**
//     * 更新编码规则设置
//     * @param coderuletypeMap
//     */
//    private void updateCoderuleType(Map<String,Object> coderuletypeMap) {
//        String sql = "UPDATE YLS_CODERULE_TYPE SET INITIAL_VALUE = ? ,TS = ? WHERE PK_CODERULE_TYPE = ?";
//
//        Object[] args = {
//                coderuletypeMap.get("INITIAL_VALUE"),
//                getCurTs(),
//                coderuletypeMap.get("PK_CODERULE_TYPE")
//        };
//        getJdbcTemplate().update(sql.toString(), args);
//    }
//
//}