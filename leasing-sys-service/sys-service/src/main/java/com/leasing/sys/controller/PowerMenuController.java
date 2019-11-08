package com.leasing.sys.controller;

import com.leasing.common.base.repository.RoleOrgRepo;
import com.leasing.common.base.repository.UserRepo;
import com.leasing.common.base.web.ResResult;
import com.leasing.common.entity.common.dos.PowerMenuDO;
import com.leasing.common.entity.common.dto.RoleOrgDTO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.entity.common.vo.PowerMenuVO;
import com.leasing.common.service.DFuncMenuService;
import com.leasing.common.service.PowerMenuService;
import com.leasing.common.utils.base.ResultUtils;
import com.leasing.common.vo.foundation.RoleOrgVO;
import com.leasing.common.vo.foundation.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @project:leasing-cloud
 * @date:2019/11/6
 * @author:wangjc@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping(value = "/leasing/powermenu")
public class PowerMenuController {
    @Autowired
    PowerMenuService powerMenuService;

    @Autowired
    DFuncMenuService dFuncMenuService;


    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleOrgRepo roleOrgRepo;

    /**
     * 获取所有带机构的角色List并封装为DTO 用于前台权限控制左侧列表展示
     */
    @RequestMapping(value = "/ListAllRoleOrg")
    public ResResult ListAllRoleOrg(){
        List<RoleOrgDTO> list = powerMenuService.ListAllRoleOrg();
        return ResultUtils.successWithData(list);
    }

    /**
     * 获取所有的角色与功能中间表VO的列表
     */
    @RequestMapping(value = "/ListAllPowerMenuVO")
    public ResResult ListAllPowerMenuVO(){
        List<PowerMenuVO> list = powerMenuService.ListAllPowerMenuVO();
        return ResultUtils.successWithData(list);
    }

    /**
     * 获取某用户所具有权限的功能菜单
     * @return
     */
    @RequestMapping(value = "/ListPowerFuncMenuByUser")
    public ResResult ListPowerFuncMenuByUser(){
        UserVO user = userRepo.findOne("0001A91000000003D6R3",UserVO.class);
        List<DFuncMenuVO> list = powerMenuService.ListPowerFuncMenuByUser(user);
        return ResultUtils.successWithData(list);
    }

    /**
     *  获取指定角色 并限定机构 的功能菜单List 前台传递数据理论上应为RoleOrgVO
     */
    @RequestMapping(value = "/ListPowerFuncMenu")
    public ResResult ListPowerFuncMenu(){
        RoleOrgVO roleOrgVO = roleOrgRepo.findOne("1001A910000000002OIE",RoleOrgVO.class);
        List<DFuncMenuVO> list = powerMenuService.ListPowerFuncMenu(roleOrgVO);
        return ResultUtils.successWithData(list);
    }

    /**
     * 为某角色赋予相应的功能权限List 前台传递List与当前中间表RoleOrgVO
     */
    @RequestMapping(value = "/givePowerFuncMenu")
    public ResResult updatePowerFuncMenu(){
        RoleOrgVO roleOrgVO = roleOrgRepo.findOne("1001A910000000002OIE",RoleOrgVO.class);
        List<DFuncMenuVO> list = dFuncMenuService.getAllMenuList();
        List<PowerMenuDO> powerlist = new ArrayList<>();
        for(DFuncMenuVO vo : list){
            PowerMenuDO dos =new PowerMenuDO();
            String str = UUID.randomUUID().toString().replace("-","");
            dos.setPkPower(str.substring(0,20));
            dos.setPkCorp(roleOrgVO.getPkCorp().getPkOrg());
            dos.setPkOrg(roleOrgVO.getPkCorp().getPkOrg());
            dos.setPkFuncmenu(vo.getPkFuncmenu());
            dos.setPkRole(roleOrgVO.getPkRole().getPkRole());
            powerlist.add(dos);
        }
        //删除对应角色指定机构下的所有功能List
        powerMenuService.deletePowerFuncMenu(roleOrgVO.getPkRole().getPkRole(),roleOrgVO.getPkCorp().getPkOrg());
        //插入修改后的所有功能集合
        for(PowerMenuDO dos : powerlist){
            powerMenuService.addPowerFuncMenu(dos);
        }
        return ResultUtils.successWithData(list);
    }




}