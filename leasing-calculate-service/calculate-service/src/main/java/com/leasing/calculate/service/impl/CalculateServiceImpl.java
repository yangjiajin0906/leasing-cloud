package com.leasing.calculate.service.impl;

import com.leasing.calculate.repository.CalculatorRepository;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lvcn on 2019-9-19.
 */
@Service("calculateService")
@Transactional
public class CalculateServiceImpl implements CalculateService {

    @Resource
    CalculatorRepository calculatorRepository;

    @Override
    public String save() {
        return null;
    }

    @Override
    public List<CalculatorVO> query() {
        return calculatorRepository.findAll();
    }

    @Override
    public String update() {
        return null;
    }
}
