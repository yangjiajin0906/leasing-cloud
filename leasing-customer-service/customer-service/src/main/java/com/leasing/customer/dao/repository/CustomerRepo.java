package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerQuery;
import com.leasing.customer.dao.vo.CustomerVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepo extends BaseRepository<CustomerDO, CustomerQuery, CustomerVO, String> {

    //查询客户名称数量
    @Query(name = "CustomerVO.countCustomerName")
    int countCustomerName(@Param("customerName") String customerName);


    // 查询指定证件号
    @Query(name = "CustomerVO.countIdentityNo")
    int countIdentityNo(@Param("identityNo") String identityNo);

    // 根据客户主键批量删除客户
    @Modifying
    @Transactional
    @Query(name = "CustomerVO.batchDeleteByPks")
    void batchDeleteByPks(@Param("pks") List<String> pks);



}
