package com.leasing.common.utils.sys;

import com.leasing.common.exception.BaseException;
import com.leasing.common.utils.tools.ConfigFactory;
import ognl.Ognl;
import ognl.OgnlException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.util.*;


/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:wangjc@yonyou.com
 * @description:编码规则解析公式工具类
 **/
public class FormulaUtils {

    static Document ruledoc;
    static {
        try {
            ruledoc = ConfigFactory.getXmlConfig("utils/rule.xml");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Element getTopic(String topic) {
        NodeList nl = ruledoc.getElementsByTagName("Rule");
        for (int i = 0; i < nl.getLength(); i++) {
            Element el = (Element) nl.item(i);
            if (topic.equals(el.getAttribute("topic"))) {
                return el;
            }

        }
        System.out.println("找不到:" + topic);
        return null;
    }

//    public static Map getTopicFieldValues(String rule_topic) {
//        Element topic = getTopic(rule_topic);
//        if (topic == null) {
//            return null;
//        }
//        NodeList nl = topic.getElementsByTagName("Field");
//        HashMap map = new HashMap();
//        for (int i = 0; i < nl.getLength(); i++) {
//            Element el = (Element) nl.item(i);
//            if (el.getAttribute("enum") != null && !"".equals(el.getAttribute("enum"))){
//                String []vs = el.getAttribute("enum").split(",");
//                map.put(el.getAttribute("name"), vs);
//            } else if(el.getAttribute("ref").length() > 0 && el.getAttribute("ref_field").length() > 0){
//                String name = el.getAttribute("name");
//                try {
//                    Class refclass = Class.forName(el.getAttribute("ref"));
//                    String ref_field = el.getAttribute("ref_field");
//                    AbstractRefModel refModel = (AbstractRefModel) refclass.newInstance();
//                    Vector refdatas = refModel.getData();//查询数据
//                    int field_index = refModel.getFieldIndex(ref_field);
//                    String[] topicValues = new String[refdatas.size()];
//                    for (int j = 0; j < refdatas.size(); j++) {
//                        Vector rowData = (Vector) refdatas.get(j);
//                        topicValues[j] = "'" + rowData.get(field_index) + "'";
//                    }
//                    map.put(name, topicValues);//放入公式 对照中
//                } catch (ClassNotFoundException e) {
//                    throw new RuntimeException(name + ":ref 配置错误",e);
//                } catch (InstantiationException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//
//        return map;
//
//    }

    public static Map getTopicFields(String rule_topic) {
        Element topic = getTopic(rule_topic);
        if (topic == null) {
            return null;
        }
        NodeList nl = topic.getElementsByTagName("Field");
        HashMap map = new LinkedHashMap();
        for (int i = 0; i < nl.getLength(); i++) {
            Element el = (Element) nl.item(i);
            map.put(el.getAttribute("name"), el.getAttribute("code"));

        }

        return map;

    }

    protected static char START_CH = '"';

    protected static char END_CH = '"';

    protected static String START_ST = String.valueOf(START_CH);

    protected static String END_ST = String.valueOf(END_CH);

    // 系统函数
    static String[] item = { "abs", "sqrt", "pow", "ln", "max", "min", "round", "floor", "to_number","1", "getProperty", "getParameter", "getAccSubject","substr","substrStart"};
    static String[] dateFunc = { "yearOf", "monthOf", "dayOf", "today", "interval" };

    static String m_sLineSep = System.getProperty("line.separator"); // 换行符

    static String m_asOperationStr[] = { "=", "!=", "<>", "<", "<=", ">", ">=", ",", "==", "\"", "'" }; // 操作符

    // 定义特殊字符串
    static String m_asSpecialStr[] = { "!=", "!>", "!<", "<>", "<=", ">=", "=", "<", ">", "||", " ", "+", "-", "*",
            "/", "(", ")", ",", "==", "\"", "'", m_sLineSep };

    // 定义特殊字符
    static String m_sSpecialChar = ",-+()*=<> " + m_sLineSep;

    /**
     * 此处插入方法说明。 创建日期：(2001-4-18 16:31:21)
     *
     * @return boolean
     * @param st
     *            java.lang.String
     */
    public static boolean isSpecialChar(String st) {
        st = st.startsWith("@gbu.util.foundation.Function@") ? st.substring("@gbu.util.foundation.Function@".length(),
                st.length()) : st;
        st = st.startsWith("@gbu.util.foundation.DateFunction@") ? st.substring("@gbu.util.foundation.DateFunction@"
                .length(), st.length()) : st;
        if (isIn(st, item)) {
            return true;
        }

        if (isIn(st, dateFunc)) {
            return true;
        }

        if (isIn(st, m_asOperationStr)) {
            return true;
        }

        if (isIn(st, m_asSpecialStr)) {
            return true;
        }
        return false;
    }

    public static Object iif(String a, String b, String c) {
        Object obj = null;
        try {
            obj = Ognl.getValue(a + "?\"" + b + "\":\"" + c+"\"", null);
        } catch (OgnlException ex) {
            throw new RuntimeException(ex);
        }
        return obj;
    }

    public static Object parseExpression(String expression) {
        Object obj = null;
        try {
            obj = Ognl.parseExpression(expression);
        } catch (OgnlException ex) {
            ex.printStackTrace();
            throw new RuntimeException("公式设置错误");
        }
        return obj;
    }

    public static Object getValue(String str, Map map) {
        Object[] keys = map.keySet().toArray() ;
        for (int i = 0; i < keys.length; i++) {
            Object key = keys[i];
            Object value = map.get(key);
            if(value != null && value instanceof BigDecimal){
                map.put(key,((BigDecimal)value).setScale(10, BigDecimal.ROUND_HALF_UP));
            }
        }
        Object obj = null;
        try {
            obj = Ognl.getValue(str, map);
            if(obj != null && obj instanceof BigDecimal){
                obj = ((BigDecimal)obj).setScale(6, BigDecimal.ROUND_HALF_UP);
            }
        } catch (OgnlException ex) {
            throw new RuntimeException(ex);
        }
        return obj;
    }

    private static String linkFormuPart(String[] formuPart, Map map) {

        if (formuPart == null || formuPart.length <= 0) {
            return null;
        }

        Vector vec = new Vector();
        int ifCount = 0; // 如果数目
        int thenCount = 0; // 则数目
        int elseCount = 0; // else数目
        int leftCount = 0; // 左括号数目
        int rightCount = 0; // 右括号数目
        int defaultElseCount = 0; // 缺省数目

        // int ifelseCount = 0;

        Stack if_stack = new Stack();
        Stack else_stack = new Stack();
        Stack left_stack = new Stack();

        for (int i = 0; i < formuPart.length; i++) {
            String st = formuPart[i];
            if (st.equals(" 如果 ".trim())) {
                if (i > 0 && (!formuPart[i - 1].equals(" 否则 ".trim()))) {
                    vec.addElement(" ");
                }

                if_stack.push(new Integer(i));

                vec.addElement("@gbu.util.foundation.FormulaUtils@iif(");
                ifCount++;
            } else if (st.equals(" 否则 ".trim())) {

                // if(elseCount > ifelseCount){
                // vec.addElement(" ) ");
                // ifelseCount++;
                // }
                while (if_stack.size() > 0 && else_stack.size() > 0 && if_stack.peek().equals(else_stack.peek())) {
                    if_stack.pop();
                    else_stack.pop();
                    vec.addElement(" ) ");
                }

                elseCount++;

                else_stack.push(if_stack.peek());

                vec.addElement(",");

                if (i < formuPart.length - 1 && !formuPart[i + 1].equals(" 如果 ".trim())) {
                    defaultElseCount = elseCount;
                }
            } else if (st.equals(" 则 ".trim())) {
                vec.addElement(",");
                thenCount++;
            } else if (st.equals(" 并且 ".trim())) {
                vec.addElement("&");
            } else if (st.equals(" 或者 ".trim())) {
                vec.addElement("|");
            } else if (st.startsWith("{")) { // 列名
                // String colName = transCol(st, i, formuPart);
                // if (colName != null) {
                vec.addElement(st);
                // } else {
                // return null;
                // }
            } else if (st.startsWith("[")) { // 固定值
                // st
                // if (valueDigit != null) {
                vec.addElement(st);
                // } else {
                // return null;
                // }
            } else if (st.startsWith("'")) { // 字符型值
                if (!st.endsWith("'")) {
                    throw new RuntimeException("" + st + "  " + "后面缺少 ' 号");
                    // return null;
                }
                st = st.substring(1, st.length() - 1);
                st = START_ST + st + END_ST;
                vec.addElement(st);

            } else {
                if (isSpecialChar(st) || map.get(st) != null || map.values().contains(st)) {
                    vec.addElement(st);
                } else {
                    try {
                        Double aD = Double.valueOf(st);
                        vec.addElement(st);
                    } catch (Exception ex) {
                        throw new BaseException("不认识的： " + st + " ！");
                        // return null;
                    }
                }
            }
            if (st.equals("如果") || st.equals("否则") || st.equals("则") || st.equals("并且") || st.equals("或者")
                    || st.equals("+") || st.equals("-") || st.equals("*") || st.equals("/")) {
                if ((i + 1) >= formuPart.length) {
                    throw new RuntimeException("'" + st + "' " + "后面必须有表达式！");
                    // return null;
                }

            }
            if (st.equals("(")) {
                leftCount++;
                left_stack.push(new Integer(i));

            }
            if (st.equals(")")) {
                if (left_stack.size() > 0) {
                    Integer index1 = (Integer) left_stack.pop();
                    if (if_stack.size() > 0) {
                        Integer index2 = (Integer) if_stack.peek();
                        while (index1.intValue() < index2.intValue()) {
                            if_stack.pop();
                            else_stack.pop();
                            vec.addElement(" ) ");

                            if (if_stack.size() == 0) {
                                break;
                            }
                            index2 = (Integer) if_stack.peek();
                        }
                    }
                }
                rightCount++;
            }
        }
        if (ifCount != thenCount) {
            throw new RuntimeException("'如果'  与  '则'  的数目不相等！");
            // return null;
        }
        if (ifCount != elseCount) {
            throw new RuntimeException("'如果'  与  '否则'  的数目不相等！");
            // return null;
        }
        if (ifCount > 0 && (elseCount == 0 || (elseCount > 0 && defaultElseCount != elseCount))) {
            throw new RuntimeException("必须有缺省值！");
            // return null;
        }
        if (leftCount != rightCount) {
            throw new RuntimeException("'左扩号'  与  '右扩号'  的数目不相等！");
            // return null;
        }
        // for (int i = 0; i < ifCount; i++) {
        // vec.addElement(")");
        // }

        while (if_stack.size() > 0 && else_stack.size() > 0 && if_stack.peek().equals(else_stack.peek())) {
            if_stack.pop();
            else_stack.pop();
            vec.addElement(" ) ");
        }
        if (vec.size() > 0) {
            // val(formuPart, "N");
            String reSql = "";
            for (int i = 0; i < vec.size(); i++) {
                reSql += vec.elementAt(i).toString() + "";
            }
            return reSql;
        }
        return null;
    }

    private static String parseWord(String s) {
        String m_sLineSep = System.getProperty("line.separator");//SystemPropertyUtil.get("line.separator");

        // 定义特殊字符串
        // String m_asSpecialStr[] = { "!=", "!>", "!<", "<>", "<=", ">=", "=",
        // "<", ">", "||", " ", "+", "-", "*", "/", "(",
        // ")", ",","==","\"","'", m_sLineSep };
        // String m_sSpecialChar = ",-+()*=<> " + m_sLineSep;
        // 注意此处不可用 s=s.trim();语句，否则会出错
        // 若输入单词长度为0，则返回""
        if (s.length() == 0) {
            return "";
        }
        // 标志:是否在''内,是否在""内,是否找到单词
        boolean bInSingle = false;
        boolean bInDouble = false;
        boolean bFound = false;
        // 初始计数器
        int iOffSet = 0;
        // 初始字符缓存
        char c;
        // 过滤掉空格,'\t',与回车换行符。计数器保存着除去特定字符的开始位置,即第一个有效字符的位置
        while ( // 若计数小于输入字串的长度，且输入字串在计数位的字符串为空格
                (iOffSet < s.length() && s.charAt(iOffSet) == ' ') // 若计数小于输入字串的长度，且输入字串在计数位的字符串为“Tab”
                        || (iOffSet < s.length() && s.charAt(iOffSet) == '\t') // 若计数小于输入字串的长度，且输入字串在计数位的字符串包含于换行符之内
                        || (iOffSet < s.length() && m_sLineSep.indexOf(s.charAt(iOffSet)) >= 0)) {
            // 计数器加1
            iOffSet++;
            // 若计数大于输入字符串长度，则返回""
            if (iOffSet > s.length()) {
                return "";
            }
        }
        // 若计数大于输入字符串长度，则返回""
        if (iOffSet >= s.length()) {
            return "";
        }
        // 取得输入字符串在计数位置的字符
        c = s.charAt(iOffSet); // 第一个有效字符
        // 返回特殊字符串
        // 计数器加1
        iOffSet++;
        // 若计数小于输入字符串长度
        if (iOffSet < s.length()) {
            // 取得输入字符串在计数位置2位的字符串
            String ss = "" + c + s.charAt(iOffSet);
            // 依次比较是否为特殊字符串
            for (int i = 0; i < m_asSpecialStr.length; i++) {
                if (ss.equals(m_asSpecialStr[i])) {
                    // 返回特殊字符串
                    return s.substring(0, iOffSet + 1);
                }
            }
        }
        // 计数器减1
        iOffSet--;
        // 查找并返回特殊字符
        for (int i = 0; i < m_sSpecialChar.length(); i++) {
            if (c == m_sSpecialChar.charAt(i)) {
                return s.substring(0, iOffSet + 1);
            }
        }
        // 若计数小于输入字符串的长度
        while (iOffSet < s.length()) {
            // 取得输入字符串在计数位置的字符
            c = s.charAt(iOffSet);
            // 若为单引号
            if (c == '\'') {
                // 若不在双引号内
                if (!bInDouble) {
                    // 若在单引号内
                    if (bInSingle) {
                        // 解析''
                        // 若计数加1小于输入字符串的长度，且输入字符串在计数加1位置的字符为单引号
                        if ((iOffSet + 1) < s.length() && s.charAt(iOffSet + 1) == '\'') {
                            // 计数加1
                            iOffSet++;
                        } else {
                            // 否则，计数加1，跳出循环
                            iOffSet++;
                            break;
                        }
                    }
                    // 是否在单引号中设为真
                    bInSingle = true;
                }
            }
            // 若为双引号
            if (c == '"') {
                // 若不在单引号中
                if (!bInSingle) {
                    // 若在双引号中
                    if (bInDouble) {
                        // 计数加1，跳出循环
                        iOffSet++;
                        break;
                    }
                    // 是否在双引号中设为真
                    bInDouble = true;
                }
            }
            // 不在单引号内且不在双引号内
            if ((!bInDouble) && (!bInSingle)) {
                // 计数加1
                iOffSet++;
                // 若计数小于输入字符串的长度
                if (iOffSet < s.length()) {
                    // 取得输入字符串在计数位置2位的字符串
                    String ss = "" + c + s.charAt(iOffSet);
                    // 循环比较是否为特殊字符串
                    for (int i = 0; i < m_asSpecialStr.length; i++) {
                        // 若找到，则跳出循环
                        if (ss.equals(m_asSpecialStr[i])) {
                            bFound = true;
                            break;
                        }
                    }
                }
                // 计数减1
                iOffSet--;

                // 循环查找是否为特殊字符
                for (int i = 0; i < m_sSpecialChar.length(); i++) {
                    if (c == m_sSpecialChar.charAt(i)) {
                        // 若找到，则跳出循环
                        bFound = true;
                        break;
                    }
                }
                // 若找到，则跳出循环
                if (bFound) {
                    break;
                }
            }
            // 计数加1
            iOffSet++;
        }
        // 将输入字符串从0到计数位进行返回
        return s.substring(0, iOffSet);
    }

    /**
     * 解析公式为串数组
     *
     * @param sql
     * @return
     */
    public static String[] parseString(String sql) {
        // 若输入的SQL为空，则返回空
        if (sql == null || sql.trim().length() == 0) {
            return new String[0];
        }
        // 初始单词序列
        String asKeyWords[] = null;
        // 初始哈西表
        java.util.Hashtable table = new java.util.Hashtable();
        // 初始记数器
        int iCount = 0;
        int iOffSet = 0;
        // 找到第一个单词
        String sWord = parseWord(sql.substring(iOffSet));
        // 若单词长度大于0，则开始寻找其余单词
        while (sWord.length() > 0) {
            // 计数加上单词的长度
            iOffSet += sWord.length();
            // 去掉单词内的空格
            sWord = sWord.trim();
            // 若单词长度大于0
            if (sWord.length() > 0) {
                // 存入新单词
                String s = sWord;
                // 存入哈西表
                table.put(new Integer(iCount), s);
                // 计数加1
                iCount++;
            }
            // 查找下一个单词
            sWord = parseWord(sql.substring(iOffSet));

            // 若单词中仅含有空格则结束
            String s = sWord.trim();
            if (s.length() == 0) {
                sWord = s;
            }
        }
        // 初始字符串数组
        asKeyWords = new String[iCount];
        // 从哈西表中提取记录
        for (int i = 0; i < iCount; i++) {
            asKeyWords[i] = (String) table.get(new Integer(i));
        }
        // 返回字符串组
        return asKeyWords;
    }

    private static boolean isIn(String st, String[] stArray) {
        if (st != null && stArray != null) {
            for (int i = 0; i < stArray.length; i++) {
                if (st.equals(stArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getFormulaIndex(String strFormula, String[] strFields) {

        for (int i = 0; i < strFields.length; i++) {
            if (strFormula.equals(strFields[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 转换中文字段和系统函数
     *
     * @param strTempFormula
     * @param fieldNameMap
     * @return
     */
    private static String getTempFormulaDesc(String strTempFormula, Map fieldNameMap) {
        // 系统函数
        // String[] item = {"abs", "exp", "sqrt", "power", "log", "ln", "max",
        // "min", "round", "int", "sgn", "iif", "sin",
        // "cos", "tg", "ctg", "asin", "acos", "atg", "getColValue",
        // "getColNmV", "cvs", "cvn", "toNumber",
        // "toString", "charAt", "left", "right", "mid", "endsWith",
        // "startsWith", "equalsIgnoreCase",
        // "indexOf", "lastIndexOf", "length", "toLowerCase", "toUpperCase",
        // "date", "year", "mon", "day",
        // "yearOf", "monOf", "dayOf"};

        Vector key = new Vector();
        Vector value = new Vector();
        value.addAll(fieldNameMap.values());
        Set set = fieldNameMap.keySet();
        key.addAll(set);
        String[] m_funcNames = (String[]) key.toArray(new String[0]);
        String[] m_functions = (String[]) value.toArray(new String[0]);

        String strResult = "";
        String[] strFormulas = parseString(strTempFormula);

        for (int iLen = 0; iLen < strFormulas.length; iLen++) {
            if (isIn(strFormulas[iLen], m_funcNames)) {
                String methodName = "";
                int index = getFormulaIndex(strFormulas[iLen], m_funcNames);
                if (index >= 0) {
                    String after = null;
                    methodName += m_functions[index];
                }
                methodName = " " + methodName;
                strResult = strResult + methodName;
            } else if (isIn(strFormulas[iLen], item)) {
                strResult = strResult + " @gbu.util.foundation.Function@" + strFormulas[iLen];
            } else if (isIn(strFormulas[iLen], dateFunc)) {
                strResult = strResult + " @gbu.util.foundation.DateFunction@" + strFormulas[iLen];
            } else if (strFormulas[iLen].equals("=")) {
                strResult = strResult + "==";
            } else if (strFormulas[iLen].equals("<>")) {
                strResult = strResult + "!=";
            } else {
                strResult = strResult + " " + strFormulas[iLen];
            }
        }
        return strResult;
    }

    // 翻译原始公式为运行公式
    public static String getStrSql(String str, String rule_topic) {

        Map ref = getTopicFields(rule_topic);

        return linkFormuPart(parseString(getTempFormulaDesc(str, ref)), ref);
    }

    // 翻译原始公式为运行公式
    public static String getStrSql(String str, Map fieldNamemap) {
        Map map = (fieldNamemap == null) ? new HashMap() : fieldNamemap;
        return linkFormuPart(parseString(getTempFormulaDesc(str, fieldNamemap)), map);
    }

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("姓名", "男");
        // map.put("男","男");
        System.out.println(FormulaUtils
                .getValue("@gbu.util.foundation.FormulaUtils@iif( 性别 == \"男\" , 100 , 200)", map));
        // FormulaUtils.getValue("",map);
        String s = " 如果 个人缴费基数 > 100 则 200 否则 abs(100) +  工作年限  +  出生日期";
        // System.out.println(FormulaUtils.getTempFormulaDesc(s, "corp_rule"));
        // System.out.println(linkFormuPart(parseString(FormulaUtils.getTempFormulaDesc(s,
        // "corp_rule"))));
        System.out.println(FormulaUtils.parseExpression(s));

    }

    /**
     * 验证
     *
     * @param exp
     *            表达式
     * @param type
     *            表达式应该的类型 "B" 为逻辑 "N" 为数字
     */
    /*
     * private static void val(String[] exp, String type) { // expStr 为 把code
     * 翻译成 name 的表达式字符串 String expStr = ""; for (int i = 0; i < exp.length; i++) {
     * expStr += CODE_NAMES.containsKey(exp[i]) ? CODE_NAMES.get(exp[i]) :
     * exp[i]; expStr += " "; } System.out.println(type.equals("B") ? "逻辑:" :
     * "数字:" + expStr);
     *
     * Set expSet = new HashSet(); for (int i = 0; i < exp.length; i++) {
     * expSet.add(exp[i]); } // 可再分 分两种情况 按照如果 则 否则 分 和按照括号分 // 每次拆分 只拆分一层 如果有多层
     * 如果 或者 括号的嵌套 用递归 分层验证 if (!isGen(exp)) { // 如果第一个 '如果' 在 第一个'(' 前 按照如果分 反之
     * 按照括号分 String theFirst = ""; int firstIfIndex = 9999; int firstLeftIndex =
     * 9999; for (int i = 0; i < exp.length; i++) { if (exp[i].equals("如果") &&
     * firstIfIndex == 9999) { firstIfIndex = i; } if (exp[i].equals("(") &&
     * firstLeftIndex == 9999) { firstLeftIndex = i; }
     *  } // 进入这个IF 一定有 '如果'或者 '(' 所以没有 firstIfIndex==firstLeftIndex的时候 if
     * (firstIfIndex < firstLeftIndex) { theFirst = "if"; } else if
     * (firstLeftIndex < firstIfIndex) { theFirst = "left"; } if
     * (theFirst.equals("left")) { // 如果存在括号的拆分方法 existParentheses 会回调 val 继续拆分
     * 知道拆分到不能拆分为止 existParentheses(exp, type); } else if
     * (theFirst.equals("if")) { // 如果存在'如果'的拆分方法 exitIf 会回调 val 继续拆分
     * 知道拆分到不能拆分为止 exitIf(exp, type); }
     *  } // 表达式不可拆分时 （没有 括号和 如果） 判断简单表达式的类型 else { if (exp.length == 0) {
     * return; } if (type.equals("B")) { if (!isBooleanExp(exp)) { throw new
     * RuntimeException(expStr + "必须为逻辑表达式！"); } } if (type.equals("N")) { if
     * (!isNumExp(exp)) { throw new RuntimeException(expStr + "必须为算术表达式！"); } } } }
     *
     *//**
     * 把存在如果的表达式 拆分成 如果前 如果的条件 则 后表达式 否则后表达式 和 否则后其他表达式 再分别对 拆分后的表达式 执行val方法
     *
     * @param exp
     * @param type
     */
    /*
     * private static void exitIf(String[] exp, String type) { // expStr 报错的时候
     * 用到此字符串 提示 expStr+.. 错误 String expStr = ""; for (int i = 0; i <
     * exp.length; i++) { expStr += CODE_NAMES.containsKey(exp[i]) ?
     * CODE_NAMES.get(exp[i]) : exp[i]; expStr += " "; } // 字符串数组中 如果 则 否则 个数
     * int ifNum = 0; int thenNum = 0; int elseNum = 0;
     *  // 几个List 分别存放如果前 如果后 则后 否则后 和其他 List beforeList = new ArrayList(); List
     * ifList = new ArrayList(); List thenList = new ArrayList(); List elseList =
     * new ArrayList(); List otherList = new ArrayList(); // boolean isOther =
     * false; // 第一个 如果 的位置 和与第一个 如果配对的则 和否则 的位置 int ifIndex = 9999; int
     * thenIndex = 0; int elseIndex = 0; // 得到 如果 则 否则的位置 for (int i = 0; i <
     * exp.length; i++) { if (exp[i].equals("如果")) { ifNum++; } if
     * (exp[i].equals("则")) { thenNum++; } if (exp[i].equals("否则")) { elseNum++; }
     * if (ifNum == 1 && ifIndex == 9999) { ifIndex = i; } if (ifNum == thenNum &&
     * ifNum != 0 && thenIndex == 0) { thenIndex = i; } if (ifNum == elseNum &&
     * ifNum != 0 && elseIndex == 0) { elseIndex = i; } } // 按照 位置 拆分 for (int i =
     * 0; i < exp.length; i++) { if (exp[i].equals("")) { continue; } if (i <
     * ifIndex) { beforeList.add(exp[i]); } if (i >= ifIndex && i < thenIndex) {
     * ifList.add(exp[i]); }
     *
     * if (i >= thenIndex && i < elseIndex) { thenList.add(exp[i]); } if (i >=
     * elseIndex) { // if (exp[i].equals(")")) { // isOther = true; // } // if
     * (isOther) { // otherList.add(exp[i]); // } else { elseList.add(exp[i]); // } } } //
     * if (beforeList.size() == 0 && otherList.size() == 0 // &&
     * type.equals("B")) { // throw new RuntimeException(expStr + "不是逻辑表达式！"); // }
     * if (ifList.size() > 0 && ifList.get(0).equals("如果")) { ifList.remove(0);
     * if (ifList.size() == 0) { throw new RuntimeException(expStr + "中的 如果
     * 后缺少表达式！"); } } if (thenList.size() > 0 && thenList.get(0).equals("则")) {
     * thenList.remove(0); if (thenList.size() == 0) { throw new
     * RuntimeException(expStr + "中的 则 后缺少表达式！"); } } if (elseList.size() > 0 &&
     * elseList.get(0).equals("否则")) { elseList.remove(0); if (elseList.size() ==
     * 0) { throw new RuntimeException(expStr + "中的 否则 后缺少表达式！"); } } // 如果
     * 当前整个字符串应该为 逻辑型 那么 '如果'前的字符串与如果之间的运算符应该为 == != < > <= >= // 为 算术型的 就应该是 + - * /
     * if (beforeList.size() > 0) { if (type.equals("B") &&
     * EQUAL_FORBOOLEAN_SET.contains(beforeList.get(beforeList .size() - 1))) {
     * beforeList.remove(beforeList.size() - 1); val((String[]) beforeList
     * .toArray(new String[beforeList.size()]), "N"); } else if
     * (type.equals("N") && OPERATOR_SET.contains(beforeList
     * .get(beforeList.size() - 1))) { beforeList.remove(beforeList.size() - 1);
     * val((String[]) beforeList .toArray(new String[beforeList.size()]), type); }
     * else { throw new RuntimeException(expStr + "中的运算符不正确！"); } } String[] s =
     * (String[]) ifList.toArray(new String[ifList.size()]); String e = ""; for
     * (int i = 0; i < s.length; i++) { e += s[i]; e += "$"; } // 如果有 并且 或者
     * 这类的逻辑运算 的话 拆分 并且 或者 前后的每个分表达式 各个验证 String[] ss = e.split("[并且|或者]"); for
     * (int i = 0; i < ss.length; i++) { if (ss[i].equals("$")) { throw new
     * RuntimeException("'并且' '或者' 之后缺少逻辑表达式！"); } String[] sss =
     * ss[i].split("[$]"); if (sss.length != 0 && !(sss.length == 1 &&
     * sss[0].equals(""))) { val(sss, "B"); } } val((String[])
     * thenList.toArray(new String[thenList.size()]), "N"); val((String[])
     * elseList.toArray(new String[elseList.size()]), "N"); if (otherList.size() >
     * 0) { val((String[]) otherList.toArray(new String[otherList.size()]),
     * type); } }
     *
     *//**
     * 按照括号拆分 拆分成 括号前 括号里 括号后 分别执行 val 方法
     *
     * @param exp
     * @param type
     */
    /*
     * private static void existParentheses(String[] exp, String type) { //
     * expStr 报错的时候 用到此字符串 提示 expStr+.. 错误 String expStr = ""; for (int i = 0; i <
     * exp.length; i++) { expStr += CODE_NAMES.containsKey(exp[i]) ?
     * CODE_NAMES.get(exp[i]) : exp[i]; expStr += " "; } // 是否有函数 boolean
     * hasItem = false; for (int i = 0; i < exp.length; i++) { if
     * (exp[i].startsWith("@gbu.util.foundation.Function@")) { hasItem = true; } } //
     * 如果有函数 先按照第一个函数拆分 否则 按照第一个左括号拆分 // 如果有函数 则函数里面表达式必须为算术表达式 if (hasItem) { //
     * 左括号 个数 int leftNum = 0; int rightNum = 0; // 函数开始位置 int itemNum = 0; //
     * int itemIndex = 9999; // 第一个左括号 位置 int leftIndex = 9999; // 与第一个
     * 左括号配对的右括号的位置 int rightIndex = 9999;
     *  // 第一个"(" 之前的表达式 List beforeList = new ArrayList(); // 括号里面的表达式 List
     * list = new ArrayList(); // 与第一个"(" 配对的 ")" 之后的表达式 List afterList = new
     * ArrayList(); for (int i = 0; i < exp.length; i++) { if
     * (exp[i].equals("(")) { leftNum++; } if (exp[i].equals(")")) { rightNum++; }
     * if (exp[i].startsWith("@gbu.util.foundation.Function@")) { itemNum++; }
     * if (itemNum == 1 && leftIndex == 9999) { leftIndex = i; } if (rightNum ==
     * leftNum && rightNum != 0 && rightIndex == 9999) { rightIndex = i; } }
     *
     * for (int i = 0; i < exp.length; i++) { if (exp[i].equals("")) { continue; }
     * if (exp[i].startsWith("@gbu.util.foundation.Function@")) { continue; } if
     * (i < leftIndex) { beforeList.add(exp[i]); } if (i >= leftIndex && i <
     * rightIndex) { list.add(exp[i]); } if (i >= rightIndex) {
     * afterList.add(exp[i]); } } // "("之前的运算符 表达式类型 必须和 整个表达式的 类型匹配 if
     * (beforeList.size() != 0) { if (type.equals("B") &&
     * EQUAL_FORBOOLEAN_SET.contains(beforeList .get(beforeList.size() - 1))) {
     * beforeList.remove(beforeList.size() - 1); val((String[])
     * beforeList.toArray(new String[beforeList .size()]), "N"); } else if
     * (type.equals("N") && OPERATOR_SET.contains(beforeList.get(beforeList
     * .size() - 1))) { beforeList.remove(beforeList.size() - 1); val((String[])
     * beforeList.toArray(new String[beforeList .size()]), type); } else { throw
     * new RuntimeException(expStr + "中的运算符不正确！"); } } if (list.size() > 0 &&
     * list.get(0).equals("(")) { list.remove(0); } // 函数里面必须是 算术表达式 if
     * (list.size() > 0) { val((String[]) list.toArray(new String[list.size()]),
     * "N"); } else { throw new RuntimeException("函数缺少参数!"); }
     *
     * if (afterList.size() > 0 && afterList.get(0).equals(")")) {
     * afterList.remove(0); } // ")" 之后的表达式类型 和运算符 必须和整个表达式类型匹配 if
     * (afterList.size() != 0) { if (type.equals("B") &&
     * EQUAL_FORBOOLEAN_SET.contains(afterList.get(0))) { afterList.remove(0);
     * val((String[]) afterList.toArray(new String[afterList .size()]), type); }
     * else if (type.equals("N") && OPERATOR_SET.contains(afterList.get(0))) {
     * afterList.remove(0); val((String[]) afterList.toArray(new
     * String[afterList .size()]), type); } else { throw new
     * RuntimeException(expStr + "中的运算符不正确！"); } } } // 没有函数的话 括号里面的东西
     * 必须跟整个表达式的类型相同 下面else 与上面if的处理方法相近 else { int leftNum = 0; int rightNum =
     * 0; int leftIndex = 9999; int rightIndex = 9999; List beforeList = new
     * ArrayList(); List list = new ArrayList(); List afterList = new
     * ArrayList(); for (int i = 0; i < exp.length; i++) { if
     * (exp[i].equals("(")) { leftNum++; } if (exp[i].equals(")")) { rightNum++; }
     * if (leftNum == 1 && leftIndex == 9999) { leftIndex = i; } if (rightNum ==
     * leftNum && rightNum != 0 && rightIndex == 9999) { rightIndex = i; } }
     *
     * for (int i = 0; i < exp.length; i++) { if (exp[i].equals("")) { continue; }
     * if (exp[i].startsWith("@gbu.util.foundation.Function@")) { continue; } if
     * (i < leftIndex) { beforeList.add(exp[i]); } if (i >= leftIndex && i <
     * rightIndex) { list.add(exp[i]); } if (i >= rightIndex) {
     * afterList.add(exp[i]); } } if (beforeList.size() != 0) { if
     * (type.equals("B") && EQUAL_FORBOOLEAN_SET.contains(beforeList
     * .get(beforeList.size() - 1))) { beforeList.remove(beforeList.size() - 1);
     * val((String[]) beforeList.toArray(new String[beforeList .size()]), "N");
     * if (list.size() > 0 && list.get(0).equals("(")) { list.remove(0); } if
     * (list.size() > 0) { val((String[]) list.toArray(new String[list.size()]),
     * "N"); } else { throw new RuntimeException("括号内缺少表达式!"); } } else if
     * (type.equals("N") && OPERATOR_SET.contains(beforeList.get(beforeList
     * .size() - 1))) { beforeList.remove(beforeList.size() - 1); val((String[])
     * beforeList.toArray(new String[beforeList .size()]), type); if
     * (list.size() > 0 && list.get(0).equals("(")) { list.remove(0); } if
     * (list.size() > 0) { val((String[]) list.toArray(new String[list.size()]),
     * type); } else { throw new RuntimeException("括号内缺少表达式!"); } } else { throw
     * new RuntimeException(expStr + "中的运算符不正确！"); } } else { if (list.size() >
     * 0 && list.get(0).equals("(")) { list.remove(0); } if (list.size() > 0) {
     * val((String[]) list.toArray(new String[list.size()]), type); } else {
     * throw new RuntimeException("括号内缺少表达式!"); } }
     *
     * if (afterList.size() > 0 && afterList.get(0).equals(")")) {
     * afterList.remove(0); } if (afterList.size() != 0) { if (type.equals("B") &&
     * EQUAL_FORBOOLEAN_SET.contains(afterList.get(0))) { afterList.remove(0);
     * val((String[]) afterList.toArray(new String[afterList .size()]), type); }
     * else if (type.equals("N") && OPERATOR_SET.contains(afterList.get(0))) {
     * afterList.remove(0); val((String[]) afterList.toArray(new
     * String[afterList .size()]), type); } else { throw new
     * RuntimeException(expStr + "中的运算符不正确！"); } } } }
     *
     *//**
     * 是否是 算术型 表达式
     *
     * @param exp
     * @return
     */
    /*
     * private static boolean isNumExp(String[] exp) { if (exp.length == 0) {
     * return false; } // 如果 表达式中 有 == != 之类 或者 学历 性别之类的 一定不是 算术型的 for (int i =
     * 0; i < exp.length; i++) { if (ENUM_FIELD.containsKey(exp[i]) ||
     * EQUAL_FORBOOLEAN_SET.contains(exp[i])) { return false; } } // 只有一个 并且是数字
     * 一定是 算术型的 if (exp.length == 1) { if (NUM_FIELDS_SET.contains(exp[0]) ||
     * isNum(exp[0])) { return true; } else { return false; } } else { boolean
     * beforeIsNum = NUM_FIELDS_SET.contains(exp[0]) || isNum(exp[0]); if
     * (!beforeIsNum) { return false; // throw new
     * RuntimeException("算术运算符前缺少表达式！"); } boolean nowIsNum = !beforeIsNum; for
     * (int i = 1; i < exp.length; i++) { nowIsNum =
     * NUM_FIELDS_SET.contains(exp[i]) || isNum(exp[i]); if (nowIsNum ==
     * beforeIsNum) { return false; // throw new
     * RuntimeException("缺少运算符或者算术表达式！"); } beforeIsNum = nowIsNum; } if
     * (!(NUM_FIELDS_SET.contains(exp[exp.length - 1]) || isNum(exp[exp.length -
     * 1]))) { return false; // throw new RuntimeException("算术运算符前后少表达式！"); } }
     * return true; }
     *
     *//**
     * 判断表达式 exp是否为逻辑型
     *
     * @param exp
     * @return
     */
    /*
     * private static boolean isBooleanExp(String[] exp) { String expStr = "";
     * for (int i = 0; i < exp.length; i++) { expStr += exp[i]; expStr += "$"; } //
     * 此正则不正确 有时候 s.length=2 有时候s.length=3 String[] s = expStr.split("[==|!=|>|<|>=|<=]"); //
     * 逻辑表达式只能存在一个 比较运算符 if (s.length != 3 && s.length != 2) { return false; }
     * else { String[] before = s[0].split("[$]"); String[] after = s[s.length -
     * 1].split("[$]"); Set beforeSet = new HashSet(); Set afterSet = new
     * HashSet(); List beforeList = new ArrayList(); List afterList = new
     * ArrayList(); for (int i = 0; i < before.length; i++) { if
     * (!before[i].equals("")) { beforeSet.add(before[i]);
     * beforeList.add(before[i]); } } for (int i = 0; i < after.length; i++) {
     * if (!after[i].equals("")) { afterSet.add(after[i]);
     * afterList.add(after[i]); } } // 比较运算符 前后必须有表达式 if (beforeSet.size() == 0 ||
     * afterSet.size() == 0) { return false; } // 学历='小学' 或者 '小学'=学历 这样的 if
     * (beforeSet.size() == 1 && afterSet.size() == 1) { String b = (String)
     * beforeSet.iterator().next(); String a = (String)
     * afterSet.iterator().next(); if ((ENUMFIELD_MAP.get(b) != null &&
     * ENUMFIELD_MAP.get(b) .equals(a)) || ENUMFIELD_MAP.get(a) != null &&
     * ENUMFIELD_MAP.get(a).equals(b)) { return true; } } //
     * 下面是判断beforeSet和afterSet 中是否存在 学历 '小学' 这些集合类型 字段 如果不存在 根据上文还只有一个 // 比较运算符
     * 并且 比较运算符前后是 算术运算符 if (!beforeSet.removeAll(ENUMFIELD_MAP.keySet()) &&
     * !afterSet.removeAll(ENUMFIELD_MAP.keySet()) &&
     * !beforeSet.removeAll(ENUM_FIELD.keySet()) &&
     * !afterSet.removeAll(ENUM_FIELD.keySet())) { if (isNumExp((String[])
     * beforeList .toArray(new String[beforeList.size()])) &&
     * isNumExp((String[]) afterList .toArray(new String[afterList.size()]))) {
     * return true; }
     *  } } return false; }
     *  // public static boolean
     *
     *//**
     * 是否可以再分
     *
     * @param exps
     *            表达式
     * @return
     */
    /*
        private static boolean isGen(String[] exps) {
            Set s = new HashSet();
            for (int i = 0; i < exps.length; i++) {
                s.add(exps[i]);
            }
            if (s.contains("如果") || s.contains("(") || s.contains(")")) {
                return false;
            }
            return true;
        }

        private static boolean isNum(String exp) {
            String reg = "^\\d*(\\.?\\d*)$";
            return exp.matches(reg);
        }*/
}