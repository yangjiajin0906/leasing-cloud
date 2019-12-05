package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.query.WithdrawDetailQuery;
import com.leasing.communication.entity.vo.WithdrawDetailVO;
import com.leasing.communication.repository.WithdrawDetailRepo;
import com.leasing.communication.service.WithdrawDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("communication.WithdrawDetailService")
public class WithdrawDetailServiceImpl implements WithdrawDetailService {

    @Resource
    private WithdrawDetailRepo repo;

    @Override
    public PageQueryData<WithdrawDetailVO> pageQuery(Pagination pagination, WithdrawDetailQuery queryVO) {
        return repo.pageQuery(pagination, queryVO, "WithdrawDetailPageQuery");
    }
}