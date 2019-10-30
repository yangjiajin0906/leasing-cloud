package com.leasing.rentearly.rentearlyservice.projectInfo.controller;

import com.leasing.common.base.repository.support.Pagination;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.ProjectInfoVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.queryVO.ProjectQueryVO;
import com.leasing.rentearly.rentearlyservice.projectInfo.enity.dos.ProjectInfoDO;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.ProjectInfoRepository;
import com.leasing.rentearly.rentearlyservice.projectInfo.repository.TestRepository;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestService;
import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestTransactionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Resource
    TestTransactionService testTransactionService;
    @Resource
    ProjectInfoRepository projectInfoRepository;


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
        return null;
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
        return null;
    }


    @RequestMapping("/test8")
    public Object test8(){
        String pk = "0001AA1000000012GG7J";
        return null;
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

//        List list = testRepository.findAll(projectInfoDO.toSpec());
        return "deleteSucessful";
    }

    @RequestMapping("testPageLike")
    public List testPageLike() {
        //测试全查
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        ProjectQueryVO projectInfoVO = new ProjectQueryVO();
        //PageQueryData list = testRepository.pageQuery(pagination,projectInfoVO);
        //加入条件
        projectInfoVO.setProjectCode("00000");
        //PageQueryData list1 = testRepository.pageQuery(pagination,projectInfoVO);

        Sort sort = new Sort(Sort.Direction.DESC,"ts");
        //PageQueryData list2 = testRepository.pageQuery(pagination,projectInfoVO,sort);
        return null;

    }


        @RequestMapping("testPage")
    public List testPage(){
        String pk = "12";
        testRepository.findOne(pk,ProjectInfoDO.class);
        testRepository.findOne(pk);
        pk = "0001AA1000000012GG7J";
            testRepository.findOne(pk,ProjectInfoDO.class);
            testRepository.findOne(pk);
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        ProjectQueryVO projectInfoVO = new ProjectQueryVO();
        ProjectInfoDO projectInfoDO = new ProjectInfoDO();
        //PageQueryData list = testRepository.pageQuery(pagination,projectInfoVO);
        Pageable pageable = PageRequest.of(1, 10);
        projectInfoDO.setProjectCode("00000");
//        testRepository.findAll(projectInfoDO.toSpec(),pageable);
            return null;
    }

    @RequestMapping("testPageJQ")
    public List testPageJQ(){
        Pagination pagination = new Pagination();
        pagination.setCurPage(1);
        pagination.setPageSize(20);
        ProjectQueryVO projectInfoVO = new ProjectQueryVO();
        String jq = "select p from ProjectInfoVO p order by case billstatus when 20 then 1 when 36 then 2 when 204 then 3 when 8 then 4 when 9 then 5 end,ts desc";
       // List list = testRepository.pageQuery(pagination,projectInfoVO,jq);
        return null;
    }

    @RequestMapping("findOne")
    public String findOne(){
        String query = "select * from yls_project_info where project_code like '%01482-07-05-2013-00130%'";
        String pk = "0001AA1000000012GG7J";
        testRepository.findOne(pk,ProjectInfoDO.class);
        return "ss";
    }

    @RequestMapping("findOneByJPQL")
    public String findOneByJPQL(){
        String jq = "select p from ProjectInfoVO p where p.pkProjectInfo = '0001AA1000000012GG7J'";
//        testRepository.findOneByJPQL(ProjectInfoVO.class,jq,false);
        return "ss";
    }

    @RequestMapping("findByNativeSql")
    public String findByNativeSql(){
        String query = "select * from yls_project_info where project_code like '%01482-07-05-2013-00130%'";
//        testRepository.findByNativeSql(ProjectInfoDO.class,query);
        return "ss";
    }

    @RequestMapping("findOneByNativeSql")
    public String findOneByNativeSql(){
        String query = "select * from yls_project_info where pk_project_info like  = '0001AA1000000012GG7J'";
//        testRepository.findByNativeSql(ProjectInfoDO.class,query);
        return "ss";
    }

    @RequestMapping("test1")
    public String test1(){
        testTransactionService.testRequired();
        testTransactionService.testRequiredNewException();
        return "ss";
    }

    @RequestMapping("test2")
    public String test2(){
        testTransactionService.testRequiredNewException();
        testTransactionService.testRequiredException();
        return "ss";
    }

    @RequestMapping("test3")
    public String test3(){
        testTransactionService.testRequiredAndNew();
        return "ss";
    }

    @RequestMapping("pageData")
    public List pageData(){
        Pagination pagination = new Pagination(1,100);
        ProjectQueryVO projectQueryVO = new ProjectQueryVO();
        List<ProjectInfoVO> list = projectInfoRepository.pageData();
        return list;
    }


    /*Pageable pageable = new PageRequest(0,5);
     */
    @RequestMapping("pageDataPage")
    public List pageDataPage(){
        Pageable pageable = new PageRequest(0,20);
        List<ProjectInfoVO> list = projectInfoRepository.pageDataPage(pageable);
        return list;
    }

}
