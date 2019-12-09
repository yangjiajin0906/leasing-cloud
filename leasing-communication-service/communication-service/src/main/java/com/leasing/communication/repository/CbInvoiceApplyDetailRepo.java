package com.leasing.communication.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.query.CbInvoiceApplyDetailQuery;
import com.leasing.communication.entity.vo.CbInvoiceApplyDetailVO;


/**
 * @project:leasing-cloud
 * @date:2019-12-08
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
public interface CbInvoiceApplyDetailRepo extends BaseRepository<CbInvoiceApplyDetailDO, CbInvoiceApplyDetailQuery,
        CbInvoiceApplyDetailVO, String> {

}