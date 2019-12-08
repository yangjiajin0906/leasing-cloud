package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbInvoiceApplyDetailDO;
import com.leasing.communication.entity.vo.CbInvoiceApplyDetailVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c票据信息导入
 **/
@Repository
public interface CbInvoiceApplyRepo extends BaseRepository<CbInvoiceApplyDetailDO,BaseQuery,CbInvoiceApplyDetailVO,String> {
}
