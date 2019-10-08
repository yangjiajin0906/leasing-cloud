package com.leasing.calculate.repository;

import com.leasing.calculate.vo.CalculatorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.com
 * @description:
 **/
@Transactional
public interface CalculatorRepository extends JpaRepository<CalculatorVO,String> {

    //自定义sql
    @Query(value = "select * from yls_lease_calculator b where b.quot_name like %:name%" ,nativeQuery = true)
    public List<CalculatorVO> findLike(@Param("name")String name);

    public List<CalculatorVO> findByTs(String ts);
}