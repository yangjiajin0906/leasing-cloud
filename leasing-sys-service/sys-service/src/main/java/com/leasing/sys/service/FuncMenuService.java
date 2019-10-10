package com.leasing.sys.service;

import com.leasing.common.entity.sys.FuncMenuVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface FuncMenuService {
    List<FuncMenuVO> getAllMenu();
    List<FuncMenuVO> getMenuByRole();
    List<FuncMenuVO> getMenuByUser();
}
