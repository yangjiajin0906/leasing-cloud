package com.leasing.common.utils.sys;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.leasing.common.entity.common.dos.CoderuleTypeDO;
import com.leasing.common.service.sys.CoderuleService;
import com.leasing.common.enums.constant.CodeRuleKey;
import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.base.TypeCast;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


import javax.annotation.PostConstruct;

import static com.leasing.common.utils.base.DateUtils.getCurDate;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:编码规则工具类实现
 **/
@Component
public class CodeRuleUtil {

    @Autowired
    CoderuleService coderuleService;

    public static CodeRuleUtil codeRuleUtil;

    @PostConstruct
    public void init(){
        codeRuleUtil = this;
    }

    /**
     * 生成编号规则
     * @param
     * @return
     *
     * <p>调用方法：调用getCodeRule(map);
     *
     * <p>调用规则：Map封装一下信息<br>
     * 2、CodeRuleKey.FUN_CODE：节点编号<br>
     * 3、CodeRuleKey.VARIABLE_NAME：变量名称<br>
     * 4、其他的安装在rule.xml中的存入值<br>
     * 注：节点编号与变量名称一定要有，因为是通过这两因素确定编码规则的<br>
     *
     * <p>举例：收租编号<br>
     * 规则：客户号 + 年份 + 顺序号<br>
     * Map map = new HashMap();<br>
     * map.put(CodeRuleKey.FUN_CODE, getClientENV().getValue(CodeRuleKey.FUN_CODE));<br>
     * map.put(CodeRuleKey.VARIABLE_NAME, "收租编号");<br>
     * map.put(CodeRuleKey.?, "C1001"); <br>
     */
    public static String getCodeRule(final Map<String, String> rootParam) {
        final String variableName = rootParam.get(CodeRuleKey.VARIABLE_NAME);
        final String funCode = rootParam.get(CodeRuleKey.FUN_CODE);
        final String currentDate = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());

        /*如果传入的参数中有"制定日期",需要对指定的日期进行格式分析*/
        if (rootParam.containsKey(CodeRuleKey.FIX_DATE)) {
            String fixDate = rootParam.get(CodeRuleKey.FIX_DATE);
            if (StringUtils.isNotBlank(fixDate)) {
                rootParam.put(CodeRuleKey.FIX_DATE, fixDate.replace("-", ""));
            }
        }

        /*
         * 之所以不用VO加载，是因为随着时间的推移，子表的数据会越来越大。
         */
        //获取编码规则设置主表信息
        Map<String,Object> codeRuleMap = getCodeRule(funCode, variableName);
        //获取编码规则设置子表非序列号的设置信息
        List<Map<String,Object>> noLiquidTypes = getCodeRuleTypeWithNoLiquid((String)codeRuleMap.get("PK_CODERULE"));

