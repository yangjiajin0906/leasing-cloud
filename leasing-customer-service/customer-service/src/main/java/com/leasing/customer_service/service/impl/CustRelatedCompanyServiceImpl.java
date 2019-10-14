package com.leasing.customer_service.service.impl;

import com.leasing.customer_service.pojo.CustRelatedCompanyVO;
import com.leasing.customer_service.repository.CustRelatedCompanyRepository;
import com.leasing.customer_service.service.CustRelatedCompanyService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-10-11
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("CustRelatedCompanyService")
public class CustRelatedCompanyServiceImpl implements CustRelatedCompanyService {

    @Resource
    private CustRelatedCompanyRepository custRelatedCompanyRepository;
    @Override
    public Map<String, Object> queryForGrid(CustRelatedCompanyVO vo) {

        Page<CustRelatedCompanyVO> vos = custRelatedCompanyRepository.findAll(vo.toSpec(), vo.toPageable());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", vos.getContent());
        resultMap.put("total", vos.getTotalElements());
        resultMap.put("totalPages", vos.getTotalPages());
        return resultMap;
    }
}