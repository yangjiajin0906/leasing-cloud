package com.leasing.common.repository.sys;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.entity.common.dos.SystemDO;
import com.leasing.common.entity.common.vo.SystemVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/10/16
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Repository
public interface SystemRepository extends BaseRepository<SystemDO, BaseQuery, SystemVO, String> {

}