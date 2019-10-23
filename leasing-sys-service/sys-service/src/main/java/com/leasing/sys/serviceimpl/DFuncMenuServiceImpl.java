package com.leasing.sys.serviceimpl;

import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;
import com.leasing.sys.dao.DFuncMenuRepository;
import com.leasing.sys.service.DFuncMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("DFuncMenuServiceImpl")
public class DFuncMenuServiceImpl implements DFuncMenuService {
    @Autowired
    DFuncMenuRepository dFuncMenuRepository;

//    @Override
//    public List<DFuncMenuDO> getAllMenu(){
//        List<DFuncMenuDO> menuVOlist = dFuncMenuRepository.findAll();
//        return menuVOlist;
//    }
//
//    @Override
//    public void addDfuncMenu(DFuncMenuDO vo){
//        dFuncMenuRepository.save(vo);
//    }
//
    @Override
    public DFuncMenuDO findByPkFuncmenu(String pk){
        return dFuncMenuRepository.findByPkFuncmenu(pk);
    }
//
//    @Override
//    public void updateDfuncMenu(DFuncMenuDO vo){
//        dFuncMenuRepository.save(vo);
//    }
//
//    @Override
//    public void deleteDfuncMenu(String pk){
//        dFuncMenuRepository.deleteDFuncMenuDOByPkFuncmenu(pk);
//    }

    @Override
    public List<DFuncMenuVO>getFuncmenu(){
        return dFuncMenuRepository.getDFuncmenu();
    }


    @Override
    public void updateDFuncMenu(DFuncMenuDO dos){dFuncMenuRepository.updateDFuncmenu(dos.getMenuPath(),dos.getPkFuncmenu(),dos.getTs());}


}