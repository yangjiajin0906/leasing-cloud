package com.leasing.sys.controller;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.service.CoderuleService;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.dto.sys.ParameterDTO;
import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.vo.CoderuleVO;
import com.leasing.common.utils.base.DozerUtils;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.common.vo.foundation.OrgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/11/1
 * @author:wangjc@yonyou.com
 * @description:编码规则前台controller
 **/
@RestController
@RequestMapping(value = "/leasing/coderule")
public class CoderuleController {
    @Autowired
    CoderuleService coderuleService;
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 获取编码规则配置列表
     * @return PageQueryData
     */
    @RequestMapping(value = "/ListCoderule")
    public ResResult ListCoderule(){
        PageQueryData<CoderuleVO> result = coderuleService.ListCoderule();
        return ResultUtils.successWithData(result);
    }

    /**
     * 更新编码规则配置数据
     * @return
     */
    @RequestMapping(value = "/updateCoderule")
    public ResResult updateCoderule(){
        CoderuleVO vo = coderuleService.getCoderule("0001AA1000000000QP4V");
        CoderuleDO dos = DozerUtils.convert(vo,CoderuleDO.class);
        dos.setPkChecker("0001A910000000004I8N");
        coderuleService.updateCoderule(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 新增编码规则配置数据
     * @return
     */
    @RequestMapping(value = "/saveCoderule")
    public ResResult saveCoderule(){
        CoderuleVO vo = new CoderuleVO();
        String str = UUID.randomUUID().toString().replace("-","");
        vo.setPkCoderule(str.substring(0,20));
        vo.setBillstatus(Short.valueOf("20"));
        ParameterDTO param = new ParameterDTO();
        param.setPkParameter("0001AA1000000006OQO7");
        vo.setVariableName(param);
        vo.setBusinessPoint("0001AA10000000091ANR");
        vo.setCodeRuleName("'SH-'  + 日期 + 顺序号");
        OrgDTO dto = new OrgDTO();
        dto.setPkOrg("1003");
        vo.setPkOrg(dto);
        CoderuleDO dos = DozerUtils.convert(vo,CoderuleDO.class);
        coderuleService.saveCoderule(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 删除编码规则配置对象
     * @return dos
     */
    @RequestMapping(value = "/deleteCoderule")
    public ResResult deleteCoderule(){
        CoderuleVO vo = coderuleService.getCoderule("0001AA1000000000QP4V");
        CoderuleDO dos = DozerUtils.convert(vo,CoderuleDO.class);
        coderuleService.deleteCoderule(dos);
        return ResultUtils.successWithData(dos);
    }




}