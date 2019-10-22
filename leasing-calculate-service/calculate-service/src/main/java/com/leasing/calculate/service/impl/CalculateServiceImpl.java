package com.leasing.calculate.service.impl;

import com.leasing.calculate.dos.CalculatorDO;
import com.leasing.calculate.vo.CalculatorVO;
import com.leasing.calculate.repository.CalculatorRepository;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.dto.CalculatorDTO;

import com.leasing.common.base.repository.support.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Service("calculate.CalculateServiceImpl")
public class CalculateServiceImpl implements CalculateService {

    @Resource
    CalculatorRepository calculatorRepository;

    @Override
    public List<CalculatorVO> pageQuery(Pagination pagination, CalculatorDO vo) {
        return calculatorRepository.pageQuery("");
    }

    @Override
    public CalculatorDO save(CalculatorDO vo) {
        return calculatorRepository.save(vo);
    }

    @Override
    public void delete(CalculatorDO vo) {
        calculatorRepository.delete(vo);
    }

    @Override
    public CalculatorDO update(CalculatorDO vo) {
        return calculatorRepository.saveAndFlush(vo);
    }

    @Override
    public CalculatorVO findOne(String pk) {
        return calculatorRepository.findByPk(pk);
    }

    @Override
    public CalculatorDTO findByIsSql(String pkLeaseCalculator) {
        return calculatorRepository.findByIsSql(pkLeaseCalculator);
    }

    @Override
    public CalculatorDTO findByPkLeaseCalculator(String pkLeaseCalculator, Class<CalculatorDTO> type) {
        return calculatorRepository.findByPkLeaseCalculator(pkLeaseCalculator,CalculatorDTO.class);
    }

    @Override
    public List<CalculatorVO> findListTest1(String pk) {
        return calculatorRepository.pageQuery(pk);
    }

}
