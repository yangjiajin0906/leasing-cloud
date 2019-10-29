package com.leasing.customer.service.impl;

import com.leasing.common.dto.customer.CustomerDTO;
import com.leasing.customer.dao.repository.CustShareHoldersRepo;
import com.leasing.customer.dao.vo.CustShareHoldersVO;
import com.leasing.customer.service.CustShareHoldersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @project:leasing-cloud
 * @date:2019-10-29
 * @author:zhangzhhn@yonyou.com
 * @description:
 **/
@Service("customer.CustShareHoldersService")
public class CustShareHoldersServiceImpl implements CustShareHoldersService {
    @Resource
    private CustShareHoldersRepo repo;

    @Override
    public List<CustShareHoldersVO> findByCustomer(String pkCustomer) {
        CustomerDTO customerDTO = new CustomerDTO(pkCustomer);
        return findByCustomer(customerDTO);
    }

    @Override
    public List<CustShareHoldersVO> findByCustomer(CustomerDTO customerDTO) {
        return repo.queryHoldersByPkCustomer(customerDTO);
    }
}