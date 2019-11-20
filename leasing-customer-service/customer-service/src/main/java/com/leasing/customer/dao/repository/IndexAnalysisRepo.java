package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.IndexAnalysisDO;
import com.leasing.customer.dao.query.IndexAnalysisQuery;
import com.leasing.customer.dao.vo.IndexAnalysisVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description: 指标分析
 **/
@Repository("customer.IndexAnalysisRepo")
public interface IndexAnalysisRepo extends BaseRepository<IndexAnalysisDO, IndexAnalysisQuery, IndexAnalysisVO, String> {
}