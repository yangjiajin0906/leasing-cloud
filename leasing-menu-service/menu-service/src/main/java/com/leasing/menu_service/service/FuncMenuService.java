package com.leasing.menu_service.service;

import com.leasing.menu_service.pojo.FuncMenuVO;

import java.util.List;
import java.util.Map;

/**
 * Created by lvcn on 2019-7-16.
 * 功能菜单管理接口
 */
public interface FuncMenuService {

    List<FuncMenuVO> getAllMenu();

    List<Map> getAllList();
    List<FuncMenuVO> getMenuByRole();
    List<FuncMenuVO> getMenuByUser();

}
