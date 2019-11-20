package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.AnalysisCashDO;
import com.leasing.customer.dao.query.AnalysisCashQuery;
import com.leasing.customer.dao.vo.AnalysisCashVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-11-13
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("customer.AnalysisCashRepo")
public interface AnalysisCashRepo extends BaseRepository<AnalysisCashDO, AnalysisCashQuery, AnalysisCashVO, String> {
}