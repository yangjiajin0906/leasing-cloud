package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.ContractHandsDO;
import com.leasing.customer.dao.query.ContractHandsQuery;
import com.leasing.customer.dao.vo.ContractHandsVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 在手合同
 **/
@Repository("customer.ContractHandsRepo")
public interface ContractHandsRepo extends BaseRepository<ContractHandsDO, ContractHandsQuery, ContractHandsVO, String> {
}