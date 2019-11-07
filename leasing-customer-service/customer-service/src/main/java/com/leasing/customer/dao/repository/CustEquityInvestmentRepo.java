package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustEquityInvestmentDO;
import com.leasing.customer.dao.query.CustEquityInvestmentQuery;
import com.leasing.customer.dao.vo.CustEquityInvestmentVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-10-30
 * @author:zhangzhhn@yonyou.com
 * @description:股权投资DAO
 **/
@Repository("customer.CustEquityInvestmentRepo")
public interface CustEquityInvestmentRepo extends BaseRepository<CustEquityInvestmentDO, CustEquityInvestmentQuery,
        CustEquityInvestmentVO, String> {


}