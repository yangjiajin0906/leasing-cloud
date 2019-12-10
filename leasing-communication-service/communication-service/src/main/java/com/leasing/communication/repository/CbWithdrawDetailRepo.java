package com.leasing.communication.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbWithdrawDetailDO;
import com.leasing.communication.entity.query.CbWithdrawDetailQuery;
import com.leasing.communication.entity.vo.CbWithdrawDetailVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("communication.CbWithdrawDetailRepo")
public interface CbWithdrawDetailRepo extends BaseRepository<CbWithdrawDetailDO, CbWithdrawDetailQuery, CbWithdrawDetailVO, String> {

    List<CbWithdrawDetailDO> queryAllByPaymentBatchNo(@Param("batchNo") String batchNo);

}