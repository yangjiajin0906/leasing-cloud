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
import com.leasing.communication.entity.vo.AccrualForAccruedPageRefVO;
import com.leasing.communication.entity.vo.AccruedVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/11/12
 * @author:Yjj@yonyou.com
 * @description: 2c月末计提
 **/
@Repository
public interface AccruedRepo extends BaseRepository<AccruedDO,AccruedQuery,AccruedDO,String> {

    /**
     * @description 查询计提数据
     * @author Yangjiajin
     * @date 2019/11/29 14:04
     * @param currentMonth 计提月份
     * @return java.util.List<com.leasing.communication.entity.vo.AccrualForAccruedPageRefVO>
     */
    @Query(name="accruedRepo.findAccrualForAccrued")
    List<AccrualForAccruedPageRefVO> findAccrualForAccrued(String currentMonth);

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
}