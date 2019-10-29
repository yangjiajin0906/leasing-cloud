package com.leasing.sys.controller;

import com.leasing.common.utils.base.ResultUtils;
import com.leasing.common.entity.sys.FuncMenuVO;
import com.leasing.common.base.web.ResResult;
import com.leasing.sys.service.FuncMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/sys")
public class FuncMenuController {

    @Autowired
            @DateTimeFormat
    FuncMenuService funcMenuService;

    @RequestMapping(value = "/getFuncMenu",method = RequestMethod.POST)
    public ResResult getFuncMenu(){
        List<FuncMenuVO> result = funcMenuService.getAllMenu();
        return ResultUtils.successWithData(result);
    }

}
