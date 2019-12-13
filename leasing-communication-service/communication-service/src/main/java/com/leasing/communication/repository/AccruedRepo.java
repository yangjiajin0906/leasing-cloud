package com.leasing.communication.repository;

/**
 * @project:leasing-cloud
 * @date:2019/11/21
 * @author:Yjj@yonyou.com
 * @description:
 **/

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.communication.entity.dos.AccruedDO;
import com.leasing.communication.entity.query.AccruedQuery;
import com.leasing.communication.entity.vo.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提
 **/
@Repository
public interface AccruedRepo extends BaseRepository<AccruedDO,AccruedQuery,AccruedVO,String> {

    /**
     * @description 解决n+1问题 查询单个主表VO
     * @author Yangjiajin
     * @date 2019/12/3 18:49
     * @param pk
     * @return CalculatorVO
     */
    @Query(name="accruedRepo.findByPk")
    AccruedChildVO findByPk(@Param("pk") String pk);

    /**
     * @description 查询计提数据
     * @author Yangjiajin
     * @date 2019/11/29 14:04
     * @param currentMonth 计提月份
     * @return java.util.List<com.leasing.communication.entity.vo.AccrualForAccruedPageRefVO>
     */
    @Query(name="accruedRepo.findAccrualForAccrued")
    List<AccrualForAccruedPageRefVO> findAccrualForAccrued(String currentMonth, String pkOrg);

    /**
     * @description 获取制定公司的最后计提月份
     * @author Yangjiajin
     * @date 2019/11/29 14:05
     * @param pkOrg 机构, billstatus 单据状态, contractType 合同类型
     * @return java.lang.String
     */
    @Query(name="accruedRepo.getLastAccruedMonth")
    String getLastAccruedMonth(String pkOrg, Short billstatus, Short contractType);

    @Query(name="accruedRepo.getGlSyssettledYearMonth")
    Map<String, String> getGlSyssettledYearMonth(String pkOrg);

//    @Modifying
//    @Transactional
//    @Query(value = "update AccrualDO set ifBegin = :ifBegin where sourceBill = :sourceBill and month= : month")
//    void batchUpdate(List<AccrualDO> accrualCVOList);
}