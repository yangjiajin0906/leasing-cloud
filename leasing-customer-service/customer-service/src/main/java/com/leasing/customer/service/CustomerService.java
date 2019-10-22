package com.leasing.customer.service;

import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-22
 * @author:zhangzhhn@yonyou.com
 * @description: 客户服务接口
 **/
public interface CustomerService {

    /**
     * 根据客户主键更新客户单据状态
     *
     * @param newBillstatus
     * @param pkCustomer
     */
    void updateBillStatus(Short newBillstatus, String pkCustomer);


    /**
     * 修改客户信息
     *
     * @param vo 客户修改成vo
     */
    void saveOrUpdate(CustomerVO vo);

    /**
     * 修改客户信息
     * @param vo 修改成vo
     */
    void saveOrUpdate(CustomerCorpAllVO vo);

}