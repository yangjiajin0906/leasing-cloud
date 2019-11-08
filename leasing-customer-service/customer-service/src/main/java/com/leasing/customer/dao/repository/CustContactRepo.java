package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustContactDO;
import com.leasing.customer.dao.query.CustContactQuery;
import com.leasing.customer.dao.vo.CustContactVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-31
 * @author:zhangzhhn@yonyou.com
 * @description: for table CustContactDO
 **/
@Repository("customer.CustContactRepo")
public interface CustContactRepo extends BaseRepository<CustContactDO, CustContactQuery, CustContactVO, String> {

}