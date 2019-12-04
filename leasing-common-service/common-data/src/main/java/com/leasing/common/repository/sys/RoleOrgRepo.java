package com.leasing.common.repository.sys;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.common.entity.foundation.vo.RoleOrgVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/7
 * @author:wangjc@yonyou.com
 * @description:
 **/
@Repository
public interface RoleOrgRepo extends BaseRepository<RoleOrgVO, BaseQuery, RoleOrgVO, String> {
}