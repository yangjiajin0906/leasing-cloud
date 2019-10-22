package com.leasing.calculate.service;
import com.leasing.calculate.dos.CalculatorDO;
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
    CalculatorDO save(CalculatorDO vo);

    /**
     * 删除方法
     * @param vo
     */
    void delete(CalculatorDO vo);

    /**
     * 更新方法
     * @param vo
     */
    CalculatorDO update(CalculatorDO vo);

    /**
     * 查询单个实体类（包含子表）
     * @return
     */
    CalculatorVO findOne(String pk);

    /**
     * 分页查询
     * @return
     */
    List<CalculatorVO> pageQuery(Pagination pagination, CalculatorDO vo);

    CalculatorDTO findByIsSql(String pkLeaseCalculator);

    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    List<CalculatorVO> findListTest1(String pk);

}
