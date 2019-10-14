package com.leasing.calculate.service;
import com.leasing.calculate.entity.CalculatorVO;

import java.util.List;

/**
 * Created by lvcn on 2019-9-19.
 */
public interface CalculateService {

    public void save(CalculatorVO vo);

    public List<CalculatorVO> query();

    public List<CalculatorVO> findAll();

    public CalculatorVO findById(String id);

    public void update(CalculatorVO vo);

    public void deleteById(String id);

    public  List<CalculatorVO> findLike(String name);

    public List<CalculatorVO> findByTs(String ts);
}
