package com.leasing.rentearly.rentearlyservice.projectInfo.service;

/**
 * @project:leasing-cloud
 * @date:2019/10/24
 * @author:jiaoshy@yonyou.com
 * @description: 测试事务接口
 **/
public interface TestTransactionService {

    /**
     * 测试 当前有事务从当前事务继承 没有事务新启一个事务
     * 这也是默认当方式
     */
    void testRequired();

    /**
     * 测试挂起当前事务 创建一个新事物
     */
    void testRequiredNew();

    /**
     * 测试没有事务方法 调用事务方法
     */
    void testNoTransaction();

    /**
     * 测试默认事务 调用新启动事务
     */
    void testRequiredAndNew();

    void createException();

    void testRequiredNewException();

    void testRequiredException();

    void testRequiredAndNewException();


}
