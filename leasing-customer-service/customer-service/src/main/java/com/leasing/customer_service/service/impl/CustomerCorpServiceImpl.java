package com.leasing.customer_service.service.impl;

import com.leasing.customer_service.pojo.CustomerCorpVO;
import com.leasing.customer_service.repository.CustomerCorpRepository;
import com.leasing.customer_service.service.CustomerCorpService;
import com.leasing.customer_service.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project:leasing-cloud
 * @date:2019-09-27
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/

@Service("CustomerCorpService")
public class CustomerCorpServiceImpl implements CustomerCorpService {

    @Resource
    private CustomerCorpRepository corpRepository;

    @Override
    public Map<String, Object> queryForGrid(CustomerCorpVO vo) {
         Page<CustomerCorpVO> vos = corpRepository.findAll(vo.toSpec(), vo.toPageable());
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", vos.getContent());
        resultMap.put("total", vos.getTotalElements());
        resultMap.put("totalPages", vos.getTotalPages());
        return resultMap;
    }
}