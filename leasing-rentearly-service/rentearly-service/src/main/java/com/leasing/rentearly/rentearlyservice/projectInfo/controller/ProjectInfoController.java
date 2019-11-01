package com.leasing.rentearly.rentearlyservice.projectInfo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPObject;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO.ProjectQueryVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.ProjectInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: leasing-cloud
 * @date: 2019/10/23
 * @author: jiaoshy@yonyou.com
 * @description: 普通项目审批
 **/
@RestController
@RequestMapping("/leasing/rentearly/projectInfoController")
public class ProjectInfoController {

    @Resource(description = "普通项目审批业务接口")
    ProjectInfoService projectInfoService;


    /**
     * 全部查询
     *
     * @param page     当前页
     * @param pageSize 页数
     * @param data     前台数据
     * @return map 结果集封装
     */
    @RequestMapping(value = "/queryForGrid", method = RequestMethod.POST)
    public ResResult queryForGrid(@RequestParam(required = false, defaultValue = "1", name = "page") Integer page,
                                  @RequestParam(required = false, defaultValue = "20", name = "pageSize") Integer pageSize,
                                  @RequestParam(required = false, name = "data") String data) {
        ProjectQueryVO projectQueryVO = JSON.parseObject(data, ProjectQueryVO.class);
        projectQueryVO.setProjectCode("1");
        Pagination pagination = new Pagination(page, pageSize);
        PageQueryData pageQueryData = projectInfoService.pageData(projectQueryVO, pagination);
        return ResultUtils.successWithData(pageQueryData);
    }

    /**
     * 修改保存
     *
     * @param data 前台数据
     * @return
     */
    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public Map saveOrUpdate(@RequestBody ProjectInfoVO data) {
        Map map = new HashMap();
//        ProjectInfoVO projectInfoVO = JSON.parseObject(data, ProjectInfoVO.class);
        ProjectInfoVO resultVO = projectInfoService.saveOrUpdate(data);
        map.put("code", "200");
        map.put("vo", resultVO);
        return map;
    }


    /**
     * 批量删除
     *
     * @param id 单据主键数组
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map delete(@RequestParam(required = false, name = "id") String id) {
        Map map = new HashMap();
        projectInfoService.delete(id);
        map.put("code", "200");
        return map;
    }

    /**
     * 查询一条
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findOne", method = RequestMethod.POST)
    public Map findOne(@RequestParam(required = false, name = "id") String id) {
        Map map = new HashMap();
        ProjectInfoVO projectInfoVO = projectInfoService.finOne(id);
        map.put("code", "200");
        map.put("vo", projectInfoVO);
        return map;
    }

    /**
     * 提交
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Map submit(@RequestParam(required = false, name = "data") String data) {
        Map map = new HashMap();
        ProjectInfoVO projectInfoVO = JSON.parseObject(data, ProjectInfoVO.class);
        projectInfoService.submit(projectInfoVO);
        map.put("code", "200");
        map.put("vo", projectInfoVO);
        return map;
    }

    /**
     * 提交
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/audit", method = RequestMethod.POST)
    public Map audit(@RequestParam(required = false, name = "data") String data) {
        Map map = new HashMap();
        ProjectInfoVO projectInfoVO = JSON.parseObject(data, ProjectInfoVO.class);
        projectInfoService.check(projectInfoVO);
        map.put("code", "200");
        map.put("vo", projectInfoVO);
        return map;
    }

    /**
     * 生成审批文档
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/genDocument", method = RequestMethod.POST)
    public Map genDocument(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 查询关联客户
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/rlCustomer", method = RequestMethod.POST)
    public Map rlCustomer(@RequestParam(required = false, name = "data") String data) {
        return null;
    }


    /**
     * 客户关系查询
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/custRelevance", method = RequestMethod.POST)
    public Map custRelevance(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 客户关联查询
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/custRelatation", method = RequestMethod.POST)
    public Map custRelatation(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 行业信息查询
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/industryInfo", method = RequestMethod.POST)
    public Map industryInfo(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 合同历史信息查询
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/custCoopHistoryCorp", method = RequestMethod.POST)
    public Map custCoopHistoryCorp(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 变更历史
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/versionLog", method = RequestMethod.POST)
    public Map versionLog(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 更新承租人信息
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public Map updateCustomer(@RequestParam(required = false, name = "data") String data) {
        return null;
    }

    /**
     * 更改审批人
     *
     * @param data
     * @return
     */
    @RequestMapping(value = "/changeAudit", method = RequestMethod.POST)
    public Map changeAudit(@RequestParam(required = false, name = "data") String data) {
        return null;
    }


}
