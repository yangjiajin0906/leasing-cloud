package com.leasing.calculate.repository;

import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Repository
public interface CalculatorRepository extends JpaRepository<CalculatorVO,String> {
    public List<CalculatorVO> findAll();
}