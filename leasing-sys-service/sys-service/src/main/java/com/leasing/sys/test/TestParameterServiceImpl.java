package com.leasing.sys.test;

import com.leasing.common.base.repository.support.Pagination;

import com.leasing.sys.dao.dos.ParameterDO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service(value = "sys.ParameterServiceImpl")
public class TestParameterServiceImpl implements TestParameterService {

    @Resource
    TestParameterRepository parameterRepository;


    @Override
    public ParameterDO save(ParameterDO vo) {
        ParameterDO resultVO = parameterRepository.save(vo);
        return resultVO;
    }

    @Override
    public void delete(ParameterDO vo) {

    }

    @Override
    public ParameterDO update(ParameterDO vo) {
        ParameterDO resultVO = parameterRepository.save(vo);
        return resultVO;
    }

    @Override
    public ParameterDO findOne(String pk) {
//        parameterRepository.getOne(pk);
        ParameterDO resultVO = parameterRepository.findOne(pk);
        return resultVO;
    }

    @Override
    public List<ParameterDO> pageQuery(ParameterDO vo, Pagination pagination) {
        return null;
    }



    @Override
    public List findtotal() {
        return parameterRepository.findAll();
    }

    @Transactional
    @Override
    public Object test1() {
        String pk = "0001AA10000000059Q9H";
        ParameterDO parameterDO = parameterRepository.findOne(pk);
        ParameterDO newDO = (ParameterDO)parameterDO.clone();
        newDO.setMemo(new Date().toString());
        parameterDO.setMemo(new Date().toString());
//        parameterRepository.save(parameterDO);
        int i = parameterRepository.updateMemo(new Date().toString(),pk,parameterDO.getTs());
        System.out.println("更新了" + i + "条数据");
        return parameterDO;
    }


}
