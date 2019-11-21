package com.leasing.communication.repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.LeaseAccruedDO;
import com.leasing.communication.entity.query.LeaseAccruedQuery;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提
 **/
@Repository
public interface LeaseAccruedRepo extends BaseRepository<LeaseAccruedDO,LeaseAccruedQuery,LeaseAccruedDO,String> {

}