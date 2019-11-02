package com.leasing.rentearly.rentearlyservice.projectInfo.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO.ProjectQueryVO;

import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/10/25
 * @author:jiaoshy@yonyou.com
 * @description: 普通项目审批接口
 **/
public interface ProjectInfoService {

    /**
     * 分页查询
     * @param projectQueryVO 查询条件
     * @param pagination 分页对象
     * @return 结果集
     */
    PageQueryData pageData(ProjectQueryVO projectQueryVO, Pagination pagination);


    /**
     * 查询一条数据
     * @param id 主键
     * @return vo
     */
    ProjectInfoVO finOne(String id);

    /**
     * 通过主键批量删除
     * @param ids
     */
    void delete(List<String> ids);

    /**
     * 修改保存
     * @param projectInfoVO
     */
    ProjectInfoVO saveOrUpdate(ProjectInfoVO projectInfoVO);

    /**
     * 提交
     * @param projectInfoVO
     * @return
     */
    ProjectInfoVO submit(ProjectInfoVO projectInfoVO);

    /**
     * 审核通过
     * @param projectInfoVO
     * @return
     */
    ProjectInfoVO check(ProjectInfoVO projectInfoVO);

    /**
     * 通过主键删除一条数据
     * @param id 主键
     */
    void delete(String id);

}
