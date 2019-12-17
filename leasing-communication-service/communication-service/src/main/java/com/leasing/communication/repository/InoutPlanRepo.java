package com.leasing.communication.repository;

import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.CbInoutPlanDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c租金计划
 **/
@Repository
public interface InoutPlanRepo extends BaseRepository<CbInoutPlanDO, BaseQuery, CbInoutPlanDO, String>{

    //根据合同编号查询收支计划
    List<CbInoutPlanDO> findByContCode(String contCode);
}