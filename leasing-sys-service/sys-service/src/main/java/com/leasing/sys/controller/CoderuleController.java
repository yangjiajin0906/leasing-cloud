package com.leasing.sys.controller;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.entity.sys.dto.ParameterDTO;
import com.leasing.common.enums.constant.CodeRuleKey;
import com.leasing.common.enums.constant.FuncCodeConstant;
import com.leasing.common.service.sys.CoderuleService;
import com.leasing.common.base.web.ResResult;

import com.leasing.common.entity.common.dos.CoderuleDO;
import com.leasing.common.entity.common.dos.CoderuleTypeDO;
import com.leasing.common.entity.common.vo.CoderuleVO;
import com.leasing.common.utils.base.BaseBusinessUtils;
import com.leasing.common.utils.sys.CodeRuleUtil;
import com.leasing.common.utils.tools.DozerUtils;
import com.leasing.common.utils.sys.ResultUtils;
import com.leasing.common.entity.foundation.vo.OrgDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        CoderuleDO dto = coderuleService.getCoderuleDO("0001AA1000000000QP4V");
        CoderuleDO dos = DozerUtils.convert(vo,CoderuleDO.class);
        dos.setCoderuleType(dto.getCoderuleType());
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
        CoderuleTypeDO zdto = new CoderuleTypeDO();
        String str1 = UUID.randomUUID().toString().replace("-","");
        zdto.setPkCoderuleType(str1.substring(0,20));
        List<CoderuleTypeDO> list = new ArrayList<>();
        list.add(zdto);
        vo.setCoderuleType(list);
        CoderuleDO dos = DozerUtils.convert(vo,CoderuleDO.class);
        coderuleService.saveCoderule(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 删除编码规则配置对象
     * @return dos
     */
    @RequestMapping(value = "/deleteCoderule")   //前台传pk 后台直接查DO删除  否则无法删除子表
    public ResResult deleteCoderule(){
//        CoderuleVO vo = coderuleService.getCoderule("3fb99bc47e494532a1dd");
        CoderuleDO dos = coderuleService.getCoderuleDO("3fb99bc47e494532a1dd");
        coderuleService.deleteCoderule(dos);
        return ResultUtils.successWithData(dos);
    }

    /**
     * 测试编码生成规则Util
     */
    @RequestMapping(value = "/testUtil")
    public ResResult testUtil(){
        Map<String, String> map = new HashMap<>();
        map.put(CodeRuleKey.FUN_CODE, FuncCodeConstant.LEASECAL_FULL_ZT);
        map.put(CodeRuleKey.VARIABLE_NAME, CodeRuleKey.PK_LEASECAL_CODE);
        map.put(CodeRuleKey.OPERATOR, "何爰蒝");
//        map.put(CodeRuleKey.FUN_CODE, FuncCodeConstant.CUS_CORP_FUNCODE);
//        map.put(CodeRuleKey.VARIABLE_NAME, CodeRuleKey.PK_CUSTOMER_CORP_CODE);
        //测试客户节点生成编码
        String code = CodeRuleUtil.getCodeRule(map);
        return ResultUtils.successWithData(code);
    }

    /**
     * 测试校验唯一性Util
     */
    @RequestMapping(value = "/testUnique")
    public boolean testUnique(){
        CoderuleVO vo = coderuleService.getCoderule("0001AA10000000059BLD");
        String wheresql = "";
        return BaseBusinessUtils.checkUniqueFields(vo,new String[] { "businessPoint" }, wheresql);
    }




}