package com.leasing.calculate.service;

import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lvcn on 2019-9-19.
 */
public interface CalculateService {

    public String save();

    public List<CalculatorVO> query();

    public String update();
}
