package com.leasing.common.utils.ParamType;

import com.leasing.common.entity.sys.vo.ParameterVO;
import com.leasing.common.service.sys.ParamTypeService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/4
 * @author:Yjj@yonyou.com
 * @description: 枚举工具类
 **/
@Component
public class ParamTypeUtils {

    @Resource
    ParamTypeService paramTypeService;

    public static ParamTypeUtils paramTypeUtils;

    @PostConstruct
    public void init(){
        paramTypeUtils = this;
    }

    /**
     * @description 根据 主表主键 查询字表
     * @author Yangjiajin
     * @date 2019/11/4 17:08
     * @param [pkParameter]
     * @return java.util.List<com.leasing.common.entity.sys.vo.ParameterVO>
     */
    public static List<ParameterVO> findByPkParamType(String pkParameter){
        return paramTypeUtils.paramTypeService.findByPkParamType(pkParameter);
    }

    /**
     * @description 根据参数分类名称查询枚举
     * @author Yangjiajin
     * @date 2019/11/4 16:52
     * @param [paramName]
     * @return java.util.List<com.leasing.common.entity.sys.vo.ParameterVO>
     */
    public static List<ParameterVO> findByParamName(String paramName){
        return paramTypeUtils.paramTypeService.findByParamName(paramName);
    }

    /**
     * @description 根据参数分类编号查询枚举
     * @author Yangjiajin
     * @date 2019/11/4 16:52
     * @param [paramCode]
     * @return java.util.List<com.leasing.common.entity.sys.vo.ParameterVO>
     */
    public static List<ParameterVO> findByParamCode(String paramCode){
        return paramTypeUtils.paramTypeService.findByParamCode(paramCode);
    }

    /**
     * @description 根据参数分类英文名查询枚举
     * @author Yangjiajin
     * @date 2019/11/4 16:53
     * @param [paramVarname]
     * @return java.util.List<com.leasing.common.entity.sys.vo.ParameterVO>
     */
    public static List<ParameterVO> findByParamVarname(String paramValue){
        return paramTypeUtils.paramTypeService.findByParamVarname(paramValue);
    }

    /**
     * @description 根据参数类型查询枚举
     * @author Yangjiajin
     * @date 2019/11/4 16:53
     * @param [paramType]
     * @return java.util.List<com.leasing.common.entity.sys.vo.ParameterVO>
     */
    public static List<ParameterVO> findByParamType(String paramType){
        return paramTypeUtils.paramTypeService.findByParamType(paramType);
    }

    /**
     * @description 根据 字表参数类型和参数值 查询字表
     * @author Yangjiajin
     * @date 2019/11/7 9:46
     * @param [paramType, paramValue]
     * @return
     */
    public static List<ParameterVO> findByParamTypeAndParamValue(String paramType,  String paramValue){
        return paramTypeUtils.paramTypeService.findByParamTypeAndParamValue(paramType, paramValue);
    }
}