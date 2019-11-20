package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustExternalFinanceDO;
import com.leasing.customer.dao.query.CustExternalFinanceQuery;
import com.leasing.customer.dao.vo.CustExternalFinanceVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-12
 * @author:zhangzhhn@yonyou.com
 * @description: 其他融资
 **/
@Repository("customer.CustExternalFinance")
public interface CustExternalFinanceRepo extends BaseRepository<CustExternalFinanceDO, CustExternalFinanceQuery,
        CustExternalFinanceVO, String> {


}