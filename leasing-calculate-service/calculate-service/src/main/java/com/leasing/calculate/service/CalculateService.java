package com.leasing.calculate.service;
import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.vo.ArithmeticCoreParam;
import com.leasing.calculate.vo.CalArithmeticVO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.dto.CalculatorDTO;
import com.leasing.calculate.vo.LeasePlanVO;
import com.leasing.calculate.vo.queryVO.CalculatorQueryVO;
import com.leasing.common.base.entity.BaseQuery;
import com.leasing.common.base.repository.support.PageQueryData;
import com.leasing.common.base.repository.support.Pagination;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.ArrayList;
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
     * 查询单个DO实体类（包含子表）
     * @return
     */
    CalculatorDO findOne(String pk);

    /**
     * 查询单个VO（包含子表）
     * @return
     */
    CalculatorVO findByPk(String pk);

    /**
     * 分页查询
     * @return
     */
    List<CalculatorVO> pageQuery(Pagination pagination, CalculatorQueryVO vo);

    /**
     * @description 查询字表数据
     * @author Yangjiajin
     * @date 2019/10/28 10:04
     * @param [id]
     * @return com.leasing.calculate.vo.CalculatorVO
     */
    CalculatorVO findChildListById(String id);

    /**
     * @description 租金计划表接口
     * @author Yangjiajin
     * @date 2019/10/23 10:17
     * @param [vo 报价VO]
     * @return com.leasing.calculate.dto.CalculatorDTO
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
     * @return com.leasing.calculate.dto.CalculatorDTO
     */
    List calMakeResults();

    /**
     * @description 计算会计分摊表
     * @author Yangjiajin
     * @date 2019/10/23 10:17
     * @param []
     * @return com.leasing.calculate.dto.CalculatorDTO
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
