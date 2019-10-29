package com.leasing.sys.service;

/**
 * @project:leasing-cloud
 * @date:2019-10-15
 * @author:wangjc@yonyou.com
 * @description:
 **/
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.sys.entity.dos.DFuncMenuDO;
import com.leasing.sys.entity.vo.DFuncMenuVO;

import java.util.List;
import java.util.Map;

public interface DFuncMenuService {
    /**
     * 获取整个所有的菜单列表VO(分页查询 条件查询  排序查询)
     * @return
     */
    PageQueryData<DFuncMenuVO> getMenuList();

    /**
     * 获取存储库内的菜单列表DO
     * @return
     */
    PageQueryData getDMenuList();

    /**
     * 根据pk查找单个对象 调用基类BaseRepository的findOne方法 返回对象为DO
     * @param pk
     */
    DFuncMenuDO findOneDO(String pk);

    /**
     * 自定义JPQL返回自定义类型对象  调用基类BaseRepository的findOneByJPQL方法  返回对象为VO(也可用作查询DO)
     * @param jpqlName
     */
    DFuncMenuVO findOneVO(String jpqlName);

    /**
     * 源生SQL返回List<Map<String,Object>> 调用基类findByNativeSql方法  返回对象在dozer中配置直接转化为VO
     * @param sql
     */
    List<Map<String,Object>> findByNativeSQL(String sql);

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
