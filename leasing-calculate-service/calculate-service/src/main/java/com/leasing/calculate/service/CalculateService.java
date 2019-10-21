package com.leasing.calculate.service;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.common.base.repository.support.Pagination;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
public interface CalculateService {
    /**
     * 保存方法
     * @param vo
     * @return
     */
    CalculatorVO save(CalculatorVO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CalculatorVO vo);

    /**
     * 更新方法
     * @param vo
     */
    CalculatorVO update(CalculatorVO vo);

    /**
     * 查询单个实体类（包含子表）
     * @return
     */
    CalculatorVO findOne(String pk);

    /**
     * 分页查询
     * @return
     */
    List<CalculatorVO> pageQuery(CalculatorVO vo, Pagination pagination);

    CalculatorDTO findByIsSql(String pkLeaseCalculator);

    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    List<CalculatorVO> findListTest(String pk);

    List<CalculatorVO> findListTest1(String pk);

    List<CalculatorVO> findListTest2(String pk);

    List<CalculatorVO> findListTest3(String pk);
}
