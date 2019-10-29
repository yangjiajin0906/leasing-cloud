package com.leasing.rentearly.rentearlyservice.projectInfo.service.Impl;

import com.leasing.common.base.repository.support.Pagination;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO.ProjectQueryVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.ProjectInfoRepository;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.ProjectInfoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/10/25
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Service(value = "projectInfoService")
@Transactional
public class ProjectInfoServiceImpl implements ProjectInfoService {


    @Resource
    ProjectInfoRepository projectInfoRepository;


    @Override
    public Map pageData(ProjectQueryVO projectQueryVO, Pagination pagination) {
        Map map = new HashMap();
        Pageable pageable = new PageRequest(pagination.getCurPage(),pagination.getPageSize());
        List<ProjectInfoVO> list = projectInfoRepository.pageDataPage(pageable);
        map.put("result",list);
        map.put("toTal",20);  //没有分页之前 暂时这么写
        map.put("code","200");
        return map;
    }

    @Override
    public ProjectInfoVO finOne(String id) {

        return projectInfoRepository.findOneVO(id);
    }

    @Override
    public void delete(List<String> ids) {
        projectInfoRepository.deleteByIds(ids);
    }

    @Override
    public ProjectInfoVO saveOrUpdate(ProjectInfoVO projectInfoVO) {
        //这里需要将vo 转换成 DO
        ProjectInfoDO projectInfoDO = new ProjectInfoDO();
        projectInfoRepository.saveAndFlush(projectInfoDO);
        return projectInfoVO;
    }

    @Override
    public ProjectInfoVO submit(ProjectInfoVO projectInfoVO) {
        //业务逻辑处理
        return null;
    }

    @Override
    public ProjectInfoVO check(ProjectInfoVO projectInfoVO) {
        //业务逻辑处理
        return null;
    }
}
