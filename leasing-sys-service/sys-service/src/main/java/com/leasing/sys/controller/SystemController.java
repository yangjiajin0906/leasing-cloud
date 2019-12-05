package com.leasing.sys.controller;

import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.service.sys.SystemService;
import com.leasing.common.utils.sys.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/16
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class SystemController {
    @Autowired
    SystemService systemService;

    @RequestMapping(value = "/listSystem")
    public ResResult ListSystem(){
        List<SystemVO> resultlist = systemService.ListSystem();
        return ResultUtils.successWithData(resultlist);
    }
}