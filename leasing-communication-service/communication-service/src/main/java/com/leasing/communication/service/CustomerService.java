package com.leasing.communication.service;

import com.leasing.communication.entity.dos.CustomerDO;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c客户信息导入
 **/
public interface CustomerService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    CustomerDO save(CustomerDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CustomerDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CustomerDO update(CustomerDO vo);

    /**
     * 单体查询
     * @return
     */
    CustomerDO findOne(String pk);
}