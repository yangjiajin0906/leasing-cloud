package com.leasing.project.controller;

import com.leasing.project.refVO.DeptdocRefVO;
import com.leasing.project.refVO.OrgRefVO;
import com.leasing.project.repository.TestRepository;
import com.leasing.project.vo.ProjectInfoVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/hello")
@RestController
public class TestController {

    @Resource
    JdbcTemplate jdbcTemplate;
    @Resource
    TestRepository testRepository;

    @RequestMapping("/world")
    public String getVale() {
        String key = "10000000000000000010";
        ProjectInfoVO projectInfoVO = testRepository.getByPrimaryKey(key);

        projectInfoVO = testRepository.getByPrimaryKeyAndTs(key,"2019-09-26 18:00:00");

        List<ProjectInfoVO> list = testRepository.queryByPrimaryKey(key);

        list = testRepository.queryObjByPrimaryKey(key);
        return "hello World";
    }

    @RequestMapping("/test")
    public List getList() {
        long startTime = System.currentTimeMillis();
        List<ProjectInfoVO> list = testRepository.findAll();
        long endTime = System.currentTimeMillis();
        float excTime = (float) (endTime - startTime) / 1000;
        System.out.println("执行时间：" + excTime + "s");
        return list;
    }

    /**
     * 测试分页
     */
    @RequestMapping("/testPage")
    public List getListPageable(){
        Page<ProjectInfoVO> page = testRepository.findAll(new PageRequest(0, 5, new Sort(Sort.Direction.ASC, "billstatus")));
        return page.getContent();
    }

    /**
     * 测试单个查询
     */
    public List getOne(){
        List<ProjectInfoVO> result = testRepository.findByPrimaryKey("0001MG00000000062690");
        ProjectInfoVO projectInfoVO = result.get(0);
        System.out.println(projectInfoVO.getPk_prj_manager().getName()+projectInfoVO.getPk_prj_manager().getPk_deptdoc().getPk());
        return result;
    }

    /**
     * 新增
     */
    public void addData(){
        ProjectInfoVO projectInfoVO = new ProjectInfoVO();
        projectInfoVO.setProject_code("0001");
        projectInfoVO.setProject_name("测试插入");
        DeptdocRefVO deptdocRefVO = new DeptdocRefVO();
        deptdocRefVO.setPk("1003111000000000003I");
        projectInfoVO.setProject_dept(deptdocRefVO);
        projectInfoVO.setBillstatus(Short.valueOf("9"));
        OrgRefVO orgRefVO = new OrgRefVO();
        orgRefVO.setPk("1003");
        projectInfoVO.setPk_org(orgRefVO);
        projectInfoVO.setVersion_num(1);
        projectInfoVO.setIf_new(Short.valueOf("0"));
        projectInfoVO.setTs("2019-09-26 18:00:00");
        testRepository.saveAndFlush(projectInfoVO);
        System.out.println("插入成功");
    }

    /**
     * 删除
     */
    public void deleteData(){
        testRepository.deleteById("10000000000000000010");
    }

    /**
     * 修改
     */
    public void updateData(){
        List<ProjectInfoVO> result = testRepository.findByPrimaryKey("10000000000000000010");
        ProjectInfoVO projectInfoVO = result.get(0);
        projectInfoVO.setProject_code(projectInfoVO.getProject_code()+"test");
        testRepository.saveAndFlush(projectInfoVO);
        System.out.println("更新成功");
    }

    /**
     * 克隆数据
     */
    public ProjectInfoVO colData(ProjectInfoVO projectInfoVO){
        return projectInfoVO;
    }




}
