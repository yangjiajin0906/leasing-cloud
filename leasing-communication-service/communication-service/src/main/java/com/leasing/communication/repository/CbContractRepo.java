package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dos.ContractDO;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description:
 **/
public interface CbContractRepo extends BaseRepository<CbContractDO, BaseQuery, BaseVO, String> {
}
