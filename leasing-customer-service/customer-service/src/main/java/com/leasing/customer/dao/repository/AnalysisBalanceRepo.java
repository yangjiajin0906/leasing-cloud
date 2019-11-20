package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.AnalysisBalanceDO;
import com.leasing.customer.dao.query.AnalysisBalanceQuery;
import com.leasing.customer.dao.vo.AnalysisBalanceVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("customer.AnalysisBalanceRepo")
public interface AnalysisBalanceRepo extends BaseRepository<AnalysisBalanceDO, AnalysisBalanceQuery, AnalysisBalanceVO,
        String> {

}