package com.leasing.calculate.service;
import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
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