        //解析非序列号的编号设置
        if (!noLiquidTypes.isEmpty()) {
            String code = "";      // 规则CODE
            Integer bitNum = null; // 位数
            String fillSign = "";  // 补位符
            for (Map<String,Object> codeRuleType : noLiquidTypes) {
                code = (String)codeRuleType.get("RULE_CODE");// 规则CODE
                if (codeRuleType.get("BIT_NUMBER") != null) {
                    bitNum = ((BigDecimal)codeRuleType.get("BIT_NUMBER")).intValue();// 位数
                }else{
                    bitNum=null;
                }
                fillSign = TypeCast.toString(codeRuleType.get("FILL_SIGN"));// 补位符

                if (CodeRuleKey.YEAR.equals(code)) {//年份
                    String year = getCurDate().substring(0, 4);
                    rootParam.put(code, year);
                } else if (CodeRuleKey.MONTH.equals(code)) {//月份
                    String month = getCurDate().substring(5, 7);
                    rootParam.put(code, month);
                } else if (CodeRuleKey.DATE.equals(code)) {//日期
                    String dateValue = currentDate;
                    if (bitNum != null) {
                        dateValue = dateValue.substring((dateValue.length() - bitNum), dateValue.length());
                    }
                    rootParam.put(code, dateValue);
                }  else {
                    if (bitNum != null) {
                        String value = rootParam.get(code);
                        if (StringUtils.isNotBlank(value)) {
                            int len = value.trim().length();
                            if (bitNum > len) {
                                //如果所取尾数大于value本身的长度需要补位
                                StringBuffer sb = new StringBuffer();
                                for (int j = 0; j < (bitNum - len); j++) {
                                    sb.append(fillSign);
                                }
                                sb.append(value);
                                rootParam.put(code, sb.toString());
                            } else {
                                value = value.substring((value.length() - bitNum), value.length());
                                rootParam.put(code, value);
                            }
                        }
                    }
                }
            }
        }
        String codeRuleName = (String)codeRuleMap.get("CODE_RULE_NAME");
        String rule = FormulaUtils.getStrSql(codeRuleName, "codeRuleName");// 翻译编码规则公式
        rootParam.put(CodeRuleKey.LIQUID, "");//先放一个空字符串，否则解析"referSort"最后面会有"null"
        String referSort = (String)FormulaUtils.getValue(rule, rootParam);//编号前缀

        //处理顺序号
        String liquid = dealLiquid((String)codeRuleMap.get("PK_CODERULE"), referSort);
        rootParam.put(CodeRuleKey.LIQUID, liquid.toString());

