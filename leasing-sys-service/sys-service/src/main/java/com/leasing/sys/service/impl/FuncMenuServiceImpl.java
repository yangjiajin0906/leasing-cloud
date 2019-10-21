package com.leasing.sys.service.impl;

import com.leasing.common.entity.sys.FuncMenuVO;
import com.leasing.sys.dao.repository.FuncMenuRepository;
import com.leasing.sys.service.FuncMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-9-23
 * @author:lvcna@yonyou.com
 * @description:
 **/
@Service("sys.FuncMenuServiceImpl")
public class FuncMenuServiceImpl implements FuncMenuService{
    @Autowired
    FuncMenuRepository funcMenuRepository;

    @Override
    public List<FuncMenuVO> getAllMenu() {
        List<FuncMenuVO> menuVOS = funcMenuRepository.findByTarget("jic-leasing");
        return menuVOS;
    }

    @Override
    public List<FuncMenuVO> getMenuByRole() {
        return null;
    }

    @Override
    public List<FuncMenuVO> getMenuByUser() {
        return null;
    }
}
