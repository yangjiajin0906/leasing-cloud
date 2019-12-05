package com.leasing.communication.service.impl;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.query.CbCapitalDetailQuery;
import com.leasing.communication.entity.vo.CbCapitalDetailVO;
import com.leasing.communication.repository.CbCapitalDetailRepo;
import com.leasing.communication.service.CbCapitalDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-04
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("communication.CbCapitalDetailService")
public class CbCapitalDetailServiceImpl implements CbCapitalDetailService {
    @Resource
    private CbCapitalDetailRepo repo;

    @Override
    public PageQueryData<CbCapitalDetailVO> pageQuery(Pagination pagination, CbCapitalDetailQuery query) {
        return repo.pageQuery(pagination, query, "capitalDetailPageQuery");
    }

    @Override
    public List<CbCapitalDetailDO> queryByBatchNo(String batchNo) {
        return repo.queryAllByCapitalBatchNo(batchNo);
    }
}