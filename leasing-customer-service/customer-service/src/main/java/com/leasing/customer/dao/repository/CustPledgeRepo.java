package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustPledgeDO;
import com.leasing.customer.dao.query.CustPledgeQuery;
import com.leasing.customer.dao.vo.CustPledgeVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 保证情况
 **/
@Repository("customer.CustPledgeRepo")
public interface CustPledgeRepo extends BaseRepository<CustPledgeDO, CustPledgeQuery, CustPledgeVO, String> {

}