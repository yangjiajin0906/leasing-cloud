package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbWithdrawDO;
import com.leasing.communication.entity.vo.CbWithdrawVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c付款信息导入
 **/
@Repository
public interface CbWithdrawRepo extends BaseRepository<CbWithdrawDO, BaseQuery, CbWithdrawVO, String> {



}
