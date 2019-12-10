package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dos.CbEarlySettlementDO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.entity.vo.CbEarlySettlementVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C提前结清数据库接口
 **/
@Repository
public interface CbEarlySettlementRepo extends BaseRepository<CbEarlySettlementDO, BaseQuery, CbEarlySettlementVO, String> {

}
