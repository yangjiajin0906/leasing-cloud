package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbInvoiceApplyDO;
import com.leasing.communication.entity.vo.CbInvoiceApplyVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c票据信息导入
 **/
@Repository
public interface CbInvoiceApplyRepo extends BaseRepository<CbInvoiceApplyDO,BaseQuery, CbInvoiceApplyVO,String> {
}
