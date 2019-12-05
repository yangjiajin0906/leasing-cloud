package com.leasing.communication.calculate.repository;

import com.leasing.communication.common.base.entity.BaseQuery;
import com.leasing.communication.common.base.entity.BaseVO;
import com.leasing.communication.common.base.repository.BaseRepository;
import com.leasing.communication.common.entity.calculate.dos.LeaseLoanPlanDO;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/10/28
 * @author:Yjj@yonyou.com
 * @description:
 **/
public interface LeaseLoanPlanRepo extends BaseRepository<LeaseLoanPlanDO,BaseQuery,BaseVO,String> {
    /**
     * @description 根据主表主键 查询字表列表
     * @author Yangjiajin
     * @date 2019/10/28 10:59
     * @param [SourceBill]
     * @return java.util.List<LeaseLoanPlanDO>
     */
    List<LeaseLoanPlanDO> findBySourceBill(@Param("SourceBill") String SourceBill);
    /**
     * @description 根据字表主键 查询字表
     * @author Yangjiajin
     * @date 2019/10/28 10:59
     * @param [pkLeaseLoanPlan]
     * @return LeaseLoanPlanDO
     */
    LeaseLoanPlanDO findByPkLeaseLoanPlan(@Param("pkLeaseLoanPlan") String pkLeaseLoanPlan);
}