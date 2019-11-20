package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustBondIssueDO;
import com.leasing.customer.dao.query.CustBondIssueQuery;
import com.leasing.customer.dao.vo.CustBondIssueVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 债券发行
 **/
@Repository("customer.CustBondIssueRepo")
public interface CustBondIssueRepo extends BaseRepository<CustBondIssueDO, CustBondIssueQuery, CustBondIssueVO, String> {

}