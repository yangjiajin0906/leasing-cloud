package com.leasing.common.repository.sys;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.sys.dos.ParamTypeDO;
import com.leasing.common.entity.sys.query.ParamTypeQuery;
import com.leasing.common.entity.sys.vo.ParamTypeVO;
import com.leasing.common.entity.sys.vo.ParameterVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-24
 * @author:lvcna@yonyou.com
 * @description: 枚举管理
 **/
@Repository
public interface ParamTypeRepo extends BaseRepository<ParamTypeDO,ParamTypeQuery,ParamTypeVO,String>{

    /**
     * 根据主表主键查询子表
     */
    @Query(value="select p from ParameterVO p \n" +
            "     left join fetch p.pkParamType pt \n" +
            "     where pt.pkParamType = ?1")
    List<ParameterVO> findByPkParamType(String pkParamType);

    /**
     * 根据 参数分类英文名 查询字表
     */
    @Query(value="select p from ParameterVO p \n" +
            "     left join fetch p.pkParamType pt \n" +
            "     where pt.paramVarname = ?1")
    List<ParameterVO> findListParamVarname(String paramVarname);

    /**
     * 根据 参数分类编码 查询字表
     */
    @Query(value="select p from ParameterVO p \n" +
            "     left join fetch p.pkParamType pt \n" +
            "     where pt.paramCode = ?1")
    List<ParameterVO> findByParamCode(String paramCode);

    /**
     * 根据 参数分类名称 查询字表
     */
    @Query(value="select p from ParameterVO p \n" +
            "     left join fetch p.pkParamType pt \n" +
            "     where pt.paramName = ?1")
    List<ParameterVO> findByParamName(String paramName);

    /**
     * 根据 参数类型 查询字表
     */
    @Query(value="select p from ParameterVO p \n" +
            "     left join fetch p.pkParamType pt \n" +
            "     where pt.paramType = ?1")
    List<ParameterVO> findByParamType(String paramType);
}
