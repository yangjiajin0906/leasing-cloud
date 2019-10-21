package com.leasing.calculate.service.impl;

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
    public CalculatorVO save(CalculatorVO vo) {
        return null;
    }

    @Override
    public void delete(CalculatorVO vo) {

    }

    @Override
    public CalculatorVO update(CalculatorVO vo) {
        return calculatorRepository.saveAndFlush(vo);
    }

    @Override
    public CalculatorVO findOne(String pk) {
        return calculatorRepository.findOne(pk);
    }

    @Override
    public List<CalculatorVO> pageQuery(CalculatorVO vo, Pagination pagination) {
        return null;
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
    public List<CalculatorVO> findListTest(String pk) {
        return calculatorRepository.findListTest(pk);
    }

    @Override
    public List<CalculatorVO> findListTest1(String pk) {
        return calculatorRepository.findListTest1(pk);
    }

    @Override
    public List<CalculatorVO> findListTest2(String pk) {
        return calculatorRepository.findListTest2(pk);
    }

    @Override
    public List<CalculatorVO> findListTest3(String pk) {
        return calculatorRepository.findListTest3(pk);
    }
}
