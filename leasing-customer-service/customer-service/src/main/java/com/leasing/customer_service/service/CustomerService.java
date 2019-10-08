package com.leasing.customer_service.service;

import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.pojo.CustomerVO;

import java.util.List;

public interface CustomerService {

    List<CustomerVO> getList(CustomerVO customerVO);

    CustomerVO queryByPK(String pk);

}
