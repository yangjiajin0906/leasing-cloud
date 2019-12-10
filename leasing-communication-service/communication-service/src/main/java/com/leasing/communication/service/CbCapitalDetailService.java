package com.leasing.communication.service;

import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import com.leasing.communication.entity.dos.CbCapitalDetailDO;
import com.leasing.communication.entity.query.CbCapitalDetailQuery;
import com.leasing.communication.entity.vo.CbCapitalDetailVO;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-12-04
 * @author:zhangzhhn@yonyou.com
 * @description: 收款服务接口
 **/
public interface CbCapitalDetailService {

    PageQueryData<CbCapitalDetailVO> pageQuery(Pagination pagination, CbCapitalDetailQuery query);


    List<CbCapitalDetailDO> queryByBatchNo(String batchNo);

}