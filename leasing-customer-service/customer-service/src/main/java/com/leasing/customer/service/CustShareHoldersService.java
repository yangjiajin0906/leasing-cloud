package com.leasing.customer.service;

import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.vo.CustRelatedCompanyVO;
import com.leasing.customer.dao.vo.CustShareHoldersVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description: 客户股东情况服务接口
 **/
public interface CustShareHoldersService {

    /**
     * 查询客户的客户股东情况
     *
     * @param pkCustomer 客户主键
     * @return 客户股东列表
     */
    List<CustShareHoldersVO> findByCustomer(String pkCustomer);

    List<CustShareHoldersVO> findByCustomer(CustomerDTO customerDTO);
}