package com.leasing.rentearly.rentearlyservice.projectInfo.service.Impl;

import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectApprovalDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.ProjectApprovalRepository;
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
    @Resource
    ProjectApprovalRepository projectApprovalRepository;

    @Override
    public List queryForList() {
        String query = "select * from sm_user_view";

        return jdbcTemplate.queryForList(query);
    }

    @Override
    public void testLock() {
        String pk = "10000000000000000010";
        ProjectInfoDO projectInfoVO = testRepository.findOne(pk);
        ProjectInfoDO projectInfoVO1 = testRepository.findOne(pk);

        projectInfoVO.setProjectCode("0001");
        projectInfoVO1.setProjectCode("0009");
        testRepository.save(projectInfoVO);
        testRepository.save(projectInfoVO1);

        testRepository.saveAndFlush(projectInfoVO);
        testRepository.saveAndFlush(projectInfoVO1);

        String ts = "2019-09-10 10:23:16";
        String update = "update yls_project_info set ts = ? where pk_project_info = ?";
        jdbcTemplate.update(update, new Object[]{ts, pk});
        testRepository.save(projectInfoVO);

    }

    @Override
    public void update() {
        String pk = "10000000000000000010";
        ProjectInfoDO projectInfoVO = testRepository.findOne(pk);
        int result = testRepository.updateTest("99999", projectInfoVO.getPkProjectInfo(), projectInfoVO.getTs());
        if (result != 1) {
            System.out.println("数据一倍他人修改");
        }
    }

    @Override
    public void delete() {
//        for(int i = 0;i<5;i++){
//
//            ProjectApprovalDO projectApprovalDO = new ProjectApprovalDO();
//            projectApprovalDO.setBillstatus(i);
//            projectApprovalDO.setProjectFilingBatch(i);
//            projectApprovalDO.setProjectFilingCode(String.valueOf(i));
//            projectApprovalDO.setProjectFilingName(String.valueOf(i));
//            projectApprovalDO.setPkOrg("1003");
//            projectApprovalDO.setThingType("10000000000000000010");
//            projectApprovalRepository.save(projectApprovalDO);
//        }

        List list = (List) testRepository.findByPkProjectInfo("10000000000000000010",ProjectInfoDO.class);
    }
}
