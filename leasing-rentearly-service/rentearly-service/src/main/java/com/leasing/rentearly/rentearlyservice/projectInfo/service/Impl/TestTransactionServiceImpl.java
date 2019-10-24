package com.leasing.rentearly.rentearlyservice.projectInfo.service.Impl;

import com.leasing.rentearly.rentearlyservice.projectInfo.service.TestTransactionService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/10/24
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
@Service(value = "testTransactionServiceImpl")
public class TestTransactionServiceImpl implements TestTransactionService {
    @Resource
    JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void testRequired() {

        String update = "update yls_project_info set project_name = '测试事务2' where pk_project_info = '10000000000000000010'";
        jdbcTemplate.update(update);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void testRequiredNew() {
        String update = "update yls_project_info set project_name = '测试事务' where pk_project_info = '0001AA1000000012GG7J'";
        jdbcTemplate.update(update);
    }

    @Override
    public void testNoTransaction() {

        testRequiredNewException();
        testRequiredException();

    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void testRequiredAndNew() {
        testRequired();
        testRequiredNewException();

    }

    public void createException(){
        //这里报一个空指针
        Map map = new HashMap();
        map.get("test").toString();
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void testRequiredNewException() {
        String update = "update yls_project_info set project_name = '测试事务5' where pk_project_info = '0001AA1000000012GG7J'";
        jdbcTemplate.update(update);
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void testRequiredException() {
        String update = "update yls_project_info set project_name = '测试事务6' where pk_project_info = '10000000000000000010'";
        jdbcTemplate.update(update);
        createException();
    }

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public void testRequiredAndNewException() {
        testRequired();
        testRequiredNewException();
    }
}
