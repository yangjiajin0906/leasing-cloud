package com.leasing.common.serviceimpl.sys;

import com.leasing.common.base.repository.refpository.OrgRefRepo;
import com.leasing.common.base.repository.support.PageQueryRefData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.common.query.OrgQuery;
import com.leasing.common.refvo.base.OrgrefVO;
import com.leasing.common.service.sys.PubRefService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/17
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Service("PubRefServiceImpl")
public class PubRefServiceImpl implements PubRefService {
    @Autowired
    OrgRefRepo orgRefRepo;

    @Override
    public PageQueryRefData<OrgrefVO> findOrgTableRef(Pagination pagination, OrgQuery orgQuery,String queryName){
        OrgrefVO orgrefVO = new OrgrefVO();
        PageQueryRefData<OrgrefVO> pageQueryRefData = orgRefRepo.pageQueryRefData(pagination, orgQuery, queryName, orgrefVO);
        return pageQueryRefData;
    }

    @Override
    public List<OrgrefVO> findOrgTreeRef(OrgQuery orgQuery, String queryName){
        List<OrgrefVO> list = orgRefRepo.pageQuery(orgQuery, queryName);
        OrgrefVO root = null;
        for(OrgrefVO vo : list){
            if(vo.getParentPk() == null) {   //根节点集团
                root = vo;
                break;
            }
        }
        List<OrgrefVO> resultlist = buildOrgTree(list, root.getPk());
        root.setChildren(resultlist);
        resultlist = new ArrayList<>();
        resultlist.add(root);
        return resultlist;
    }

    //建立树节点参照树
    private static List<OrgrefVO> buildOrgTree(List<OrgrefVO> List, String parentPk) {
        List<OrgrefVO> treeList = new ArrayList<OrgrefVO>();
        for (OrgrefVO orgrefVO : List) {
            if (!StringUtils.isEmpty(orgrefVO.getParentPk()) && orgrefVO.getParentPk().equals(parentPk)) {
                orgrefVO.setChildren(buildOrgTree(List, orgrefVO.getPk()));
                treeList.add(orgrefVO);
            }
        }
        return treeList;
    }
}