package com.leasing.calculate.service;
import com.leasing.calculate.entity.dto.CalculatorDTO;
import com.leasing.calculate.entity.query.CalculatorQuery;
import com.leasing.calculate.entity.vo.CalculatorVO;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
     * 单体查询
     * @return
     */
    CalculatorVO findOne(String pk);

    /**
     * 查询单个VO（包含子表）
     * @return
     */
    CalculatorVO findByPk(String pk);

    /**
     * 分页查询
     * @return
     */
    PageQueryData<CalculatorVO> pageQuery(Pagination pagination, CalculatorQuery vo);

    /**
     * @description 查询字表数据
     * @author Yangjiajin
     * @date 2019/10/28 10:04
     * @param id
     * @return com.leasing.calculate.entity.vo.CalculatorVO
     */
    CalculatorVO findChildListById(String id);

    /**
     * @description 租金计划表接口
     * @author Yangjiajin
     * @date 2019/10/23 10:17
     * @param vo
     * @return com.leasing.calculate.entity.dto.CalculatorDTO
     */
    List calOperateLease(CalculatorVO vo);

    CalculatorDTO findByIsSql(String pkLeaseCalculator);

    Map<String,Object> findByIsSql2(String pkLeaseCalculator);

    CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type);

    List<CalculatorVO> findListByPk(String pk);

    /**
     * @description 计算计提结果表
     * @author Yangjiajin
     * @date 2019/10/23 10:17
     * @param []
     * @return com.leasing.calculate.entity.dto.CalculatorDTO
     */
    List calMakeResults();

    /**
     * @description 计算会计分摊表
     * @author Yangjiajin
     * @date 2019/10/23 10:17
     * @param []
     * @return com.leasing.calculate.entity.dto.CalculatorDTO
     */
    List calAccountingShare();

    /**
     * @description 计算irr
     * @author Yangjiajin
     * @date 2019/10/23 10:25
     * @param []
     * @return java.math.BigDecimal
     */
    BigDecimal calDayIRR();

    /**
     * @description 专门用于C端业务批量计算
     * @author Yangjiajin
     * @date 2019/10/23 10:25
     * @param []
     * @return java.math.BigDecimal
     */
    List calBatchBusinessC();


}
