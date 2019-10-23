package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerQuery;
import com.leasing.customer.dao.vo.CustomerVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerDO, CustomerQuery, CustomerVO, String> {

    //查询客户名称数量
    @Query(value = "select b from CustomerVO b " +
            " where b.customerName = :customerName ")
    int countCustomerName(@Param("customerName") String customerName);


    // 查询指定证件号数量
    @Query(value = "SELECT CASE WHEN EXISTS (SELECT 0 FROM CustomerVO a WHERE a.identityNo = :identityNo " +
            " AND a.ifNew = 0) THEN 1 ELSE 0 END FROM DUAL")
    int countIdentityNo(@Param("identityNo") String identityNo);
}
