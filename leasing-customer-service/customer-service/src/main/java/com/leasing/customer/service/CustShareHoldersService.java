package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.dos.CustShareHoldersDO;
import com.leasing.customer.dao.query.CustShareHoldersQuery;
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
     * 分页查询
     *
     * @param pagination 分页
     * @param query      查询条件
     * @return 分页列表
     */

    PageQueryData<CustShareHoldersVO> pageQuery(Pagination pagination, CustShareHoldersQuery query);

    /**
     * 根据客户主键查询股东情况
     *
     * @param pkCustomer 客户主键
     * @return 股东情况列表
     */
    List<CustShareHoldersDO> getCustShareHolders(String pkCustomer);
}