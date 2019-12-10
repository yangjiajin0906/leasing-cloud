package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbContractDO;
import com.leasing.communication.entity.dos.CbOverdueContractDO;
import com.leasing.communication.entity.vo.CbContractVO;
import com.leasing.communication.entity.vo.CbOverdueContractVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-3
 * @author:lvcna@yonyou.com
 * @description: 2C逾期合同数据库接口
 **/
@Repository
public interface CbOverdueContractRepo extends BaseRepository<CbOverdueContractDO, BaseQuery, CbOverdueContractVO, String> {

}
