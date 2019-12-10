package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.AccrualCDO;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.AccrualCVO;
import com.leasing.communication.entity.vo.AccruedVO;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提 当前表
 **/
@Repository
public interface AccrualCRepo extends BaseRepository<AccrualCDO,BaseQuery,AccrualCVO,String> {

    AccrualCDO findBySourceBillAndMonth(String sourceBill, String month);
}
