package com.leasing.calculate.service.impl;

import com.leasing.calculate.repository.CalculatorRepository;
import com.leasing.calculate.service.CalculateService;
import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lvcn on 2019-9-19.
 */
@Service("calculateService")
public class CalculateServiceImpl implements CalculateService {

    @Resource
    CalculatorRepository calculatorRepository;

    @Override
    public void save(CalculatorVO vo) {
        calculatorRepository.save(vo);
    }

    @Override
    public List<CalculatorVO> query() {
        int pageIndex = 1;// 前台传过来的当前页
        int pageSize = 100;// 每页需要的记录数
        /**
         * 不带排序写法: Pageable pageable = new PageRequest(pageIndex, pageSize);
         */
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "ts");
        Sort sort = new Sort(order);
        Pageable pageable = new PageRequest(pageIndex - 1, pageSize, sort);
        Page<CalculatorVO> page = calculatorRepository.findAll(pageable);
        List<CalculatorVO> list = page.getContent();
        return list;
    }

    @Override
    public List<CalculatorVO> findAll(){ return calculatorRepository.findAll(); }

    @Override
    public CalculatorVO findById(String id){ return calculatorRepository.findById(id).get(); };

    @Override
    public void update(CalculatorVO vo) {
        calculatorRepository.saveAndFlush(vo);
    }

    @Override
    public void deleteById(String id) {
        calculatorRepository.deleteById(id);
    }

    @Override
    public List<CalculatorVO> findLike(String name) {
        return calculatorRepository.findLike(name);
    }

    @Override
    public List<CalculatorVO> findByTs(String ts) {
        return calculatorRepository.findByTs(ts);
    }
}
