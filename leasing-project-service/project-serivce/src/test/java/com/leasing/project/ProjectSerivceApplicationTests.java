package com.leasing.project;

import com.leasing.project.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectSerivceApplicationTests {

    @Resource
    TestRepository testRepository;
    @Test
    public void contextLoads() {
        List list = testRepository.findAll();
    }


}
