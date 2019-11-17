package com.leasing.common.serviceimpl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.query.DFuncMenuQuery;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.base.repository.DFuncMenuRepo;
import com.leasing.common.service.DFuncMenuService;
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

    @Override
    public List<DFuncMenuVO>getMenuList(){
        DFuncMenuQuery queryvo =new DFuncMenuQuery();
//        queryvo.setFuncName("参数");
        String jqpl="select s from DFuncMenuVO s" +
                "            left join fetch s.pkParent l" +
                "            left join fetch s.pkSystem p" +
                "            left join fetch s.pkOrg o" +
                "            left join fetch s.pkDept d" +
                "            left join fetch s.pkOperator t" +
                "   where s.ifPower = '1' and s.ifEnabled = '0' order by s.ts desc";
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