package com.leasing.menu_service.controller;

import com.leasing.menu_service.pojo.FuncMenuVO;
import com.leasing.menu_service.service.FuncMenuService;
import com.leasing.menu_service.utils.Result;
import com.leasing.menu_service.utils.ResultUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-09-26
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/menu")
public class MenuController {

    @Resource
    FuncMenuService funcMenuService;

    @PostMapping(value = "/getFuncMenu")
    public Result getFuncMenu(){
        List<FuncMenuVO> result = funcMenuService.getAllMenu();
        return ResultUtils.successWithData(result);
    }
}