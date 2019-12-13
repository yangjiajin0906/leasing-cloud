package com.leasing.common.service.sys;

import com.leasing.common.base.repository.support.PageQueryRefData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.common.entity.common.query.EventTypeQuery;
import com.leasing.common.entity.common.query.OrgQuery;
import com.leasing.common.entity.common.ref.EventTypeRefVO;
import com.leasing.common.refvo.base.OrgrefVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/5
 * @author:wangjc@yonyou.com
 * @description: 公共参照接口
 **/
public interface PubRefService {

    /**
     * 查询机构表参照
     * @param pagination 分页条件
     * @param query  查询条件
     * @param queryName  JPQL名称
     * @return PageQueryRefData
     */
    PageQueryRefData<OrgrefVO> findOrgTableRef(Pagination pagination, OrgQuery query, String queryName);

    /**
     * 查询机构树参照
     * @param orgQuery 查询条件
     * @param queryName JPQL名称
     * @return
     */
    List<OrgrefVO> findOrgTreeRef(OrgQuery orgQuery, String queryName);

    /**
     * 查询事件类别参照
     */
    List<EventTypeRefVO> listEventTypeRef(String queryName);

}
