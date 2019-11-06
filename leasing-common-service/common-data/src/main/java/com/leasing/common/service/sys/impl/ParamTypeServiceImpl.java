package com.leasing.common.service.sys.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.sys.dos.ParamTypeDO;
import com.leasing.common.entity.sys.query.ParamTypeQuery;
import com.leasing.common.entity.sys.vo.ParamTypeVO;
import com.leasing.common.entity.sys.vo.ParameterVO;
import com.leasing.common.repository.sys.ParamTypeRepo;
import com.leasing.common.service.sys.ParamTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-24
 * @author:lvcna@yonyou.com
 * @description: 枚举管理
 **/

@Transactional
@Service("ParamTypeServiceImpl")
public class ParamTypeServiceImpl implements ParamTypeService {

    @Resource
    ParamTypeRepo paramTypeRepo;

    @Override
    public ParamTypeDO save(ParamTypeDO vo) {
        return paramTypeRepo.save(vo);
    }

    @Override
    public void delete(ParamTypeDO vo) {
        paramTypeRepo.delete(vo);
    }

    @Override
    public ParamTypeDO update(ParamTypeDO vo) {
        return paramTypeRepo.updateEntity(vo);
    }

    @Override
    public ParamTypeDO findOne(String pk) {
        return paramTypeRepo.findOne(pk);
    }

    @Override
    public ParamTypeVO findByPk(String pk) {
        return paramTypeRepo.findOne(pk,ParamTypeVO.class);
    }

    @Override
    public PageQueryData<ParamTypeVO> pageQuery(Pagination pagination, ParamTypeQuery vo) {
        return paramTypeRepo.pageQuery(pagination,vo,"ParamTypeRepo.pageQuery");
    }

    @Override
    public List<ParameterVO> listChild(String pk) {
        List<ParameterVO> list = paramTypeRepo.findByPkParamType(pk);
        return list;
    }

    @Override
    public List<ParameterVO> findByPkParamType(String pk) {
        return paramTypeRepo.findByPkParamType(pk);
    }

    @Override
    public List<ParameterVO> findByParamVarname(String paramVarname) {
        return paramTypeRepo.findListParamVarname(paramVarname);
    }

    @Override
    public List<ParameterVO> findByParamCode(String paramCode) {
        return paramTypeRepo.findByParamCode(paramCode);
    }

    @Override
    public List<ParameterVO> findByParamName(String paramName) {
        return paramTypeRepo.findByParamName(paramName);
    }

    @Override
    public List<ParameterVO> findByParamType(String paramType) {
        return paramTypeRepo.findByParamType(paramType);
    }
}
