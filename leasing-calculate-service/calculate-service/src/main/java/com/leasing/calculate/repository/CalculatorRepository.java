package com.leasing.calculate.repository;

import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.vo.queryVO.CalculatorQueryVO;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Transactional
public interface CalculatorRepository extends BaseRepository<CalculatorDO,CalculatorQueryVO,CalculatorVO,String> {

    //自定义sql
    @Query(name="CalculatorRepository.findByIsSql")
    CalculatorDTO findByIsSql(@Param("pkLeaseCalculator") String pkLeaseCalculator);

    //自定义sql2
    @Query(name="CalculatorRepository.findByIsSql2")
    Map<String,Object> findByIsSql2(@Param("pkLeaseCalculator") String pkLeaseCalculator);

    //动态类投影
    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    //解决n+1问题
    @Query(value = "select c from CalculatorVO c " +
            " left join fetch c.pkLimitPlan l" +
            " left join fetch c.pkDept d" +
            " left join fetch c.pkChecker u" +
            " left join fetch c.pkOrg o" +
            " where c.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> findListByPk(String pk);

    //解决n+1问题
    @Query(name="CalculatorRepository.findByPk")
    CalculatorVO findByPk(@Param("pk") String pk);


}