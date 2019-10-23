package com.leasing.rentearly.rentearlyservice.projectInfo.service;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/21
 * @author:jiaoshy@yonyou.com
 * @description:
 **/

public interface TestService {
    List queryForList();

    void testLock();

    void update();

    void delete();
}
