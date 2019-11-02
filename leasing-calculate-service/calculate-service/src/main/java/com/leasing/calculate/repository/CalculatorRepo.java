package com.leasing.calculate.repository;

import com.leasing.calculate.entity.dos.CalculatorDO;
import com.leasing.calculate.entity.dos.LeaseLoanPlanDO;
import com.leasing.calculate.entity.dto.CalculatorDTO;
import com.leasing.calculate.entity.vo.CalculatorVO;
import com.leasing.calculate.entity.query.CalculatorQueryVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Repository
public interface CalculatorRepo extends BaseRepository<CalculatorDO,CalculatorQueryVO,CalculatorVO,String> {

    //自定义sql
    @Query(name="CalculatorRepo.findByIsSql")
    CalculatorDTO findByIsSql(@Param("pk") String pkLeaseCalculator);

    //自定义sql2
    @Query(name="CalculatorRepo.findByIsSql2")
    Map<String,Object> findByIsSql2(@Param("pk") String pkLeaseCalculator);

    //动态类投影
    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    //解决n+1问题 查询列表主表VO
    @Query(name="CalculatorRepo.findListByPk")
    List<CalculatorVO> findListByPk(@Param("pk") String pk);

    //解决n+1问题 查询单个主表VO
    @Query(name="CalculatorRepo.findByPk")
    CalculatorVO findByPk(@Param("pk") String pk);


}