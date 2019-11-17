package com.leasing.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.refpository.OrgRefRepo;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.query.OrgQuery;
import com.leasing.common.ref.base.OrgrefVO;
import com.leasing.common.ref.base.PublicRefVO;
import com.leasing.common.utils.base.ResultUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/13
 * @author:wangjc@yonyou.com
 * @description: 公共参照的controller接口 返回由ResRusult封装的PublicRefVO对象
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class PubRefController {
    @Autowired
    OrgRefRepo orgRepo;

    //表结构参照
    @RequestMapping(value = "/queryOrg")
    public ResResult queryOrg(@RequestBody(required = false) String data){
        JSONObject json = JSONObject.parseObject(data);
        OrgrefVO vo = new OrgrefVO();
        OrgQuery orgQuery = new OrgQuery();
        Pagination pagination = new Pagination(1, 5);
        if(json.get("wherecondition") != null && !StringUtils.isEmpty(json.get("wherecondition").toString())){
            orgQuery = JSON.parseObject(json.get("wherecondition").toString(),OrgQuery.class);
        }
        if(json.get("pagination") != null && !StringUtils.isEmpty(json.get("pagination").toString())) {
            pagination = JSON.parseObject(json.get("pagination").toString(),Pagination.class);
        }
        PageQueryData<OrgrefVO> list = orgRepo.pageQuery(pagination,orgQuery,"orgRefJPQLQuery");
        PublicRefVO refVO = new PublicRefVO();
        refVO.setStrFieldCode(vo.getFieldCode());
        refVO.setStrFieldName(vo.getFieldName());
        refVO.setData(list.getPageData());
        pagination.setTotal(Integer.parseInt(String.valueOf(list.getTotal())));
        int number = pagination.getTotal()%Integer.parseInt(String.valueOf(list.getPageSize()));
        int count = pagination.getTotal()/Integer.parseInt(String.valueOf(list.getPageSize()));
        pagination.setPageCount(number == 0 ? count : count+1);
        refVO.setPage(pagination);
        return ResultUtils.successWithData(refVO);
    }

    //树节点参照
    @RequestMapping(value = "/queryTreeOrg")
    public ResResult queryTreeOrg(@RequestBody(required = false) String data){
        JSONObject json = JSONObject.parseObject(data);
        OrgQuery orgQuery = new OrgQuery();
        if(json!=null && json.get("wherecondition") != null && !StringUtils.isEmpty(json.get("wherecondition").toString())){
            orgQuery = JSON.parseObject(json.get("wherecondition").toString(),OrgQuery.class);
        }
        List<OrgrefVO> list = orgRepo.pageQuery(orgQuery,"orgRefJPQLQuery");
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
        return ResultUtils.successWithData(resultlist);
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


