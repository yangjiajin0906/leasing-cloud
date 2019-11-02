package com.leasing.rentearly.rentearlyservice.projectInfo.service.Impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.utils.base.DozerUtils;
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
    public PageQueryData pageData(ProjectQueryVO projectQueryVO, Pagination pagination) {
        return projectInfoRepository.pageQuery(pagination,projectQueryVO,"ProjectInfoVO.queryForGrid");
    }

    @Override
    public ProjectInfoVO finOne(String id) {
        projectInfoRepository.findOne(id,ProjectInfoVO.class);
        return projectInfoRepository.findOneVO(id);
    }

    @Override
    public void delete(List<String> ids) {
//        projectInfoRepository.deleteByIds(ids);
    }

    @Override
    public ProjectInfoVO saveOrUpdate(ProjectInfoVO projectInfoVO) {
        //这里需要将vo 转换成 DO
        ProjectInfoDO projectInfoDO = DozerUtils.convert(projectInfoVO,ProjectInfoDO.class);
        projectInfoDO.setPkOrg("1003");
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

    @Override
    public void delete(String id) {
        id = "10000000000000000010";
        projectInfoRepository.deleteById(id);
    }
}
