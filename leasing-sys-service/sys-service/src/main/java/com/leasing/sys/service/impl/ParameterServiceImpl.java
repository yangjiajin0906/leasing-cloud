package com.leasing.sys.service.impl;

import com.leasing.common.entity.sys.common.ParameterVO;
import com.leasing.common.repository.support.Pagination;
import com.leasing.sys.repository.ParameterRepository;
import com.leasing.sys.service.ParameterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service(value = "sys.ParameterServiceImpl")
public class ParameterServiceImpl implements ParameterService {

    @Resource
    ParameterRepository parameterRepository;

    @Override
    public ParameterVO save(ParameterVO vo) {
        ParameterVO resultVO = parameterRepository.save(vo);
        return resultVO;
    }

    @Override
    public void delete(ParameterVO vo) {

    }

    @Override
    public ParameterVO update(ParameterVO vo) {
        ParameterVO resultVO = parameterRepository.save(vo);
        return resultVO;
    }

    @Override
    public ParameterVO findOne(String pk) {
//        parameterRepository.getOne(pk);
        ParameterVO resultVO = parameterRepository.findOne(pk);
        return resultVO;
    }

    @Override
    public List<ParameterVO> pageQuery(ParameterVO vo, Pagination pagination) {
        return null;
    }
}
