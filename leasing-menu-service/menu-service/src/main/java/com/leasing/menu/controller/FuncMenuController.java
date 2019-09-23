package com.leasing.menu.controller;


import com.leasing.common_service.util.Result;
import com.leasing.common_service.util.ResultUtils;
import com.leasing.menu.service.FuncMenuService;
import com.leasing.menu_data.pojo.FuncMenuVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by lvcn on 2019-7-11.
 */
@RequestMapping("/jic/menu/funcMenu")
@RestController
public class FuncMenuController {
    @Resource
    FuncMenuService funcMenuService;

    @RequestMapping(value = "/getFuncMenu")
    public Result getFuncMenu(){
        List<FuncMenuVO> result = funcMenuService.getAllMenu();
        return ResultUtils.successWithData(result);
    }
    @PostMapping(value = "/list")
    public Result list(){
        List<Map> result = funcMenuService.getAllList();
        return ResultUtils.successWithData(result);
    }

    @PostMapping(value = "/save")
    public Result saveFuncMenu(@RequestParam(value = "data") String data) {
        System.out.printf(data);
        return null;
    }


}
