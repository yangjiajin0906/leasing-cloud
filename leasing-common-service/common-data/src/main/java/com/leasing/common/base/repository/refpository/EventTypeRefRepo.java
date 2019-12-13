package com.leasing.common.base.repository.refpository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.common.dos.EventTypeDO;
import com.leasing.common.entity.common.ref.EventTypeRefVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/12/12
 * @author:wangjc@yonyou.com
 * @description: 事件类别存储库接口
 **/
@Repository
public interface EventTypeRefRepo extends BaseRepository<EventTypeDO, BaseQuery, EventTypeRefVO, String> {
}