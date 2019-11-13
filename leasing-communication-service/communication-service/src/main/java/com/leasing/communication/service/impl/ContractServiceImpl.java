package com.leasing.communication.service.impl;

import com.leasing.communication.entity.dos.ContractDO;
import com.leasing.communication.repository.ContractRepo;
import com.leasing.communication.service.ContractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service("communication.ContractServiceImpl")
public class ContractServiceImpl implements ContractService {
    @Resource
    ContractRepo contractRepo;

    @Override
    public ContractDO save(ContractDO vo) {
        return contractRepo.saveEntity(vo);
    }

    @Override
    public void delete(ContractDO vo) {
        contractRepo.delete(vo);
    }

    @Override
    public ContractDO update(ContractDO vo) {
        return contractRepo.updateEntity(vo);
    }

    @Override
    public ContractDO findOne(String pk) {
        return contractRepo.findOne(pk);
    }
}