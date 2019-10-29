package com.leasing.calculate.repository;

import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.dos.LeaseLoanPlanDO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.vo.queryVO.CalculatorQueryVO;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
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
     * @return java.util.List<com.leasing.calculate.dos.LeaseLoanPlanDO>
     */
    List<LeaseLoanPlanDO> findBySourceBill(@Param("SourceBill") String SourceBill);
    /**
     * @description 根据字表主键 查询字表
     * @author Yangjiajin
     * @date 2019/10/28 10:59
     * @param [pkLeaseLoanPlan]
     * @return com.leasing.calculate.dos.LeaseLoanPlanDO
     */
    LeaseLoanPlanDO findByPkLeaseLoanPlan(@Param("pkLeaseLoanPlan") String pkLeaseLoanPlan);
}