package com.leasing.common.service.sys;

import com.leasing.common.entity.common.dos.PowerMenuDO;
import com.leasing.common.entity.common.dto.RoleOrgDTO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;
import com.leasing.common.entity.common.vo.PowerMenuVO;
import com.leasing.common.entity.foundation.vo.RoleOrgVO;
import com.leasing.common.entity.foundation.vo.UserVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description: 权限分配节点接口类
 **/
public interface PowerMenuService {
    /**
     * 给定用户 获取该角色当前系统下得到的权限菜单
     * @return
     */
    List<DFuncMenuVO> ListPowerFuncMenuByUser(UserVO user);

    /**
     * 根据中间表VO 获取 限定机构 角色 得到的权限菜单
     */
    List<DFuncMenuVO> ListPowerFuncMenu(RoleOrgVO vo);

    /**
     *  获取所有的菜单权限中间表VO 用于前台树渲染
     */
    List<PowerMenuVO> ListAllPowerMenuVO();

    /**
     * 获取所有角色与机构中间表数据 并封装为前台展示DTO
     */
    List<RoleOrgDTO> ListAllRoleOrg();

    /**
     * 删除某角色与指定机构下的所有功能权限
     */
    void deletePowerFuncMenu(String pkRole,String pkOrg);

    /**
     * 给指定角色插入所有功能权限的数据
     */
    void addPowerFuncMenu(PowerMenuDO dos);
}
