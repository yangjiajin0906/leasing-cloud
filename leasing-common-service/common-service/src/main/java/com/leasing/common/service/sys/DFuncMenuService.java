package com.leasing.common.service.sys;

/**
 * @project:leasing-cloud
 * @date:2019-10-15
 * @author:wangjc@yonyou.com
 * @description:
 **/
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.entity.common.dos.DFuncMenuDO;
import com.leasing.common.entity.common.vo.DFuncMenuVO;

import java.util.List;

public interface DFuncMenuService {
    /**
     * 获取整个所有的菜单列表VO(分页查询 条件查询  排序查询)
     * @return
     */
    List<DFuncMenuVO> getMenuList(String systemPk);

    /**
     * 获取整个所有菜单列表List
     */
    List<DFuncMenuVO> getAllMenuList();

    /**
     * 根据pk查找单个对象 调用基类BaseRepository的findOne方法 返回对象为DO
     * @param pk
     */
    DFuncMenuDO findOneDO(String pk);


    /** 新增菜单项 前台进controller层为vo 配置直接转换为do保存 直接调save方法或者saveAndFlush方法
     * 更改菜单数据(存在部分修改及整体修改情况)
     * @param dos
     */
    void addorupdate(DFuncMenuDO dos);

    /**
     * 单独修改do中部分字段 以jpql形式存储在orm中
     * @param dos
     */
    void update(DFuncMenuDO dos);


    /**
     * 删除菜单项 调用存储库的deleteby加字段的方法 直接删除单条菜单
     */
    void delete(DFuncMenuDO dos);


}
