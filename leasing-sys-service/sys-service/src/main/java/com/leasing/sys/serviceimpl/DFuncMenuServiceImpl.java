package com.leasing.sys.serviceimpl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.query.DFuncMenuQuery;
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

    @Override
    public PageQueryData<DFuncMenuVO>getMenuList(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        DFuncMenuQuery queryvo =new DFuncMenuQuery();
        String jqpl="select s from DFuncMenuVO s" +
                "            left join fetch s.pkParent l" +
                "            left join fetch s.pkSystem p" +
                "            left join fetch s.pkOrg o" +
                "            left join fetch s.pkDept d" +
                "            left join fetch s.pkOperator t";
        PageQueryData<DFuncMenuVO> list = dFuncMenuRepository.pageQuery(pagination,queryvo,jqpl);
        return list;

    }

    @Override
    public PageQueryData getDMenuList(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        DFuncMenuQuery queryvo =new DFuncMenuQuery();
//        PageQueryData list = dFuncMenuRepository.pageQuery(pagination,queryvo);
        PageQueryData list = null;
//        queryvo.setFuncName("系统");
//        PageQueryData list2 =dFuncMenuRepository.pageQuery(pagination,queryvo);
        return list;
    }

    @Override
    public void addorupdate(DFuncMenuDO dos){dFuncMenuRepository.save(dos);}

    @Override
    public void update(DFuncMenuDO dos){dFuncMenuRepository.updateDFuncmenu(dos.getBillstatus(),dos.getPkFuncmenu(),dos.getTs());}


    @Override
    public void delete(DFuncMenuDO dos){dFuncMenuRepository.deleteDFuncMenuDOByPkFuncmenu(dos.getPkFuncmenu());}

    @Override
    public DFuncMenuDO findOneDO(String pk){return dFuncMenuRepository.findOne(pk);}

    @Override
    public DFuncMenuVO findOneVO(String jpqlName){return null;}

    @Override
    public List<Map<String,Object>>findByNativeSQL(String sql){return dFuncMenuRepository.findByNative(sql);}


}