package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerDO;
import com.leasing.customer.dao.query.CustomerQuery;
import com.leasing.customer.dao.vo.CustomerVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<CustomerDO, CustomerQuery, CustomerVO, String> {

    @Query(value = "select b from CustomerVO b " +
            " left join CustomerDTO m on b.pkCustomer = m.pkCustomer " +
            " where b.pkCustomer = ?1 ")
    List<CustomerVO> findTest(String pk);


}
