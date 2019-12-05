package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.query.CbWithdrawDetailQuery;
import com.leasing.communication.entity.vo.CbWithdrawDetailVO;
import com.leasing.communication.repository.CbWithdrawDetailRepo;
import com.leasing.communication.service.CbWithdrawDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @project:leasing-cloud
 * @date:2019-12-02
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("communication.CbWithdrawDetailService")
public class CbWithdrawDetailServiceImpl implements CbWithdrawDetailService {

    @Resource
    private CbWithdrawDetailRepo repo;

    @Override
    public PageQueryData<CbWithdrawDetailVO> pageQuery(Pagination pagination, CbWithdrawDetailQuery queryVO) {
        return repo.pageQuery(pagination, queryVO, "WithdrawDetailPageQuery");
    }
}