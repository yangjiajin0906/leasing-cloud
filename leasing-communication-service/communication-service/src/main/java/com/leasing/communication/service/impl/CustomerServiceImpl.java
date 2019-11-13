package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.CustomerDO;
import com.leasing.communication.repository.CustomerRepo;
import com.leasing.communication.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service("communication.CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService{
    @Resource
    CustomerRepo customerRepo;

    @Override
    public CustomerDO save(CustomerDO vo) {
        return customerRepo.saveEntity(vo);
    }

    @Override
    public void delete(CustomerDO vo) {
        customerRepo.delete(vo);
    }

    @Override
    public CustomerDO update(CustomerDO vo) {
        return customerRepo.updateEntity(vo);
    }

    @Override
    public CustomerDO findOne(String pk) {
        return customerRepo.findOne(pk);
    }
}