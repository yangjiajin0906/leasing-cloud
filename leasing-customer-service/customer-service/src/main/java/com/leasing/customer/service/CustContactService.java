package com.leasing.customer.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.dao.vo.CustContactVO;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: 联系人服务接口
 **/
public interface CustContactService {

    PageQueryData<CustContactVO> pageQuery(Pagination pagination, CustContactQuery query);
}