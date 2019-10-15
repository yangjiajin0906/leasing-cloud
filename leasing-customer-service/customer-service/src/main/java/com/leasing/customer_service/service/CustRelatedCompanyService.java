package com.leasing.customer_service.service;

import com.leasing.customer_service.pojo.CustRelatedCompanyVO;

import java.util.Map;

public interface CustRelatedCompanyService {

    Map<String, Object> queryForGrid(CustRelatedCompanyVO vo);
}
