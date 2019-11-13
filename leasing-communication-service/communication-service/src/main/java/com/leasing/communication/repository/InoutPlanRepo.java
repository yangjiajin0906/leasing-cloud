package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.InoutPlanDO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c收款
 **/
@Repository
public interface InoutPlanRepo extends BaseRepository<InoutPlanDO, BaseQuery, BaseVO, String>{
}