package com.leasing.communication.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.query.CbCapitalDetailQuery;
import com.leasing.communication.entity.vo.CbCapitalDetailVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-04
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository
public interface CbCapitalDetailRepo extends BaseRepository<CbCapitalDetailDO, CbCapitalDetailQuery, CbCapitalDetailVO, String> {


    List<CbCapitalDetailDO> queryAllByCapitalBatchNo(@Param("batchNo") String batchNo);

}