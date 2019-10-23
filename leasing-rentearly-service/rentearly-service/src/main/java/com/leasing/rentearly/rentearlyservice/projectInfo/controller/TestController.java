package com.leasing.rentearly.rentearlyservice.projectInfo.controller;

import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.refVO.ProjectInfoRefVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.TestRepository;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    TestService testService;
    @Resource
    TestRepository testRepository;


    @RequestMapping("/test")
    public List test(){
                String name = "侯莹莹";
        return testRepository.findTest(name);
    }

    @RequestMapping("/testLock")
    public void testLock(){
        testService.testLock();
    }

    @RequestMapping("/testT")
    public Object testToYing(){
        String pk = "0001AA1000000012GG7J";
        List projectInfoRefVO = (List) testRepository.findTest6(pk,ProjectInfoRefVO.class);
        return projectInfoRefVO;
    }
//
    @RequestMapping("/testLeft")
    public List testss(){
        String pk = "0001AA1000000012GG7J";
        return testRepository.findTest2(pk);
    }


    @RequestMapping("/testFetch")
    public List testFetch(){
        String pk = "0001AA1000000012GG7J";
        return testRepository.findTest3(pk);
    }

    @RequestMapping("/findTest4")
    public Object findTest4(){
        String pk = "0001AA1000000012GG7J";
        List projectInfoRefVO = (List) testRepository.findTest4(pk,ProjectInfoRefVO.class);
        return projectInfoRefVO;
    }


    @RequestMapping("/test8")
    public Object test8(){
        String pk = "0001AA1000000012GG7J";
        List list = (List) testRepository.findByPkProjectInfo(pk,ProjectInfoRefVO.class);
        return list;
    }

    @RequestMapping("/findFetch")
    public Object findFetch(){
        String pk = "0001AA1000000012GG7J";
        List list =  testRepository.findFetch(pk);
        return list;
    }


    @RequestMapping("/findProjectALL")
    public Object findProjectALL(){
        List list =  testRepository.findProjectALL();
        return list;
    }


    @RequestMapping("/testUpdate")
    public String testUpdate(){
        testService.update();
        return "update sucess";
    }

    @RequestMapping("delete")
    public String delete(){
//        testService.delete();
        ProjectInfoDO projectInfoDO = new ProjectInfoDO();
//        projectInfoDO.setProjectName("昆明轨道交通有限公司交通运输回租项目");
        projectInfoDO.setProjectName("昆明");
        projectInfoDO.setProjectCode("01482-07-05-2013-00130");

        List list = testRepository.findAll(projectInfoDO.toSpec());
        return "deleteSucessful";
    }
}
