package com.leasing.calculate.repository;

import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.common.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Transactional
public interface CalculatorRepository extends BaseRepository<CalculatorVO,String> {

    //自定义sql
    @Query(value = "select new com.leasing.calculate.dto.CalculatorDTO(l.pkLeaseCalculator as pkLeaseCalculator, u.pkUser as quot_code, u.userName as quot_name ) \n" +
            "from CalculatorVO l, UserVO u\n" +
            "where l.pkChecker = u.pkUser\n" +
            "and l.pkLeaseCalculator = ?1")
    CalculatorDTO findByIsSql(String pkLeaseCalculator);

    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    @Query(value = "select b from CalculatorVO b " +
            " left join LimitPlanRefVO m on b.pkLimitPlan = m.pkLimitPlan " +
            " where b.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> findListTest(String pk);

    @Query(value = "select c from CalculatorVO c " +
            " left join fetch c.pkLimitPlan l" +
            " left join fetch c.pkDept d" +
            " left join fetch c.pkChecker u" +
            " left join fetch c.pkOrg o" +
            " where c.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> findListTest1(String pk);

    @Query(value = "select b from CalculatorVO b " +
            " left join fetch LimitPlanRefVO m on b.pkLimitPlan = m.pkLimitPlan " +
            " where b.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> findListTest2(String pk);

    @Query(value = "select b,m.limitName from CalculatorVO b " +
            " left join fetch b.pkLimitPlan m " +
            " where b.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> findListTest3(String pk);

}