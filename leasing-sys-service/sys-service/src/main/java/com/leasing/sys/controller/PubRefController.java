package com.leasing.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leasing.common.base.repository.support.PageQueryRefData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.query.OrgQuery;
import com.leasing.common.refvo.base.OrgrefVO;
import com.leasing.common.service.sys.PubRefService;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.utils.base.DataParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    PubRefService pubRefService;

    //表结构参照
    @RequestMapping(value = "/queryOrg")
    public ResResult queryOrg(@RequestBody(required = false) String data){
        Pagination pagination = DataParseUtils.jsonToBean(data, "pagination", Pagination.class);
        OrgQuery orgQuery = DataParseUtils.jsonToBean(data, "where", OrgQuery.class);
        PageQueryRefData<OrgrefVO> pageQueryRefData = pubRefService.findOrgTableRef(pagination,orgQuery,"orgRefJPQLQuery");
        return ResultUtils.successWithData(pageQueryRefData);
    }

    //树节点参照
    @RequestMapping(value = "/queryTreeOrg")
    public ResResult queryTreeOrg(@RequestBody(required = false) String data){
        OrgQuery orgQuery = DataParseUtils.jsonToBean(data, "where", OrgQuery.class);
        List<OrgrefVO> resultlist = pubRefService.findOrgTreeRef(orgQuery,"orgRefJPQLQuery");
        return ResultUtils.successWithData(resultlist);
    }

}


