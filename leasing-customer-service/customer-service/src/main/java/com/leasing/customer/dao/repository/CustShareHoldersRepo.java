package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.dos.CustShareHoldersDO;
import com.leasing.customer.dao.query.CustShareHoldersQuery;
import com.leasing.customer.dao.vo.CustShareHoldersVO;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description: 股东情况DAO
 **/
@Repository
public interface CustShareHoldersRepo extends BaseRepository<CustShareHoldersDO, CustShareHoldersQuery, CustShareHoldersVO,String> {

}