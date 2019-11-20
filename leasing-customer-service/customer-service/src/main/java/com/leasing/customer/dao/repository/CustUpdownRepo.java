package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustUpdownDO;
import com.leasing.customer.dao.query.CustUpdownQuery;
import com.leasing.customer.dao.vo.CustUpdownVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 上下游客户
 **/
@Repository("customer.CustUpdownRepo")
public interface CustUpdownRepo  extends BaseRepository<CustUpdownDO, CustUpdownQuery, CustUpdownVO, String> {

}