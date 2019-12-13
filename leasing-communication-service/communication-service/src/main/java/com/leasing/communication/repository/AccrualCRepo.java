package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.AccrualDO;
import com.leasing.communication.entity.vo.AccrualVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提 当前表
 **/
@Repository
public interface AccrualCRepo extends BaseRepository<AccrualDO,BaseQuery,AccrualVO,String> {

    @Query(name="accrualCRepo.findByPkAndMonth")
    AccrualDO findByPkAndMonth(String pkAccrual, String month);
}
