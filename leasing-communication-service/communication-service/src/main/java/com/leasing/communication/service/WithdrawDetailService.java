package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.communication.entity.query.WithdrawDetailQuery;
import com.leasing.communication.entity.vo.WithdrawDetailVO;
import com.leasing.common.base.repository.support.Pagination;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description: 付款详细子表
 **/
public interface WithdrawDetailService {

    /**
     * 分页查询
     *
     * @param pagination 分页
     * @param queryVO    查询条件
     * @return 分页列表
     */
    PageQueryData<WithdrawDetailVO> pageQuery(Pagination pagination, WithdrawDetailQuery queryVO);
}