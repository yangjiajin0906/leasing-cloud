package com.leasing.common.utils.base;

import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.CoderuleTypeRepo;
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

    @Resource                           //自动装配必须要添加一个非基本库的存储接口 此处随便添加了一个指定类型的存储库接口
    private CoderuleTypeRepo coderuleTypeRepo;

    private static BaseBusinessUtils baseBusinessUtils;

    @PostConstruct
    public void init(){
        baseBusinessUtils = this;
    }

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
        List list = baseBusinessUtils.coderuleTypeRepo.findByJPQL(jqpl);
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
}