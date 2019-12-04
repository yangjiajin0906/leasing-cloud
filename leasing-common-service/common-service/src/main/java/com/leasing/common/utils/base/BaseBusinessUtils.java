package com.leasing.common.utils.base;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.BaseEntityRepository;
import com.leasing.common.repository.sys.CoderuleTypeRepo;
import com.leasing.common.exception.BaseException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-11-01
 * @author:zhangzhhn@yonyou.com
 * @description: 所有业务类节点公共工具类
 **/
@Component
public class BaseBusinessUtils {

    @Resource
    BaseEntityRepository baseEntityRepository;

    public static BaseBusinessUtils baseBusinessUtils;

    @PostConstruct
    public void init(){
        baseBusinessUtils = this;
    }

    public static BaseBusinessUtils getInstance(){
        return baseBusinessUtils;
    }




    /**
     * 校验字段唯一性
     * @param vo 当前业务vo类
     * @param strFields 字段String数组
     * @param where 其他拼接where条件
     * @return
     */
    public static boolean checkUniqueFields(BaseVO vo, String[] strFields, String where) {
        Object[] strValues = new Object[strFields.length];
        for (int i = 0; i < strFields.length; i++) {
            if (strFields[i] != null) {
                Object objTemp = vo.getAttributeValue(strFields[i]);
                if (vo.getAttributeValue(strFields[i]) == null) {
                    throw new BaseException(new Object[]{strFields[i]}.toString() + "无法寻找到此属性");
                }
                strValues[i] = objTemp;
            }
        }
        String strCond = getSqlString(strFields, strValues, "and");
        String pk = vo.getPk() == null ? "" : "vo.id <> '" + vo.getPk() + "' and ";
        String jqpl = " select vo.id from " + vo.getClass().getName() + " vo where " + pk + strCond
                + ((where != null && !"".equals(where)) ? " and " + where : "" );
        List list = baseBusinessUtils.baseEntityRepository.findByJPQL(jqpl);
        if(list.size()>0){
            return true;
        }
        return false;
    }

    /**
     * getSqlString
     * 通过字段拼SQL
     * @param strFields String[]
     * @param strAndOr String
     * @return String
     */
    private static String getSqlString(String[] strFields, Object[] strValues, String strAndOr) {

        String strCond = "( vo.";
        boolean bFirst = false;
        for (int i = 0; i < strFields.length; i++) {
            if (strFields[i] != null) {
                if (!bFirst) {
                    strCond = strCond + strFields[i];
                    bFirst = true;
                } else {
                    strCond = strCond + " " + strAndOr + " vo. " + strFields[i];
                }
                strCond = strCond + " ='" + strValues[i] +"'" ;
            }
        }
        strCond = strCond + ")";
        return strCond;
    }

    /**
     * 根据JPQL查询
     * @param t
     * @param sql
     * @param <T>
     * @return
     */
    public static <T> List<T> findListByJpql(Class<T> t,String sql){
        List<T> result = baseBusinessUtils.baseEntityRepository.findByJPQL(sql);
        return result;
    }


    /**
     * 主键生成策略接口
     * @return 返回生成主键
     */
    public static String getOID(){

        return null;
    }
}