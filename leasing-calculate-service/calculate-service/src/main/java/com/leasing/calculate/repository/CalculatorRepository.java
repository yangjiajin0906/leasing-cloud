package com.leasing.calculate.repository;

import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.vo.queryVO.CalculatorQueryVO;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.entity.BaseVO;
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
public interface CalculatorRepository extends BaseRepository<CalculatorDO,CalculatorQueryVO,CalculatorVO,String> {

    //自定义sql
    @Query(value = "select new com.leasing.calculate.dto.CalculatorDTO(l.pkLeaseCalculator as pkLeaseCalculator, u.pkUser as quot_code, u.userName as quot_name ) \n" +
            "from CalculatorVO l, UserVO u\n" +
            "where l.pkChecker = u.pkUser\n" +
            "and l.pkLeaseCalculator = ?1")
    CalculatorDTO findByIsSql(String pkLeaseCalculator);

    //动态类投影
    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    //解决n+1问题
    @Query(value = "select c from CalculatorVO c " +
            " left join fetch c.pkLimitPlan l" +
            " left join fetch c.pkDept d" +
            " left join fetch c.pkChecker u" +
            " left join fetch c.pkOrg o" +
            " where c.pkLeaseCalculator = ?1 ")
    List<CalculatorVO> pageQuery(String pk);

    //解决n+1问题
    @Query(value = "select c from CalculatorVO c " +
            " left join fetch c.pkLimitPlan l" +
            " left join fetch c.pkDept d" +
            " left join fetch c.pkChecker u" +
            " left join fetch c.pkGrantor pg" +
            " left join fetch c.pkOrg o" +
            " left join fetch c.pkInterrate i" +
            " left join fetch c.pkInterrateDepos pid" +
            " left join fetch c.pkSpecialInterrate psi" +
            " where c.pkLeaseCalculator = ?1 ")
    CalculatorVO findByPk(String pk);


}