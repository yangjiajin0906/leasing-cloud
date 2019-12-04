package com.leasing.common.base.repository.support;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.SystemDO;
import com.leasing.common.entity.common.vo.SystemVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019-12-2
 * @author:lvcna@yonyou.com
 * @description: 作为基础存储库接口使用
 **/
@Repository
public interface BaseEntityRepository extends BaseRepository<SystemDO, BaseQuery, SystemVO, String> {

}
