package com.leasing.communication.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbCapitalDO;
import com.leasing.communication.entity.query.CbCapitalQuery;
import com.leasing.communication.entity.vo.CbCapitalVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c收款
 **/
@Repository
public interface CbCapitalRepo extends BaseRepository<CbCapitalDO, CbCapitalQuery, CbCapitalVO, String>{


}