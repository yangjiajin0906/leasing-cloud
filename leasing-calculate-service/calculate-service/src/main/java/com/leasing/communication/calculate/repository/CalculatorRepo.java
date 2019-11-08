package com.leasing.communication.calculate.repository;

import com.leasing.communication.common.base.repository.BaseRepository;
import com.leasing.communication.common.entity.calculate.dos.CalculatorDO;
import com.leasing.communication.common.entity.calculate.query.CalculatorQuery;
import com.leasing.communication.common.entity.calculate.vo.base.CalculatorVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @project:leasing-cloud
 * @date:2019/9/23
 * @author:Yjj@yonyou.comlist
 * @description:
 **/
@Repository
public interface CalculatorRepo extends BaseRepository<CalculatorDO,CalculatorQuery,CalculatorVO,String> {
    //解决n+1问题 查询单个主表VO
    @Query(name="CalculatorRepo.findByPk")
    CalculatorVO findByPk(@Param("pk") String pk);
}