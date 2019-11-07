package com.leasing.customer.service;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.customer.dao.dos.CustExecutiveInformationDO;
import com.leasing.customer.dao.query.CustExecutiveInformationQuery;
import com.leasing.customer.dao.vo.CustExecutiveInformationVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 高管信息服务接口
 **/

public interface CustExecutiveInformationService  {

    PageQueryData pageQuery(Pagination pagination, CustExecutiveInformationQuery query);

}