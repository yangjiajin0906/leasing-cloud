package com.leasing.sys.controller;

import com.leasing.common.entity.sys.common.ParameterVO;
import com.leasing.common.entity.sys.web.ResResult;
import com.leasing.common.utils.ResultUtils;
import com.leasing.sys.service.ParameterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-10-12
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "leasing/sys")
public class ParameterController {

    @Resource
    ParameterService parameterService;

    @RequestMapping("test")
    public ResResult test(){
        ParameterVO vo = parameterService.findOne("0001AA10000000059Q9H");
        vo.setParamName("我的测试来了");
        ParameterVO result = parameterService.update(vo);
        return ResultUtils.successWithData(result);
    }
}
