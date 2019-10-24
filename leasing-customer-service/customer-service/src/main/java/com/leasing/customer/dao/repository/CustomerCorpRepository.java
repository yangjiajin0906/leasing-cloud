package com.leasing.customer.dao.repository;

import com.leasing.common.base.repository.BaseRepository;
import com.leasing.customer.dao.dos.CustomerCorpDO;
import com.leasing.customer.dao.query.CustomerCorpQuery;
import com.leasing.customer.dao.vo.CustomerCorpAllVO;
import com.leasing.customer.dao.vo.CustomerCorpVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-21
 * @author:zhangzhhn@yonyou.com
 * @description: 单位客户数据操作
 **/
@Repository
public interface CustomerCorpRepository extends BaseRepository<CustomerCorpDO, CustomerCorpQuery, CustomerCorpAllVO,String> {

    @Query(value = "select b from CustomerCorpVO b " +
            " left join CustomerDTO m on b.pkCustomer = m.pkCustomer " +
            " where b.pkCustomer = ?1 ")
    List<CustomerCorpVO> findTest(String pk);

    /**
     * 根据客户主键查询单位客户详情
     * @param pkCustomer 客户主键
     * @return List<CustomerCorpAllVO>
     */
    @Query(value = "select b from CustomerCorpAllVO b " +
            "where b.pkCustomer = :pkCustomer ")
    CustomerCorpAllVO findOneAllByPkCustomer(@Param("pkCustomer") String pkCustomer);

    /**
     * 根据客户名称查询单位客户详情
     * @param pkCustomer 客户名称
     * @return List<CustomerCorpAllVO>
     */
    @Query(value = "select count(b.customerName) from CustomerCorpAllVO b " +
            "where b.customerName = :pkCustomer AND b.ifNew = 0")
    int findOneAllByCustomerName(@Param("pkCustomer") String pkCustomer);



//
//
//    @Query(value = "select b from CustomerCorpVO b " +
//            " left join fetch b.customerProperty t" +
//            " left join fetch b.customerPropertyIn l" +
//            " left join fetch b.pkChecker m" +
//            " where b.pkCustomer = ?1 ")
//    List<CustomerCorpVO> findTest1(String pk);
//
//    @Query(value = "select b from ParameterVO b " +
//            " left join fetch ParamTypeDTO m on b.pkParamType = m.pkParamType " +
//            " where b.paramCode = ?1 ")
//    List<CustomerVO> findTest2(String pk);
//
//    @Query(value = "select b,m.paramVarname from ParameterVO b " +
//            " left join fetch b.pkParamType m " +
//            " where m.paramCode = ?1 ")
//    List<CustomerVO> findTest3(String pk);
//
}