        String code = String.valueOf(FormulaUtils.getValue(rule, rootParam));
        return code;

    }


    /**
     * 处理编码规则的序列号
     * @param
     */
    private static String dealLiquid(final String pk_coderule, final String referSort) {
        //获取序列号设置信息
        List<Map<String, Object>> liquidTypes = getCodeRuleTypeWithLiquid(pk_coderule, referSort);
        StringBuffer liquid = new StringBuffer();
        if (!liquidTypes.isEmpty()) {
            Map<String, Object> originalMap = null;//初始设置的
            Map<String, Object> currentUsedMap = null;//当前使用
            boolean isCopy = true;
            for (Map map : liquidTypes) {
                String refer_Sort = (String) map.get("REFER_SORT");
                if (StringUtils.isNotBlank(refer_Sort)) {
                    if (currentUsedMap == null) {
                        currentUsedMap = map;
                    } else {
                        Integer initValue_1 = null;
                        if (map.get("INITIAL_VALUE") != null) {
                            initValue_1 = ((BigDecimal) map.get("INITIAL_VALUE")).intValue();
                        }
                        initValue_1 = initValue_1 == null ? 0 : initValue_1;
                        Integer initValue_2 = null;
                        if (currentUsedMap.get("INITIAL_VALUE") != null) {
                            initValue_2 = ((BigDecimal) currentUsedMap.get("INITIAL_VALUE")).intValue();
                        }
                        initValue_2 = initValue_2 == null ? 0 : initValue_2;

                        if (initValue_1.compareTo(initValue_2) > 0) {
                            currentUsedMap = map;
                        }
                    }
                    isCopy = false;
                } else {
                    originalMap = map;
                }
            }

            if (currentUsedMap != null) {
                originalMap = currentUsedMap;
            }

            String fillSign = originalMap.get("FILL_SIGN").toString();
            Integer bitNum = null;
            if (originalMap.get("BIT_NUMBER") != null) {
                bitNum = ((BigDecimal) originalMap.get("BIT_NUMBER")).intValue();
            }
            Integer initValue = null;
            if (originalMap.get("INITIAL_VALUE") != null) {
                initValue = ((BigDecimal) originalMap.get("INITIAL_VALUE")).intValue();
            }
            initValue = initValue == null ? 1 : initValue;
            if (bitNum != null) {
                int length = String.valueOf(initValue).length();
                if (bitNum > length) {
                    for (int i = 0; i < bitNum - length; i++) {
                        if (StringUtils.isNotBlank(fillSign)) {
                            liquid.append(fillSign);
                        } else {
                            liquid.append("0");
                        }
                    }
                }
            }
            liquid.append(initValue);

            Map<String,Object> resultmap = new HashMap<>();
            if (isCopy) {
                for(String key : originalMap.keySet()){
                    if(!key.equals("INITIAL_VALUE")&&!key.equals("REFER_SORT")){
                        resultmap.put(key,originalMap.get(key));
                    }
                }
                resultmap.put("INITIAL_VALUE", ++initValue);
                resultmap.put("REFER_SORT", referSort);
                insertCoderuleType(resultmap);
            } else {
                for(String key : originalMap.keySet()){
                    if(!key.equals("INITIAL_VALUE")){
                        resultmap.put(key,originalMap.get(key));
                    }
                }
                resultmap.put("INITIAL_VALUE", ++initValue);
                updateCoderuleType(resultmap);
            }

        }
        return liquid.toString();
    }

    /**
     * <b>根据节点编号及参数名称获取编码规则设置主表信息</b>
     * @param fun_code String 节点编码
     * @param variableName String 参数名称
     * @return Map
     */
    private static  Map<String,Object> getCodeRule(String fun_code,String variableName) {
        Assert.notNull(fun_code, "节点编码不能为空!");
        Assert.notNull(variableName, "参数名称不能为空!");
        List<Map<String,Object>> list = codeRuleUtil.coderuleService.findCoderuleByFuncCodeAndVariableName(fun_code,variableName);
        if (list == null || list.isEmpty()) {
            throw new BaseException("【" + variableName + "】编码规则设置未定义或者丢失，请联系管理员。");
        }
        return list.get(0);
    }

    /**
     * <b>获取非序列号的设置信息</b>
     * @param pk_coderule
     * @return
     */
    private static List<Map<String,Object>> getCodeRuleTypeWithNoLiquid(String pk_coderule) {
        return codeRuleUtil.coderuleService.getCodeRuleTypeWithNoLiquid(pk_coderule);
    }

    /**
     * <b>获取序列号的设置信息</b>
     * @param pk_coderule
     * @return
     */
    private static List<Map<String,Object>> getCodeRuleTypeWithLiquid(String pk_coderule,String refer_sort) {
        return codeRuleUtil.coderuleService.getCodeRuleTypeWithLiquid(pk_coderule,refer_sort);
    }

    /**
     * 插入编码规则设置子表
     * @param coderuletypeMap
     */
    private static void insertCoderuleType(Map<String,Object> coderuletypeMap) {
        String str = UUID.randomUUID().toString().replace("-","");
        CoderuleTypeDO dos = new CoderuleTypeDO();
        dos.setPkCoderuleType(str.substring(0,20));
        dos.setPkCoderule(coderuletypeMap.get("PK_CODERULE").toString());
        dos.setCoderuleType(coderuletypeMap.get("CODERULE_TYPE").toString());
        dos.setRuleCode(coderuletypeMap.get("RULE_CODE").toString());
        dos.setBitNumber(Integer.parseInt(coderuletypeMap.get("BIT_NUMBER").toString()));
        dos.setFillSign(coderuletypeMap.get("FILL_SIGN").toString());
        dos.setInitialValue(Integer.parseInt(coderuletypeMap.get("INITIAL_VALUE").toString()));
        dos.setReferSort(coderuletypeMap.get("REFER_SORT").toString());
        codeRuleUtil.coderuleService.insertCoderuleType(dos);
    }

    /**
     * 更新编码规则设置子表数据
     * @param coderuletypeMap
     */
    private static void updateCoderuleType(Map<String,Object> coderuletypeMap) {
        codeRuleUtil.coderuleService.updateCoderuleType(coderuletypeMap.get("INITIAL_VALUE").toString(),
                coderuletypeMap.get("PK_CODERULE_TYPE").toString());
    }

}