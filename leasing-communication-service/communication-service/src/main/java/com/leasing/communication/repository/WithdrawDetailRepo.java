package com.leasing.communication.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.WithdrawDetailDO;
import com.leasing.communication.entity.query.WithdrawDetailQuery;
import com.leasing.communication.entity.vo.WithdrawDetailVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Repository("communication.WithdrawDetailRepo")
public interface WithdrawDetailRepo extends BaseRepository<WithdrawDetailDO, WithdrawDetailQuery, WithdrawDetailVO, String> {

    List<WithdrawDetailDO> queryAllByPaymentBatchNo(@Param("batchNo") String batchNo);

}