package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustExecutiveInformationDO;
import com.leasing.customer.dao.query.CustExecutiveInformationQuery;
import com.leasing.customer.dao.vo.CustExecutiveInformationVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description: 高管信息DAO
 **/
@Repository("customer.CustExecutiveInformationRepo")
public interface CustExecutiveInformationRepo extends BaseRepository<CustExecutiveInformationDO, CustExecutiveInformationQuery, CustExecutiveInformationVO, String> {

}