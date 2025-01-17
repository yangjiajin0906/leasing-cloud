package com.leasing.common.serviceimpl.sys;

import com.leasing.common.repository.sys.SystemRepository;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.query.DFuncMenuQuery;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.repository.sys.DFuncMenuRepo;
import com.leasing.common.service.sys.DFuncMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/15
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("DFuncMenuServiceImpl")
public class DFuncMenuServiceImpl implements DFuncMenuService {
    @Autowired
    DFuncMenuRepo dFuncMenuRepo;

    @Autowired
    SystemRepository systemRepository;

    @Override
    public List<DFuncMenuVO>getMenuList(String systemPk){
        DFuncMenuQuery queryvo =new DFuncMenuQuery();
        SystemVO systemVO = systemRepository.findOne(systemPk,SystemVO.class);
        if(systemVO != null){
            queryvo.setPkSystem(systemVO);
        }
        List<DFuncMenuVO> list = dFuncMenuRepo.pageQuery(queryvo,"getDFuncmenuList");
        return list;

    }

    @Override
    public List<DFuncMenuVO> getAllMenuList(){
        DFuncMenuQuery queryvo =new DFuncMenuQuery();
        return dFuncMenuRepo.pageQuery(queryvo,"getDFuncmenuList");
    }

    @Override
    public void addorupdate(DFuncMenuDO dos){
        dFuncMenuRepo.save(dos);}

    @Override
    public void update(DFuncMenuDO dos){
        dFuncMenuRepo.updateDFuncmenu(dos.getBillstatus(),dos.getPkFuncmenu(),dos.getTs());}


    @Override
    public void delete(DFuncMenuDO dos){
        dFuncMenuRepo.deleteDFuncMenuDOByPkFuncmenu(dos.getPkFuncmenu());}

    @Override
    public DFuncMenuDO findOneDO(String pk){return dFuncMenuRepo.findOne(pk);}



}