package com.leasing.rentearly.rentearlyservice.projectInfo.service.Impl;

import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.TestRepository;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Service(value = "testServiceImpl")
@Transactional
public class TestServiceImpl implements TestService {

    @Resource
    JdbcTemplate jdbcTemplate;
    @Resource
    TestRepository testRepository;

    @Override
    public List queryForList() {
        String query = "select * from sm_user_view";

        return jdbcTemplate.queryForList(query);
    }

    @Override
    public void testLock() {
        String pk = "10000000000000000010";
        ProjectInfoVO projectInfoVO = testRepository.findOne(pk);
        ProjectInfoVO projectInfoVO1 = testRepository.findOne(pk);

        testRepository.saveAndFlush(projectInfoVO);
        testRepository.saveAndFlush(projectInfoVO1);

    }
}
