package com.leasing.common.service.sys;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.sys.dos.ParamTypeDO;
import com.leasing.common.entity.sys.query.ParamTypeQuery;
import com.leasing.common.entity.sys.vo.ParamTypeVO;
import com.leasing.common.entity.sys.vo.ParameterVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-24
 * @author:lvcna@yonyou.com
 * @description: 枚举管理
 **/
public interface ParamTypeService {

    /**
     * 保存方法
     * @param vo
     * @return
     */
    ParamTypeDO save(ParamTypeDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(ParamTypeDO vo);

    /**
     * 更新方法
     * @param vo
     */
    ParamTypeDO update(ParamTypeDO vo);

    /**
     * 查询单个DO实体类（包含子表）
     * @return
     */
    ParamTypeDO findOne(String pk);

    /**
     * 查询单个VO（包含子表）
     * @return
     */
    ParamTypeVO findByPk(String pk);

    /**
     * 分页查询
     * @return
     */
    PageQueryData<ParamTypeVO> pageQuery(Pagination pagination, ParamTypeQuery vo);
    /**
     * 根据主表主键查询子表
     */
    List<ParameterVO> listChild(String pk);

    /**
     * 根据主表主键查询子表
     */
    List<ParameterVO> findByPkParamType(String pk);

    /**
     * 根据 参数分类英文名 查询子表
     */
    List<ParameterVO> findByParamVarname(String paramVarname);

    /**
     * 根据 参数分类编码 查询子表
     */
    List<ParameterVO> findByParamCode(String paramCode);

    /**
     * 根据 参数分类名称 查询子表
     */
    List<ParameterVO> findByParamName(String paramName);

    /**
     * 根据 参数类型 查询子表
     */
    List<ParameterVO> findByParamType(String paramType);

    /**
     * 根据 字表参数类型和参数值 查询字表主键
     */
    List<ParameterVO> findByParamTypeAndParamValue(Integer paramType,  String paramValue);

    /**
     * 根据 字表参数类型和(参数编码或参数值) 查询字表主键
     */
    List<ParameterVO> findByTypeWithCodeOrName(Integer paramType,  String paramValue);
}
