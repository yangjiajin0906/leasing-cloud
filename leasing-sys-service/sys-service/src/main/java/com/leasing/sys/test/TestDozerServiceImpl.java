package com.leasing.sys.test;

import com.leasing.sys.dao.DFuncMenuRepository;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/23
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("TestDozerServiceImpl")
public class TestDozerServiceImpl implements TestDozerService {
    @Autowired
    TestDozerRepository testDozerRepository;

    @Override
    public DFuncMenuDO findByPkFuncmenu(String pk){
        return testDozerRepository.findByPkFuncmenu(pk);
    }

    @Override
    public List<DFuncMenuVO> getFuncmenu(){
        return testDozerRepository.getDFuncmenu();
    }


    @Override
    public void updateDFuncMenu(DFuncMenuDO dos){testDozerRepository.updateDFuncmenu(dos.getMenuPath(),dos.getPkFuncmenu(),dos.getTs());}


}